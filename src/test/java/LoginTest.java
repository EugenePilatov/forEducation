import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class LoginTest {

    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeEach
    public void setup() {
        //Запуск драйвера
        WebDriverManager.chromedriver().setup();
        //создание экземпляра драйвера
        driver = new ChromeDriver(
                new ChromeOptions().addArguments("--window-size=500, 500")
        );
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://tt-develop.quality-lab.ru");
        // устанавливаем явное ожидание
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void incorrectUserNameAndPassword() {
        By locatorForInvalidCredentials = By.xpath("//div[contains (text(), 'Invalid credentials.')]");
        // предпочитаю взять By,
        // также можно взять String
        // но правильно все элементы выносятся в класс с объектами страницы, разумеется
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("TestUser");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password");
        try {
            driver.findElement(locatorForInvalidCredentials);
            fail();
        } catch (NoSuchElementException ignored) {
        }
        driver.findElement(By.xpath("//input[@value='Войти']")).submit();
        WebElement invalidCredentialsLocator = driver.findElement(locatorForInvalidCredentials);
        // я предпочел бы использовать проверку на assertEquals а не просто нахождение элемента,
        // если бы мы не привязывались к тексту (продемонстрировал ниже), просто для примера
        Assert.assertEquals(
                "Проверка на совпадение текста для примера",
                "Invalid credentials.",
                driver.findElement(locatorForInvalidCredentials).getText());
    }

    @AfterEach
    public void exit() {
        Assert.assertNotNull(
                "Проверка на не Null",
                driver
        );
        driver.close();
    }
}
