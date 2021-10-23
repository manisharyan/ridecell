package pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoryPage extends BaseClass{

    public static By repoName = By.cssSelector("#org-repositories li a[itemprop]");
    public static By repoDescription = By.cssSelector("#org-repositories li p[itemprop]");

    ArrayList repoNameList = new ArrayList();
    ArrayList repoNameApi;
    ArrayList repoDescList = new ArrayList();
    ArrayList repoDescApi;


    public void fetchRepoName() {
        List<WebElement> element = driver.findElements(repoName);
        for(int i=0;i<element.size();i++) {
            repoNameList.add(element.get(i).getText());
        }
        System.out.println("+++++------------" + repoNameList);


    }

    public void fetchRepoDesc(){
        List<WebElement> element = driver.findElements(repoDescription);
        for(int i=0;i<element.size();i++) {
            repoDescList.add(element.get(i).getText());
        }
        System.out.println("+++++++++" + repoDescList);
    }

    public void getRepoNamesApi(){
        repoNameApi = driver.getResponse("name");
        System.out.println("+++++++++" + repoNameApi);
    }

    public void getRepoDescriptionApi(){
        repoDescApi = driver.getResponse("description");
        System.out.println("+++++++++" + repoDescApi);
    }

    public void compareName(){
        Collections.sort(repoNameList);
        Collections.sort(repoNameApi);
        Assert.assertTrue(repoNameList.equals(repoNameApi));
    }

    public void compareDescription(){
        Collections.sort(repoDescList);
        Collections.sort(repoDescApi);
        Assert.assertTrue(repoDescList.equals(repoDescApi));
    }

}
