import org.testng.Assert;
import org.testng.annotations.Test;

public class FamilyLinkingTests extends BaseUI{


    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void parentCreatesFamilyInvitesKidAndGrandparent(String loginParent, String passwordParent, String loginKid, String passwordKid) throws InterruptedException {

        main.clickLogin();
        login.enterEmailAndPassword(loginParent, passwordParent);
        familyLinking.parentCreatesFamily();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);
        //Send Jassby code
        familyLinking.inviteFamilyMemberViaJassbyCode();
        //Verify code was successfully sent
        Thread.sleep(1000);
        String alertInvitationSentText = familyLinking.alertGetText();
        Assert.assertTrue(alertInvitationSentText.contains(Data.invitationSentExpectedText));
        //Logout from parent account
        main.logOut();
        //Login as kid
        login.enterEmailAndPassword(loginKid, passwordKid);
        Thread.sleep(1000);
        String alertInvitationReceivedText = familyLinking.alertGetText();
        Assert.assertTrue(alertInvitationReceivedText.contains(Data.invitationReceivedExpectedText));
        //Click Approve invitation
        familyLinking.clickApproveButtonToJoinFamily();
        //Verify kid joined family
        familyLinking.clickFamilyMenu();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);
        //Logout from kid account
        main.logOut();
        //Login as parent to delete family
        login.enterEmailAndPassword(loginParent, passwordParent);
        //delete family
        familyLinking.deletefamily();
    }
}
