package page;

import conf.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class PolicyDictionaryPage extends Method {
    //政策词典菜单
    public static By policyDictionaryMenu=xpathOrId("//ul[@class='menu_list']/li[3]");
    //关键词输入框
    public static By searchInput=xpathOrId("//input[@placeholder='请输入关键词搜索']");
    //页面标题
    public static By pageTitle=xpathOrId("//div[@class='search']/div/h1");
    //政策词典标题
    public static By dictionaryTitles=xpathOrId("//div[@class='docs']/div[2]/div");
    //热门搜索：第一个关键词
    public static By searchHot=xpathOrId("//ul[@class='searchHot']/li[2]");
    //按字母：ABCDE
    public static By searchLetter=xpathOrId("//div[@class='cidian']/div[3]/div[1]/ul/li[2]");
    //按字母：不限
    public static By searchLetterAll=xpathOrId("//div[@class='cidian']/div[3]/div[1]/ul/li[1]");
    //字母分类
    public static By letterGroup=xpathOrId("//div[@class='docs']/div[1]");
    //名词类型：按中文
    public static By searchChinese=xpathOrId("//div[@class='cidian']/div[3]/div[2]/ul/li[2]");
    //名词类型：按英文
    public static By searchEnglish=xpathOrId("//div[@class='cidian']/div[3]/div[2]/ul/li[3]");
    //名词类型：不限
    public static By searchLanguageAll=xpathOrId("//div[@class='cidian']/div[3]/div[2]/ul/li[1]");
    //词典详情：词典标题
    public static By detailDictionaryTitle=xpathOrId("//div[@class='explain']/div/h1");
    //词典详情：词典内容
    public static By detailDictionaryInfo=xpathOrId("//div[@class='explain']/div/div");
    //词典详情：相关政策
    public static By relationPolicy=xpathOrId("//div[@class='relevant']/div[2]/div/div/a/div[1]");
    //词典详情：相关名词
    public static By relationDictionary=xpathOrId("//div[@class='explain']/ul/div[2]/li");

    //词典数量
    public int dictionaryNum=0;
    //断言文本
    public String assertText="";
    //断言键值对
    public HashMap<String,String> assertMap=new HashMap<>();

    public void waitlasterHotPolicyTitle(){
        waitText(HomePage.lasterHotPolicyTitle,"近期热门政策");
    }

    //进入政策词典页面
    public void enterPolicyDictionary(){
        find(policyDictionaryMenu).click();
        waitText(pageTitle,"政策词典");
        dictionaryNum=finds(dictionaryTitles).size();
    }

    //筛选：关键词搜索
    public ArrayList<String> searchKeySuccess(String key){
        titleSearch(key);
        ArrayList<String> title=getDictionaryTitles(dictionaryTitles);
        find(searchInput).sendKeys(Keys.CONTROL,"a");
        find(searchInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        return title;
    }

    private static void titleSearch(String key) {
        find(searchInput).sendKeys(Keys.CONTROL,"a");
        find(searchInput).sendKeys(Keys.BACK_SPACE);
        find(searchInput).sendKeys(key);
        find(pageTitle).click();
    }

    //筛选：热门搜索
    public ArrayList<String> searchHotKeySuccess(){
        find(searchHot).click();
        assertText=find(searchHot).getText();
        ArrayList<String> title=getDictionaryTitles(dictionaryTitles);
        dictionaryNum=finds(dictionaryTitles).size();
        find(searchInput).sendKeys(Keys.CONTROL,"a");
        find(searchInput).sendKeys(Keys.BACK_SPACE);
        find(pageTitle).click();
        while (dictionaryNum==finds(dictionaryTitles).size()){
            System.currentTimeMillis();
        }
        return title;
    }

    //筛选：按字母，ABCDE
    public ArrayList<String> searchLetterSuccess(){
        find(searchLetter).click();
        assertText=find(searchLetter).getText();
        ArrayList<String> title=getDictionaryTitles(letterGroup);
        dictionaryNum=finds(dictionaryTitles).size();
        find(searchLetterAll).click();
        while (dictionaryNum==finds(dictionaryTitles).size()){
            System.currentTimeMillis();
        }
        return title;
    }

    //筛选：名词类型-按中文
    public ArrayList<String> searchChineseKeySuccess(){
        find(searchChinese).click();
        ArrayList<String> title=getDictionaryTitles(dictionaryTitles);
        find(searchLanguageAll).click();
        return title;
    }

    //筛选：名词类型-按英文
    public ArrayList<String> searchEngKeySuccess(){
        find(searchEnglish).click();
        ArrayList<String> title=getDictionaryTitles(dictionaryTitles);
        dictionaryNum=finds(dictionaryTitles).size();
        find(searchLanguageAll).click();
        while (dictionaryNum==finds(dictionaryTitles).size()){
            System.currentTimeMillis();
        }
        return title;
    }

    //跳转相关政策
    public String skipRelationPolicySuccess(String key,String title,PolicyDetailPage policyDetailPage){
        titleSearch(key);
        waitText(dictionaryTitles,key);
        find(dictionaryTitles).click();
        waitText(detailDictionaryTitle,title);
        assertMap.clear();
        assertMap.put(find(detailDictionaryTitle).getText(),find(detailDictionaryInfo).getText());
        assertText=find(relationPolicy).getText();
        find(relationPolicy).click();
        String policyTitle=policyDetailPage.getTitleText("政策标题");
        enterPolicyDictionary();
        return policyTitle;
    }

    //跳转相关名词
    public String skipRelationDictionarySuccess(String key,String title){
        titleSearch(key);
        waitText(dictionaryTitles,key);
        find(dictionaryTitles).click();
        waitText(detailDictionaryTitle,title);
        assertText=find(relationDictionary).getText();
        jsClick(relationDictionary);
        waitText(detailDictionaryTitle,assertText);
        String dictionaryTitle=find(detailDictionaryTitle).getText();
        enterPolicyDictionary();
        return dictionaryTitle;
    }

    //返回所有词典
    public ArrayList<String> getDictionaryTitles(By by){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        while (dictionaryNum==finds(dictionaryTitles).size()){
            System.currentTimeMillis();
        }
        ArrayList<String> title=new ArrayList<>();
        finds(by).forEach(webElement -> {
            title.add(webElement.getText());
        });
        return  title;
    }
}
