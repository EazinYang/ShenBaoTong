package page;

import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RetryUtils;

import static org.testng.Assert.*;

public class ProjectMatchRecordPageTest {
    LoginPage loginPage=new LoginPage();
    Config config=Config.load("/config.yaml");
    PolicyFileDetailPage policyFileDetailPage=new PolicyFileDetailPage();
    ProjectMatchRecordPage projectMatchRecordPage=new ProjectMatchRecordPage();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username12, config.vercode);
        projectMatchRecordPage.waitlasterHotPolicyTitle();
        projectMatchRecordPage.enterProjectMatchRecordPage();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().quit();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：进入匹配记录详情页")
    @Story("匹配记录")
    public void enterMatchDetailSuccess(){
        assertEquals(projectMatchRecordPage.enterMatchDetail(),projectMatchRecordPage.assertText);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：重新匹配项目")
    @Story("匹配记录")
    public void matchAgainSuccess(){
        assertEquals(projectMatchRecordPage.matchAgain(),projectMatchRecordPage.assertText);
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击项目标题，打开对应的项目摘要页")
    @Story("匹配记录")
    public void openProjectDetail(){
        assertEquals(projectMatchRecordPage.openProjectDetail(policyFileDetailPage),projectMatchRecordPage.assertText);
    }
}