import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeAll
    public static void setup() {
        //Запуск драйвера
        WebDriverManager.chromedriver().setup();
        //создание экземпляра драйвера
        driver = new ChromeDriver(
                new ChromeOptions().addArguments("--window-size=500, 500")
        );
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://tt-develop.quality-lab.ru");
        // устанавливаем явное ожидание
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    /**
     * изменение размеров окна и закрытие браузере
     */
    @Test
    public void testWindowSize() {
        driver.manage().window().setSize(new Dimension(200, 100));
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.manage().window().maximize();
        driver.quit();
    }
}
