package page;

import conf.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.ArrayList;
import java.util.HashMap;

public class PushPage extends Method {
    //智能推送菜单按钮
    public By pushMenu=By.partialLinkText("智能推送");
    //页面标题
    public static By pushPageTitle=xpathOrId("//div[@class='push-banner']/h3");
    //我的订阅页面
    public static By subscribe=xpathOrId("//div[@class='choose']/div[3]");
    //我的订阅-政策标题
    public static By subscribeTitles=xpathOrId("//div[@class='title']/div/div[1]/span");
    //我的订阅-页面标题
    public static By subscribePageTitle=xpathOrId("//div[@class='subscribe']/span[1]");
    //我的订阅-暂无更多按钮
    public static By showMore=xpathOrId("//div[@class='showMore']");
    //关注政策页面
    public static By attentionPolicy=xpathOrId("//div[@class='choose']/div[2]");
    //关注政策-页面标题
    public static By attentionPolicyPageTitle=xpathOrId("//div[@class='follow']/span[1]");
    //关注政策-暂无内容
    public static By attentionPolicyNoDataText=xpathOrId("//div[@class='el-empty']/div[2]/p");
    //关注政策-关注设置按钮
    public static By attentionSettingBtn=xpathOrId("//div[@class='follow']/span[2]");
    //关注政策-关注设置-添加关键词字符
    public static By keywordAddText=xpathOrId("//div[@class='addKeyword']/p");
    //关注政策-关注设置-添加关键词【+】
    public static By keywordAddBtn=xpathOrId("//div[@class='addKeyword']/div/img");
    //关注政策-关注设置-输入关键词
    public static By keywordInput=xpathOrId("//div[@class='addKeyword']/div/div/div/input");
    //关注政策-关注设置-关键词文本
    public static By keywordInputtext=xpathOrId("//div[@class='addKeyword']/div/div/span");
    //关注政策-关注设置-保存设置按钮
    public static By attentionSettingSaveBtn=xpathOrId("//div[@class='dialog-footer']/button");
    //关注政策-政策标题
    public static By attentionPolicyTitles=xpathOrId("//div[@class='title']/div/div[1]");
    //关注政策-项目标题
    public static By attentionProjectTitles=xpathOrId("//div[@class='zc-content']/ul/li/div[1]");
    //关注政策-主管部门标题
    public static By attentionDepartmentTitles=xpathOrId("//div[@class='title']/div/div[2]/span[1]");
    //关注政策-关注设置-关键词删除按钮
    public static String keywordDeleteBtn="//div[@class='el-dialog__body']/div/div/div/span[1]/i";
    //关注政策-关注设置-政策等级下拉框
    public static By policyLevelSelect=xpathOrId("//input[@placeholder='请选择']");
    //关注政策-关注设置-政策等级：国家级
    public static By policyLevelSelectContry=xpathOrId("//div[@class='el-scrollbar']/div/ul/li[1]");
    //关注政策-关注设置-政策等级：市级
    public static By policyLevelSelectCity=xpathOrId("//div[@class='el-scrollbar']/div/ul/li[3]");
    //关注政策-关注设置-政策等级删除按钮
    public static By policyLevelDeleteBtn=xpathOrId("//div[@class='el-dialog__body']/div[2]/div/div[2]/span/span/i");
    //适配项目
    public static By adaptiveProject=xpathOrId("//div[@class='choose']/div[1]");
    //适配项目-搜索项目
    public static By searchProjectInput=xpathOrId("//input[@placeholder='搜索项目']");
    //适配项目-项目标题
    public static By adaptiveProjectTitles=xpathOrId("//div[@class='project_title']");
    //适配项目-发文时间
    public static By publicTimeTitles=xpathOrId("//div[@class='start_time']/span[1]");
    //适配项目-截止时间
    public static By endTimeTitles=xpathOrId("//li[@class='li_card']/div[4]/div[1]");
    //适配项目-扶持方式
    public static By supportTag=xpathOrId("//li[@class='li_card'][1]/div[4]/div");
    //适配项目-清除全部历史
    public static By clearInputHistoryBtn=xpathOrId("//div[@role='region']/div/div/ul/li[last()]");
    //适配项目-排序：时间排序下拉框
    public static By timeSortSelect=xpathOrId("//div[@class='condition']/div[1]/div/div[2]/span[1]");
    //适配项目-排序：发文时间
    public static By publicTimeOption=xpathOrId("/html/body/div[last()]/div/div/ul/li[2]");
    //适配项目-排序：截止时间
    public static By endTimeOption=xpathOrId("/html/body/div[last()]/div/div/ul/li[3]");
    //适配项目-筛选：扶持方式下拉框
    public static By supportSelect=xpathOrId("//div[@class='condition']/div[2]/div/div[2]/span[1]");
    //适配项目-扶持方式：不限
    public static By supportAll=xpathOrId("/html/body/div[last()]/div/div/ul/li[1]/span");
    //适配项目-扶持方式：资金扶持
    public static By supportCapitalOption=xpathOrId("/html/body/div[last()]/div/div/ul/li[2]/span");
    //适配项目-扶持方式：称号认定
    public static By supportTitleconfirmOption=xpathOrId("/html/body/div[last()]/div/div/ul/li[3]/span");
    //适配项目-筛选：申报状态下拉框
    public static By applySelect=xpathOrId("//div[@class='condition']/div[3]/div/div[2]/span[1]");
    //适配项目-完善信息按钮
    public static By completeInfo=xpathOrId("//div[@class='perfect']/div/div/span[1]");
    //适配项目-匹配项目
    public static By matchProject=xpathOrId("//div[@class='perfect']/div/div/span[2]");
    //提示信息
    public static By info=xpathOrId("/html/body/div[last()]/p");
    //匹配项目次数
    public static By matchProjectXpath=xpathOrId("//div[@class='perfect']/div/div");

