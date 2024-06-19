package page;

import com.github.javafaker.Faker;
import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RetryUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import static org.testng.Assert.*;

public class ProjectMatchPageTest {
    LoginPage loginPage=new LoginPage();
    Config config=Config.load("/config.yaml");
    PolicyFileDetailPage policyFileDetailPage=new PolicyFileDetailPage();
    ProjectMatchPage projectMatchPage=new ProjectMatchPage();
    Faker faker=new Faker(Locale.CHINA);

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username11, config.vercode);
        projectMatchPage.waitlasterHotPolicyTitle();
        projectMatchPage.enterProjectMatch();
        projectMatchSuccsess();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().quit();
        Driver.getThreadLocal().remove();
    }

    @Description("正常测试用例：项目匹配成功")
    @Story("项目匹配")
    public void projectMatchSuccsess(){
        ArrayList<String> arrayList=projectMatchPage.searchCompany(config.company);
        assertEquals(arrayList.get(0),config.company);
        assertTrue(Double.parseDouble(arrayList.get(1))>0);
        assertTrue(Integer.parseInt(arrayList.get(2))>0);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：申报成功")
    @Story("项目匹配")
    public void declareSuccsess(){
        assertEquals(projectMatchPage.declareSuccess(config.company,faker.name().fullName(),faker.phoneNumber().cellPhone(),"备注"),"提交成功，平台客服稍后会与您联系");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：申报成功")
    @Story("项目匹配")
    public void filterSupportSuccess(){
        HashMap<String,ArrayList<String>> map=projectMatchPage.filterSupportSuccess();
        map.entrySet().forEach(entry -> {
            assertTrue(entry.getValue().contains("称号"));
        });
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：根据发文时间排序")
    @Story("项目匹配")
    public void publishTimeSort(){
        ArrayList<String> list=projectMatchPage.publishTimeSort();
        for(int i=0;i<list.size()-1;i++){
            assertTrue(Integer.parseInt(list.get(i+1))<=Integer.parseInt(list.get(i)));
        }
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：根据截止时间排序")
    @Story("项目匹配")
    public void endTimeSort(){
        ArrayList<String> list=projectMatchPage.endTimeSort();
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

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击项目标题，打开对应的项目摘要页")
    @Story("项目匹配")
    public void openProjectDetail(){
        assertEquals(projectMatchPage.openProjectDetail(policyFileDetailPage),projectMatchPage.assertText);
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：点击切换，更换企业匹配")
    @Story("项目匹配")
    public void switchCompanyMatch(){
        ArrayList<String> arrayList=projectMatchPage.switchCompanyMatch("北京安恒测试技术有限公司");
        assertEquals(arrayList.get(0),"北京安恒测试技术有限公司");
        assertTrue(Double.parseDouble(arrayList.get(1))>0);
        assertTrue(Integer.parseInt(arrayList.get(2))>0);
    }
}