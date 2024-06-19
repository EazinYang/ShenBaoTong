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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class PushPageTest {
    LoginPage loginPage=new LoginPage();
    Config config=Config.load("/config.yaml");
    PolicyFileDetailPage policyFileDetailPage=new PolicyFileDetailPage();
    PushPage pushPage=new PushPage();
    PolicyLibraryPage policyLibraryPage=new PolicyLibraryPage();
    UserCenter userCenter=new UserCenter();

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username13, config.vercode);
        pushPage.waitlasterHotPolicyTitle();
        pushPage.enterPushPage();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目:根据关键字搜索存在的项目")
    @Story("智能推送")
    public void searchAdaptiveProjectSuccess(){
        ArrayList<String> titles= pushPage.searchAdaptiveProjectSuccess("智能推送");
        titles.forEach(string -> {
            assertTrue(string.contains("智能推送"));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：根据关键字搜索不存在的项目")
    @Story("智能推送")
    public void searchAdaptiveProjectFail(){
        assertEquals(pushPage.searchAdaptiveProjectFail("null!"),"暂无内容");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：根据发文时间排序")
    @Story("智能推送")
    public void publishTimeSort(){
        ArrayList<String> list=pushPage.publishTimeSort();
        for(int i=0;i<list.size()-1;i++){
            assertTrue(Integer.parseInt(list.get(i+1))<=Integer.parseInt(list.get(i)));
        }
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：根据截止时间排序")
    @Story("智能推送")
    public void endTimeSort(){
        ArrayList<String> list=pushPage.endTimeSort();
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i+1).matches("\\d*") && list.get(i).matches("\\d*")){
                assertTrue(Integer.parseInt(list.get(i))>=Integer.parseInt(list.get(i+1)));
            }else if (list.get(i).matches("\\d*") && list.get(i+1).matches("今天截止")){
                assertTrue(true);
            }else if (list.get(i).matches("\\d*") && list.get(i+1).matches("未启动")){
                assertTrue(true);
            }else if (list.get(i).matches("今天截止") && list.get(i+1).matches("未启动")){
                assertTrue(true);
            }else if (list.get(i).matches("今天截止") && list.get(i+1).matches("\\d*")){
                assertTrue(false);
            }else if (list.get(i).matches("未启动") && list.get(i+1).matches("\\d*")){
                assertTrue(false);
            }else if (list.get(i).matches("未启动") && list.get(i+1).matches("今天截至")){
                assertTrue(false);
            }
        }
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：扶持方式：资金扶持")
    @Story("智能推送")
    public void filterSupportOneSuccess(){
        HashMap<String,ArrayList<String>> map=pushPage.filterSupportOneSuccess();
        map.entrySet().forEach(entry -> {
            assertTrue(entry.getValue().contains("资金"));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：扶持方式：资金扶持，称号认定")
    @Story("智能推送")
    public void filterSupportMultiSuccess(){
        HashMap<String,ArrayList<String>> map=pushPage.filterSupporMultiSuccess();
        map.entrySet().forEach(entry -> {
            assertTrue(entry.getValue().contains("资金"));
            assertTrue(entry.getValue().contains("称号"));
        });
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：清空输入的搜索历史关键词")
    @Story("智能推送")
    public void clearInputHistory(){
        assertEquals(pushPage.clearInputHistory(),"删除成功");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：关注政策：搜索单个关键词")
    @Story("智能推送")
    public void searchOneKeywordSuccess(){
        ArrayList<String> titles= pushPage.searchOneKeywordSuccess("技术");
        titles.forEach(string -> {
            assertTrue(string.contains("技术"));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：关注政策：搜索多个关键词")
    @Story("智能推送")
    public void searchMultiKeywordSuccess(){
        ArrayList<String> titles= pushPage.searchMultiKeywordSuccess("技术","科技","新型");
        titles.forEach(string -> {
            assertTrue(string.contains("技术") || string.contains("科技") || string.contains("新型") );
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：申报状态：申报中")
    @Story("智能推送")
    public void filterApplySuccess(){
        ArrayList<String> list=pushPage.filterApplySuccess();
        list.forEach(string -> {
            assertTrue(string.matches("剩\\d*天"));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：申报状态：已截止")
    @Story("智能推送")
    public void filterFinishSuccess(){
        ArrayList<String> list=pushPage.filterFinishSuccess();
        list.forEach(string -> {
            assertTrue(string.equals("今天截止") || string.equals("未启动"));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：点击完善信息跳转用户中心页面")
    @Story("智能推送")
    public void completeInfomaton(){
        assertEquals(pushPage.completeInfomaton(userCenter),"用户中心");
    }

    @DataProvider(name = "匹配项目")
    public Object[][] matchProjectData(){
        return new Object[][]{
                {},{},{},{}
        };
    }

    @Test(dataProvider = "匹配项目",retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：匹配项目")
    @Story("智能推送")
    public void matchProject(){
        if(pushPage.matchProjectNum.contains("0")){
            assertEquals(pushPage.matchProjectFail(),"今天刷新次数已用完");
        }else if(!pushPage.matchProjectNum.contains("0")){
            String num=pushPage.matchProjectSuccess();
            assertTrue(Integer.parseInt(num)==Integer.parseInt(pushPage.assertText)-1);
        }
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：适配项目：跳转项目摘要页")
    @Story("智能推送")
    public void adaptiveSkipProjectDetailSuccess(){
        assertEquals(pushPage.adaptiveSkipProjectDetail(policyFileDetailPage),pushPage.assertText);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：关注政策：搜索国家级政策等级")
    @Story("智能推送")
    public void searchOnePolicyLevelSuccess(){
        ArrayList<String> titles= pushPage.searchOnePolicyLevelSuccess(policyLibraryPage);
        titles.forEach(string -> {
            assertTrue(pushPage.assertList.contains(string));
        });
    }

    @Test()
    @Description("正常测试用例：关注政策：搜索国家级、市级政策等级")
    @Story("智能推送")
    public void searchMultiPolicyLevelSuccess(){
        ArrayList<String> titles= pushPage.searchMultiPolicyLevelSuccess(policyLibraryPage);
        titles.forEach(string -> {
            assertTrue(pushPage.assertList.contains(string));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：关注政策：搜索关键词、国家级政策等级组合搜索")
    @Story("智能推送")
    public void searchKeywordAndPolicyLevelSuccess(){
        HashMap<String,ArrayList<String>> titles= pushPage.searchKeywordAndPolicyLevelSuccess("技术",policyLibraryPage);
        titles.get("政策标题").forEach(string -> {
            assertTrue(string.contains("技术"));
        });
        titles.get("主管部门").forEach(string -> {
            assertTrue(pushPage.assertList.contains(string));
        });
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：关注政策：跳转政策详情页")
    @Story("智能推送")
    public void attentionSkipPolicyDetailSuccess(){
        String title= pushPage.attentionSkipPolicyDetail(policyFileDetailPage,"技术");
        assertEquals(title,pushPage.assertText);
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：关注政策：跳转项目详情页")
    @Story("智能推送")
    public void attentionSkipProjectDetailSuccess(){
        String title= pushPage.attentionSkipProjectDetail(policyFileDetailPage,"技术");
        assertEquals(title,pushPage.assertText);
    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：我的订阅：跳转政策详情页")
    @Story("智能推送")
    public void skipPolictDetailSuccess(){
        String title= pushPage.skipPolicyDetail(policyFileDetailPage);
        assertEquals(title,pushPage.assertText);
    }
}