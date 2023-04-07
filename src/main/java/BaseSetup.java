import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.sql.Timestamp;

public class BaseSetup {

    public WebDriver driver;

    BasePageClass basePageClass;
    static ExtentTest test;
    static ExtentReports report;

    @Parameters("browser")

    @BeforeClass
    public void beforeTest(String browser){
        if(browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions fireFoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(fireFoxOptions);
            driver.manage().deleteAllCookies();
            driver.manage().window().setSize(new Dimension(1024, 768));
            driver.manage().window().maximize();
        }else if (browser.equalsIgnoreCase("chrome")||browser.isEmpty()) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().deleteAllCookies();
            driver.manage().window().setSize(new Dimension(1024, 768));
            driver.manage().window().maximize();
        }
    }


    @BeforeMethod
    public void before(Method method){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        report = new ExtentReports("./Report/ExtentReport"+timestamp.getTime()+".html",true);
        test = report.startTest(method.getName());
        basePageClass=new BasePageClass(driver);
    }

    @AfterClass
    public void afterMethod(){
       driver.quit();
       report.endTest(test);
       report.flush();
    }


}
