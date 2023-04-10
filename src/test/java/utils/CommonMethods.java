package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CommonMethods {
    public static WebDriver driver;
    public static void openBrowsersAndLaunchApplication(){
        ConfigReader.readProperties();
        String browserType=ConfigReader.getPropertyValue("browserType");
        switch (browserType){
            case "Chrome":
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

    public static void doClick(WebElement element){
        element.click();
    }

    public static void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }
    public static Select clickDropdown(WebElement element){
        Select select=new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value){
        clickDropdown(element).selectByValue(value);
    }

    public static void selectByIndex(WebElement element, int index){
        clickDropdown(element).selectByIndex(index);
    }

    public static void selectByVisibleText(WebElement element, String text){
        clickDropdown(element).selectByVisibleText(text);
    }

    public static void selectByOptions(WebElement element, String text){
        List<WebElement> options=clickDropdown(element).getOptions();
        for (WebElement option : options) {
            String getText=option.getText();
            if (getText.equalsIgnoreCase(text)){
                option.click();
                break;
            }
        }

    }
}
