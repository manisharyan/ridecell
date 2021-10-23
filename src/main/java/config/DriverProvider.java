package config;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class DriverProvider extends DriverClass {

    Logger log = Logger.getLogger(this.getClass().getName());

    public static DriverProvider appDriver = null;

    public  static DriverProvider getDriver() {
        appDriver = (appDriver == null) ? new DriverProvider() : appDriver;
        return appDriver;
    }

    public void openUrl() {
        log.info("Opening the url");
        appDriver.get(Configuration.getUrl());
    }

    public void type(By element, String value) {
        appDriver.findElement(element).clear();
        appDriver.findElement(element).sendKeys(value);
        log.info(" Entered value--> "+value);

    }

    public void click(By element) {
        try{
            appDriver.findElement(element).click();
            log.info(" Clicked on element");
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }

    public String getText(By by) {
        waitForElement(by);
        return appDriver.findElement(by).getText().trim();
    }

    public void waitForElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(appDriver, 60);
            wait.until(ExpectedConditions.visibilityOf(appDriver.findElement(by)));
        } catch (Exception e) {

        }
    }

    public ArrayList getResponse(String field){
        log.info("Fetching the response through API");
        RestAssured.baseURI="https://api.github.com/users/django/repos";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        JsonPath jsonPath = response.jsonPath();
        ArrayList fieldValue = jsonPath.get(field);
        log.info("Removing null values");
        fieldValue.removeAll(Collections.singleton(null));
        return fieldValue;
    }

}

class DriverClass extends EventFiringWebDriver {

    public DriverClass() {
        super(createDriver(Configuration.getBrowser()));
    }

    private static WebDriver createDriver(String browser) {
        WebDriver driver = null;
        String driverPath = System.getProperty("user.dir") + "/src/main/java/config/";
        switch (browser) {
            case "chrome":
                System.setProperty(Configuration.chromeKey, driverPath + "chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(Configuration.fireFoxKey, driverPath + "geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                Assert.assertTrue("Not found mentioned browser" + browser, false);

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        return driver;
    }

}
