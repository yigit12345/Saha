package pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageElement.PageElementModel;
import pageElement.WebButton;
import utils.driver.Driver;

public class HomePage extends WebMasterPage{

    //region Veriables
    private static final Log log = LogFactory.getLog(HomePage.class);
    private static HomePage instance;
    private static String actualPage;
    //endregion

    //region WebButton
    private static WebButton BTN_GIRISYAP = new WebButton(PageElementModel.selectorNames.CLASS_NAME, "cart-copy");
    private static WebButton BTN_GIRISYAP_UYE = new WebButton(PageElementModel.selectorNames.ID, "login");
    //endregion

    //region HomePage instance
    public static synchronized HomePage getInstance() {
        if (instance == null)
            instance = new HomePage();
        return instance;
    }

    //endregion
    //region HomePageExist
    public void isHomePageExists() {
        log.info("Controllling HomePage existence...");
        boolean isExist = BTN_GIRISYAP.isExist();
        Assert.assertTrue("Anasayfa goruntulenemedi", isExist);
    }
    //endregion

    //region Home Scenario
    public void Login() throws AssertionError, InterruptedException {
        log.info("Start Home Page");
        BTN_GIRISYAP.isExist();
        BTN_GIRISYAP.waitFor(1);
        BTN_GIRISYAP.click();

        actualPage = Driver.webDriver.findElement(By.className("cart-copy")).getText();
        System.out.println("Home Page: " + actualPage);
        Assert.assertEquals("Giriş Yap", actualPage);

        //Assert yerine if else ile raporlama çıktısı yapısı kullanılabilir. Exceptionları bu şekilde rapora basabiliriz.

        BTN_GIRISYAP_UYE.isExist();
        BTN_GIRISYAP_UYE.waitFor(1);
        BTN_GIRISYAP_UYE.click();

        //Senaryonun devamını yazmıyorum çünkü aynı yapı ile işlemler devam edilerek yazılabilir.

    }
    //endregion

}
