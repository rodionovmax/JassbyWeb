import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main extends BaseActions{

    public Main(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }


    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.HOME_LOGIN));
        driver.findElement(Locators.HOME_LOGIN).click();
    }

    public void logOut() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.HOME_MORE_BUTTON));
        ajaxClick(Locators.HOME_MORE_BUTTON);
        ajaxClick(Locators.LOGOUT_BUTTON);
    }
}
