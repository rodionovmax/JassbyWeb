import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginCredentials")
    public static Object[][] loginCredentials(){
        return new Object[][]{

                {Data.loginEmailUser1, Data.loginPasswordUser},
                {Data.loginEmailUser2, Data.loginPasswordUser},
        };
    }

    @DataProvider(name = "CredentialsForFamilyLinkingTests")
    public static Object[][] credentialsForFamilyLinking(){
        return new Object[][]{
                {Data.loginParentForFamilyLinkingTests, Data.password, Data.loginKidForFamilyLinkingTests, Data.loginGrandparentForFamilyLinkingTests}
        };
    }

    @DataProvider(name = "CredentialsForSendMoneyTests")
    public static Object[][] credentialsForSendMoney(){
        return new Object[][]{
                {Data.loginParentForSendMoneyTests, Data.password, Data.loginKidForSendMoneyTests, Data.loginGrandparentForSendMoneyTests}
        };
    }
}
