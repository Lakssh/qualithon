package com.test.lakshmanan.selenium.pagelocators;

import com.test.lakshmanan.selenium.framework.FrameworkUtils;
import org.openqa.selenium.By;

public class TreasureHunt extends FrameworkUtils {

    public final By btnEnter = By.xpath("//a[@href='/intro']");
    public final By btnStart = By.id("start");
    public final By randonAccessOptions = By.xpath("//div[@class='card-action']/button");
    public final By header = By.xpath("//h2");

    public final By iframeYouTube = By.xpath("//iframe[@id='aVideoPlayer']");
    public final By btnYoutTubePlay = By.xpath("//button[@class='ytp-large-play-button ytp-button']");
    public final By btnYouTubeMute = By.xpath("//button[@class='ytp-mute-button ytp-button']");
    public final By btnVideoSubmit = By.id("aVideoSubmit");

    public final By mazeIdentifier = By.xpath("//table[@id='maze']/tr/td");
    public final By up = By.xpath("//i[contains(text(),'arrow_upward')]");
    public final By down = By.xpath("//i[contains(text(),'arrow_downward')]");
    public final By left = By.xpath("//i[contains(text(),'arrow_back')]");
    public final By right = By.xpath("//i[contains(text(),'arrow_forward')]");
    public final By buttonMazeSubmit = By.id("crystalMazeFormSubmit");

    public final By imgMap = By.xpath("//img[@class='olTileImage']");
    public final By buttonMapProceed = By.id("mapsChallengeSubmit");

    public final By imgCaptcha = By.id("notABotCaptchaImg");
    public final By txtCaptcha = By.id("notABotCaptchaResponse");
    public final By btnSubmitCaptcha = By.id("notABotCaptchaSubmit");

    public final By urlSocket = By.id("wsurl");
    public final By socketMessage = By.xpath("//div[@class='yellow lighten-3']");
    public final By txtAccessToken = By.id("socketGateMessage");
    public final By btnSubmitAccessToken = By.xpath("//button[@class='btn deep-orange darken-4']");

    public final By socketUrl = By.id("serverSelected");
    public final By btnClick = By.xpath("//button[@class='btn btn-sm btn-primary']");
    public final By msg = By.id("msgToServer");
    public final By btnSubmit = By.xpath("//button[@class='btn btn-sm btn-success']");
    public final By txtResponse = By.xpath("//ul[@id='responseFromServer']/li");

}
