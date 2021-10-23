package stepdef;

import config.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import config.DriverProvider;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;


public class Hooks {

    Logger log = Logger.getLogger(this.getClass().getName());

@Before
    public void before() {

        Configuration.loadConfig();
        //DriverProvider.appDriver = DriverProvider.getDriver();
        PropertyConfigurator.configure(new File("src/main/java/config/log4j.properties").getAbsolutePath());

    }

    @After
    public void after() {
        DriverProvider driver = DriverProvider.getDriver();

        driver.quit();
    }


}
