package page;

import conf.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ProjectMatchPage extends Method {
    //项目匹配菜单
    public static By projectMatchMenu=xpathOrId("//ul[@class='menu_list']/li[4]");
    //页面标题
    public By pageTitle=xpathOrId("//div[@aria-label='Breadcrumb']/span[2]/span[1]");
    //企业名称输入框
    public static By companyInput=xpathOrId("//input[@placeholder='请输入企业名称']");
    //联想结果下拉列表
    public static By relationResultList=xpathOrId("//div[@role='region']/div/div/ul/li/div/span");
    //匹配记录
    public By matchRecordBtn=xpathOrId("//div[@class='title_record']");
    //匹配结果页-企业名称
    public static By companyName=xpathOrId("//div[@class='left_company_name']");
    //匹配结果页-申领资金
    public static By declareCapital=xpathOrId("//div[@class='left_fcje']");
    //匹配结果页-申报项目数
    public static By deaclareProjectNum=xpathOrId("//div[@class='left_xms']");
    //立即申报按钮
    public By declareBtn=xpathOrId("//button[@class='btn_doing btn']");
    //我要申报-申报主体(企业名称)
    public By declareCompanyInput=xpathOrId("//input[@placeholder='请输入企业主体的名称']");
    //我要申报-联系人
    public By declareContactInput=xpathOrId("//input[@placeholder='请输入联系人姓名']");
    //我要申报-电话
    public By declarePhoneInput=xpathOrId("//input[@placeholder='请输入联系人电话']");
    //我要申报-备注
    public By declareRemarkInput=xpathOrId("//textarea[@placeholder='请输入你的需求']");
    //我要申报-提交
    public By declareSaveBtn=xpathOrId("//div[@class='has_declare']/div[2]/button");
    //我要申报-标题
    public By declarePageTitle=xpathOrId("//span[@class='header_title']");
    //筛选-扶持方式：称号认定
    public By supportTitleConfirm=xpathOrId("//div[@class='header_label']/div[3]");
    //筛选：扶持方式：全部
    public By supportAll=xpathOrId("//div[@class='header_label']/div[1]");
    //列表：项目标题
    public By listProjectTitles=xpathOrId("//div[@class='item_title']");
    //列表：扶持方式
    public String listSupportTitles="//div[@class='right_content right_content_supple']/div[1]/div/div[3]/div";
    //列表：发文日期
    public By publishTimeTitles=xpathOrId("//div[@class='item_left']/div[2]/span[1]");
    //列表：截止日期
    public By endTimeTitles=xpathOrId("//div[@class='item_left']/div[3]/div[1]");
    //排序下拉框
    public By sortSelect=xpathOrId("//div[@class='paixu_icon']");
    //排序：按发文日期
    public By publishTimeOption=xpathOrId("/html/body/ul/li[2]/span");
    //排序：按截止日期
    public By endTimeOption=xpathOrId("/html/body/ul/li[3]/span");
    //更换
    public By switchCompanyBtn=xpathOrId("//div[@class='left_txt']");

    public String assertText="";

    //提示信息弹框
    public By info=xpathOrId("/html/body/div[last()]/p");

    public void waitlasterHotPolicyTitle(){
        waitText(HomePage.lasterHotPolicyTitle,"近期热门政策");
    }

    //进入项目匹配页面
    public void enterProjectMatch(){
        find(projectMatchMenu).click();
        waitText(pageTitle,"项目匹配");
    }

    //输入企业名称筛选
    public ArrayList<String> searchCompany(String company){
        find(companyInput).sendKeys(company);
        waitText(relationResultList,company);
        find(relationResultList).click();
        waitText(companyName,company);
        ArrayList<String> list=new ArrayList<>();
        list.add(find(companyName).getText());
        list.add(find(declareCapital).getText());
        list.add(find(deaclareProjectNum).getText());
        return list;
    }

    //立即申报
    public String declareSuccess(String company,String contact,String phone,String remark){
        find(declareBtn).click();
        waitText(declarePageTitle,"我要申报");
        find(declareCompanyInput).sendKeys(company);
        find(declareContactInput).sendKeys(contact);
        find(declarePhoneInput).sendKeys(phone);
        find(declareRemarkInput).sendKeys(remark);
        find(declareSaveBtn).click();
        return find(info).getText();
    }

    //筛选：扶持方式：称号认定
    public HashMap<String, ArrayList<String>> filterSupportSuccess(){
        ArrayList<String> startList=new ArrayList<>();
        finds(listProjectTitles).forEach(webElement -> {
            startList.add(webElement.getText());
        });
        assertText=find(supportTitleConfirm).getText();
        find(supportTitleConfirm).click();
        while (true){
            ArrayList<String> endList=new ArrayList<>();
            finds(listProjectTitles).forEach(webElement -> {
                endList.add(webElement.getText());
            });
            if(!endList.equals(startList)){
                HashMap<String,ArrayList<String>> map=new HashMap<>();
                int i=1;
                for(WebElement webElement:finds(listProjectTitles)){
                    ArrayList<String> supporttag=new ArrayList<>();
                    finds(By.xpath(listSupportTitles.replace("/div[1]/div/div[3]/div","/div["+i+"]/div/div[3]/div"))).forEach(webElement1 -> {
                        supporttag.add(webElement1.getText());
                    });
                    map.put(webElement.getText(),supporttag);
                    i++;
                }
                find(supportAll).click();
                while (finds(listProjectTitles).equals(startList)){
                    System.currentTimeMillis();
                }
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return map;
            }
        }
    }

    //排序：按发文日期排序
    public ArrayList<String> publishTimeSort(){
        ArrayList<String> startList = sort(listProjectTitles,publishTimeOption);
        System.out.println(startList.toString());
        while (true){
            ArrayList<String> endList=new ArrayList<>();
            finds(listProjectTitles).forEach(webElement -> {
                endList.add(webElement.getText());
            });
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(!endList.equals(startList)){
                ArrayList<String> time=new ArrayList<>();
                finds(publishTimeTitles).forEach(webElement -> {
                    time.add(webElement.getText().replace("-",""));
                });
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return time;
            }
        }
    }

    private ArrayList<String> sort(By title,By option) {
        ArrayList<String> startList=new ArrayList<>();
        finds(title).forEach(webElement -> {
            startList.add(webElement.getText().replace("-",""));
        });
        mouseMoveToElement(sortSelect);
        jsClick(option);
//        find(companyName).click();
        return startList;
    }

    //排序：按截止日期排序
    public ArrayList<String> endTimeSort(){
        ArrayList<String> startList = sort(endTimeTitles,endTimeOption);
        while(true){
            ArrayList<String> endList=new ArrayList();
            finds(endTimeTitles).forEach(webElement -> {
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
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return endtimelist;
            }
        }
    }

    //打开项目摘要页
    public String openProjectDetail(PolicyFileDetailPage policyFileDetailPage){
        assertText=find(listProjectTitles).getText();
        find(listProjectTitles).click();
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

    //更换匹配企业
    public ArrayList<String> switchCompanyMatch(String company){
        find(switchCompanyBtn).click();
        waitText(pageTitle,"项目匹配");
        return searchCompany(company);
    }
}
