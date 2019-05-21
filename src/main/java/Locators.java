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
    public static final By MENU_FAMILY_ICON = By.xpath("//span[@class='jIcon icon-icon_linkedaccounts']");
    public static final By MENU_HOME_ICON = By.xpath("//span[@class='jIcon icon-icon_home']");
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
    public static final By FAMILY_ALERT_INVITATION = By.xpath("//span[@class='alertMessage']");
    public static final By FAMILY_APPROVE_INVITATION_BUTTON = By.xpath("//button//span[contains(text(), 'Approve')]");
    public static final By FAMILY_INVITE_PARENT = By.xpath("//div[@id='inviteParentCol']");
    public static final By FAMILY_JOIN_FAMILY = By.xpath("//div[@id='joinFamilyCol']");
    public static final By FAMILY_MESSAGE_INVITE_NOT_ALLOWED = By.xpath("//p[contains(text(), 'Sorry, the invite is not allowed')]");

    public static final By SEND_MONEY_MENU_ICON = By.xpath("//span[@class='jIcon icon-icon_request']");
    public static final By SEND_MONEY_SELECT_SEND_TO = By.xpath("//select[@id='sendMoneyTo']");
    public static final By SEND_MONEY_SELECT_KID= By.xpath("//select[@id='sendMoneyTo']//option");
    public static final By SEND_MONEY_SELECT_BUDGET= By.xpath("//select[@id='sendMoneyBudget']");
    public static final By SEND_MONEY_SELECT_BUDGET_OPTION= By.xpath("//select[@id='sendMoneyBudget']//option");
    public static final By SEND_MONEY_AMOUNT_INPUT= By.xpath("//input[@id='sendMoneyAmount']");
    public static final By SEND_MONEY_BUTTON= By.xpath("//button[@id='sendMoneySubmitBtn']");

    public static final By KID_NAME_CARDS= By.xpath("//span[@class='d-block card-kid__name']");
    public static final By KIDS_BALANCE_ON_CARD= By.xpath("//h4[@class='card-amount jassby-text-gray card-kid__amount']");




}
