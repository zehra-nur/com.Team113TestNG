package tests.day18_TestNGReports_ParalelCalistirma;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderNegatifLoginTesti {
    @DataProvider
    public static Object[][] YanlisKullaniciAdlariListesi() {

        String[][] kullaniciBilgileriArrayi = {{"Memre","12345"},{"Mustafa","23456"},
                                               {"Burcu","32456"},{"Cigdem","867453"},
                                               {"Ahmet","78945"},{"Kemal","285237"},
                                               {"Melike","56547"},{"Cinar","612347"},
                                               {"Muleyke","4589"},{"Kadir","324569"}};

        return kullaniciBilgileriArrayi;
    }
    /*
        verilen 10 kullanici bilgisi ile sisteme giris yapilamadigini test edin
     */

    @Test(dataProvider = "YanlisKullaniciAdlariListesi")
    public void gecersizIsimSifreTesti(String kullaniciAdi, String password) {

        // qualytydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginLinkElementi.click();

        // gecersiz username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(kullaniciAdi);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        // login butonuna tiklayin
        qualitydemyPage.loginButonu.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
