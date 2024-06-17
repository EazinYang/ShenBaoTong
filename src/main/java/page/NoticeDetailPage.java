package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class NoticeDetailPage extends PolicyDetailPage{
    //公示公告标题
    public static By title=xpathOrId("//div[@class='fg']/div/h1");
    //联系信息tab
    public static By relationTab=xpathOrId("//div[@class='el-row']/div/ul/li[2]/a");
    //获批名单tab
    public static By receiveApprovalTab=xpathOrId("//div[@class='el-row']/div/ul/li[3]/a");
    //政策文件tab
    public By policyFileTab=xpathOrId("//div[@class='el-row']/div/ul/li[4]/a");
    //政策文件tab-政策标题
    public static By policyTitle=xpathOrId("//div[@class='zhengce_area']/div/div");
    //政策文件tab-项目标题
    public static By projectTitle=xpathOrId("//div[@class='zhengce_area']/div[3]/div/div/div");
    //相关文件tab
    public static By fileTab=xpathOrId("//div[@class='el-row']/div/ul/li[5]/a");

    public String getTitle() {
        return find(title).getText();
    }

    //进入详情页
    public ArrayList<String> verficationDetailInfo(){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(find(title).getText());
        arrayList.add(find(department).getText().replace("来源：",""));
        arrayList.add(find(publicDate).getText().replace("发文日期：",""));
        arrayList.add(find(policyTab).getText());
        return arrayList;
    }

    //分享
    public String share(){
        mouseMoveToElement(shareBtn);
        id=getDriver().getCurrentUrl().replaceAll("\\D","");
        System.out.println(id);
        return find(shareId).getAttribute("title").replaceAll("\\D","");
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

    //政策文件tab：跳转政策详情页
    public String policyFileSkipPolicyDetail(PolicyDetailPage policyDetailPage,String title){
        jsClick(policyFileTab);
        find(policyTitle).click();
        assertText=policyDetailPage.getTitleText("政策标题");
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterNoticeDeatil(title);
        return assertText;
    }

    //政策文件tab：跳转项目摘要页
    public ArrayList<String> policyFileSkipProjectDetail(PolicyDetailPage policyDetailPage,String title){
        jsClick(policyFileTab);
        find(projectTitle).click();
        ArrayList<String> list=new ArrayList<>();
        list.add(policyDetailPage.getTitleText("项目标题"));
        list.add(policyDetailPage.getProjectTitle());
        policyLibraryPage.enterpolicyLibrary();
        policyLibraryPage.enterNoticeDeatil(title);
        return list;
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
}
