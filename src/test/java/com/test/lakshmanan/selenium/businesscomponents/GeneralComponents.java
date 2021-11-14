package com.test.lakshmanan.selenium.businesscomponents;
import com.test.lakshmanan.selenium.framework.FrameworkUtils;
import com.test.lakshmanan.selenium.framework.Settings;
import com.test.lakshmanan.selenium.pagelocators.TreasureHunt;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GeneralComponents extends FrameworkUtils {

    private static Properties globalProperties = Settings.getInstance();
        TreasureHunt th = new TreasureHunt();

        public void launchApplication(String application) {

            String url = null;
            url = globalProperties.getProperty(application);
            if (url == null)
                addStepError("Application URL is not defined");
            driver.get(url);
            waitForPageLoad(20);
        }

        public void launchApplicationInNewTab(String application) {
            String url = null;
            url = globalProperties.getProperty(application);
            WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
            newTab.get(url);
        }

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

            }

            //YoutubeVideoPage
            driver.switchTo().frame(driver.findElement(th.iframeYouTube));
            clickUsingJS(th.btnYoutTubePlay, "play");
            waitFor(9500);
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

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            String log = (String)executor.executeScript("return captcha.toString()");
            String captchaVal = log.split(";")[1].replace("console.log(\"","").replace("\")","").trim();
            driver.findElement(th.txtCaptcha).sendKeys(captchaVal);
            click(th.btnSubmitCaptcha);


            //Socket
            String socketUrl = getText(th.urlSocket);
            String sendingMessage = getText(th.socketMessage);
            waitFor(500);
            launchApplicationInNewTab("socket");
            driver.findElement(th.socketUrl).sendKeys(socketUrl);
            click(th.btnClick);
            waitFor(500);
            driver.findElement(th.msg).sendKeys(sendingMessage);
            click(th.btnSubmit);
            String response = getText(th.txtResponse);
            response = response.substring(10,response.length());
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            driver.findElement(th.txtAccessToken).sendKeys(response);
            click(th.btnSubmitAccessToken);


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


}

