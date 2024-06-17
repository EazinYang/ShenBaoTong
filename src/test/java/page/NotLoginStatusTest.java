package page;

import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RetryUtils;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class NotLoginStatusTest {
    NotLoginStatus notLoginStatus=new NotLoginStatus();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【首页】未登录状态下点击近期热门政策的项目弹出去登录的提醒")
    @Story("未登录状态")
    public void clickLastHotPolicyProject(){
        assertMessage(notLoginStatus.clickLastHotPolicyProject());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【首页】点击登录提醒弹框的去登录按钮，跳转登录页面")
    @Story("未登录状态")
    public void clickGoToLoginBtn(){
        assertEquals(notLoginStatus.clickGoToLoginBtn(),"欢迎登录政沣云");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策专题】未登录状态下点击政策专题下的项目弹出去登录的提醒")
    @Story("未登录状态")
    public void clickPolicySubjectProject(){
        assertMessage(notLoginStatus.clickPolicySubjectProject());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击我要申报弹出去登录的提醒")
    @Story("未登录状态")
    public void declare(){
        assertMessage(notLoginStatus.clare());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击订阅弹出去登录的提醒")
    @Story("未登录状态")
    public void subscribe(){
        assertMessage(notLoginStatus.subscribe());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击相关文件的附件弹出去登录的提醒")
    @Story("未登录状态")
    public void clickFile(){
        assertMessage(notLoginStatus.clickFile());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击相关文件的下载按钮弹出去登录的提醒")
    @Story("未登录状态")
    public void downloadFile(){
        assertMessage(notLoginStatus.downloadFile());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击项目摘要弹出去登录的提醒")
    @Story("未登录状态")
    public void clickProjectTab(){
        assertMessage(notLoginStatus.projectTab());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击项目摘要弹出去登录的提醒")
    @Story("未登录状态")
    public void clickRelationTab(){
        assertMessage(notLoginStatus.contactTab());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击获批名单弹出去登录的提醒")
    @Story("未登录状态")
    public void clickReceiveApprovalTab(){
        assertMessage(notLoginStatus.receiveApprovalTab());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【政策详情】未登录状态下点击政策文件弹出去登录的提醒")
    @Story("未登录状态")
    public void clickPolicyFileTab(){
        assertMessage(notLoginStatus.policyFileTab());
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【项目匹配】未登录状态下进入项目匹配页面弹出去登录的提醒")
    @Story("未登录状态")
    public void enterProjectMatchPage(){
        ArrayList<String> list=notLoginStatus.enterProjectMatchPage();
        assertEquals(list.get(0),"您还没登录呢！");
        assertEquals(list.get(1),"去登录");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【项目匹配】未登录状态下在项目匹配页面点击去登录，跳转登录页面")
    @Story("未登录状态")
    public void projectMatchPageClickGoToLogin(){
        assertEquals(notLoginStatus.projectMatchPageClickGoToLogin(),"欢迎登录政沣云");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【智能推送】未登录状态下进入智能推送页面弹出去登录的提醒")
    @Story("未登录状态")
    public void enterPushPage(){
        ArrayList<String> list=notLoginStatus.enterPushPage();
        assertEquals(list.get(0),"您还没登录呢！");
        assertEquals(list.get(1),"去登录");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【申报管家】未登录状态下进入申报管家页面弹出去登录的提醒")
    @Story("未登录状态")
    public void enterDeclareStewardPage(){
        ArrayList<String> list=notLoginStatus.enterDeclareStewardPage();
        assertEquals(list.get(0),"您还没登录呢！");
        assertEquals(list.get(1),"去登录");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：【申报管家】未登录状态下点击我的消息图标弹出去登录的提醒")
    @Story("未登录状态")
    public void clickMessageTag(){
        ArrayList<String> list=notLoginStatus.clickMessageTag();
        assertEquals(list.get(0),"您还没登录呢！");
        assertEquals(list.get(1),"去登录");
    }

    private static void assertMessage(ArrayList<String> list) {
        assertEquals(list.get(0),"请先登录账号");
        assertEquals(list.get(1),"去登录");
    }
}