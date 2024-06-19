package page;

import conf.Config;
import conf.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.RetryUtils;

import java.util.ArrayList;
import java.util.HashMap;

import static org.testng.Assert.*;

public class PolicyLibraryTest {
    public PolicyLibraryPage policyLibrary=new PolicyLibraryPage();
    public LoginPage loginPage=new LoginPage();
    Config config=Config.load("/config.yaml");

    @BeforeClass
    public void beforeClass(){
        Driver.start();
        loginPage.enterLoginPage();
        loginPage.verficationCodeLoginSuccess(config.username9,config.vercode);
        policyLibrary.waitlasterHotPolicyTitle();
        policyLibrary.enterpolicyLibrary();
    }

    @BeforeMethod
    public void beforeMethod(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().close();
        Driver.getThreadLocal().remove();
    }

    @Test(retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：进入政策文库，默认搜索系统当前城市的申报通知")
    @Story("政策文库")
    public void defaultSearchSuccess(){
        ArrayList<String> departmentList=policyLibrary.defaultSearch();
        for(String str:departmentList){
            assertTrue(policyLibrary.departmentList.contains(str));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：国家级")
    @Story("政策文库")
    public void countrySearch(){
        ArrayList<String> assertTextList=policyLibrary.searchCountry();
        for(String str:assertTextList){
            assertTrue(policyLibrary.departmentList.contains(str));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：国家级，主管部门为第一个部门")
    @Story("政策文库")
    public void countryDepartmentSearch(){
        ArrayList<String> assertTextList=policyLibrary.searchCountryDepartment();
        for(String str:assertTextList){
            assertTrue(str.equals(policyLibrary.assertText));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：省级")
    @Story("政策文库")
    public void provinceSearch(){
        ArrayList<String> departmentList=policyLibrary.searchProvince();
        for(String str:departmentList){
            assertTrue(policyLibrary.departmentList.contains(str));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：省级，主管部门为第一个部门")
    @Story("政策文库")
    public void provinceDepartmentSearch(){
        ArrayList<String> departmentList=policyLibrary.searchProvinceDepartment();
        for(String str:departmentList){
            assertTrue(str.equals(policyLibrary.assertText));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：区级，第一个区")
    @Story("政策文库")
    public void districtSearch(){
        ArrayList<String> departmentList=policyLibrary.searchDistrict();
        for(String str:departmentList){
            assertTrue(policyLibrary.departmentList.contains(str));
        }
    }

    @Test(priority = 0,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：区级，第一个区，主管部门为第一个部门")
    @Story("政策文库")
    public void districtDepartmentSearch(){
        ArrayList<String> departmentList=policyLibrary.searchDistrictDepartment();
        for(String str:departmentList){
            assertTrue(str.equals(policyLibrary.assertText));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：镇街级，第一个镇街")
    @Story("政策文库")
    public void StreetSearch(){
        ArrayList<String> departmentList=policyLibrary.searchStreet();
        for(String str:departmentList){
            assertTrue(policyLibrary.departmentList.contains(str));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索选择区域：镇街级，第一个镇街，主管部门为第一个部门")
    @Story("政策文库")
    public void StreetDepartmentSearch(){
        ArrayList<String> departmentList=policyLibrary.searchStreetDepartment();
        for(String str:departmentList){
            assertTrue(str.equals(policyLibrary.assertText));
        }
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索存在的政策原文标题")
    @Story("政策文库")
    public void policyTitleSearchSuccess(){
        String policyTitle="佛山市科学技术局 佛山市金融投资控股有限公司关于组织申报2019年佛山市科技型中小企业信贷风险补偿基金贷款贴息的通知" ;
        policyLibrary.searchPolicyTitleSuccess(policyTitle).forEach(title->{
            assertTrue(title.contains(policyTitle));
        });
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索存在的项目标题")
    @Story("政策文库")
    public void projectTitleSearchSuccess(){
        String projectTitle="疫情防控省工程中心" ;
        policyLibrary.searchProjectTitleSuccess(projectTitle).forEach(title->{
            assertTrue(title.contains("疫情"));
            assertTrue(title.contains("防控"));
            assertTrue(title.contains("省"));
            assertTrue(title.contains("工程中心"));
        });
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：搜索不存在的政策、项目关键字等")
    @Story("政策文库")
    public void policyTitleSearchFail(){
        String titles="null!" ;
        assertEquals(policyLibrary.searchPolicyTitleFail(titles),
                "没有找到关于\"null!\"的申报通知");
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索申报状态：申报中")
    @Story("政策文库")
    public void applySearch(){
        HashMap<Integer,ArrayList<String>> map=policyLibrary.searchApply();
        Boolean start=false;
        for(ArrayList<String> str:map.values()){
            for(String text:str){
                if(text.matches("【剩\\d*天】") || text.matches("【今天截止】")){
                    start=true;
                    break;
                }else {
                    start=false;
                    assertTrue(start);
                }
            }
        }
        assertTrue(start);
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索申报状态：已截止")
    @Story("政策文库")
    public void FinshSearch(){
        HashMap<Integer,ArrayList<String>> map=policyLibrary.searchFinsh();
        Boolean start=false;
        for(ArrayList<String> str:map.values()){
            for(String text:str){
                if(text.matches("【已截止】")){
                    start=true;
                    break;
                }else {
                    start=false;
                    assertTrue(start);
                }
            }
        }
        assertTrue(start);
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索扶持扶持方式：资金扶持")
    @Story("政策文库")
    public void searchSupportOne(){
        HashMap<Integer,ArrayList<String>> map=policyLibrary.searchOneSupport();
        Boolean start=false;
        for(ArrayList<String> str:map.values()){
            if(str.contains(policyLibrary.assertText)){
                start=true;
            }else {
                start=false;
                assertTrue(start);
            }
        }
        assertTrue(start);
    }

    @Test(priority = 1,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索扶持扶持方式：资金扶持")
    @Story("政策文库")
    public void searchSupportAll(){
        HashMap<Integer,ArrayList<String>> map=policyLibrary.searchAllSupport();
        Boolean start=false;
        for(ArrayList<String> str:map.values()){
            if(str.containsAll(policyLibrary.assertTextList)){
                start=true;
                break;
            }else {
                start=false;
                assertTrue(start);
            }
        }
        assertTrue(start);
    }

//    @Test(priority = 1)
//    @Description("正常测试用例：发文日期排序：升序")
//    @Story("政策文库")
//    public void publicDateSortAsc(){
//        ArrayList<String> list=policyLibrary.sortPublicDateAsc();
//        Boolean start=false;
//        for(int i=0;i<list.size()-1;i++){
//            System.out.println(Integer.parseInt(list.get(i).replace("-","")));
//            if(Integer.parseInt(list.get(i+1).replace("-",""))>=Integer.parseInt(list.get(i).replace("-",""))){
//                start=true;
//            }else {
//                start=false;
//                assertTrue(start);
//            }
//        }
//        assertTrue(start);
//    }
//
//    @Test(priority = 1)
//    @Description("正常测试用例：发文日期排序：降序")
//    @Story("政策文库")
//    public void publicDateSortDesc(){
//        ArrayList<String> list=policyLibrary.sortPublicDateDesc();
//        Boolean start=false;
//        for(int i=0;i<list.size()-1;i++){
//            if(Integer.parseInt(list.get(i+1).replace("-",""))<=Integer.parseInt(list.get(i).replace("-",""))){
//                start=true;
//            }else {
//                start=false;
//                assertTrue(start);
//            }
//        }
//        assertTrue(start);
//    }
//
//    @Test(priority = 1)
//    @Description("正常测试用例：截止日期：升序")
//    @Story("政策文库")
//    public void finishDateSortAsc(){
//        ArrayList<String> list=policyLibrary.sortFinishDateAsc();
//        Boolean start=false;
//        for(int i=0;i<list.size()-1;i++){
//            if(Integer.parseInt(list.get(i+1).replace("-",""))<=Integer.parseInt(list.get(i).replace("-",""))){
//                start=true;
//            }else {
//                start=false;
//                assertTrue(start);
//            }
//        }
//        assertTrue(start);
//    }

    @Test(priority = 5,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索政策文件关键字")
    @Story("政策文库")
    public void policyFileSearchSuccess(){
        ArrayList<String> list=policyLibrary.searchPolicyFileTitleSuccess();
        Boolean start=false;
        for(String str:list){
            if(str.contains(policyLibrary.assertText)){
                start=true;
            }else {
                start=false;
                assertTrue(start);
            }
        }
        assertTrue(start);
    }

    @Test(priority = 4,retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：搜索不存在的政策文件")
    @Story("政策文库")
    public void policyFileSearchFail(){
        String titles="null!" ;
        assertEquals(policyLibrary.searchPolicyFileTitleFail(titles),
                "没有找到关于 \"null!\" 的政策文件");
    }

    @Test(priority = 3,retryAnalyzer = RetryUtils.class)
    @Description("正常测试用例：搜索公示公告关键字")
    @Story("政策文库")
    public void noticeSearchSuccess(){
        ArrayList<String> list=policyLibrary.searchNoticeSuccess();
        Boolean start=false;
        for(String str:list){
            if(str.contains(policyLibrary.assertText)){
                start=true;
            }else {
                start=false;
                assertTrue(start);
            }
        }
        assertTrue(start);
    }

    @Test(priority = 2,retryAnalyzer = RetryUtils.class)
    @Description("异常测试用例：搜索不存在的公示公告")
    @Story("政策文库")
    public void noticeSearchFail(){
        String titles="null!" ;
        assertEquals(policyLibrary.searchNoticeFail(titles),
                "没有找到关于 \"null!\" 的公示公告");
    }

}