package org.autotest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MainTest {
    public static final String DOWNLOAD_FOLDER = "C:\\Users\\" + System.getProperty("user.name") + "\\Downloads\\";
    public static final String URL = "https://es.inspire-tech.ru/onp/_web/";


    WebDriver driver = null;

    @BeforeClass
    public void before() {
        driver = getDriver();
    }

    @Test
    public void test() {
        System.out.println(URL);
    }

    @AfterClass
    public void after() {
        driver.close();
    }

    public static WebDriver getDriver() {


        try {
            WebDriverManager.chromedriver().setup();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("download.default_directory", DOWNLOAD_FOLDER);
            ChromeOptions opt = new ChromeOptions();
            opt.setExperimentalOption("prefs", chromePrefs);
            opt.addArguments("start-maximized");
            return new ChromeDriver(opt);
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
