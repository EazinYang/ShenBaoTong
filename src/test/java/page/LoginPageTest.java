package page;

import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.RetryUtils;

import static org.testng.Assert.*;

public class LoginPageTest {
    LoginPage loginPage=new LoginPage();
    Config config= Config.load("/config.yaml");

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：手机验证码登录成功")
    @Story("登录页面")
    public void verficationCodeLoginSuccess(){
        assertEquals(loginPage.verficationCodeLoginSuccess(config.username3,config.vercode),"登录成功");
        loginPage.quit();
    }

    @DataProvider(name = "获取错误的验证码")
    public String[][] getVerficationCode(){
        return new String[][]{
                {" "},{"12345"}
        };
    }

    @Test(dataProvider = "获取错误的验证码",retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：手机验证登录，1、错误的验证码，2、不填验证码" )
    @Story("登录页面")
    public void verficationCodeLoginFail(String verficationCode){
        assertEquals(loginPage.verficationCodeLoginFail(config.username3,verficationCode),"验证码错误或已过期");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：免费注册" )
    @Story("登录页面")
    public void enterRegisterPage(){
        RegisterPage registerPage=loginPage.enterRegisterPage();
        assertEquals(registerPage.getRegisterTitle(),"欢迎注册政沣云");
        loginPage.enterLoginPage();
    }

}