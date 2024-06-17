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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class PolicyDictionaryPageTest {
    LoginPage loginPage=new LoginPage();
    PolicyDictionaryPage policyDictionaryPage=new PolicyDictionaryPage();
    Config config=Config.load("/config.yaml");
    PolicyDetailPage policyDetailPage=new PolicyDetailPage();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username7, config.vercode);
        policyDictionaryPage.waitlasterHotPolicyTitle();
        policyDictionaryPage.enterPolicyDictionary();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索关键词成功")
    @Story("政策词典")
    public void searchKeySuccess(){
        ArrayList<String> list=policyDictionaryPage.searchKeySuccess("技术");
        list.forEach(string -> {
            assertTrue(string.contains("技术"));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击热门搜索关键词搜索成功")
    @Story("政策词典")
    public void searchHotKeySuccess(){
        ArrayList<String> list=policyDictionaryPage.searchHotKeySuccess();
        list.forEach(string -> {
            assertTrue(string.contains(policyDictionaryPage.assertText));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：按字母筛选成功")
    @Story("政策词典")
    public void searchLetterSuccess(){
        ArrayList<String> list=policyDictionaryPage.searchLetterSuccess();
        list.forEach(string -> {
            assertTrue(policyDictionaryPage.assertText.contains(string));
        });
    }

    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    @Test
    @Description("正常测试用例：名词类型筛选中文")
    @Story("政策词典")
    public void searchChineseKeySuccess(){
        ArrayList<String> list=policyDictionaryPage.searchChineseKeySuccess();
        list.forEach(string -> {
            assertTrue(isContainChinese(string) || string.matches(".*\\d.*"));

        });
    }

    @Test
    @Description("正常测试用例：名词类型筛选英文")
    @Story("政策词典")
    public void searchEngKeySuccess(){
        ArrayList<String> list=policyDictionaryPage.searchEngKeySuccess();
        list.forEach(string -> {
            assertTrue(string.matches(".*\\w.*"));
        });
    }

    @Test
    @Description("正常测试用例：跳转相关政策")
    @Story("政策词典")
    public void skipRelationPolicySuccess(){
        String title= policyDictionaryPage.skipRelationPolicySuccess(config.dictionary.get(0),config.dictionary.get(0),policyDetailPage);
        assertTrue(policyDictionaryPage.assertMap.containsKey(config.dictionary.get(0)));
        assertTrue(policyDictionaryPage.assertMap.get(config.dictionary.get(0)).equals(config.dictionary.get(1)));
        assertTrue(title.equals(policyDictionaryPage.assertText));
    }

    @Test
    @Description("正常测试用例：跳转相关名词")
    @Story("政策词典")
    public void skipRelationDictionarySuccess(){
        String title= policyDictionaryPage.skipRelationDictionarySuccess(config.dictionary.get(0),config.dictionary.get(0));
        assertTrue(policyDictionaryPage.assertText.equals(title));
    }
}