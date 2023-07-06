package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C02_qualitydemyLoginTest {

    @Test
    public void test01(){

        // qualytydemy anasayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginLinkElementi.click();

        // gecerli username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");

        // login butonuna tiklayin
        qualitydemyPage.loginButonu.click();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisKontrolElementi.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
