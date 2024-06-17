package page;

import conf.Method;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class PolicySubjectPage extends Method {
    //政策专题的专题名称
    public By policySubjectTitle=xpathOrId("//div[@class='flex col around']/h1");
    //相关政策专题名称
    public By relationPolicySubjectTitle=xpathOrId("//div[@class='policy-detail']/div[1]");
    //专题标题tab：人才补贴
    public By subjectTab=xpathOrId("//div[@class='tabs_text_box']/div[2]/a");
    //政策名称
    public By projectTitles=xpathOrId("//div[@class='relevant-policy']/div/a/div/div[1]");

    public String subjectText="";
    public String relationSubjectText="";
    public ArrayList<String> startPolicy=new ArrayList<>();

    public String assertText="";
    public ArrayList<String> assertList=new ArrayList<>();

    public void enterPolicySubjectPage(HomePage homePage){
        homePage.skipPolicySubject();
        waitText(policySubjectTitle,"服务外包");
        finds(projectTitles).forEach(webElement -> {
            startPolicy.add(webElement.getText());
        });
    }

    //切换专题
    public String switchSubject(){
        find(subjectTab).click();
        subjectText=find(subjectTab).getText();
        waitText(policySubjectTitle,subjectText);
        assertText=find(policySubjectTitle).getText();
        String text=find(relationPolicySubjectTitle).getText();
        finds(projectTitles).forEach(webElement -> {
            assertList.add(webElement.getText());
        });
        return text;
    }

    //点击政策跳转政策详情页
    public String skipPolicyDetail(PolicyFileDetailPage policyFileDetailPage,HomePage homePage){
        assertText=find(projectTitles).getText();
        find(projectTitles).click();
        String text=policyFileDetailPage.getTitleText("项目标题");
        enterPolicySubjectPage(homePage);
        return text;
    }
}
