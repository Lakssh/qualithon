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
}
