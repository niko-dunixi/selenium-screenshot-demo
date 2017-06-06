import com.google.common.io.Files;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by paul.baker on 5/30/17.
 */
public class DemoTest {

    @Test
    public void demonstrateScreenshotTest() throws IOException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/wiki/Special:Random");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // This move is necessary, the original file is temporary and gets deleted after java exists
        File resultingScreenshot = new File(System.getProperty("user.home"), "screenshot.png");
        Files.move(screenshotFile, resultingScreenshot);
        driver.quit();

        System.out.println("The screenshot is found here: " + resultingScreenshot);
    }
}
