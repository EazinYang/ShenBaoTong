package page;

import conf.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class PolicyDetailPage extends Method {
    //政策标题
    public static By title=xpathOrId("//h1[@class='copy-title']");
    //主体单位
    public static By department=xpathOrId("//div[@class='title-info']/div/span");
    //发文日期
    public static By publicDate=xpathOrId("//div[@class='title-info']/div/span[2]");
    //申报通知tab
    public static By policyTab=xpathOrId("//div[@class='el-row']/div/ul/li[1]/a");
    public static final String DIV_CLASS_EL_ROW_DIV_UL_LI_2_A = "//div[@class='el-row']/div/ul/li[2]/a";
    //相关文件tab
    public By fileTab=xpathOrId(DIV_CLASS_EL_ROW_DIV_UL_LI_2_A);
    //相关文件tab：附件标题
    public By fileTitles=xpathOrId("//div[@class='content']/div[3]/div/table/tbody/tr/td[2]/div");
    //相关文件tab：下载按钮
    public By downloadFileBtn=xpathOrId("//div[@class='content']/div[3]/div/table/tbody/tr/td[3]/button");
    //相关文件tab：文件预览弹框文本
    public static By readFileTitle=xpathOrId("//div[@aria-label='文件预览']/div/span");
    //相关文件tab：文件预览弹框关闭按钮
    public static By readFileCloseBtn=xpathOrId("//div[@aria-label='文件预览']/div/button");
    //项目摘要
    public By projectTab=By.partialLinkText("项目摘要");
    //项目摘要：link-项目名称
    public static By projectLinkTitles=xpathOrId("//div[@class='flex']/div[2]");
    //项目摘要：项目名称
    public By projectTitle=xpathOrId("//div[@class='copy-sub']");
    //项目摘要：扶持标准
    public static By supportText=xpathOrId("//div[@class='jietu2']/../div[3]");
    //项目摘要：申报条件概述
    public static By declareCondition=xpathOrId("//div[@class='jietu2']/../div[5]/div[3]/table//tbody/tr/td[2]/div/div");
    //项目摘要：材料简称
    public static By meterialsTitle=xpathOrId("//div[@class='jietu2']/../div[7]/div[3]/table/tbody/tr/td[3]/div/div");
    //纳入计划按钮
    public static By naruJihuaBtn=xpathOrId("//div[@class='jiedu-choose']/../div[@class='content']/div/div/div[2]");
    //纳入计划：纳入计划成功
    public static By naruJihuaSuccessText=xpathOrId("//div[@class='jiedu']/div/div[3]/div[last()-1]/div/div[2]/div[2]");
    //纳入计划：申报管家-申报计划
    public static By declarePlanLink=xpathOrId("//div[@class='jiedu']/div/div[3]/div[last()-1]/div/div[2]/div[3]/span");
    //联系信息
    public By relationTab=xpathOrId("//div[@class='el-row']/div/ul/li[4]/a");
    //联系消息的信息展示名片
    public static By relationInfo=xpathOrId("//div[@class='info-content']/div");
    //获批名单
    public By receiveApprovalTab=xpathOrId("//div[@class='el-row']/div/ul/li[5]/a");
    //获批名单-公示标题
    public static By approvedNoticeLink=xpathOrId("//div[@class='table_list']/div[2]/div[3]/table/tbody/tr/td[2]/div/div");
    //获批名单-项目单位输入框
    public static By approviedProjectInput=xpathOrId("//input[@placeholder='请输入项目单位']");
    //获批名单-项目单位名称
    public static By approviedCompanyName=xpathOrId("//div[@class='enterpriseName']");
    //我要申报按钮
    public By declareBtn=xpathOrId("//div[@class='zc']/div[2]/button");
    //我要申报：申报主体（企业名称）
    public static By companyNameInput=xpathOrId("//input[@placeholder='请输入企业主体的名称']");
    //我要申报：联系人
    public static By ContactInput=xpathOrId("//input[@placeholder='请输入联系人姓名']");
    //我要申报：电话
    public static By phoneInput=xpathOrId("//input[@placeholder='请输入联系人电话']");
    //+订阅
    public By subscribeBtn=xpathOrId("//div[@class='title-info']/div[2]/span");
    //分享
    public static By shareBtn=xpathOrId("//div[@class='title-info']/div[2]/div");
    //返回上一级
    public static By returnBtn=xpathOrId("//div[@class='content']/div[2]/div[2]/button");
    //分享页面的二维码
    public static By shareId=xpathOrId("qrcode");
    //提示信息
    public static By tipsText=xpathOrId("/html/body/div[last()]/p");
    //当前政策的标题文本
    public String titleText="";
    //提示信息文本
    public String tips="";
    //政策Id
    public String id="";
    //订阅按钮的文本
    public String subscribeText="";
    //断言文本
    public String assertText="";
    //项目标题
    public String projectTitleText="";

    PolicyLibraryPage policyLibraryPage=new PolicyLibraryPage();

    //进入详情页
    public ArrayList<String> verficationDetailInfo(){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(find(title).getText());
        arrayList.add(find(department).getText().replace("来源：",""));
        arrayList.add(find(publicDate).getText().replace("发文日期：",""));
        arrayList.add(find(policyTab).getText());
        return arrayList;
    }

    //返回列表页
    public PolicyLibraryPage returnList(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        jsClick(returnBtn);
        return new PolicyLibraryPage();
    }

    public void setSubscribeText(){
        subscribeText=find(subscribeBtn).getText();
    }

    //分享
    public String share(){
        mouseMoveToElement(shareBtn);
        id=getDriver().getCurrentUrl().replaceAll("\\D","");
        return find(shareId).getAttribute("title").replaceAll("\\D","");
    }

    //订阅
    public String subscribe(PushPage pushPage,String titles){
        titleText=find(title).getText();
        find(subscribeBtn).click();
        tips=find(tipsText).getText();
        String btnStatus=find(subscribeBtn).getText();
        pushPage.enterPushPage();
        pushPage.getSubscribeTitles();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil(titles);
        setSubscribeText();
        return btnStatus;
    }

    //todo：每个政策只能申报一次，交给人工或接口
    //申报成功
    public void declareSuccess(String org,String name,String phone,String info){

    }

    //todo:等待修改bug
    //申报失败
    public void declareFail(String org,String name,String phone){
        find(declareBtn).click();
    }

    //预览相关文件
    public String readFile(){
        jsClick(fileTab);
        HashMap<String,String> map=new HashMap<>();
//        finds(fileTitles).forEach(webElement -> {
//            String text=webElement.getText();
//            webElement.click();
//            map.put(text,find(readFileTitle).getText());
//            find(readFileCloseBtn).click();
//        });
        find(fileTitles).click();;
        String text=find(readFileTitle).getText();
        find(readFileCloseBtn).click();
        return text;
    }

    //项目摘要数据校验和切换项目
    public HashMap<String,ArrayList<String>> projectTab(String project){
        jsClick(projectTab);
        waitText(projectTitle,project);
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(WebElement webElement:finds(projectLinkTitles)){
            webElement.click();
            waitText(projectTitle,webElement.getText());
            ArrayList arrayList=new ArrayList();
            arrayList.add(find(projectTitle).getText());
            arrayList.add(find(supportText).getText());
            arrayList.add(find(declareCondition).getText());
            arrayList.add(find(meterialsTitle).getText());
            map.put(webElement.getText(),arrayList);
        }
        return map;
    }

    //项目摘要-纳入计划
    public ArrayList<String> naruJihua(DeclareStewardPage declareStewardPage,String titles){
        find(naruJihuaBtn).click();
        assertText=find(naruJihuaSuccessText).getText();
        find(declarePlanLink).click();
        ArrayList<String> title=declareStewardPage.getPolicyTitles();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil(titles);
        return title;
    }

    //项目摘要-取消计划
    public String cancelNaruJihua(String titles){
        find(naruJihuaBtn).click();
        String text=find(tipsText).getText();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil(titles);
        return text;
    }

    public String getNaruJihuaBtnText(String project){
        jsClick(projectTab);
        waitText(projectTitle,project);
        projectTitleText=find(projectTitle).getText();
        return find(naruJihuaBtn).getText();
    }

    //联系信息
    public ArrayList contactInfoVerify(){
        jsClick(relationTab);
        ArrayList<String> info=new ArrayList<>();
        finds(relationInfo).forEach(webElement -> {
            info.add(webElement.getText());
        });
        return info;
    }

    //获批名单-跳转公示公告
    public String approvedSkipNotice(NoticeDetailPage noticeDetailPage,String title){
        jsClick(receiveApprovalTab);
        jsClick(approvedNoticeLink);
        assertText=noticeDetailPage.getTitle();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil(title);
        return assertText;
    }

    //获批名单-数据校验
    public Integer approvedDataVerify(){
        jsClick(receiveApprovalTab);
        int i=0;
        for(WebElement webElement:finds(approviedCompanyName)){
            if(webElement.getText().length()>0){
                i++;
            }
        }
        return i;
    }

    //todo:获批名单-项目单位筛选
    public void approvedCompanySearch(NoticeDetailPage noticeDetailPage){
    }

    //todo:获批名单-地区筛选
    public void approvedLocationSearch(NoticeDetailPage noticeDetailPage){
    }

    //todo:获批名单-行业筛选
    public void approvedTradeSearch(NoticeDetailPage noticeDetailPage){
    }

    public String getTitleText(String str){
        if(str.equals("政策标题")){
            return find(title).getText();
        }else if(str.equals("项目标题")){
            return find(projectTitle).getText();
        }
        return null;
    }

    public String getProjectTitle() {
        return find(projectTitle).getText();
    }
}
