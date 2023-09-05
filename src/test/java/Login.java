import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target{
    @Test
    public void main (){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btn_submit\"]"))
        );
        driver.findElement(By.name("user_name")).sendKeys("Your_Username");
        driver.findElement(By.name("user_password")).sendKeys("Your_Password");
        driver.findElement(By.xpath("//*[@id=\"btn_submit\"]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div/div/div/div/h4"))
        );
        driver.quit();
    }

    //Login Failed Case
    @Test
    public void failedLogin (){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btn_submit\"]"))
        );
        driver.findElement(By.name("user_name")).sendKeys("Your_Username");
        driver.findElement(By.name("user_password")).sendKeys("Your_Password");
        driver.findElement(By.xpath("//*[@id=\"btn_submit\"]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div/div/div/div/div[2]/div[1]"))
        );
        driver.quit();
    }
}
