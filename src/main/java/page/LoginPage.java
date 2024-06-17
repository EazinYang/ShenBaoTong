package page;

import conf.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends Method {
    //登录页面
    public static By loginMenu=xpathOrId("//div[@class='menu_btn']/div");
    //手机号码输入框
    public static By phoneInput=xpathOrId("//input[@placeholder='请输入手机号码']");
    //验证码输入框
    public static By verficationCodeInput=xpathOrId("//input[@placeholder='请输入5位验证码']");
    //获取验证码按钮
    public static By getVerficationCodeBtn=xpathOrId("//*[@placeholder='请输入5位验证码']/../../button");
    //立即登录按钮
    public static By loginBtn=xpathOrId("//button[@class='el-button submit-btn el-button--primary']");
    //退出登录按钮
    public static By quitBtn=xpathOrId("/html/body/ul/li[last()]/div/span");
    //登录成功提示信息
    public static By loginSuccessInfo=xpathOrId("/html/body/div[last()]/p");
    //密码登录按钮
    public static By passwordLoginBtn=xpathOrId("//div[@class='verification']/div[2]/div[2]");
    //免费注册按钮
    public static By freeRegisterBtn=xpathOrId("//a[@href='/register']/span");
    //欢迎登录政沣云
    public By loginTitle=xpathOrId("//div[@class='login-right-top']/span");

    //头像
    public static By photo=xpathOrId("//div[@class='avatar el-dropdown']");
    public void enterLoginPage(){
        find(loginMenu).click();
        waitText(loginTitle,"欢迎登录政沣云");
    }

    //手机验证码登录：正确的手机号和验证码
    public String verficationCodeLoginSuccess(String phone,String verficationCode) {
        getDriver().navigate().refresh();
        find(phoneInput).sendKeys(phone);
        find(verficationCodeInput).sendKeys(verficationCode);
        find(loginBtn).click();
        return find(loginSuccessInfo).getText();
    }

    //退出登录
    public void quit(){
        mouseMoveToElement(photo);
        find(quitBtn).click();
    }

    //手机验证码登录：正确的手机号和错误的验证码
    public String verficationCodeLoginFail(String phone,String verficationCode) {
        getDriver().navigate().refresh();
        find(phoneInput).sendKeys(phone);
        find(verficationCodeInput).sendKeys(verficationCode);
        find(loginBtn).click();
        return find(loginSuccessInfo).getText();
    }

    //跳转注册页面
    public RegisterPage enterRegisterPage(){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(find(freeRegisterBtn));
        actions.click();
        actions.perform();
        return new RegisterPage();
    }
}

