package page;

import conf.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.sql.Time;
import java.util.ArrayList;

public class DeclareStewardPage extends Method {
    //申报管家菜单按钮
    public By declareStewardMenu=xpathOrId("//ul[@class='menu_list']/li[6]");
    //页面标题
    public By pageTitle=xpathOrId("//div[@class='member']/div/span[2]/span[1]");
    //申报计划tab
    public By declarePlanTab=xpathOrId("//ul[@class='personal-choose']/li[2]");
    //申报计划页面标题
    public By declarePlanPageTitle=xpathOrId("//div[@class='declare']/div/div[1]");
    //申报计划：政策标题
    public static By declarePolicyTitles=xpathOrId("//div[@class='el-card__body']/div[1]");
    //申报计划：取消计划按钮
    public By cancelPlanBtn=xpathOrId("//div[@class='plan_btn']");
    //申报计划：取消计划-确定按钮
    public By confirmBtn=xpathOrId("//body/div[last()-1]/div/div[3]/button[2]");
    //佐证材料tab
    public By evidencetab=xpathOrId("//ul[@class='personal-choose']/li[3]");
    //佐证材料：页面标题
    public By evidencePageTitle=xpathOrId("//div[@class='evidence']/div[1]");
    //佐证材料：添加材料按钮
    public By addMeterialBtn=xpathOrId("//div[@class='evidence']/div[3]/form/div[2]/div/button[2]");
    //佐证材料：添加材料页面标题
    public By addMeterialPageTitle=xpathOrId("//div[@aria-label='添加佐证材料']/div/span");
    //佐证材料-添加材料：材料名称输入框
    public By meterialInput=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div/div/div/input");
    //佐证材料-添加材料：选择分类下拉框
    public By clasifySelect=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[2]/div/div/div/input");
    //佐证材料-添加材料：一级分类
    public By oneLevelSelect=xpathOrId("//body/div[last()]/div/div/div/ul/li[1]");
    //佐证材料-添加材料：二级分类
    public By twoLevelSelect=xpathOrId("//body/div[last()]/div/div[2]/div/ul/li[1]");
    //佐证材料-添加材料：点击上传按钮
    public By uploadBtn=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[3]/div/div/div/input");
    //佐证材料-添加材料：上传成功文件名
    public By uploadSuccessFileName=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[3]/div/div/ul/li/a");
    //佐证材料-添加材料：有效期-无期限
    public By indefiniteDurationRadio=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[4]/div/div/label[1]/span[2]");
    //佐证材料-添加材料：有效期-设置有效期
    public By setTimeRadio=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[4]/div/div/label[2]/span[2]");
    //佐证材料-添加材料：开始日期
    public By setStartTimeInput=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[4]/div/div[2]/input[1]");
    //佐证材料-添加材料：结束日期
    public By setEndTimeInput=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[4]/div/div[2]/input[2]");
    //佐证材料-添加材料：保存并添加按钮
    public By saveBtn=xpathOrId("//div[@aria-label='添加佐证材料']/div[2]/form/div[5]/div/button");
    //佐证材料-添加材料：关闭页面按钮
    public By closeBtn=xpathOrId("//div[@aria-label='添加佐证材料']/div/button");
    //佐证材料：查询按钮
    public By searchBtn=xpathOrId("//div[@class='evidence']/div[3]/form/div[3]/div/button[1]");
    //佐证材料：查询按钮
    public By searchBtn1=xpathOrId("//div[@class='evidence']/div[3]/form/div[2]/div/button[1]");
    //佐证材料：文件名称
    public By fileName=xpathOrId("//div[@class='card']/div[2]/div[1]");
    //佐证材料-筛选：一级分类下拉框
    public By filterOneSelect=xpathOrId("//input[@placeholder='请选择一级标签']");
    //佐证材料-筛选：一级分类：财务
    public By oneSelectOption=xpathOrId("//body/div[last()]/div/div/ul/li[3]");
    //佐证材料-筛选：一级分类：全部
    public By oneSelectOptionAll=xpathOrId("//body/div[last()]/div/div/ul/li[1]");
    //佐证材料-筛选：二级分类下拉框
    public By filterTwoSelect=xpathOrId("//input[@placeholder='请选择子标签']");
    //佐证材料-筛选：二级分类:财务审计报表
    public By twoSelectOption=xpathOrId("//body/div[last()]/div/div/ul/li[2]");
    //佐证材料-编辑弹出按钮
    public By moreBtn=xpathOrId("//div[@class='card']/div[3]/div[1]");
    //佐证材料：编辑按钮
    public By editBtn=xpathOrId("//body/ul/li[2]");
    //佐证材料：删除按钮
    public By deleterBtn=xpathOrId("//body/ul/li[3]");
    //佐证材料-编辑：修改材料名称按钮
    public By editNameBtn=xpathOrId("//div[@class='modify'][1]");
    //佐证材料-编辑：材料名称输入框
    public By editNameInput=xpathOrId("//input[@placeholder='请输入备注名']");
    //佐证材料-编辑：保存按钮
    public By editSaveBtn=xpathOrId("//div[@class='form_sub']");
    //
    //提示信息
    public static By tips=xpathOrId("/html/body/div[last()]/p");

