package page;

import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RetryUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest {
    LoginPage loginPage=new LoginPage();
    Config config=Config.load("/config.yaml");
    HomePage homePage=new HomePage();
    ProjectMatchPage projectMatchPage=new ProjectMatchPage();
    PolicyLibraryPage policyLibraryPage=new PolicyLibraryPage();
    PolicyFileDetailPage policyFileDetailPage=new PolicyFileDetailPage();
    PolicySubjectPage policySubjectPage=new PolicySubjectPage();
    NewsCenter newsCenter=new NewsCenter();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username2, config.vercode);
        homePage.waitlasterHotPolicyTitle();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击多维度项目匹配跳转项目匹配页面")
    @Story("首页")
    public void skipProjectMatchSuccess(){
        assertEquals(homePage.skipProjectMatch(projectMatchPage),"项目匹配");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击近期热门政策旁的【更多】跳转政策文库页面")
    @Story("首页")
    public void clickMorePolicySkipPageSuccess(){
        assertEquals(homePage.clickMorePolicy(policyLibraryPage),"政策文库");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击近期热门政策下的项目标题跳转项目摘要页面")
    @Story("首页")
    public void skipProjectDetailSuccess(){
        assertEquals(homePage.skipProjectDetail(policyFileDetailPage),homePage.assertText);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击政策专题跳转对应专题页面")
    @Story("首页")
    public void skipPolicySubjectSuccess(){
        assertEquals(homePage.skipPolicySubject(policySubjectPage),homePage.assertText);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击新闻中心旁的【更多】跳转新闻中心页面")
    @Story("首页")
    public void clickMoreNewsSkipPageSuccess(){
        assertEquals(homePage.clickMoreNews(newsCenter),"新闻中心");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击新闻中心下的新闻标题跳转新闻详情页面")
    @Story("首页")
    public void skipNewsDetailSuccess(){
        assertEquals(homePage.skipNewsDetail(newsCenter),homePage.assertText);
    }
}