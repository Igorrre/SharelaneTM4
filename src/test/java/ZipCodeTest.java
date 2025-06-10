import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZipCodeTest {

    @Test
    public void  test() {
        /*
        1.Открыть браузер
        2.Открыть страницу "https://sharelane.com/cgi-bin/register.py"
        3.В поле ZipCode ввести 1111
        4.Нажать кнопку Continue
        5.Провертиь появление ошибки и текст ошибки
        6.Закрыть браузер
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(error,"Oops, error on page. ZIP code should have 5 digits");

        driver.quit();
    }
}