    public String assertText1="";
    public String assertText2="";

    public void waitlasterHotPolicyTitle(){
        waitText(HomePage.lasterHotPolicyTitle,"近期热门政策");
    }

    //进入申报管家页面
    public void enterDeclareStewardPage(){
        find(declareStewardMenu).click();
        waitText(pageTitle,"申报管家");
    }

    //进入申报计划页面
    public void enterDeclarePlanPage(){
        find(declarePlanTab).click();
        waitText(declarePlanPageTitle,"申报计划");
    }

    //进入佐证材料页面
    public void enterevidencePage(){
        find(evidencetab).click();
        waitText(evidencePageTitle,"佐证材料");
    }

    //【申报计划】取消计划
    public String cancelPlan(){
        enterDeclarePlanPage();
        assertText1=find(declarePolicyTitles).getText();
        find(cancelPlanBtn).click();
        find(confirmBtn).click();
        String text=find(tips).getText();
        waitNoText(declarePolicyTitles,assertText1);
        assertText2=find(declarePolicyTitles).getText();
        return text;
    }

    //【申报计划】跳转项目详情页
    public String skipProjectDetail(PolicyFileDetailPage policyFileDetailPage){
        enterDeclarePlanPage();
        assertText1=find(declarePolicyTitles).getText();
        find(declarePolicyTitles).click();
        String text=policyFileDetailPage.getTitleText("项目标题");
        enterDeclareStewardPage();
        return text;
    }

    //【佐证材料】上传无限期的材料
    public String uploadIndefiniteDurationFileSuccess(String meterial,String file){
        uploadFile(meterial,file);
        find(indefiniteDurationRadio).click();
        save();
        return find(tips).getText();
    }

    //【佐证材料】上传有效期内的材料
    public String uploadValidityFileSuccess(String meterial,String file,String startTime,String endTime){
        uploadFile(meterial,file);
        find(setTimeRadio).click();
        find(setStartTimeInput).sendKeys(startTime);
        find(setEndTimeInput).sendKeys(endTime);
        save();
        return find(tips).getText();
    }

    //【佐证材料】上传材料：材料名称为空，保存失败
    public String nullMeterialSaveFail(String file){
        enterevidencePage();
        find(addMeterialBtn).click();
        waitText(addMeterialPageTitle,"添加佐证材料");
        find(clasifySelect).click();
        find(oneLevelSelect).click();
        find(twoLevelSelect).click();
        find(addMeterialPageTitle).click();
        getDriver().findElement(uploadBtn).sendKeys(file);
        find(saveBtn).click();
        String text=find(tips).getText();
        find(closeBtn).click();
        return text;
    }

