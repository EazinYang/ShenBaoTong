package conf;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class Method extends Driver{

    public static void refresh(){
        getDriver().navigate().refresh();
    }

    public static By xpathOrId(String by){
        if(by.matches("/.*")){
            return By.xpath(by);
        }else {
            return By.id(by);
        }
    }

    public static WebElement find(By by){
        try {
            wait(by);
            return getDriver().findElement(by);
        }catch (TimeoutException e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<WebElement> finds(By by){
        try {
            wait(by);
            return getDriver().findElements(by);
        }catch (TimeoutException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void wait(By by){
        WebDriverWait wait=new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitElementDisapper(By by){
        WebDriverWait wait=new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitText(By by,String text){
        WebDriverWait wait=new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by,text));
    }

    //改写
//    public static void waitNoText(By by,ArrayList<String> baseTitle){
//        WebDriverWait wait=new WebDriverWait(getDriver(),10);
//        wait.until(textToBePresentInElementLocated(by,baseTitle));
//    }

    public static void waitNoText(By by,String text){
        WebDriverWait wait=new WebDriverWait(getDriver(),10);
        wait.until(textToBePresentInElementLocated(by,text));
    }

    //改写
//    public static ExpectedCondition<Boolean> textToBePresentInElementLocated(final By locator, final ArrayList<String> bastTitle) {
//
//        return new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                try {
////                    String elementText = driver.findElement(locator).getText();
////                    return !elementText.contains(text);
//                    return driver.findElements(locator).retainAll(bastTitle);
//
//                } catch (StaleElementReferenceException e) {
//                    return null;
//                }
//            }
//
//
////            @Override
////            public String toString() {
////                return String.format("text ('%s') to be present in element found by %s",
////                        text, locator);
////            }
//        };
//    }

    public static ExpectedCondition<Boolean> textToBePresentInElementLocated(final By locator,
                                                                             final String text) {

        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = driver.findElement(locator).getText();
                    return !elementText.contains(text);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be present in element found by %s",
                        text, locator);
            }
        };
    }

    public static ArrayList<Object> currentUrl(){
        ArrayList<Object> list=new ArrayList<>();
        list.add(System.currentTimeMillis());
        list.add(getDriver().getCurrentUrl());
        return list;
    }

    public static void waitUrlUpdate(ArrayList<Object> currentUrl){
        while (true){
            if(!currentUrl.get(1).equals(getDriver().getCurrentUrl())){
                break;
            }
            long afterTime=System.currentTimeMillis();
            if(afterTime-(long)currentUrl.get(0)>5000){
                throw new RuntimeException("超过等待时间！");
            }
        }
    }

    public static void waitUrl(String url){
        WebDriverWait wait=new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.urlContains(url));
    }

    public static void mouseMoveToElement(By by){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(find(by));
        actions.perform();
    }

    public static void mouseClickElement(By by){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(find(by));
        actions.click();
        actions.perform();
    }

    public static void jsClick(By by){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click()",find(by));
    }

    public static void jsScroll(By by){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView()",find(by));
    }
}
