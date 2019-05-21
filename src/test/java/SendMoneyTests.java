import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMoneyTests extends BaseUI{



    @Test(dataProvider = "CredentialsForSendMoneyTests", dataProviderClass = DataProviders.class)
    public void parentSendsMoneyKidVerifiesMoneyReceived(String loginParent, String password, String loginKid, String loginGrandparent) throws InterruptedException {
        main.clickLogin();
        login.enterEmailAndPassword(loginParent, password);
        Thread.sleep(1000);
        double firstKidBalanceBeforeSendMoney = sendMoney.checkFirstKidBalance();
        double secondKidBalanceBeforeSendMoney = sendMoney.checkSecondKidBalance();
        sendMoney.clickSendMoneyMenu();
        sendMoney.selectKidToSendMoney("Kalina");
        sendMoney.selectBudgetToSendMoney("food");
        sendMoney.sendMoneyAmount(Data.sendMoneyAmount);
        sendMoney.clickSendMoneyButton();
        sendMoney.clickHomeMenu();
        double firstKidBalanceAfterSendMoney = sendMoney.checkFirstKidBalance();
        double secondKidBalanceAfterSendMoney = sendMoney.checkSecondKidBalance();
        if(secondKidBalanceAfterSendMoney - secondKidBalanceBeforeSendMoney != Double.parseDouble(Data.sendMoneyAmount)*2){
            Assert.fail("Kid's budget is incorrect");
        }
    }
}
