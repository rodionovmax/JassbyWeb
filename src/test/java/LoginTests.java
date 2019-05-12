import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends BaseUI{

    @Test
    public void firstTest(){
        System.out.println("First Test");
        driver.findElement(By.xpath("//li[@class='nav-item nav-item-toponly']//a//span[contains(text(), 'Log In')]")).click();
    }
}
