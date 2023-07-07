package tests.day16_POM_Assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SingletonPattern {

    @Test
    public void test(){
        /*
           otomasyon icin elimiz ve kolumuz olarak
           Driver class'indaki WebDriver driver objesini kullaniyoruz
           ANCAK driver'in bizim istedigimiz islemleri yapabilmesi icin
           oncelikle getDriver() icinde yaptigimiz atama islemlerine ihtiyaci var

           Bir frameWork'de calisan kisilerin
           getDriver() kullanmadan direk driver objesine erisimini engellemek icin
           Singleton Pattern kullanimi TERCİH EDİLMİSTİR

           Singleton Pattern bir class'tan obje olusturulmasini ve
           o obje ile class'taki class uyelerine erisimi engellemek icin kullanilir.


         */

        // Driver.driver.get(ConfigReader.getProperty("amazonUrl"));
        // getDriver() calismadigindan driver null olarak isaretlendiginden
        // NullPointerExeption verir

        // Driver driver = new Driver();
        // driver.get("https:www.amazon.com");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Driver class'indaki constructor'i private yapinca
        // kimse Driver class'indan obje olusturamaz

        // System.out.println(Driver.driver);

    }
}
