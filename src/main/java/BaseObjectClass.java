
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseObjectClass {
    WebDriver driver;

    public void launchURL(String url){
        driver.get(url);

    }

    public void ddnSelection(List<WebElement> list, String value){
        for(WebElement el:list) {
            if (el.getText().contains(value)) {
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(el));
                el.click();
                break;
            }
        }

    }

    public void elementClick(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void enterText(WebElement element, String value){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    public String getText(WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element)).getText();
    }

}
