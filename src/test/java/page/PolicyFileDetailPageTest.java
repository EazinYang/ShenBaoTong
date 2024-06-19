package page;

import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import util.RetryUtils;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class PolicyFileDetailPageTest {
    LoginPage loginPage=new LoginPage();
    PolicyLibraryPage policyLibraryPage=new PolicyLibraryPage();
    PolicyDetailPage policyDetailPage=new PolicyDetailPage();
    PushPage pushPage=new PushPage();
    DeclareStewardPage declareStewardPage=new DeclareStewardPage();
    Config config=Config.load("/config.yaml");
    NoticeDetailPage noticeDetailPage=new NoticeDetailPage();
    PolicyFileDetailPage policyFileDetailPage=new PolicyFileDetailPage();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username8, config.vercode);
        policyLibraryPage.waitlasterHotPolicyTitle();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyFileDeatil("测试数据-政策文件");
    }


    @BeforeMethod
    public void beforeMethod(){
        policyFileDetailPage.setSubscribeText();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：进入政策文件详情页")
    @Story("政策文件详情页")
    public void enterPolicyDetailSuccess(){
        ArrayList<String> info=policyFileDetailPage.verficationDetailInfo();
        assertTrue(info.get(0).contains(config.policyfilename.get("title").get(0)));
        assertTrue(info.get(1).contains(config.policyfilename.get("title").get(1)));
        assertTrue(info.get(2).contains(config.policyfilename.get("title").get(2)));
        assertTrue(info.get(3).contains("政策原文"));
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：回到列表页面")
    @Story("政策文件详情页")
    public void retuenList(){
        assertEquals(policyFileDetailPage.returnList().getPageText(),"政策搜索");
        policyLibraryPage.enterPolicyFileDeatil("测试数据-政策文件");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：分享")
    @Story("政策文件详情页")
    public void share(){
        assertEquals(policyFileDetailPage.share(),policyFileDetailPage.id);
    }

    @DataProvider(name = "订阅")
    public String[][] subscribeDat(){
        return new String[][]{
                {},
                {}
        };
    }

    @Test(dataProvider = "订阅",priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：订阅")
    @Story("政策文件详情页")
    public void subscribe() throws Exception {
        if(policyFileDetailPage.subscribeText.contains("+ 订阅")){
            assertEquals(policyFileDetailPage.subscribe(pushPage,config.policyfilename.get("title").get(0)),"已订阅");
            assertEquals(policyFileDetailPage.tips,"操作成功");
            assertTrue(pushPage.titlesList.contains(policyFileDetailPage.titleText));
        }else if(policyFileDetailPage.subscribeText.contains("已订阅")){
            assertEquals(policyFileDetailPage.subscribe(pushPage,config.policyfilename.get("title").get(0)),"+ 订阅");
            assertEquals(policyFileDetailPage.tips,"操作成功");
            assertTrue(!pushPage.titlesList.contains(policyFileDetailPage.titleText));
        }else {
            throw new Exception("订阅按钮文本为空！");
        }
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：联系信息校验")
    @Story("政策文件详情页")
    public void contactInfoVerifySuccess(){
        ArrayList<String> info=policyFileDetailPage.contactInfoVerify();
        ArrayList<String> data=config.policyfilename.get("联系信息");
        assertEquals(info.get(0),"联系单位："+data.get(0));
        assertEquals(info.get(1),"联系人："+data.get(1));
        assertEquals(info.get(2),"联系电话："+data.get(2));
        assertEquals(info.get(3),"联系地址："+data.get(3));
        assertEquals(info.get(4),"邮箱："+data.get(4));
        assertEquals(info.get(5),"备注："+data.get(5));
    }
}