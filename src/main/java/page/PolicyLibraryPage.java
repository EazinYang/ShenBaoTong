package page;

import conf.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;

//政策文库页面
public class PolicyLibraryPage extends Method {
    //政策文库菜单按钮
    public static By policyLibraryMenu=xpathOrId("//ul[@class='menu_list']/li[2]");
    //城市下拉框
    public static By citySelect=xpathOrId("//div[@class='menu_address']/div/span");
    //政策文库-页面标题
    public By policyPageTitle=xpathOrId("//div[@class='policy']/div/span[2]/span[1]");
    //多选范围
    public static By multipleSelect=xpathOrId("//div[@class='complete']/div/div/div/div/div/span[1]");
    //筛选条件-选择区域：市级
    public static By filterLocationCity=xpathOrId("//div[@class='selectList_box']/div[2]/div/div[2]/div/div[@class='item active']");
    //筛选条件-选择区域：市级-佛山市
    public By filterLocationCityFoshan=xpathOrId("//div[@class='selectList_box']/div[2]/div/div[2]/div/div[4]");
    //筛选条件-选择区域：国家级
    public By filterLocationCountry=xpathOrId("//div[@class='selectList_box']/div[2]/div/div[2]/div/div[2]");
    //筛选条件-选择区域：省级
    public static By filterLocationProvince=xpathOrId("//div[@class='selectList_box']/div[2]/div/div[2]/div/div[3]");
    //筛选条件-选择区域-区县级：第一个区
    public static By filterLocationDistrictFirst=xpathOrId("//*[@class='areaList']/div[3]");
    //筛选条件-选择区域-镇街级：第一个街
    public static By filterLocationStreetFirst=xpathOrId("//*[@class='areaList_down']/div/div[3]");
    //筛选条件-选择区域：不限
    public static By filterLocationAll=xpathOrId("//div[@class=\"complete\"]/../div/div[2]/div[2]/div/div/div/div/span");
    //筛选条件-主管部门：不限
    public static By filterDepartmentAll=xpathOrId("//*[@class='selectList_box']/div[3]/div/div[2]/div/div[2]");
    //筛选条件-主管部门：所有主管部门共同的元素路径//*[@class='selectList_box']/div[3]/div/div[2]/div/div
    public static By filterDepartmentXpathAll=xpathOrId("//div[@class='areaList areaList_up']/div");
    //筛选条件-主管部门：第一个部门
    public static By filterDepartmentFirst=xpathOrId("//div[@class='selectList_box']/div[3]/div/div[2]/div/div[3]");
    //主管部门的下拉框
    public static By departmentSelect=xpathOrId("//*[@class='selectList_box']/div[3]/div/div[2]/div/div[1]");
    //筛选条件-政策范围：仅限本级
    public static By policyLevel=xpathOrId("//div[@class='selectList_box']/div[4]/div/div[2]/div/div[1]/span");
    //筛选条件-扶持方式：资金扶持
    public static By filterSupportCapital=By.partialLinkText("资金扶持");
    //筛选条件-扶持方式：不限
    public static By filterSupportAny=xpathOrId("//div[@class='selectList_box']/div[5]/div/div[2]/div[1]/div[1]/a");
    //筛选条件-扶持方式：所有
    public static By filterSupportAll=xpathOrId("//div[@class='selectList_box']/div[5]/div/div[2]/div/div/a");
    //排序方式：发文日期
    public static By publicDateSortAsc=xpathOrId("//div[@class='fcfs']/div[1]/div[2]/div[@class='triangle_up']");
    //排序方式：截止日期
    public static By finishDateSortAsc=xpathOrId("//div[@class='fcfs']/div[2]/div[2]/div[@class='triangle_up']");
    //更多筛选-按钮向下
    public static By moreFilter=xpathOrId("//div[@class='more']/div[2]/div[1]");
    //列表标题：主管部门字段
    public static By sponseTitles=xpathOrId("//div[@class='noticeList']/div/div/span[1]");
    //列表标题：发文日期
    public static By publicDateTitles=xpathOrId("//div[@class='noticeList']/div/div/span[2]");
    //筛选条件：政策名称/项目名称
    public static By filterTitleTextInput=xpathOrId("//input[@placeholder='请输入政策名称/项目名称']");
    //列表标题：政策搜索-政策原文标题字段
    public static By policyTitles=xpathOrId("//div[@class='noticeList']/div/a/div");
    //列表标题：项目标题
    public static By projectTitles=xpathOrId("//div[@class='noticeList']/div/div[2]/div/a/div[2]/div[1]");
    //搜索按钮
    public static By searchBtn=xpathOrId("//input[@placeholder='请输入政策名称/项目名称']/../div/button");
    //搜索结果为空的提示文本
    public static By emptyResultText=xpathOrId("//div[@class='el-empty']/../div[2]");
    //筛选条件-申报状态：申报中
    public static By filterApplyStart=xpathOrId("//div[@class='selectList_box']/div[1]/div/div[2]/div/div[2]/a");
    //筛选条件-中报状态：已截止
    public static By filterApplyFinsh=xpathOrId("//div[@class='selectList_box']/div/div/div[2]/div/div[3]/a[1]");
    //筛选条件-申报状态：不限
    public static By filterApplyAll=xpathOrId("//div[@class='selectList_box']/div/div/div[2]/div/div[1]/a[1]");
    //列表标题-政策原文：政策原文标题
    public static By basePolicyTitles=By.xpath("//div[@class='underline']");
    //列表标题-政策文件：政策文件最后一个的标题
    public static By lastPolicyFileTitle=xpathOrId("//div[@class='regulations']/div[10]/a/div/div[1]");
    //列表标题-政策文件：政策文件标题
    public static By policyFileTitles=xpathOrId("//div[@class='title_line']");
    //文件类型：申报通知
    public static By fileType=xpathOrId("//div[@class='complete']/../div[3]/div/div/a");
    //文件类型：政策文件
    public static By policyFile=xpathOrId("//div[@class='complete']/../div[3]/div/div[2]/a");
    //文件类型：公示公告
    public static By notice=xpathOrId("//div[@class='complete']/../div[3]/div/div[3]/a");
    //公示公告：政策标题
    public static By noticeTitles=xpathOrId("//div[@class='title_line']");
    //政策文件列表xpath
    public static By policyFileXpath=xpathOrId("//div[@class='regulations']");
    //政策搜索-页面标题
    public static By pageTitle=xpathOrId("//div[@class='policySearch']/div/span[3]/span[1]");
    //页面字符；国家到镇街五级政府政策，一键查询
    public static By listTitleInfo=xpathOrId("//div[@class='search']/div/div[1]");

