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
import java.util.Locale;

import static org.testng.Assert.*;

public class DeclareStewardPageTest {
    LoginPage loginPage=new LoginPage();
    DeclareStewardPage declareStewardPage=new DeclareStewardPage();
    Config config=Config.load("/config.yaml");
    PolicyFileDetailPage policyFileDetailPage=new PolicyFileDetailPage();
    Faker faker=new Faker(Locale.CHINA);

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username1, config.vercode);
        declareStewardPage.waitlasterHotPolicyTitle();
        declareStewardPage.enterDeclareStewardPage();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：申报计划-取消计划")
    @Story("申报管家")
    public void cancelPlanSuccess(){
        assertEquals(declareStewardPage.cancelPlan(),"取消纳入成功");
        assertTrue(!declareStewardPage.assertText1.equals(declareStewardPage.assertText2));
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：申报计划-点击项目标题跳转项目摘要页面")
    @Story("申报管家")
    public void skipProjectDetail(){
        assertEquals(declareStewardPage.skipProjectDetail(policyFileDetailPage),declareStewardPage.assertText1);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-上传无限期材料成功")
    @Story("申报管家")
    public void uploadIndefiniteDurationFileSuccess(){
        String text=faker.random().hex();
       assertEquals(declareStewardPage.uploadIndefiniteDurationFileSuccess(text,"D:\\Desktop\\IMS\\house (1).jpg"),"新增成功");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-上传有效期内材料成功")
    @Story("申报管家")
    public void uploadValidityFileSuccess(){
        String text=faker.random().hex();
        assertEquals(declareStewardPage.uploadValidityFileSuccess(text,"D:\\Desktop\\IMS\\house (1).jpg","2024-05-28","2024-12-31"),"新增成功");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-材料名称为空，保存失败")
    @Story("申报管家")
    public void nullMeterialSaveFail(){
        assertEquals(declareStewardPage.nullMeterialSaveFail("D:\\Desktop\\IMS\\house (1).jpg"),"请输入材料名称");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-分类为空，保存失败")
    @Story("申报管家")
    public void nullClasifySaveFail(){
        assertEquals(declareStewardPage.nullClasifySaveFail(faker.random().hex(),"D:\\Desktop\\IMS\\house (1).jpg"),"请选择分类");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-文件为空，保存失败")
    @Story("申报管家")
    public void nullFileSaveFail(){
        assertEquals(declareStewardPage.nullFileSaveFail(faker.random().hex()),"请上传文件");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-有效期为空，保存失败")
    @Story("申报管家")
    public void nullTimeSaveFail(){
        assertEquals(declareStewardPage.nullTimeSaveFail(faker.random().hex(),"D:\\Desktop\\IMS\\house (1).jpg"),"请选择有效期");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-筛选：一级分类")
    @Story("申报管家")
    public void oneLevelClasifySearchSuccess(){
        ArrayList<String> list=declareStewardPage.oneLevelClasifySearchSuccess();
        assertTrue(list.contains("增值税申报表"));
        assertTrue(list.contains("财务审计报告"));
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：佐证材料-筛选：二分类")
    @Story("申报管家")
    public void twoLevelClasifySearchSuccess(){
        ArrayList<String> list=declareStewardPage.twoLevelClasifySearchSuccess();
        System.out.println(list.toString());
        assertTrue(!list.contains("增值税申报表"));
        assertTrue(list.contains("财务审计报告"));
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：编辑材料名称成功")
    @Story("申报管家")
    public void editSuccess(){
        String text=faker.random().hex();
        assertEquals(declareStewardPage.editSuccess(text),text);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：删除文件成功")
    @Story("申报管家")
    public void deleteSuccess(){
        assertEquals(declareStewardPage.deleteSuccess(),"删除成功");
    }
}