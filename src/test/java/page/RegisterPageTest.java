package page;

import com.github.javafaker.Faker;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.RetryUtils;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class RegisterPageTest {
    RegisterPage registerPage=new RegisterPage();
    Faker faker=new Faker(Locale.CHINA);

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        registerPage.enterRegisterPage();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：输入完整信息注册成功")
    @Story("注册")
    public void registerSuccess(){
        String name=faker.name().fullName();
        String phone=faker.phoneNumber().cellPhone();
        assertEquals(registerPage.registerSuccess(name,phone,"55555","123456a","123456a"),"注册成功");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：姓名为空")
    @Story("注册")
    public void registerNameFail(){
        String phone=faker.phoneNumber().cellPhone();
        assertEquals(registerPage.nonNameRegisterFail(phone,"55555","123456a","123456a"),"请输入联系人姓名");
    }

    @DataProvider(name = "手机号码")
    public String[][] phoneNumber(){
        return new String[][]{
                {""},{"1590000000"},{"中文"},{"abcdabcdabc"}
        };
    }


    @Test(dataProvider = "手机号码",retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：错误的手机号码")
    @Story("注册")
    public void registerPhoneFail(String phone){
        String name=faker.name().fullName();
        assertEquals(registerPage.nonPhoneRegisterFail(name,phone,"55555","123456a","123456a"),"请输入正确的11位手机号码");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：空验证码")
    @Story("注册")
    public void registerEmptyVerficationCodeFail(){
        String name=faker.name().fullName();
        String phone=faker.phoneNumber().cellPhone();
        assertEquals(registerPage.nonVerficationCodeRegisterFail(name,phone,"123456a","123456a"),"请输入验证码");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：错误验证码")
    @Story("注册")
    public void registerFailVerficationCodeFail(){
        String name=faker.name().fullName();
        String phone=faker.phoneNumber().cellPhone();
        assertEquals(registerPage.failVerficationCodeRegisterFail(name,phone,"12345","123456a","123456a"),"验证码错误或已过期");
    }

    @DataProvider(name = "密码")
    public String[][] passowrd(){
        return new String[][]{
                {""},{"1234a"},{"123456"},{"12345@"}
        };
    }

    @Test(dataProvider = "密码",retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：密码为空、格式不准确")
    @Story("注册")
    public void registerPassowrdFail(String passowrd){
        String name=faker.name().fullName();
        String phone=faker.phoneNumber().cellPhone();
        assertEquals(registerPage.nonPassowrdRegisterFail(name,phone,"55555",passowrd,"123456a"),"请输入新密码（6-20位，须含数字和字母）");
    }

    @DataProvider(name = "再次确认密码")
    public String[][] affirmPassowrd(){
        return new String[][]{
                {""},{"12345"}
        };
    }


    @Test(dataProvider = "再次确认密码",retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：再次确认密码为空、不一致")
    @Story("注册")
    public void registerAffirmPassowrdFail(String affirmPassowrd){
        String name=faker.name().fullName();
        String phone=faker.phoneNumber().cellPhone();
        assertEquals(registerPage.nonAffirmPassowrdRegisterFail(name,phone,"55555","123456a",affirmPassowrd),"两次输入的密码不一致，请重新输入");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：跳转《服务及隐私协议》")
    @Story("注册")
    public void enterServiceAgreement(){
        assertEquals(registerPage.enterServiceAgreement(),"政沣云-政策服务云平台用户服务及隐私协议");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：返回登录页面")
    @Story("注册")
    public void enterLoginPage(){
        assertEquals(registerPage.enterLoginPage(),"欢迎登录政沣云");
    }
}