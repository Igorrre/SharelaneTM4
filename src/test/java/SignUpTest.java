import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest {

    @Test
    public void test() {
        /*
        1.Открыть браузер
        2.Открыть страницу "https://sharelane.com/cgi-bin/register.py"
        3.В поле ZipCode ввести 11111
        4.Нажать кнопку Continue
        5.Авторизоваться, получить успешное сообщение
        6.Закрыть браузер
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        driver.findElement(By.name("first_name")).sendKeys("Igo");
        driver.findElement(By.name("last_name")).sendKeys("B");
        driver.findElement(By.name("email")).sendKeys("Igo@b.com");
        driver.findElement(By.name("password1")).sendKeys("112233");
        driver.findElement(By.name("password2")).sendKeys("112233");

        driver.findElement(By.cssSelector("[value=Register]")).click();

        String error = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(error, "Account is created!");

        driver.quit();
    }
}