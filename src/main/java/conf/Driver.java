package conf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();

    public static void start(){
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        Config config=Config.load("/config.yaml");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognitio");
        WebDriver driver=new ChromeDriver(chromeOptions);
        threadLocal.set(driver);
        getDriver().get(config.url);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        return threadLocal.get();
    }

    public static ThreadLocal getThreadLocal(){
        return threadLocal;
    }
}
