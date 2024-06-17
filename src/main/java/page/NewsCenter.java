package page;

import conf.Method;
import org.openqa.selenium.By;

public class NewsCenter extends Method {
    //页面标题
    public By pageTitle=xpathOrId("//div[@class='news_center']/div/span[2]/span");
    //新闻详情-标题
    public By detailNewsTitls=xpathOrId("//div[@class='content-left']/div/h1");
    //新闻标题
    public By newsTitles=xpathOrId("//span[@class='title']");
    //新闻详情-返回新闻中心
    public By returnNewsCenter=xpathOrId("//div[@class='content-left']/div[2]");

    public String assertText="";

    //进入新闻中心页面
    public void enterNewsCenterPage(HomePage homePage){
        homePage.clickMoreNews();
        waitText(pageTitle,"新闻中心");
    }

    //进入新闻详情页
    public String enterNewsDetail(){
        assertText=find(newsTitles).getText();
        mouseClickElement(newsTitles);
        waitText(detailNewsTitls,assertText);
        String text=find(detailNewsTitls).getText();
        find(returnNewsCenter).click();
        return text;
    }

}
