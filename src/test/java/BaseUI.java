import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;
    Main main;
    Login login;
    FamilyLinking familyLinking;
    SendMoney sendMoney;

    String nodeURL;

    @Parameters({"host"})
    @BeforeMethod
    public void setUp(String host) throws MalformedURLException {

        if (host.equalsIgnoreCase("chrome")) {
            nodeURL = "http://172.17.0.3:5555/wd/hub";
            System.out.println("Chrome Browser Initiated");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            Capabilities chromeCapabilities = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL(nodeURL), chromeCapabilities);

            driver.get("chrome://settings/clearBrowserData");

        } else if (host.equalsIgnoreCase("firefox")) {
            nodeURL = "http://172.17.0.4:5555/wd/hub";
            System.out.println("Firefox Browser Initiated");
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL(nodeURL), firefoxCapabilities);
        } else {
            System.out.println("Cannot identify host to run");
        }

//        System.setProperty("webdriver.chrome.driver", "chromedriver");
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 5);
//        driver.get("chrome://settings/clearBrowserData");
//        driver.manage().window().maximize();

        driver.get(Data.startUrl);

        main = new Main(driver, wait);
        login = new Login(driver, wait);
        familyLinking = new FamilyLinking(driver, wait);
        sendMoney = new SendMoney(driver, wait);

    }


    @AfterMethod
    public void tearDown(){
//        driver.quit();
        System.out.println("Close browser");
    }
}



//        System.setProperty("webdriver.gecko.driver", "geckodriver");
//        driver = new FirefoxDriver();
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("browser.cache.disk.enable", false);
//        profile.setPreference("browser.cache.memory.enable", false);
//        profile.setPreference("browser.cache.offline.enable", false);
//        profile.setPreference("network.http.use-cache", false);