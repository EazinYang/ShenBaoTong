package page;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class PolicyFileDetailPage extends PolicyDetailPage{
    //联系信息tab
    public static By relationTab=xpathOrId("//div[@class='el-row']/div/ul/li[3]/a");

    //订阅
    public String subscribe(PushPage pushPage,String titles){
        titleText=find(title).getText();
        find(subscribeBtn).click();
        tips=find(tipsText).getText();
        String btnStatus=find(subscribeBtn).getText();
        pushPage.enterPushPage();
        pushPage.getSubscribeTitles();
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterPolicyFileDeatil(titles);
        return btnStatus;
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
}
