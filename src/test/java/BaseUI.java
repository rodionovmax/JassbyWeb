import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp(){

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.get(Data.START_URL);
    }


    @AfterMethod
    public void tearDown(){
//        driver.quit();
        System.out.println("Close browser");
    }
}
