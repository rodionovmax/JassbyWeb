import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FamilyLinking extends BaseActions{

    public FamilyLinking(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickFamilyMenu() throws InterruptedException {
        Thread.sleep(1000);
        ajaxClick(Locators.FAMILY_MENU_ICON);
    }

    public void clickCreateFamily(){
        driver.findElement(Locators.CREATE_FAMILY_BUTTON).click();
    }

    public void clickContinueOnConfirmationPopup(){
        driver.findElement(Locators.CONFIRMATION_POPUP_CONTINUE_BUTTON).click();
    }

    public void enterFamilyNameAndSubmit() throws InterruptedException {
        Thread.sleep(1000);
//        driver.findElement(Locators.FAMILY_DISPLAY_NAME_FIELD).clear();
        driver.findElement(Locators.FAMILY_DISPLAY_NAME_FIELD).sendKeys(Data.defaultFamilyName);
        driver.findElement(Locators.FAMILY_NAME_SUBMIT_BUTTON).click();
        Thread.sleep(1000);
        clickContinueOnConfirmationPopup();
    }

    public void parentCreatesFamily() throws InterruptedException {
        clickFamilyMenu();
        clickCreateFamily();
        enterFamilyNameAndSubmit();
    }

    public String getFamilyDisplayNameForVerification(){
        String familyDisplayName = driver.findElement(Locators.FAMILY_DISPLAY_NAME_TITLE).getText();
        return familyDisplayName;
    }

    public void deletefamily() throws InterruptedException {
        ajaxClick(Locators.FAMILY_ICON_SETTINGS);
        Thread.sleep(1000);
        ajaxClick(Locators.FAMILY_DELETE_BUTTON);
        Thread.sleep(1000);
        driver.findElement(Locators.FAMILY_DELETE_CONFIRMATION_BUTTON).click();
        Thread.sleep(1000);
        clickContinueOnConfirmationPopup();
    }
}
