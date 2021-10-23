package pages;

import config.DriverProvider;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BaseClass {

    Logger log = Logger.getLogger(this.getClass().getName());
    public DriverProvider driver;

    public static By repositoryTab = By.cssSelector("a[class='UnderlineNav-item '][href*='repositories']");

    public BaseClass() {
        driver = DriverProvider.getDriver();
    }

    public void openHomeURL() {
        driver.openUrl();
    }
    public void clickRepoTab() {
        driver.click(repositoryTab);

    }


}
