import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;


public class KCardsTest extends Objects {

    @Before
    public void setup() throws Exception {
        setUp();
    }

    @After
    public void endTest() {
        driver.quit();
    }

//    @Test
    public void changeColor() {
        System.out.println("Starting change color test");
        WebElement color_button = driver.findElement(By.id("changeColorButton"));
        color_button.click();
        driver.findElementByName("Yellow - Same Thread");
        color_button.click();
        driver.findElementByName("Red - I MUST SPEAK RIGHT NOW!");
        color_button.click();
        driver.findElementByName("Blue - Rat hole/going nowhere");
        color_button.click();
        driver.findElementByName("Green - New Thread");
        System.out.println("Change collor test completed successfully");
    }

//    @Test
    public void infoButton() {
        System.out.println("Opening the info");
        driver.findElementById("infoButton").click();
        driver.findElementByName("Info about the K-Cards");
        driver.findElementByName("OK").click();
        driver.findElement(By.id("changeColorButton"));
        System.out.println("Info button test completes successfully");
    }

   @Test
    public void checkTextResize() throws Exception {
        System.out.println("starting text resize check ");
        WebElement addname = driver.findElementById("add_name_button");
        addname.click();
        WebElement textfield = driver.findElementByClassName("android.widget.EditText");
        textfield.sendKeys("timea");
        WebElement addbutton = driver.findElementById("button1");
        addbutton.click();
        takeScreenshot("01-portret-initial");
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(SHORT_SLEEP);
        takeScreenshot("02-landscape-short");
        driver.rotate(ScreenOrientation.PORTRAIT);
        Thread.sleep(SHORT_SLEEP);
        takeScreenshot("03-portret-after-resize");

        addname.click();
        textfield.clear();
        textfield.sendKeys("12345678910");
        addbutton.click();
        takeScreenshot("04-portret-long-intial");
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(SHORT_SLEEP);
        takeScreenshot("05-landscape-long");
        driver.rotate(ScreenOrientation.PORTRAIT);
        Thread.sleep(SHORT_SLEEP);
        takeScreenshot("06-portret-long-after-resize");
        System.out.println("text resize check completed successfully");
    }
}
