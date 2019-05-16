import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyLinking extends BaseActions{

    public FamilyLinking(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickFamilyMenu(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ajaxClick(Locators.FAMILY_MENU_ICON);
    }

    public void clickCreateFamily(){
        driver.findElement(Locators.CREATE_FAMILY_BUTTON).click();
    }

    public void clickContinueOnConfirmationPopup(){
        driver.findElement(Locators.CONFIRMATION_POPUP_CONTINUE_BUTTON).click();
    }

    public void enterFamilyNameAndSubmit(){
        driver.findElement(Locators.FAMILY_DISPLAY_NAME_FIELD).clear();
        driver.findElement(Locators.FAMILY_DISPLAY_NAME_FIELD).sendKeys(Data.defaultFamilyName);
        driver.findElement(Locators.FAMILY_NAME_SUBMIT_BUTTON).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickContinueOnConfirmationPopup();
    }

    public void parentCreatesFamily(){
        clickFamilyMenu();
        clickCreateFamily();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterFamilyNameAndSubmit();
    }

    public String getFamilyDisplayNameForVerification(){
        String familyDisplayName = driver.findElement(Locators.FAMILY_DISPLAY_NAME_TITLE).getText();
        return familyDisplayName;
    }

    public void deletefamily() throws InterruptedException {
        clickFamilyMenu();
        ajaxClick(Locators.FAMILY_ICON_SETTINGS);
        Thread.sleep(1000);
        ajaxClick(Locators.FAMILY_DELETE_BUTTON);
        Thread.sleep(1000);
        driver.findElement(Locators.FAMILY_DELETE_CONFIRMATION_BUTTON).click();
        Thread.sleep(1000);
        clickContinueOnConfirmationPopup();
    }

    public void clickInviteMemberButton(){
        ajaxClick(Locators.FAMILY_INIVITE_MEMBER_BUTTON);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inviteFamilyMemberViaJassbyCode(){
        clickInviteMemberButton();
        enterJassbyCodeInCellsAndSubmit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickContinueOnConfirmationPopup();
    }

    public void enterJassbyCodeInCellsAndSubmit(){

        // Create list of web-elements for Jassby code
        List<WebElement> jassbyCode = driver.findElements(Locators.FAMILY_CELL_PLACEHOLDER);
        jassbyCode.add(driver.findElement(Locators.FAMILY_LAST_CELL_PLACEHOLDER));

        // Create list of digits for Jassby code
        List<String> jassbyCodeDigits = new ArrayList<>(Arrays.asList("0", "3", "2", "1", "7", "2"));

        for (int i = 0; i < jassbyCode.size(); i++) {
            WebElement jassbyCodeCurrentPlaceholder = jassbyCode.get(i);
            jassbyCodeCurrentPlaceholder.clear();
            jassbyCodeCurrentPlaceholder.sendKeys(jassbyCodeDigits.get(i));
        }

        clickSubmitButtonInviteFamilyMember();

    }

    public void clickSubmitButtonInviteFamilyMember(){
        driver.findElement(Locators.FAMILY_INVITE_MEMBER_BUTTON).click();
    }

    /** Get text of alert for sent or received invitation to family */
    public String alertGetText(){
        String alertText = driver.findElement(Locators.FAMILY_ALERT_INVITATION).getText();
        return alertText;
    }

    /** Click Approve button to accept invitation to family */
    public void clickApproveButtonToJoinFamily(){
        driver.findElement(Locators.FAMILY_APPROVE_INVITATION_BUTTON).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickContinueOnConfirmationPopup();
    }



}
