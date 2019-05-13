import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseActions {

    public Login(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void enterEmailAndPassword(String email, String password){

        // Enter email
        driver.findElement(Locators.LOGIN_EMAIL_FIELD).clear();
        driver.findElement(Locators.LOGIN_EMAIL_FIELD).sendKeys(email);
        // Enter password
        driver.findElement(Locators.LOGIN_PASSWORD_FIELD).clear();
        driver.findElement(Locators.LOGIN_PASSWORD_FIELD).sendKeys(password);
        // Click Next button
        driver.findElement(Locators.LOGIN_SUBMIT_BUTTON).click();

    }

    public void loginViaGmail(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LOGIN_VIA_GMAIL));
        driver.findElement(Locators.LOGIN_VIA_GMAIL).click();
    }

    public void enterGmailCredentials(String email, String password) throws InterruptedException {
        // Enter email
        driver.findElement(Locators.GMAIL_LOGIN_FIELD).clear();
        driver.findElement(Locators.GMAIL_LOGIN_FIELD).sendKeys(email);
        // Click next button
        gmailNextButton();
        // Enter password
        Thread.sleep(1000);
        driver.findElement(Locators.GMAIL_PASSWORD_FIELD).clear();
        driver.findElement(Locators.GMAIL_PASSWORD_FIELD).sendKeys(password);
        gmailNextButton();

    }

    public void gmailNextButton(){
        driver.findElements(Locators.GMAIL_NEXT_BUTTON).get(0).click();
    }

    public String getLoginVerificationTitle(){
        String loginVerificationTitle = driver.findElement(Locators.LOGIN_H5_VERIFICATION_HEADER).getText();
        return loginVerificationTitle;
    }
}