    public ArrayList<String> departmentList=new ArrayList<>();
    public ArrayList<String> assertTextList=new ArrayList<>();
    public String assertText="";
    public ArrayList<String> policyDetailInfo=new ArrayList<>();

    //申报通知总的数据数量
    //todo:5.10 15：03修改：polictAll="申报通知 (100)"
    public String polictyAll="申报通知  (2171)";
    //政策文件总的数据量
    public String policyFileAll="";
    //公示公告总的数据量
    public String noticeAll="";

    public void waitlasterHotPolicyTitle(){
        waitText(HomePage.lasterHotPolicyTitle,"近期热门政策");
    }

    //进入政策文库页面
    public void enterpolicyLibrary(){
        find(policyLibraryMenu).click();
        find(searchBtn).click();
        wait(fileType);
        policyFileAll=find(policyFile).getText();
        noticeAll=find(notice).getText();
        polictyAll=find(fileType).getText();

    }


    //【申报通知】筛选：进入到政策文库默认搜索当前系统选择的城市
    public ArrayList<String> defaultSearch(){
        assertText="";
        assertText=find(filterLocationCity).getText();
//        if(!assertText.equals(find(citySelect).getText())){
//            throw new RuntimeException("选择区域没有选择当前页面默认的市级地点！");
//        }
        find(filterLocationCityFoshan).click();
        moreFilterAndDepartment();
        finds(filterDepartmentXpathAll).forEach((webElement -> {
            departmentList.add(webElement.getText());
        }));
        departmentList.remove("不限");
        finds(sponseTitles).forEach((webElement -> {
            assertTextList.add(webElement.getText());
        }));
        find(filterLocationAll).click();
        try{
            Thread.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        polictyAll=find(fileType).getText();
        return assertTextList;
    }


    //获取title字段并存储
    public void getTitles(ArrayList<String> list, By by,By updateText,String text){
        list.clear();
        System.out.println(polictyAll);
        System.out.println(find(fileType).getText());
        waitNoText(updateText,text);
        System.out.println(find(fileType).getText());
        finds(by).forEach((webElement -> {
            list.add(webElement.getText());
        }));
    }

    //获取系统当前的城市
    public String getCitySelectText(){
        return find(citySelect).getText();
    }

    //【申报通知】筛选：输入存在的政策名称
    public ArrayList<String> searchPolicyTitleSuccess(String title){
        titleSearch(title);
        getTitles(assertTextList,policyTitles,fileType,polictyAll);
        find(filterTitleTextInput).sendKeys(Keys.CONTROL,"a");
        find(filterTitleTextInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        find(searchBtn).click();
        waitUrl("keyWord=&");
        find(filterLocationAll).click();
        return assertTextList;
    }

    //【申报通知】筛选：输入存在的项目名称
    public ArrayList<String> searchProjectTitleSuccess(String title){
        titleSearch(title);
        waitText(projectTitles,"疫情防控省工程中心");
        getTitles(assertTextList,projectTitles,fileType,polictyAll);
        find(filterTitleTextInput).sendKeys(Keys.CONTROL,"a");
        find(filterTitleTextInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        find(searchBtn).click();
        waitUrl("keyWord=&");
        find(filterLocationAll).click();
        return assertTextList;
    }

    //封装输入title、点击搜索过程
    public void titleSearch(String title){
        find(filterTitleTextInput).clear();
        find(filterTitleTextInput).sendKeys(title);
        find(pageTitle).click();
        find(searchBtn).click();
    }

    //【申报通知】筛选：不存在的政策、项目等
    public String searchPolicyTitleFail(String title){
        titleSearch(title);
        String tis=find(emptyResultText).getText();
        find(filterTitleTextInput).clear();
        find(searchBtn).click();
        getDriver().navigate().refresh();
        policyFileAll=find(policyFile).getText();
        noticeAll=find(notice).getText();
        polictyAll=find(fileType).getText();
        find(filterLocationAll).click();
        return tis;
    }

    //【申报通知】筛选：搜索申报状态="申报中"
    public HashMap<Integer,ArrayList<String>> searchApply(){
        HashMap<Integer,ArrayList<String>> map=getProjectMap(filterApplyStart,"]/div[2]/div/a/div[1]");
        find(filterApplyAll).click();
        return map;
    }

    //【申报通知】筛选：搜索申报状态="已截止"
    public HashMap<Integer,ArrayList<String>> searchFinsh(){
        find(filterLocationAll).click();
        HashMap<Integer,ArrayList<String>> map=getProjectMap(filterApplyFinsh,"]/div[2]/div/a/div[1]");
        find(filterApplyAll).click();
        return map;
    }

    /*
    封装：定位项目标题父级元素，作为键，再拼接剩余天数的元素路径。达到一个键(项目标题框架)mapping多个的剩余天数
    待优化：目前靠等待title的变化，来查找元素个数,不稳定
     */
    public HashMap<Integer,ArrayList<String>> getProjectMap(By by,String xpath){
        return getProjectValueMap(by,xpath);
    }

    private HashMap<Integer, ArrayList<String>> getProjectValueMap(By by,String xpath) {
        moreFilterAndDepartment();
        find(by).click();
        assertText = find(by).getText();
        waitNoText(fileType,polictyAll);
        //项目标题父级元素
        String xpath1="//*[@class='noticeList']/div";
        int xpathNum1=finds(xpathOrId(xpath1)).size();
        System.out.println(xpathNum1);
        HashMap<Integer,ArrayList<String>> status=new HashMap<>();

        for(int i=1;i<=xpathNum1;i++){
            //剩余天数的元素路径拼接
//            String xpath2=xpath1+"["+i+"]/div[2]/div/a/div[1]";
            String xpath2=xpath1+"["+i+xpath;
//                                       /div[2]/div/a/div[2]/div[2]/div
            //+展开更多的路径拼接
            String xpath3=xpath1+"["+i+"]/div[2]/div[last()]";
            if(find(xpathOrId(xpath3)).getText().contains("+展开更多")){
                find(xpathOrId(xpath3)).click();
            }
            ArrayList<String> text=new ArrayList<>();
            finds(xpathOrId(xpath2)).forEach(webElement -> {
                text.add(webElement.getText());
            });
            status.put(i,text);
        }
        return status;
    }

    //【申报通知】筛选：选择区域=国家级
    public ArrayList<String> searchCountry(){
        regionSearch(filterLocationCountry);
        return assertTextList;
    }

    //【申报通知】筛选：选择区域：国家级，主管部门：选择搜索第一个部门
    public ArrayList<String> searchCountryDepartment(){
        departmentSearch(filterLocationCountry);
        return assertTextList;
    }

    //【申报通知】筛选：选择区域：省级
    public ArrayList<String> searchProvince(){
        regionSearch(filterLocationProvince);
        return assertTextList;
    }

    //【申报通知】筛选：选择区域：省级，主管部门：选择搜索第一个部门
    public ArrayList<String> searchProvinceDepartment(){
//        find(filterLocationAll).click();
        departmentSearch(filterLocationProvince);
        return assertTextList;
    }

    //【申报通知】筛选：选择区域：区县级
    public ArrayList<String> searchDistrict(){
        find(filterLocationCityFoshan).click();
        regionSearch(filterLocationDistrictFirst);
        return assertTextList;
    }

    //【申报通知】筛选：选择区域：区县级，主管部门：选择搜索第一个部门
    public ArrayList<String> searchDistrictDepartment(){
        find(filterLocationCityFoshan).click();
        departmentSearch(filterLocationDistrictFirst);
        return assertTextList;
    }

    //【申报通知】筛选：选择区域：镇街级
    public ArrayList<String> searchStreet(){
        find(filterLocationCityFoshan).click();
        find(filterLocationDistrictFirst).click();
        regionSearch(filterLocationStreetFirst);
        return assertTextList;
    }

    //【申报通知】筛选：选择区域：区县级，主管部门：选择搜索第一个部门
    public ArrayList<String> searchStreetDepartment(){
        find(filterLocationCityFoshan).click();
        find(filterLocationDistrictFirst).click();
        departmentSearch(filterLocationStreetFirst);
        return assertTextList;
    }

    //封装：搜索选择区域：国家级、省、市、区县
    public void regionSearch(By by){
        selectLocation(by);
        getTitles(departmentList,filterDepartmentXpathAll,fileType,polictyAll);
        departmentList.remove("不限");
        for(String str:departmentList){
            System.out.println(str);
        }
        getTitles(assertTextList,sponseTitles,fileType,polictyAll);
        find(filterLocationAll).click();
    }


    //封装：搜索选择区域：国家、省级下的部门
    private void departmentSearch(By by) {
        selectLocation(by);
        WebElement department=find(filterDepartmentFirst);
        assertText=department.getText();
        department.click();
        getTitles(assertTextList,sponseTitles,fileType,polictyAll);
        find(filterLocationAll).click();
    }

    //封装：点击选择区域--点击"更多筛选"--点击"主管部门"下拉框
    private static void selectLocation(By by) {
        find(by).click();
        moreFilterAndDepartment();
    }

    private static void moreFilterAndDepartment() {
        if(find(moreFilter).getAttribute("class").contains("next more_down")){
            find(moreFilter).click();
        }
        find(policyLevel).click();
        if(find(moreFilter).getAttribute("class").contains("next more_down")){
            find(moreFilter).click();
        }
        if(find(departmentSelect).getAttribute("class").contains("next down")){
            find(departmentSelect).click();
        };
    }

    //【申报通知】筛选：扶持方式,资金扶持方式
    public HashMap<Integer,ArrayList<String>> searchOneSupport(){
        moreFilterAndDepartment();
        HashMap<Integer,ArrayList<String>> map=getProjectMap(filterSupportCapital,"]/div[2]/div/a/div[2]/div[2]/div");
        if(find(moreFilter).getAttribute("class").contains("next more_down")){
            find(moreFilter).click();
        }
        find(filterSupportAny).click();
        return map;
    }

    //【申报通知】筛选：扶持方式，勾选所有扶持方式
    public HashMap<Integer,ArrayList<String>> searchAllSupport(){
        assertTextList.clear();
        moreFilterAndDepartment();
        if(find(moreFilter).getAttribute("class").contains("next more_down")){
            find(moreFilter).click();
        }
        assertTextList.add(find(filterSupportCapital).getText());
        for(WebElement webElement:finds(filterSupportAll)){
            if(!webElement.getText().contains("不限")){
                assertTextList.add(webElement.getText());
                webElement.click();
            }
        }
        HashMap<Integer,ArrayList<String>> map=getProjectMap(filterSupportCapital,"]/div[2]/div/a/div[2]/div[2]/div");
        if(find(moreFilter).getAttribute("class").contains("next more_down")){
            find(moreFilter).click();
        }
        find(filterSupportAny).click();
        return map;
    }

    //【申报通知】排序方式：发文日期升序
    public ArrayList<String> sortPublicDateAsc(){
        dateSort(publicDateSortAsc,find(publicDateSortAsc).getAttribute("style").contains("184, 184, 184"));
        return assertTextList;
    }

    //封装排序
    private void dateSort(By by, Boolean b) {
        if(b){
            find(by).click();
        }
        getTitles(assertTextList,publicDateTitles,fileType,polictyAll);
    }

    //【申报通知】排序方式：发文日期降序
    public ArrayList<String> sortPublicDateDesc(){
        dateSort(publicDateSortAsc,!find(publicDateSortAsc).getAttribute("style").contains("184, 184, 184"));
        return assertTextList;
    }


//    //【申报通知】排序方式：截止日期升序
//    public ArrayList<String> sortFinishDateAsc(){
//        dateSort(finishDateSortAsc,find(finishDateSortAsc).getAttribute("style").contains("184, 184, 184"));
//        return assertTextList;
//    }
//
//    //【申报通知】排序方式：截止日期降序
//    public ArrayList<String> sortFinishDateDesc(){
//        dateSort(finishDateSortAsc,!find(finishDateSortAsc).getAttribute("style").contains("184, 184, 184"));
//        return assertTextList;
//    }

    //【政策文件】筛选：通过关键字搜索政策文件
    public ArrayList<String> searchPolicyFileTitleSuccess(){
        find(policyFile).click();
        while(!getDriver().getPageSource().contains("政策文件-政策申报服务平台-政沣云")){
            System.currentTimeMillis();
        }
        assertText=find(lastPolicyFileTitle).getText();
        titleSearch(assertText);
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        getTitles(assertTextList,policyFileTitles,policyFile,policyFileAll);
        find(filterTitleTextInput).sendKeys(Keys.CONTROL,"a");
        find(filterTitleTextInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        find(fileType).click();
        wait(multipleSelect);
        return assertTextList;
    }

    //【政策文件】筛选：不存在的政策文件
    public String searchPolicyFileTitleFail(String str){
        find(policyFile).click();
        while(!getDriver().getPageSource().contains("政策文件-政策申报服务平台-政沣云")){
            System.currentTimeMillis();
        }
        titleSearch(str);
        String text=find(emptyResultText).getText();
        policyFileAll=find(policyFile).getText();
        noticeAll=find(notice).getText();
        polictyAll=find(fileType).getText();
        find(filterTitleTextInput).sendKeys(Keys.CONTROL,"a");
        find(filterTitleTextInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        find(fileType).click();
        wait(multipleSelect);
        return text;
    }

    //【政策文件】筛选：通过关键字搜索公式公告
    public ArrayList<String> searchNoticeSuccess(){
        getDriver().navigate().refresh();
        find(notice).click();
        while(!getDriver().getPageSource().contains("公示公告-政策申报服务平台-政沣云")){
            System.currentTimeMillis();
        }
        assertText=find(lastPolicyFileTitle).getText();
        titleSearch(assertText);
        getTitles(assertTextList,policyFileTitles,notice,noticeAll);
        find(filterTitleTextInput).sendKeys(Keys.CONTROL,"a");
        find(filterTitleTextInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        find(fileType).click();
        wait(multipleSelect);
        getDriver().navigate().refresh();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return assertTextList;
    }

    //【政策文件】筛选：不存在的公示公告
    public String searchNoticeFail(String str){
        find(notice).click();
        while(!getDriver().getPageSource().contains("公示公告-政策申报服务平台-政沣云")){
            System.currentTimeMillis();
        }
        titleSearch(str);
        String text=find(emptyResultText).getText();
        find(filterTitleTextInput).sendKeys(Keys.CONTROL,"a");
        find(filterTitleTextInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        find(fileType).click();
        wait(multipleSelect);
        return text;
    }

    //进入申报通知详情页
    public void enterPolicyDeatil(String title){
        titleSearch(title);
        waitNoText(fileType,polictyAll);
        find(policyTitles).click();
    }

    //进入公示公告详情页
    public void enterNoticeDeatil(String title){
        find(notice).click();
//        waitElementDisapper(multipleSelect);
        while(!getDriver().getPageSource().contains("公示公告-政策申报服务平台-政沣云")){
            System.currentTimeMillis();
        }
        titleSearch(title);
        waitNoText(fileType,polictyAll);
        find(noticeTitles).click();
    }

    //进入政策文件详情页
    public void enterPolicyFileDeatil(String title){
        find(policyFile).click();
        while(!getDriver().getPageSource().contains("政策文件-政策申报服务平台-政沣云")){
            System.currentTimeMillis();
        }
        titleSearch(title);
        waitNoText(policyFile,policyFileAll);
        find(policyFileTitles).click();
    }

    public String getPageText() {
        return find(pageTitle).getText();
    }

    //获取主管部门
    public ArrayList<String> getDepartmentList(By by){
        find(by).click();
        moreFilterAndDepartment();
        ArrayList<String> list=new ArrayList<>();
        finds(filterDepartmentXpathAll).forEach((webElement -> {
            list.add(webElement.getText());
        }));
        list.remove("不限");
        return list;
    }
}
