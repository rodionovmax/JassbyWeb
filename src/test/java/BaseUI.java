import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;
    Main main;
    Login login;
    FamilyLinking familyLinking;


    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("chrome://settings/clearBrowserData");
        wait = new WebDriverWait(driver, 5);
//        driver.manage().window().maximize();
        driver.get(Data.startUrl);

        main = new Main(driver, wait);
        login = new Login(driver, wait);
        familyLinking = new FamilyLinking(driver, wait);

    }


    @AfterMethod
    public void tearDown(){
//        driver.quit();
        System.out.println("Close browser");
    }
}
