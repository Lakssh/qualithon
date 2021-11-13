package com.test.lakshmanan.cucumber.stepdefinitions;

import com.test.lakshmanan.selenium.businesscomponents.GeneralComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class GeneralStepDef {

    GeneralComponents components = new GeneralComponents();

    @Given ("^I launch the (.+)$")
    public void i_launch_the_application(String application) throws InterruptedException {
        components.launchApplication(application);
    }
    @And("^I play the treasurehunt$")
    public void i_play() throws IOException {
        components.playTreasureHunt();
    }


}
