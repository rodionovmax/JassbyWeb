import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginCredentials")
    public static Object[][] loginCredentials(){
        return new Object[][]{

                {Data.loginEmailUser1, Data.loginPasswordUser},
                {Data.loginEmailUser2, Data.loginPasswordUser},
        };
    }

    @DataProvider(name = "CredentialsForParentInvitesKidAndGrandparent")
    public static Object[][] credentialsForFamilyLinking(){
        return new Object[][]{
                {Data.loginParent, Data.password, Data.loginKid, Data.password}
        };
    }
}
