package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {

    public static WebDriver driver;
    private DriverCross(){
        /*
           Singleton Pattern kullanilarak istenmeyen yontemlerle
           driver objesine erisilmesini engelledik

           Constructor'i private yaparak bu class'tan obje olusturularak
           class uyelerinin kullanilmasinin onune gectik
         */
    }

    public static WebDriver getDriver(String browser){

        browser = browser == null ? ConfigReader.getProperty("browser") : browser ;
        /*
            bu satir bizim emniyet subabimiz
            eger parametre olarak null gonderilirse
            configiration.properties'deki browser degerini alacak
         */

        if(driver == null){

            switch (browser){
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){           // (driver != null) : kodun Driver.closeDriver(); ile başlaması ihtimaline karşı
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver(){   // (driver != null) : kodun Driver.closeDriver(); ile başlaması ihtimaline karşı
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
