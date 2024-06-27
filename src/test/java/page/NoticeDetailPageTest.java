package page;

import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RetryUtils;

import java.util.ArrayList;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NoticeDetailPageTest {
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
        loginPage.verficationCodeLoginSuccess(config.username5, config.vercode);
        policyLibraryPage.waitlasterHotPolicyTitle();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterNoticeDeatil("测试数据-公告公示");
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：进入公示公告详情页")
    @Story("公示公告详情页")
    public void enterPolicyDetailSuccess(){
        ArrayList<String> info=noticeDetailPage.verficationDetailInfo();
        assertTrue(info.get(0).contains(config.noticename.get("title").get(0)));
        assertTrue(info.get(1).contains(config.noticename.get("title").get(1)));
        assertTrue(info.get(2).contains(config.noticename.get("title").get(2)));
        assertTrue(info.get(3).contains("公示公告"));
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：回到列表页面")
    @Story("公示公告详情页")
    public void retuenList(){
        assertEquals(noticeDetailPage.returnList().getPageText(),"政策搜索");
        policyLibraryPage.enterNoticeDeatil("测试数据-公告公示");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：分享")
    @Story("公示公告详情页")
    public void share(){
        assertEquals(noticeDetailPage.share(),noticeDetailPage.id);
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：联系信息校验")
    @Story("公示公告详情页")
    public void contactInfoVerifySuccess(){
        ArrayList<String> info=noticeDetailPage.contactInfoVerify();
        ArrayList<String> data=config.noticename.get("联系信息");
        assertEquals(info.get(0),"联系单位："+data.get(0));
        assertEquals(info.get(1),"联系人："+data.get(1));
        assertEquals(info.get(2),"联系电话："+data.get(2));
        assertEquals(info.get(3),"联系地址："+data.get(3));
        assertEquals(info.get(4),"邮箱："+data.get(4));
        assertEquals(info.get(5),"备注："+data.get(5));
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：检查获批名单是否有数据")
    @Story("公示公告详情页")
    public void approvedDataVerify(){
        assertTrue(noticeDetailPage.approvedDataVerify()>=1);
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：政策文件tab内点击政策标题跳转政策详情页")
    @Story("公示公告详情页")
    public void policyFileSkipPolicyDetailSuccess(){
        assertEquals(noticeDetailPage.policyFileSkipPolicyDetail(policyDetailPage,config.noticename.get("title").get(0)),config.policyname.get("title").get(0));
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：政策文件tab内点击项目标题跳转项目详情页")
    @Story("公示公告详情页")
    public void policyFileSkipProjectDetailSuccess(){
        ArrayList<String> list=noticeDetailPage.policyFileSkipProjectDetail(policyDetailPage,config.noticename.get("title").get(0));
        assertEquals(list.get(0),config.project1.get(0));
        assertEquals(list.get(1),config.project1.get(0));
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：预览相关文件")
    @Story("公示公告详情页")
    public void readFile(){
        assertEquals(noticeDetailPage.readFile(),"文件预览");
    }
}