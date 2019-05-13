import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseUI{

    @Test(dataProvider = "LoginCredentials", dataProviderClass = DataProviders.class)
    public void testLoginViaEmailWithDataProvider(String email, String password) throws InterruptedException {

        main.clickLogin();
        login.enterEmailAndPassword(email, password);
        main.logOut();
    }

    @Test
    public void testLoginViaGmail() throws InterruptedException {
        main.clickLogin();
        login.loginViaGmail();
        login.enterGmailCredentials(Data.gmailLoginOne, Data.gmailPasswordOne);
        main.logOut();
        Assert.assertEquals(login.getLoginVerificationTitle(), Data.expectedLoginVerificationTitle);
    }



}
