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

public class NewsCenterTest {
    LoginPage loginPage=new LoginPage();
    Config config=Config.load("/config.yaml");
    HomePage homePage=new HomePage();
    NewsCenter newsCenter=new NewsCenter();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username4, config.vercode);
        newsCenter.enterNewsCenterPage(homePage);
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击新闻标题进入详情页")
    @Story("新闻中心")
    public void switchSubject(){
        assertEquals(newsCenter.enterNewsDetail(),newsCenter.assertText);
    }
}