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

public class PolicySubjectPageTest {
    LoginPage loginPage=new LoginPage();
    Config config=Config.load("/config.yaml");
    HomePage homePage=new HomePage();
    PolicyFileDetailPage policyFileDetailPage=new PolicyFileDetailPage();
    PolicySubjectPage policySubjectPage=new PolicySubjectPage();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username10, config.vercode);
        policySubjectPage.enterPolicySubjectPage(homePage);
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：切换政策标题")
    @Story("政策专题")
    public void switchSubject(){
        String text= policySubjectPage.switchSubject();
        assertEquals(policySubjectPage.assertText,policySubjectPage.subjectText);
        assertEquals(text,policySubjectPage.subjectText+"相关政策");
        assertTrue(!policySubjectPage.assertList.equals(policySubjectPage.startPolicy));
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：切换政策标题")
    @Story("政策专题")
    public void skipPolicyDetail(){
        assertEquals(policySubjectPage.skipPolicyDetail(policyFileDetailPage,homePage),policySubjectPage.assertText);
    }
}