import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyLinkingTests extends BaseUI{


    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void parentCreatesFamilyInvitesKidAndKidAccepts(String loginParent, String password, String loginKid, String loginGrandparent) throws InterruptedException {

        main.clickLogin();
        login.enterEmailAndPassword(loginParent, password);
        familyLinking.parentCreatesFamily();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);
        //Send Jassby code to kid
        List<String> jassbyCodeDigits = new ArrayList<>(Arrays.asList("0", "3", "2", "1", "7", "2"));
        familyLinking.inviteFamilyMemberViaJassbyCode(jassbyCodeDigits);
        //Verify code was successfully sent
        Thread.sleep(1000);
        String alertInvitationSentText = familyLinking.alertGetText();
        Assert.assertTrue(alertInvitationSentText.contains(Data.invitationSentExpectedText));
        //Logout from parent account
        main.logOut();
        //Login as kid
        login.enterEmailAndPassword(loginKid, password);
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
        login.enterEmailAndPassword(loginParent, password);
        //delete family
        familyLinking.deletefamily();
    }

    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void parentCreatesFamilyInvitesGrandparentAndGrandparentAccepts(String loginParent, String password, String loginKid, String loginGrandparent) throws InterruptedException {
        main.clickLogin();
        login.enterEmailAndPassword(loginParent, password);
        familyLinking.parentCreatesFamily();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);
        //Send Jassby code to grandparent
        List<String> jassbyCodeDigits = new ArrayList<>(Arrays.asList("2", "7", "8", "6", "2", "2"));
        familyLinking.inviteFamilyMemberViaJassbyCode(jassbyCodeDigits);
        //Verify code was successfully sent
        Thread.sleep(1000);
        String alertInvitationSentText = familyLinking.alertGetText();
        Assert.assertTrue(alertInvitationSentText.contains(Data.invitationSentExpectedText));
        //Logout from parent account
        main.logOut();
        //Login as grandparent
        login.enterEmailAndPassword(loginGrandparent, password);
        Thread.sleep(1000);
        String alertInvitationReceivedText = familyLinking.alertGetText();
        Assert.assertTrue(alertInvitationReceivedText.contains(Data.invitationReceivedExpectedText));
        //Click Approve invitation
        familyLinking.clickApproveButtonToJoinFamily();
        //Verify grandparent joined family
        familyLinking.clickFamilyMenu();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);
        //Logout from kid account
        main.logOut();
        //Login as parent to delete family
        login.enterEmailAndPassword(loginParent, password);
        //delete family
        familyLinking.deletefamily();
    }

    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void KidRequestsToJoinFamilyAndParentAccepts(String loginParent, String password, String loginKid, String loginGrandparent) {
        main.clickLogin();
        login.enterEmailAndPassword(loginKid, password);

    }
}
