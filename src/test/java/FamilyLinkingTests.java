import org.testng.Assert;
import org.testng.annotations.Test;

public class FamilyLinkingTests extends BaseUI{


    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void parentCreatesFamilyInvitesKidAndGrandparent(String loginParent, String passwordParent) throws InterruptedException {

        main.clickLogin();
        login.enterEmailAndPassword(loginParent, passwordParent);
        familyLinking.parentCreatesFamily();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);

        //delete family
        familyLinking.deletefamily();
    }
}