    //【佐证材料】上传材料：分类为空，保存失败
    public String nullClasifySaveFail(String meterial,String file){
        enterevidencePage();
        find(addMeterialBtn).click();
        waitText(addMeterialPageTitle,"添加佐证材料");
        find(meterialInput).sendKeys(meterial);
        getDriver().findElement(uploadBtn).sendKeys(file);
        find(saveBtn).click();
        while (true){
            if(find(tips).getText().equals("请上传文件")){
                try{
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                find(saveBtn).click();
            }else if(find(tips).getText().equals("请选择分类")){
                String text=find(tips).getText();
                find(closeBtn).click();
                return text;
            }
        }
    }

    //【佐证材料】上传材料：文件为空，保存失败
    public String nullFileSaveFail(String meterial){
        enterevidencePage();
        find(addMeterialBtn).click();
        waitText(addMeterialPageTitle,"添加佐证材料");
        find(meterialInput).sendKeys(meterial);
        find(clasifySelect).click();
        find(oneLevelSelect).click();
        find(twoLevelSelect).click();
        find(addMeterialPageTitle).click();
        find(saveBtn).click();
        String text=find(tips).getText();
        find(closeBtn).click();
        return text;
    }

    //【佐证材料】上传材料：有效期为空，保存失败
    public String nullTimeSaveFail(String meterial,String file){
        enterevidencePage();
        find(addMeterialBtn).click();
        waitText(addMeterialPageTitle,"添加佐证材料");
        find(meterialInput).sendKeys(meterial);
        find(clasifySelect).click();
        find(oneLevelSelect).click();
        find(twoLevelSelect).click();
        getDriver().findElement(uploadBtn).sendKeys(file);
        waitText(uploadSuccessFileName,"house (1).jpg");
        find(saveBtn).click();
        while (true){
            if(find(tips).getText().equals("请上传文件")){
                try{
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                find(saveBtn).click();
            }else if(find(tips).getText().equals("请选择有效期")){
                String text=find(tips).getText();
                find(closeBtn).click();
                return text;
            }
        }
    }

    //【佐证材料】筛选：一级分类
    public ArrayList<String> oneLevelClasifySearchSuccess(){
        enterevidencePage();
        ArrayList<String> startList=new ArrayList<>();
        finds(fileName).forEach(webElement -> {
            startList.add(webElement.getText());
        });
        find(filterOneSelect).click();
        find(oneSelectOption).click();
        find(searchBtn).click();
        while(true){
            if (finds(fileName).size()!=startList.size()){
                ArrayList<String> endList=new ArrayList<>();
                finds(fileName).forEach(webElement -> {
                    endList.add(webElement.getText());
                });
                find(filterOneSelect).click();
                find(oneSelectOptionAll).click();
                find(searchBtn1).click();
                return endList;
            }
        }
    }

    //【佐证材料】筛选：二级分类
    public ArrayList<String> twoLevelClasifySearchSuccess(){
        enterevidencePage();
        ArrayList<String> startList=new ArrayList<>();
        finds(fileName).forEach(webElement -> {
            startList.add(webElement.getText());
        });
        find(filterOneSelect).click();
        find(oneSelectOption).click();
        find(filterTwoSelect).click();
        find(twoSelectOption).click();
        find(searchBtn).click();
        while(true){
            if (finds(fileName).size()!=startList.size()){
                ArrayList<String> endList=new ArrayList<>();
                finds(fileName).forEach(webElement -> {
                    endList.add(webElement.getText());
                });
                find(filterOneSelect).click();
                find(oneSelectOptionAll).click();
                find(searchBtn1).click();
                return endList;
            }
        }
    }

    //【佐证材料】编辑文件
    public String editSuccess(String name){
        enterevidencePage();
        find(moreBtn).click();
        find(editBtn).click();
        find(editNameBtn).click();
        find(editNameInput).sendKeys(Keys.CONTROL,"a");
        find(editNameInput).sendKeys(Keys.BACK_SPACE);
        find(editNameInput).sendKeys(name);
        find(editSaveBtn).click();
        waitText(fileName,name);
        assertText1=find(fileName).getText();
        return assertText1;
    }

    //【佐证材料】删除文件
    public String deleteSuccess(){
        enterevidencePage();
        find(moreBtn).click();
        find(deleterBtn).click();
        waitText(tips,"删除成功");
        assertText1=find(tips).getText();
        return assertText1;
    }

    private void save() {
        find(saveBtn).click();
        while (true){
            if(find(tips).getText().equals("请上传文件")){
                try{
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                find(saveBtn).click();
            }else if(find(tips).getText().equals("新增成功")){
                break;
            }
        }
    }

    private void uploadFile(String meterial,String file) {
        enterevidencePage();
        find(addMeterialBtn).click();
        waitText(addMeterialPageTitle,"添加佐证材料");
        find(meterialInput).sendKeys(meterial);
        find(clasifySelect).click();
        find(oneLevelSelect).click();
        find(twoLevelSelect).click();
        find(addMeterialPageTitle).click();
        getDriver().findElement(uploadBtn).sendKeys(file);
        waitText(uploadSuccessFileName,"house (1).jpg");
    }

    //政策标题
    public ArrayList<String> policyTitles=new ArrayList<>();

    public ArrayList<String> getPolicyTitles(){
        finds(declarePolicyTitles).forEach(webElement -> {
            policyTitles.add(webElement.getText());
        });
        return policyTitles;
    }
}
