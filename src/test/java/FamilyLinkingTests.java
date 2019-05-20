import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyLinkingTests extends BaseUI{

    /** Tests that: 1. Parent creates Jassby Family
     *              2. Parent invites kid
     *              3. Verify that invitation was sent
     *              4. Logout from parent account and login as kid
     *              5. Accept invitation and verify that Kid sees Family name
     *              6. Logout from kid account and login as Parent
     *              7. Delete family to make test reusable*/
    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void parentCreatesFamilyInvitesKidAndKidAccepts(String loginParent, String password, String loginKid, String loginGrandparent) throws InterruptedException {

        main.clickLogin();
        login.enterEmailAndPassword(loginParent, password);
        familyLinking.parentCreatesFamily();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);
        familyLinking.clickInviteMemberButton();
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

    /** Tests that: 1. Parent creates Jassby Family
     *              2. Parent invites grandparent
     *              3. Verify that invitation was sent
     *              4. Logout from parent account and login as grandparent
     *              5. Accept invitation and verify that Grandparent sees Family name
     *              6. Logout from Grandparent account and login as Parent
     *              7. Delete family to make test reusable*/
    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void parentCreatesFamilyInvitesGrandparentAndGrandparentAccepts(String loginParent, String password, String loginKid, String loginGrandparent) throws InterruptedException {
        main.clickLogin();
        login.enterEmailAndPassword(loginParent, password);
        familyLinking.parentCreatesFamily();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.defaultFamilyName);
        familyLinking.clickInviteMemberButton();
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

    /** Tests that: 1. Kid logs in
     *              2. Kid invites Parent
     *              3. Verify that invitation was sent
     *              4. Logout from kid account and login as parent
     *              5. Accept invitation and verify that parent sees Family name
     *              6. Delete family to make test reusable*/
    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void kidRequestsToJoinFamilyAndParentAccepts(String loginParent, String password, String loginKid, String loginGrandparent) throws InterruptedException {
        main.clickLogin();
        login.enterEmailAndPassword(loginKid, password);
        familyLinking.clickFamilyMenu();
        familyLinking.inviteParent();
        //Send Jassby code to parent family owner
        List<String> jassbyCodeDigits = new ArrayList<>(Arrays.asList("2", "8", "1", "8", "0", "5"));
        familyLinking.inviteFamilyMemberViaJassbyCode(jassbyCodeDigits);
        //Verify code was successfully sent
        Thread.sleep(1000);
        String alertInvitationSentText = familyLinking.alertGetText();
        Assert.assertTrue(alertInvitationSentText.contains(Data.invitationSentExpectedText));
        //Logout from kid account
        main.logOut();
        //Login as parent
        login.enterEmailAndPassword(loginParent, password);
        Thread.sleep(1000);
        String alertInvitationReceivedText = familyLinking.alertGetText();
        Assert.assertTrue(alertInvitationReceivedText.contains(Data.invitationReceivedExpectedText));
        //Click Approve invitation
        familyLinking.clickApproveButtonToJoinFamily();
        //Verify kid joined family
        familyLinking.clickFamilyMenu();
        Thread.sleep(1000);
        Assert.assertEquals(familyLinking.getFamilyDisplayNameForVerification(), Data.jassbyFamilyName);
        //delete family
        familyLinking.deletefamily();
    }

    /** Tests that: 1. Grandparent logs in
     *              2. Grandparent invites Parent
     *              3. Verify that the error message comes up "Invite is not allowed"
     *              4. Logout from grandparent account */
    @Test(dataProvider = "CredentialsForParentInvitesKidAndGrandparent", dataProviderClass = DataProviders.class)
    public void verifyGrandparentCannotRequestToJoinFamily(String loginParent, String password, String loginKid, String loginGrandparent){
        main.clickLogin();
        login.enterEmailAndPassword(loginGrandparent, password);
        familyLinking.clickFamilyMenu();
        familyLinking.requestToJoinAsGrandparent();
        //Send Jassby code to parent family owner
        List<String> jassbyCodeDigits = new ArrayList<>(Arrays.asList("2", "8", "1", "8", "0", "5"));
        familyLinking.requestToJoinAsGrandparent(jassbyCodeDigits);
        //Verify that grandparent cannot request to join family
        String messageGrandparentCannotInvite = familyLinking.getMessageGrandparentCannotRequestToJoin();
        Assert.assertEquals(messageGrandparentCannotInvite, Data.grandparentCannotJoinFamilyExpectedMessage);
        familyLinking.clickContinueOnConfirmationPopup();

        //Logout from kid account
        main.logOut();

    }

}
