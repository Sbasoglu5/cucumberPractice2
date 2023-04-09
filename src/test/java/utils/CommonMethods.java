package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CommonMethods {
    public static WebDriver driver;
    public static void openBrowsersAndLaunchApplication(){
        ConfigReader.readProperties();
        String browserType=ConfigReader.getPropertyValue("browserType");
        switch (browserType){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;
            default:
                driver=new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));
    }
    public static void closeBrowser(){
        driver.close();
    }
}
