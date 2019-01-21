package backend;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.driver.Driver;

import java.io.File;
import java.io.IOException;

public class WebAutomationException extends RuntimeException{
    private static final Log log = LogFactory.getLog(WebAutomationException.class);

    public WebAutomationException (String message){
        super(message);
        File scrFile = ((TakesScreenshot) Driver.webDriver).getScreenshotAs(OutputType.FILE);
        String filePath = "screenshots\\screenshot " + AutomationContext.getContextValue(ContextKeys.CASENAME) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String description = "APAC WEB AUTOMATION FAILED AT STEP: " + AutomationContext.getContextValue(ContextKeys.STEPNAME) + " WITH EXCEPTION MESSAGE: " + message;
        log.info(description);
        AutomationContext.addContext(ContextKeys.EXCEPTION, description);
        AutomationContext.addContext(ContextKeys.SSLINK, filePath);

    }
}
