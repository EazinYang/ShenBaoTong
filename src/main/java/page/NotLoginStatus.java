package page;

import conf.Method;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class NotLoginStatus extends Method {
    //提醒登录弹框的文本
    public By loginDialogsText=xpathOrId("//*[@class='permission']/div/div/div[2]/div[2]");
    //去登录按钮
    public By goToLoginBtn=xpathOrId("//*[@class='permission']/div/div/div[3]/span/button/span");
    //提醒登录弹框的关闭按钮
    public By loginDialogsCloseBtn=xpathOrId("//*[@class='permission']/div/div/div[1]/button");
    //私密链接-高级按钮
    public By returnBtn=xpathOrId("primary-button");
    //【项目匹配】提醒登录文本
    public By projectMatchLoginDialogsText=xpathOrId("//div[@class='hint']/div[2]");
    //【项目匹配】提醒登录按钮
    public By projectMatchLoginBtn=xpathOrId("//div[@class='hint']/div[4]/button/span");
    //我的消息图标
    public By messageTag=xpathOrId("//div[@class='el-badge item']");

    HomePage  homePage=new HomePage();
    PolicyDetailPage policyDetailPage=new PolicyDetailPage();
    PolicyLibraryPage policyLibraryPage=new PolicyLibraryPage();
    NoticeDetailPage noticeDetailPage=new NoticeDetailPage();
    ProjectMatchPage projectMatchPage=new ProjectMatchPage();
    LoginPage loginPage=new LoginPage();
    PushPage pushPage=new PushPage();
    DeclareStewardPage declareStewardPage=new DeclareStewardPage();

    ArrayList<String> loginTips=new ArrayList<>();
    PolicySubjectPage policySubjectPage=new PolicySubjectPage();

    //【首页】点击近期热门政策的项目标题
    public ArrayList<String> clickLastHotPolicyProject(){
        homePage.enterHomePage();
        jsClick(homePage.projectTitle);
        find(returnBtn).click();
        ArrayList<String> list=getLoginTips();
        getDriver().navigate().refresh();
        return list;
    }

    //【首页】点击去登录按钮
    public String clickGoToLoginBtn(){
        homePage.enterHomePage();
        jsClick(homePage.projectTitle);
        find(returnBtn).click();
        find(goToLoginBtn).click();
        waitText(loginPage.loginTitle,"欢迎登录政沣云");
        String text=find(loginPage.loginTitle).getText();
        getDriver().navigate().refresh();
        return text;
    }

    public ArrayList<String> getLoginTips(){
        String str=find(By.xpath("//*[@class='permission']/div[1]")).getAttribute("style");
        loginTips.clear();
        loginTips.add(find(loginDialogsText).getText());
        loginTips.add(find(goToLoginBtn).getText());//*[@class='permission']/div[1]
        while(true){
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(find(By.xpath("//*[@class='permission']/div[1]")).getAttribute("style").equals(str)){
                jsClick(loginDialogsCloseBtn);
                break;
            }
        }
        return loginTips;
    }

    //【政策专题】点击项目
    public ArrayList<String> clickPolicySubjectProject(){
        homePage.enterHomePage();
        homePage.skipPolicySubject();
        find(policySubjectPage.projectTitles).click();
        ArrayList<String> list=getLoginTips();
        getDriver().navigate().refresh();
        return list;
    }

    //【政策详情】我要申报
    public ArrayList<String> clare(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        find(policyDetailPage.declareBtn).click();
        return getLoginTips();
    }

    //【政策详情】订阅
    public ArrayList<String> subscribe(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        find(policyDetailPage.subscribeBtn).click();
        return getLoginTips();
    }

    //【政策详情】点击相关文件的附件
    public ArrayList<String> clickFile(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        jsClick(policyDetailPage.fileTab);
        find(policyDetailPage.fileTitles).click();
        return getLoginTips();
    }

    //【政策详情】点击相关文件的附件
    public ArrayList<String> downloadFile(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        jsClick(policyDetailPage.fileTab);
        find(policyDetailPage.downloadFileBtn).click();
        return getLoginTips();
    }

    //【政策详情】项目摘要
    public ArrayList<String> projectTab(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        jsClick(policyDetailPage.projectTab);
        return getLoginTips();
    }

    //【政策详情】联系信息
    public ArrayList<String> contactTab(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        jsClick(policyDetailPage.relationTab);
        return getLoginTips();
    }

    //【政策详情】获批名单
    public ArrayList<String> receiveApprovalTab(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyDeatil("测试数据-申报通知");
        jsClick(policyDetailPage.receiveApprovalTab);
        return getLoginTips();
    }

    //【政策详情】政策文件
    public ArrayList<String> policyFileTab(){
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterNoticeDeatil("测试数据-公告公示");
        jsClick(noticeDetailPage.policyFileTab);
        ArrayList<String> list=getLoginTips();
        getDriver().navigate().refresh();
        return list;
    }

    //【项目匹配】进入项目匹配页面
    public ArrayList<String> enterProjectMatchPage(){
        find(projectMatchPage.projectMatchMenu).click();
        ArrayList<String> list=new ArrayList<>();
        list.add(find(projectMatchLoginDialogsText).getText());
        list.add(find(projectMatchLoginBtn).getText());
        return list;
    }

    //【项目匹配】点击去登录按钮
    public String projectMatchPageClickGoToLogin(){
        find(projectMatchPage.projectMatchMenu).click();
        find(projectMatchLoginBtn).click();
        return find(loginPage.loginTitle).getText();
    }

    //【智能推送】进入智能推送页面
    public ArrayList<String> enterPushPage(){
        find(pushPage.pushMenu).click();
        ArrayList<String> list=new ArrayList<>();
        list.add(find(projectMatchLoginDialogsText).getText());
        list.add(find(projectMatchLoginBtn).getText());
        return list;
    }

    //【申报管家】进入申报管家页面
    public ArrayList<String> enterDeclareStewardPage(){
        find(declareStewardPage.declareStewardMenu).click();
        ArrayList<String> list=new ArrayList<>();
        list.add(find(projectMatchLoginDialogsText).getText());
        list.add(find(projectMatchLoginBtn).getText());
        return list;
    }

    //【申报管家】进入申报管家页面
    public ArrayList<String> clickMessageTag(){
        find(messageTag).click();
        ArrayList<String> list=new ArrayList<>();
        list.add(find(projectMatchLoginDialogsText).getText());
        list.add(find(projectMatchLoginBtn).getText());
        return list;
    }
}
