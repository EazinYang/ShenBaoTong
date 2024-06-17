package page;

import conf.Method;
import org.openqa.selenium.By;

public class HomePage extends Method {
    //"近期热门政策"title
    public static By lasterHotPolicyTitle=By.xpath("//div[@class='remenzhengce']");
    //首页
    public By homepageMenu=xpathOrId("//ul[@class='menu_list']/li[1]");
    //多维度项目匹配
    public By projectMatch=xpathOrId("//div[@class='page_index']/div[2]/div[2]/div[2]");
    //近期热门政策-更多
    public By morePolicyBtn=xpathOrId("//div[@class='remenzhengce']/../div[2]");
    //近期热门政策-项目标题
    public By projectTitle=xpathOrId("//ul[@class='item']/li/a/div/span");
    //政策专题：服务外包
    public By policySubjec=xpathOrId("//div[@class='zhengcezhuanti']/../div[2]/div/div/div/a/section/section[1]");
    //新闻中心-更多
    public By moreNewsBtn=xpathOrId("//div[@class='xinwenzhongxin']/../div[2]");
    //新闻中心-新闻标题
    public By newsTitle=xpathOrId("//div[@class='page_index']/div[4]/ul/li[1]/a/div[2]");

    public String assertText="";

    public void waitlasterHotPolicyTitle(){
        waitText(HomePage.lasterHotPolicyTitle,"近期热门政策");
    }

    //进入首页
    public void enterHomePage(){
        find(homepageMenu).click();
        waitlasterHotPolicyTitle();
    }

    //多维度项目匹配跳转
    public String skipProjectMatch(ProjectMatchPage projectMatchPage){
        return skipPage(projectMatch, projectMatchPage.pageTitle,"项目匹配");
    }

    //近期热门政策点击更多跳转
    public String clickMorePolicy(PolicyLibraryPage policyLibraryPage){
        return skipPage(morePolicyBtn, policyLibraryPage.policyPageTitle,"政策文库");
    }

    private String skipPage(By morePolicyBtn, By title,String waitText) {
        find(morePolicyBtn).click();
        waitText(title, waitText);
        String text = find(title).getText();
        enterHomePage();
        return text;
    }

    private String skipPage(By morePolicyBtn, By title) {
        assertText=find(morePolicyBtn).getText();
        mouseClickElement(morePolicyBtn);
        waitText(title, assertText);
        String text = find(title).getText();
        enterHomePage();
        return text;
    }

    //跳转项目摘要页
    public String skipProjectDetail(PolicyFileDetailPage policyFileDetailPage){
        return skipPage(projectTitle, policyFileDetailPage.projectTitle);
    }

    //跳转政策专题
    public String skipPolicySubject(PolicySubjectPage policySubjectPage){
        return skipPage(policySubjec, policySubjectPage.policySubjectTitle);
    }

    public void skipPolicySubject(){
        enterHomePage();
        waitlasterHotPolicyTitle();
        mouseClickElement(policySubjec);
    }


    //新闻中心点击更多跳转
    public String clickMoreNews(NewsCenter newsCenter){
        return skipPage(moreNewsBtn, newsCenter.pageTitle,"新闻中心");
    }

    //跳转新闻详情页
    public String skipNewsDetail(NewsCenter newsCenter){
        return skipPage(newsTitle, newsCenter.detailNewsTitls);
    }

    public void clickMoreNews(){
        enterHomePage();
        waitlasterHotPolicyTitle();
        mouseClickElement(moreNewsBtn);
    }
}
