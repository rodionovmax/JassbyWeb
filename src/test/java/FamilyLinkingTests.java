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
        //Send Jassby code
        familyLinking.inviteFamilyMemberViaJassbyCode();
        //Verify code was successfully sent
        Thread.sleep(1000);
        String invitationSentAlertText = familyLinking.assertInvitationSuccessfullySent();
        Assert.assertTrue(invitationSentAlertText.contains(Data.invitationSentExpectedText));
        //delete family
        familyLinking.deletefamily();
    }
}
