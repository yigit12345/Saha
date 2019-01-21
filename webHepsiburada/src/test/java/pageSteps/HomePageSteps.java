package pageSteps;

import com.thoughtworks.gauge.Step;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pages.HomePage;

public class HomePageSteps {
    private static pages.HomePage HomePage = pages.HomePage.getInstance();
    private static final Log log = LogFactory.getLog(HomePageSteps.class);

    @Step("Control HomePage existence")
    public void isHomePageExists() {
        HomePage.isHomePageExists();
    }

    @Step("Control HomePage Giris Yap Clicking")
    public void clickGirisYapButton() throws InterruptedException {
        HomePage.Login();
    }
}
