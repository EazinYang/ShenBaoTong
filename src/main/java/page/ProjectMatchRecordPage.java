package page;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Set;

public class ProjectMatchRecordPage extends ProjectMatchPage{
    //匹配到项目
    public By matchProjectNum=xpathOrId("//div[@class='right_project']/span");
    //页面标题
    public By pageTitle=xpathOrId("//div[@class='record']/div/span[3]/span[1]");
    //匹配详情页标题
    public By matchDetailPageTitle=xpathOrId("//div[@aria-label='匹配详情']/div/span");
    //匹配详情-扶持项目(x)
    public By supportProjectNum=xpathOrId("//div[@class='content_box']/div");
    //匹配详情-关闭按钮
    public By matchDetailCloseBtn=xpathOrId("//button[@aria-label='Close']");
    //匹配详情-项目名称
    public By matchDetailProjectTitle=xpathOrId("//div[@class='box_table']/table/tr[2]/td[1]");
    //重新匹配
    public By matchAgainBtn=xpathOrId("//div[@class='right_btn']");
    //企业名称
    public By matchCompanyName=xpathOrId("//div[@class='card_left']/div[1]");

    public String assertText="";

    //进入匹配记录页
    public void enterProjectMatchRecordPage(){
        enterProjectMatch();
        find(matchRecordBtn).click();
        waitText(pageTitle,"匹配记录");
    }

    //进入匹配详情页
    public String enterMatchDetail(){
        assertText=find(matchProjectNum).getText();
        find(matchProjectNum).click();
        waitText(matchDetailPageTitle,"匹配详情");
        String text=find(supportProjectNum).getText().replaceAll("\\D","");
        find(matchDetailCloseBtn).click();
        return text;
    }

    //重新匹配
    public String matchAgain(){
        assertText=find(matchCompanyName).getText();
        find(matchAgainBtn).click();
        waitText(super.pageTitle,"项目匹配");
        String text=find(companyName).getText();
        enterProjectMatchRecordPage();
        return text;
    }

    //打开项目摘要页
    public String openProjectDetail(PolicyFileDetailPage policyFileDetailPage){
        enterMatchDetail();
        assertText=find(matchDetailProjectTitle).getText();
        find(matchDetailProjectTitle).click();
        while (getDriver().getWindowHandles().size()==1){
            System.currentTimeMillis();
        }
        Set<String> allHandlers=getDriver().getWindowHandles();
        String currentHandler=getDriver().getWindowHandle();
        for(String handler:allHandlers){
            if(!handler.equals(currentHandler)){
                getDriver().switchTo().window(handler);
            }
        }
        String title=policyFileDetailPage.getTitleText("项目标题");
        getDriver().close();
        return title;
    }
}
