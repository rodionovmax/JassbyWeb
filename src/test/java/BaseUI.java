import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;
    Main main;
    Login login;
    FamilyLinking familyLinking;
    SendMoney sendMoney;


    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("chrome://settings/clearBrowserData");

//        System.setProperty("webdriver.gecko.driver", "geckodriver");
//        driver = new FirefoxDriver();
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("browser.cache.disk.enable", false);
//        profile.setPreference("browser.cache.memory.enable", false);
//        profile.setPreference("browser.cache.offline.enable", false);
//        profile.setPreference("network.http.use-cache", false);

        wait = new WebDriverWait(driver, 5);
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
