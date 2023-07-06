package tests.day14_TestNGFrameworkOlusturma;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C02_Ignore {

    /*
         @Ignore notasyonu
         bsina yazildigi testin Ignore edilmesini saglar.
     */

    @Test(priority = 57)
    public void youtubeTesti(){

        System.out.println("Youtube");
    }
    @Test(priority = -3)@Ignore
    public void wiseTesti(){

        System.out.println("Wise Quarter");
    }
    @Test
    public void amazonTesti(){  //priority yazilmazsa 0 degeri(default deger) alir
        System.out.println("Amazon");
    }
}
