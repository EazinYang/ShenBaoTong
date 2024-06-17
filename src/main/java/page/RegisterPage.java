package page;

import conf.Method;
import org.openqa.selenium.By;

public class RegisterPage extends Method {
    //页面标题：欢迎注册政沣云
    public static By registerTitle=xpathOrId("//div[@class='login-right-top']/span");
    //注册页面
    public static By registerMenu=xpathOrId("//div[@class='menu_btn']/div[2]");
    //联系人姓名输入框
    public static By nameInput=xpathOrId("//input[@placeholder='请输入联系人姓名']");
    //联系人输入提示信息
    public static By NameInputInfo=xpathOrId("//div[@class='login-form']/form/div/div/div[2]");
    //手机号码输入框
    public static By phoneInput=xpathOrId("//input[@placeholder='请输入手机号码']");
    //验证码输入框
    public static By verficationCodeInput=xpathOrId("//input[@placeholder='请输入5位验证码']");
    //密码输入框
    public static By passwordInput=xpathOrId("password");
    //密码确认输入框
    public static By passwordAffirmInput=xpathOrId("//input[@placeholder='请再次输入密码']");
    //阅读并同意《服务及隐私协议》勾选框
    public static By serviceAgreementBtn=xpathOrId("//label[@class='el-checkbox']/span");
    //阅读并同意《服务及隐私协议》链接
    public static By serviceAgreementLink=xpathOrId("//label[@class='el-checkbox']/../span");
    //《服务及隐私协议》标题
    public static By serviceAgreementTitle=xpathOrId("//div[@class='el-dialog__body']/div/h1");
    //《服务及隐私协议》关闭按钮
    public static By serviceAgreementCloseBtn=xpathOrId("//button[@aria-label='Close']");
    //注册按钮
    public static By registerBtn=xpathOrId("//div[@class='login-form']/form/div[7]/div/button");
    //注册成功提示信息
    public static By registerSuccessInfo=xpathOrId("/html/body/div[last()]/p");
    //返回登录按钮
    public static By returnLoginbtn=By.partialLinkText("返回登录");

    public void enterRegisterPage(){
        find(registerMenu).click();
    }

    public String getRegisterTitle() {
        waitText(registerTitle,"欢迎注册政沣云");
        return find(registerTitle).getText();
    }

    //清空输入框
    public void inputClear(){
        find(nameInput).clear();
        find(phoneInput).clear();
        find(verficationCodeInput).clear();
        find(passwordInput).clear();
        if(find(passwordAffirmInput).isEnabled()){
            find(passwordAffirmInput).clear();
        }
    }

    //注册成功
    public String registerSuccess(String name,String phone,String verficationCode,String password,String affirmPassword){
        inputClear();
        registerInput(name, phone, verficationCode, password, affirmPassword);
        enterRegisterPage();
        return find(registerSuccessInfo).getText();
    }

    //注册失败：不输入姓名
    public String nonNameRegisterFail(String phone,String verficationCode,String password,String affirmPassword){
        getDriver().navigate().refresh();
        registerInput("", phone, verficationCode, password, affirmPassword);
        String text=find(NameInputInfo).getText();
        getDriver().navigate().refresh();
        return text;
    }
    //注册失败：phone为空、格式不正确
    public String nonPhoneRegisterFail(String name,String phone,String verficationCode,String password,String affirmPassword){
        getDriver().navigate().refresh();
        registerInput(name, phone, verficationCode, password, affirmPassword);
        return find(NameInputInfo).getText();
    }

    //输入流程
    private static void registerInput(String name, String phone, String verficationCode, String password, String affirmPassword) {
        find(nameInput).sendKeys(name);
        find(phoneInput).sendKeys(phone);
        find(verficationCodeInput).sendKeys(verficationCode);
        find(passwordInput).sendKeys(password);
        find(passwordAffirmInput).click();
        if(find(passwordAffirmInput).isEnabled()){
            find(passwordAffirmInput).sendKeys(affirmPassword);
        }
        if(find(registerBtn).getAttribute("class").contains("el-button submit-btn el-button--primary check-box-click")){
            find(serviceAgreementBtn).click();
        }
        find(registerBtn).click();
    }

    //注册失败：验证码为空
    public String nonVerficationCodeRegisterFail(String name,String phone,String password,String affirmPassword){
        getDriver().navigate().refresh();
        registerInput(name,phone,"",password,affirmPassword);
        return find(NameInputInfo).getText();
    }

    //注册失败：错误验证码
    public String failVerficationCodeRegisterFail(String name,String phone,String verficationCode,String password,String affirmPassword){
        getDriver().navigate().refresh();
        registerInput(name, phone, verficationCode, password, affirmPassword);
        return find(registerSuccessInfo).getText();
    }

    //注册失败：密码为空、格式不准确
    public String nonPassowrdRegisterFail(String name,String phone,String verficationCode,String password,String affirmPassword){
        inputClear();
        registerInput(name, phone, verficationCode, password, affirmPassword);
        return find(NameInputInfo).getText();
    }

    //注册失败：再次确认密码为空、错误
    public String nonAffirmPassowrdRegisterFail(String name,String phone,String verficationCode,String password,String affirmPassword){
        inputClear();
        registerInput(name, phone, verficationCode, password, affirmPassword);
        return find(NameInputInfo).getText();
    }

    //跳转《服务及隐私协议》
    public String enterServiceAgreement(){
        find(serviceAgreementLink).click();
        String title=find(serviceAgreementTitle).getText();
        find(serviceAgreementCloseBtn).click();
        return title;
    }

    //跳转登录页面
    public String enterLoginPage(){
        find(returnLoginbtn).click();
        waitText(registerTitle,"欢迎登录政沣云");
        String title=find(registerTitle).getText();
        enterRegisterPage();
        return title;
    }
}