    //匹配项目次数
    public String matchProjectNum="";

    public ArrayList<String> assertList=new ArrayList<>();

    public String getAssertText() {
        return assertText;
    }

    //所有订阅的政策标题
    public ArrayList<String> titlesList=new ArrayList<>();
    //断言文本
    public String assertText="";

    public void waitlasterHotPolicyTitle(){
        waitText(HomePage.lasterHotPolicyTitle,"近期热门政策");
    }

    //进入智能推送页面
    public void enterPushPage(){
        find(pushMenu).click();
        waitText(pushPageTitle,"智能推送");
        matchProjectNum=find(matchProjectXpath).getText().replaceAll("\\D","");
    }

    //【关注政策】进入关注政策页面
    public void enterAttentionPolicyPage(){
        find(attentionPolicy).click();
        waitText(attentionPolicyPageTitle,"关注政策");

    }

    //【我的订阅】进入我的订阅页面
    public void enterMySubscribePage(){
        find(subscribe).click();
        waitText(subscribePageTitle,"我的订阅");
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //【适配项目】筛选：存在项目的关键字
    public ArrayList<String> searchAdaptiveProjectSuccess(String project){
        find(adaptiveProject).click();
        int size=finds(adaptiveProjectTitles).size();
        inputProjectKeyword(project);
        while (finds(adaptiveProjectTitles).size()==size){
            System.currentTimeMillis();
        }
        ArrayList<String> titles=new ArrayList<>();
        finds(adaptiveProjectTitles).forEach(webElement -> {
            titles.add(webElement.getText());
        });
        clearInput();
        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return titles;
    }

    private static void inputProjectKeyword(String project) {
        find(searchProjectInput).sendKeys(project);
        find(searchProjectInput).sendKeys(Keys.ENTER);
    }

    //【适配项目】筛选：不存在项目的关键字
    public String searchAdaptiveProjectFail(String project){
        find(adaptiveProject).click();
        inputProjectKeyword(project);
        String text=find(attentionPolicyNoDataText).getText();
        clearInput();
        return text;
    }

    private static void clearInput() {
        find(searchProjectInput).sendKeys(Keys.CONTROL,"a");
        find(searchProjectInput).sendKeys(Keys.BACK_SPACE);
        find(searchProjectInput).sendKeys(Keys.ENTER);
    }

    //【适配项目】清空搜索历史
    public String clearInputHistory(){
        find(adaptiveProject).click();
        inputProjectKeyword("123");
        clearInput();
        find(clearInputHistoryBtn).click();
        return find(info).getText();
    }

    //【适配项目】排序：发文时间
    public ArrayList<String> publishTimeSort(){
        ArrayList<String> startList = filterProject(timeSortSelect,publicTimeOption,publicTimeTitles);
        while(true){
            ArrayList<String> endList=new ArrayList();
            finds(publicTimeTitles).forEach(webElement -> {
                endList.add(webElement.getText().replace("-",""));
            });
            if(!endList.equals(startList)){
                return endList;
            }
        }
    }

    //【适配项目】排序：截止日期
    public ArrayList<String> endTimeSort(){
        ArrayList<String> startList = filterProject(timeSortSelect,endTimeOption,adaptiveProjectTitles);
        while(true){
            ArrayList<String> endList=new ArrayList();
            finds(adaptiveProjectTitles).forEach(webElement -> {
                endList.add(webElement.getText());
            });
            if(!endList.equals(startList)){
                ArrayList<String> endtimelist=new ArrayList<>();
                finds(endTimeTitles).forEach(webElement -> {
                    if(webElement.getText().matches("剩\\d*天")){
                        String text=webElement.getText().replace("剩","");
                        text=text.replace("天","");
                        endtimelist.add(text);
                    }else {
                        endtimelist.add(webElement.getText());
                    }
                });
                return endtimelist;
            }
        }
    }

    private ArrayList<String> filterProject(By select,By option,By listvalue) {
        find(adaptiveProject).click();
        ArrayList<String> startList=new ArrayList<>();
        finds(listvalue).forEach(webElement -> {
            startList.add(webElement.getText());
        });
        find(select).click();
        find(option).click();
        return startList;
    }

    private ArrayList<String> filterProject(By select,By option1,By option2,By listvalue) {
        find(adaptiveProject).click();
        ArrayList<String> startList=new ArrayList<>();
        finds(listvalue).forEach(webElement -> {
            startList.add(webElement.getText());
        });
        find(select).click();
        find(option1).click();
        find(select).click();
        find(option2).click();
        return startList;
    }

    //【适配项目】筛选：单个扶持方式，资金扶持
    public HashMap<String,ArrayList<String>> filterSupportOneSuccess(){
        ArrayList<String> startList=filterProject(supportSelect,supportCapitalOption,adaptiveProjectTitles);
        return getSupportTag(startList);
    }

    //【适配项目】筛选：多个扶持方式，资金扶持，称号认定
    public HashMap<String,ArrayList<String>> filterSupporMultiSuccess(){
        ArrayList<String> startList=filterProject(supportSelect,supportCapitalOption,supportTitleconfirmOption,adaptiveProjectTitles);
        return getSupportTag(startList);
    }

    private static HashMap<String, ArrayList<String>> getSupportTag(ArrayList<String> startList) {
        while(true){
            ArrayList<String> endList=new ArrayList();
            finds(adaptiveProjectTitles).forEach(webElement -> {
                endList.add(webElement.getText());
            });
            if(!endList.equals(startList)){
                HashMap<String,ArrayList<String>> map=new HashMap<>();
                finds(adaptiveProjectTitles).forEach(webElement -> {
                    ArrayList<String> value=new ArrayList<>();
                    finds(supportTag).forEach(webElement1 -> {
                        value.add(webElement1.getText());
                    });
                    map.put(webElement.getText(),value);
                });
                find(supportSelect).click();
                find(supportAll).click();
                return map;
            }
        }
    }

    //【适配项目】筛选：申报状态：申报中
    public ArrayList<String> filterApplySuccess(){
        ArrayList<String> startList=filterProject(applySelect,supportCapitalOption,endTimeTitles);
        while(true){
            ArrayList<String> endList=new ArrayList();
            finds(endTimeTitles).forEach(webElement -> {
                endList.add(webElement.getText());
            });
            if(!endList.equals(startList)){
                find(applySelect).click();
                find(supportAll).click();
                return endList;
            }
        }
    }

    //【适配项目】筛选：申报状态：已截止
    public ArrayList<String> filterFinishSuccess(){
        ArrayList<String> startList=filterProject(applySelect,supportTitleconfirmOption,endTimeTitles);
        while(true){
            ArrayList<String> endList=new ArrayList();
            finds(endTimeTitles).forEach(webElement -> {
                endList.add(webElement.getText());
            });
            if(!endList.equals(startList)){
                find(applySelect).click();
                find(supportAll).click();
                return endList;
            }
        }
    }

    //【适配项目】完善信息
    public String completeInfomaton(UserCenter userCenter){
        find(adaptiveProject).click();
        find(completeInfo).click();
        assertText=find(userCenter.pageTitle).getText();
        enterPushPage();
        return assertText;
    }

    //【适配项目】匹配项目
    public String matchProjectSuccess(){
        find(adaptiveProject).click();
        find(matchProject).click();
        waitText(matchProjectXpath,"系统已经完成匹配项目，立即刷新");
        find(completeInfo).click();
        String projectNum=find(matchProjectXpath).getText().replaceAll("\\D","");
        assertText=matchProjectNum;
        matchProjectNum=projectNum;
        return projectNum;
    }

    //【适配项目】匹配项目:次数为0
    public String matchProjectFail(){
        find(adaptiveProject).click();
        find(matchProject).click();
        return find(info).getText();
    }

    //【适配项目】跳转项目摘要页
    public String adaptiveSkipProjectDetail(PolicyFileDetailPage policyFileDetailPage){
        find(adaptiveProject).click();
        assertText=find(adaptiveProjectTitles).getText();
        find(adaptiveProjectTitles).click();
        String text= policyFileDetailPage.getTitleText("项目标题");
        enterPushPage();
        return text;
    }

    //【关注政策】筛选：单个关键词
    public ArrayList<String> searchOneKeywordSuccess(String keyword){
        enterAttentionPolicyPage();
        clickAttentionSetting();
        inputKeyword(keyword);
        find(attentionSettingSaveBtn).click();
        ArrayList<String> titles = getAttentionPolicyTitle(1,attentionPolicyTitles, keywordDeleteBtn);
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return titles;
    }

    private static void inputKeyword(String keyword) {
        find(keywordAddBtn).click();
        find(keywordInput).sendKeys(keyword);
        find(keywordAddText).click();
    }

    private static void clickAttentionSetting() {
        find(attentionSettingBtn).click();
        waitText(keywordAddText, "添加关键词");
    }

    private ArrayList<String> getAttentionPolicyTitle(int size,By bytitle, String keywordDeleteBtn) {
        try {
            Thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<String> titles = new ArrayList<>();
        finds(bytitle).forEach(webElement -> {
            titles.add(webElement.getText());
        });
        clareKeyword(size, keywordDeleteBtn);
        return titles;
    }

    private ArrayList<String> getAttentionPolicyTitle(By bytitle, By by) {
        ArrayList<String> titles = new ArrayList<>();
        finds(bytitle).forEach(webElement -> {
            titles.add(webElement.getText());
        });
        clareKeyword(by);
        return titles;
    }

    //【关注政策】筛选：多个关键词
    public ArrayList<String> searchMultiKeywordSuccess(String keyword1,String keyword2,String keyword3){
        enterAttentionPolicyPage();
        clickAttentionSetting();
        inputKeyword(keyword1);
        inputKeyword(keyword2);
        inputKeyword(keyword3);
        find(attentionSettingSaveBtn).click();
        ArrayList<String> titles = getAttentionPolicyTitle(3,attentionPolicyTitles, keywordDeleteBtn);
        try {
            Thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return titles;
    }

    //【关注政策】筛选：单个政策等级
    public ArrayList<String> searchOnePolicyLevelSuccess(PolicyLibraryPage policyLibraryPage){
        enterAttentionPolicyPage();
        clickAttentionSetting();
        find(policyLevelSelect).click();
        waitText(policyLevelSelectContry,"国家级");
        find(policyLevelSelectContry).click();
        find(keywordAddText).click();
        find(attentionSettingSaveBtn).click();
        ArrayList<String> titles = getAttentionPolicyTitle(attentionDepartmentTitles,policyLevelDeleteBtn);
        policyLibraryPage.enterpolicyLibrary();
        assertList.clear();
        assertList=policyLibraryPage.getDepartmentList(policyLibraryPage.filterLocationCountry);
        enterPushPage();
        enterAttentionPolicyPage();
        return titles;
    }

    //【关注政策】筛选：多个政策等级
    public ArrayList<String> searchMultiPolicyLevelSuccess(PolicyLibraryPage policyLibraryPage){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        enterAttentionPolicyPage();
        clickAttentionSetting();
        while (getDriver().getPageSource().contains("请选择")){
            find(policyLevelSelect).click();
            waitText(policyLevelSelectContry,"国家级");
            find(policyLevelSelectContry).click();
            find(policyLevelSelectCity).click();
            find(keywordAddText).click();
        }
        find(attentionSettingSaveBtn).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<String> titles = getAttentionPolicyTitle(attentionDepartmentTitles,policyLevelDeleteBtn);
        policyLibraryPage.enterpolicyLibrary();
        assertList.clear();
        assertList=policyLibraryPage.getDepartmentList(policyLibraryPage.filterLocationCountry);
        assertList.addAll(policyLibraryPage.getDepartmentList(policyLibraryPage.filterLocationCityFoshan));
        enterPushPage();
        enterAttentionPolicyPage();
        return titles;
    }

    //【关注政策】筛选：组合搜索
    public HashMap<String,ArrayList<String>> searchKeywordAndPolicyLevelSuccess(String keyword, PolicyLibraryPage policyLibraryPage){
        enterAttentionPolicyPage();
        clickAttentionSetting();
        inputKeyword(keyword);
        find(policyLevelSelect).click();
        waitText(policyLevelSelectContry,"国家级");
        find(policyLevelSelectContry).click();
        find(keywordAddText).click();
        find(attentionSettingSaveBtn).click();
        ArrayList<String> policyTitles = new ArrayList<>();
        finds(attentionPolicyTitles).forEach(webElement -> {
            policyTitles.add(webElement.getText());
        });
        ArrayList<String> departmentTitles = new ArrayList<>();
        finds(attentionDepartmentTitles).forEach(webElement -> {
            departmentTitles.add(webElement.getText());
        });
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        map.put("政策标题",policyTitles);
        map.put("主管部门",departmentTitles);
        clareKeyword(1, keywordDeleteBtn,policyLevelDeleteBtn);
        policyLibraryPage.enterpolicyLibrary();
        assertList.clear();
        assertList=policyLibraryPage.getDepartmentList(policyLibraryPage.filterLocationCountry);
        enterPushPage();
        enterAttentionPolicyPage();
        return map;
    }

    //【关注政策】跳转政策详情页
    public String attentionSkipPolicyDetail(PolicyFileDetailPage policyFileDetailPage,String keyword){
        String text = attentionSkip(policyFileDetailPage,keyword,attentionPolicyTitles,"政策标题");
        return text;
    }

    private String attentionSkip( PolicyFileDetailPage policyFileDetailPage,String keyword,By title,String str) {
        enterAttentionPolicyPage();
        clickAttentionSetting();
        inputKeyword(keyword);
        find(attentionSettingSaveBtn).click();
        assertText=find(title).getText();
        find(title).click();
        String text= policyFileDetailPage.getTitleText(str);
        enterPushPage();
        enterAttentionPolicyPage();
        clareKeyword(1,keywordDeleteBtn);
        return text;
    }

    //【关注政策】跳转项目摘要页
    public String attentionSkipProjectDetail(PolicyFileDetailPage policyFileDetailPage,String keyword){
        String text = attentionSkip(policyFileDetailPage,keyword,attentionProjectTitles,"项目标题");
        return text;
    }

    //【关注政策】清空关键词
    public void clareKeyword(int size,String deleteBtn){
        find(attentionSettingBtn).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        for(int i=0;i<size;i++){
            String path=deleteBtn.replace("span[1]","span["+(i+1)+"]");
            find(By.xpath(path)).click();
        }
        find(attentionSettingSaveBtn).click();
        waitText(attentionPolicyNoDataText,"暂无内容");
    }

    //【关注政策】清除政策等级
    public void clareKeyword(By by){
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        find(attentionSettingBtn).click();
        mouseClickElement(by);
        find(attentionSettingSaveBtn).click();
        waitText(attentionPolicyNoDataText,"暂无内容");
    }

    //【关注政策】清除关键词、政策等级
    public void clareKeyword(int size,String deleteBtn,By by){
        find(attentionSettingBtn).click();
        try {
            Thread.sleep(250);
        }catch (Exception e){
            e.printStackTrace();
        }
        for(int i=0;i<size;i++){
            String path=deleteBtn.replace("span[1]","span["+(i+1)+"]");
            find(By.xpath(path)).click();
        }
        mouseClickElement(by);
        find(attentionSettingSaveBtn).click();
        waitText(attentionPolicyNoDataText,"暂无内容");
    }


    //【我的订阅】获取订阅的政策标题
    public ArrayList<String> getSubscribeTitles(){
        titlesList.clear();
        enterMySubscribePage();
        if(getDriver().getPageSource().contains("暂无内容")){
            return titlesList;
        }
        if (getDriver().getPageSource().contains("展开更多")) {
            if(find(showMore).getText().contains("展开更多")){
                find(showMore).click();
                waitText(showMore,"暂无更多内容");
                finds(subscribeTitles).forEach(webElement -> {
                    titlesList.add(webElement.getText());
                });
                return titlesList;
            }
        }
        finds(subscribeTitles).forEach(webElement -> {
            titlesList.add(webElement.getText());
        });
        return titlesList;
    }


    //【我的订阅】跳转订阅的政策详情页
    public String skipPolicyDetail(PolicyFileDetailPage policyFileDetailPage){
        enterMySubscribePage();
        assertText=find(subscribeTitles).getText();
        find(subscribeTitles).click();
        String title=policyFileDetailPage.getTitleText("政策标题");
        enterPushPage();
        return title;
    }
}
