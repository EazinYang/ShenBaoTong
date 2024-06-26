package page;

import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import util.RetryUtils;
import java.util.ArrayList;
import java.util.HashMap;
import static org.testng.Assert.*;

public class PolicyDetailPageTest {
    LoginPage loginPage=new LoginPage();
    PolicyLibraryPage policyLibraryPage=new PolicyLibraryPage();
    PolicyDetailPage policyDetailPage=new PolicyDetailPage();
    PushPage pushPage=new PushPage();
    DeclareStewardPage declareStewardPage=new DeclareStewardPage();
    Config config=Config.load("/config.yaml");
    NoticeDetailPage noticeDetailPage=new NoticeDetailPage();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username6, config.vercode);
        policyLibraryPage.waitlasterHotPolicyTitle();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        policyDetailPage.setSubscribeText();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：进入申报通知详情页")
    @Story("申报通知详情页")
    public void enterPolicyDetailSuccess(){
        ArrayList<String> info=policyDetailPage.verficationDetailInfo();
        assertTrue(info.get(0).contains(config.policyname.get("title").get(0)));
        assertTrue(info.get(1).contains(config.policyname.get("title").get(1)));
        assertTrue(info.get(2).contains(config.policyname.get("title").get(2)));
        assertTrue(info.get(3).contains("申报通知"));
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：回到列表页面")
    @Story("申报通知详情页")
    public void retuenList(){
        assertEquals(policyDetailPage.returnList().getPageText(),"政策搜索");
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：分享")
    @Story("申报通知详情页")
    public void share(){
        assertEquals(policyDetailPage.share(),policyDetailPage.id);
    }

    @DataProvider(name = "订阅")
    public String[][] subscribeDat(){
        return new String[][]{
                {},
                {}
        };
    }
    //retryAnalyzer = RetryUtils.class

    @Test(dataProvider = "订阅",priority = 3)
    @Description("正常测试用例：订阅")
    @Story("申报通知详情页")
    public void subscribe() throws Exception {
        if(policyDetailPage.subscribeText.contains("+ 订阅")){
            assertEquals(policyDetailPage.subscribe(pushPage,config.policyname.get("title").get(0)),"已订阅");
            assertEquals(policyDetailPage.tips,"操作成功");
            assertTrue(pushPage.titlesList.contains(policyDetailPage.titleText));
        }else if(policyDetailPage.subscribeText.contains("已订阅")){
            assertEquals(policyDetailPage.subscribe(pushPage,config.policyname.get("title").get(0)),"+ 订阅");
            assertEquals(policyDetailPage.tips,"操作成功");
            assertTrue(!pushPage.titlesList.contains(policyDetailPage.titleText));
        }else {
            throw new Exception("订阅按钮文本为空！");
        }
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：预览相关文件")
    @Story("申报通知详情页")
    public void readFile(){
        assertEquals(policyDetailPage.readFile(),"文件预览");
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：项目摘要页面数据校验")
    @Story("申报通知详情页")
    public void projectVerify() {
        HashMap<String,ArrayList<String>> map=policyDetailPage.projectTab(config.project1.get(0));
        map.entrySet().forEach(entry->{
            assertEquals(entry.getKey(),entry.getValue().get(0));
            if(entry.getKey().equals("测试数据-项目一")){
                assertTrue(entry.getValue().equals(config.project1));
            }else if(entry.getKey().equals("测试数据-项目二")){
                assertTrue(entry.getValue().equals(config.project2));
            }else {
                assertEquals("数据不存在","报错");
            }
        });
    }

    @DataProvider(name="纳入项目计划")
    public Object[][] naruJihuaDat(){
        return new Object[][]{
                {},{}
        };
    }

    @Test(dataProvider = "纳入项目计划",priority = 3)
    @Description("正常测试用例：项目纳入计划")
    @Story("申报通知详情页")
    public void naruJihua(){
        if(policyDetailPage.getNaruJihuaBtnText(config.project1.get(0)).contains("+纳入计划")){
            ArrayList<String> titles=policyDetailPage.naruJihua(declareStewardPage,config.policyname.get("title").get(0));
            assertEquals(policyDetailPage.assertText,"纳入计划成功");
            assertTrue(titles.contains(policyDetailPage.projectTitleText));
        }else if(policyDetailPage.getNaruJihuaBtnText(config.project1.get(0)).contains("取消计划")){
            assertEquals(policyDetailPage.cancelNaruJihua(config.policyname.get("title").get(0)),"取消纳入成功");
        }else {
            assertEquals("按钮不存在","报错");
        }
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：联系信息校验")
    @Story("申报通知详情页")
    public void contactInfoVerifySuccess(){
        ArrayList<String> info=policyDetailPage.contactInfoVerify();
        ArrayList<String> data=config.policyname.get("联系信息");
        assertEquals(info.get(0),"联系单位："+data.get(0));
        assertEquals(info.get(1),"联系人："+data.get(1));
        assertEquals(info.get(2),"联系电话："+data.get(2));
        assertEquals(info.get(3),"联系地址："+data.get(3));
        assertEquals(info.get(4),"邮箱："+data.get(4));
        assertEquals(info.get(5),"备注："+data.get(5));
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：获批名单内点击政策标题跳转公示公告详情页")
    @Story("申报通知详情页")
    public void approvedSkipNoticeSuccess(){
        assertEquals(policyDetailPage.approvedSkipNotice(noticeDetailPage,config.policyname.get("title").get(0)),config.noticename.get("title").get(0));
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：检查获批名单是否有数据")
    @Story("申报通知详情页")
    public void approvedDataVerify(){
        assertTrue(policyDetailPage.approvedDataVerify()>=1);
    }
}