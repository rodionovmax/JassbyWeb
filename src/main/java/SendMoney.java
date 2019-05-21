import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SendMoney extends BaseActions{

    public SendMoney(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickSendMoneyMenu(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ajaxClick(Locators.SEND_MONEY_MENU_ICON);
    }


    public void selectKidToSendMoney(String kidName){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SEND_MONEY_SELECT_SEND_TO));
        driver.findElement(Locators.SEND_MONEY_SELECT_SEND_TO).click();
        List<WebElement> kidsForSendMoney = driver.findElements(Locators.SEND_MONEY_SELECT_KID);
        for (int i = 0; i < kidsForSendMoney.size(); i++) {
            WebElement selectedKid = kidsForSendMoney.get(i);
            if(selectedKid.getText().contains(kidName)){
                selectedKid.click();
            }
        }
    }

    public void selectBudgetToSendMoney(String budgetName){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SEND_MONEY_SELECT_BUDGET));
        Select budget = new Select(driver.findElement(Locators.SEND_MONEY_SELECT_BUDGET));
        budget.selectByValue(budgetName);

    }

    public void sendMoneyAmount(String amount){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SEND_MONEY_AMOUNT_INPUT));
        driver.findElement(Locators.SEND_MONEY_AMOUNT_INPUT).click();
        driver.findElement(Locators.SEND_MONEY_AMOUNT_INPUT).sendKeys(amount);
    }

    public void clickSendMoneyButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SEND_MONEY_BUTTON));
        driver.findElement(Locators.SEND_MONEY_BUTTON).click();
        clickContinueOnConfirmationPopup();
    }

//    public String checkKidsBalanceBeforeSendMoney(){
//        wait.until(ExpectedConditions.elementToBeClickable(Locators.KID_NAME_CARDS));
//        List<WebElement> kidNameCards = driver.findElements(Locators.KID_NAME_CARDS);
//        for (int i = 0; i < kidNameCards.size(); i++) {
//            WebElement kidName = kidNameCards.get(i);
//            String kidBalance = driver.findElements(Locators.KIDS_BALANCE_ON_CARD).get(i).getText();
//        }
//        return kidBalance;
//    }
    public double checkFirstKidBalance(){
        String firstKidBalance = driver.findElements(Locators.KIDS_BALANCE_ON_CARD).get(0).getText();
        firstKidBalance = firstKidBalance.replace("$", "");
        double firstKidBalanceDouble = Double.parseDouble(firstKidBalance);
        return firstKidBalanceDouble;
    }

    public double checkSecondKidBalance(){
        String secondKidBalance = driver.findElements(Locators.KIDS_BALANCE_ON_CARD).get(1).getText();
        secondKidBalance = secondKidBalance.replace("$", "");
        double secondKidBalanceDouble = Double.parseDouble(secondKidBalance);
        return secondKidBalanceDouble;
    }

}
