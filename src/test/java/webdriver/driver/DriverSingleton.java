package webdriver.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.ArrayList;

public class DriverSingleton {
    private static WebDriver driver;

    public DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    ProfilesIni profilesIni = new ProfilesIni();
                    FirefoxProfile firefoxProfile = profilesIni.getProfile("Webdriver_Profile");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setProfile(firefoxProfile);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                }
                default: {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    ArrayList<String> list = new ArrayList<>();
                    list.add("user-data-dir=C:\\Users\\klim\\AppData\\Local\\Google\\Chrome\\User Data");
                    list.add("profile-directory=Profile 2");
                    list.add("disable-infobars");
                    chromeOptions.addArguments(list);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
