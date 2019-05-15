import org.openqa.selenium.By;

/** Class for Locators **/

public class Locators {

    public static final By HOME_LOGIN = By.xpath("//li[@class='nav-item nav-item-toponly']//a//span[contains(text(), 'Log In')]");
    public static final By LOGIN_EMAIL_FIELD = By.xpath("//input[@type='email']");
    public static final By LOGIN_PASSWORD_FIELD = By.xpath("//input[@type='password']");
    public static final By LOGIN_SUBMIT_BUTTON = By.xpath("//button[@id='registrationNextBtn']");

    public static final By HOME_MORE_BUTTON = By.xpath("//a[@id='settingsNav']");
    public static final By LOGOUT_BUTTON = By.xpath("//a[@href='logout']");
    public static final By LOGIN_VIA_GMAIL = By.xpath("//form[@id='redirectGoogle']");
    public static final By GMAIL_LOGIN_FIELD = By.xpath("//input[@type='email']");

    public static final By GMAIL_NEXT_BUTTON = By.xpath("//span[@class='RveJvd snByac']");
    public static final By GMAIL_PASSWORD_FIELD = By.xpath("//input[@type='password']");
    public static final By LOGIN_H5_VERIFICATION_HEADER = By.xpath("//h5");
    public static final By FAMILY_MENU_ICON = By.xpath("//span[@class='jIcon icon-icon_linkedaccounts']");
    public static final By CREATE_FAMILY_BUTTON = By.xpath("//div[@id='createFamilyCol']");
    public static final By FAMILY_DISPLAY_NAME_FIELD = By.xpath("//input[@id='familyDisplayName']");
    public static final By FAMILY_NAME_SUBMIT_BUTTON= By.xpath("//div[@id='createFamilyBtn']");
    public static final By CONFIRMATION_POPUP_CONTINUE_BUTTON= By.xpath("//div[contains(text(), 'Continue')]");
    public static final By FAMILY_DISPLAY_NAME_TITLE= By.xpath("//h5[@class='card-title']");
    public static final By FAMILY_ICON_SETTINGS= By.xpath("//span[@class='icon-icon_settings']");
    public static final By FAMILY_DELETE_BUTTON= By.xpath("//li[@data-action='delete']");
    public static final By FAMILY_DELETE_CONFIRMATION_BUTTON= By.xpath("//button[contains(text(), 'Delete Family')]");
    public static final By FAMILY_INIVITE_MEMBER_BUTTON= By.xpath("//button[contains(text(), 'Invite Member')]");
    public static final By FAMILY_CELL_PLACEHOLDER = By.xpath("//input[@class='jassby-code-digit']");
    public static final By FAMILY_LAST_CELL_PLACEHOLDER = By.xpath("//input[@class='jassby-code-digit last']");
    public static final By FAMILY_INVITE_MEMBER_BUTTON = By.xpath("//div[@id='addKidBtn']");
    public static final By FAMILY_ALERT_INVITATION_SENT = By.xpath("//span[@class='alertMessage']");




}
