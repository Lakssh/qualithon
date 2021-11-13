package com.test.lakshmanan.selenium.businesscomponents;
import com.test.lakshmanan.selenium.framework.FrameworkUtils;
import com.test.lakshmanan.selenium.framework.Settings;
import com.test.lakshmanan.selenium.pagelocators.TreasureHunt;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class GeneralComponents extends FrameworkUtils {
    private static Properties globalProperties = Settings.getInstance();
    TreasureHunt th = new TreasureHunt();

    /*    Function to launch the application
        @param : application name
    */

    public void launchApplication(String application) {

        String url = null;
        url = globalProperties.getProperty(application);
        if (url == null)
            addStepError("Application URL is not defined");
        driver.get(url);
        waitForPageLoad(20);
        addStepLog(" Application Launched : " + url);
    }

    /*    Function to login to the application
        @param : String Username and parameter
    */

    public void playTreasureHunt() throws IOException {

        //HomePage
        click(th.btnEnter);
        click(th.btnStart);

        //RandomAccessPage
        List<WebElement> options = driver.findElements(th.randonAccessOptions);
        int counter = 0;
        for (WebElement option : options) {
            options.get(counter).click();
            waitForPageLoad(20);
            if (getText(th.header).contains("Random")) {
                counter++;
            } else {
                break;
            }
            System.out.println("Counter is : " + counter);

        }

        //YoutubeVideoPage
        driver.switchTo().frame(driver.findElement(th.iframeYouTube));
        clickUsingJS(th.btnYoutTubePlay, "play");
        waitFor(8750);
        clickUsingJS(th.btnYouTubeMute, "Mute");
        driver.switchTo().defaultContent();
        click(th.btnVideoSubmit);

        //Maze
        counter = 1;
        List<WebElement> mazeOptions = driver.findElements(th.mazeIdentifier);
        for (WebElement mazeOption : mazeOptions) {
            if (mazeOption.getAttribute("class").contains("deep-purple")) {
                break;
            }
            counter++;
        }
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, mazeOptions.get(25));

        if (counter == 25) {
            optionRow3();
        }
        if (counter == 97) {
            optionRow9();
        }
        click(th.buttonMazeSubmit);

        //Map
        click(th.imgMap);
        Actions action = new Actions(driver);
        action.sendKeys("i");
        action.perform();
        action.release();
        action.sendKeys(Keys.ARROW_RIGHT);
        for (int i = 1; i <= 37; i++) {
            action.sendKeys(Keys.ARROW_RIGHT);
            action.perform();
            action.release();
        }
        for (int i = 1; i <= 9; i++) {
            action.sendKeys(Keys.ARROW_UP);
            action.perform();
            action.release();
        }
        click(th.buttonMapProceed);

        //Captcha

        String src = driver.findElement(th.imgCaptcha).getAttribute("src").substring(22);
        System.out.println(src);
        decodeToImage(src);
        String text = getImgText("image.png");
        System.out.println(text);


    }

    public void clickDirection(By by, int count) {
        for (int i = 1; i <= count; i++) {
            click(by);
        }
    }

    public void optionRow9() {
        clickDirection(th.right, 2);
        clickDirection(th.down, 1);
        clickDirection(th.right, 2);
        clickDirection(th.up, 3);
        clickDirection(th.left, 2);
        clickDirection(th.up, 2);
        clickDirection(th.right, 1);
        clickDirection(th.up, 2);
        clickDirection(th.right, 2);
        clickDirection(th.down, 3);
        clickDirection(th.right, 2);
        clickDirection(th.down, 4);
        clickDirection(th.right, 1);
        clickDirection(th.down, 1);
        clickDirection(th.right, 3);
    }

    public void optionRow3() {
        clickDirection(th.right, 2);
        clickDirection(th.down, 2);
        clickDirection(th.right, 2);
        clickDirection(th.up, 1);
        clickDirection(th.right, 3);
        clickDirection(th.down, 2);
        clickDirection(th.left, 1);
        clickDirection(th.down, 1);
        clickDirection(th.left, 3);
        clickDirection(th.down, 1);
        clickDirection(th.left, 1);
        clickDirection(th.down, 2);
        clickDirection(th.right, 6);
        clickDirection(th.up, 2);
        clickDirection(th.right, 1);
        clickDirection(th.up, 1);
        clickDirection(th.right, 2);
    }

    public String getImgText(String imageLocation) {
        ITesseract instance = new Tesseract();
        instance.setDatapath(new File(imageLocation).getPath());
        try {
            String imgText = instance.doOCR(new File(imageLocation));
            return imgText;
        } catch (TesseractException e) {
            e.getMessage();
            return "Error while reading image";
        }
    }

    public static void decodeToImage(String imageString) throws IOException {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            Base64 decoder = new Base64();
            imageByte = decoder.decodeBase64(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File outputfile = new File("image.png");
        ImageIO.write(image, "png", outputfile);
    }

}

