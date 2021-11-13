package com.test.lakshmanan.selenium.framework;

import io.cucumber.java.Scenario;
import com.test.lakshmanan.selenium.enums.Browser;
import com.test.lakshmanan.selenium.enums.ExecutionMode;

public class TestParameters {

    private TestParameters(){}
    private static TestParameters instance = new TestParameters();
    public static TestParameters getInstance(){
        return instance;
    }

    private ExecutionMode executionMode;
    private Browser browser;
    private Scenario scenario;

    public ExecutionMode getExecutionMode() { return this.executionMode; }
    public Browser getBrowser() { return this.browser; }
    public Scenario getScenario(){ return this.scenario; }
    public void setExecutionMode(ExecutionMode executionMode) { this.executionMode = executionMode;}
    public void setBrowser(Browser browser) { this.browser = browser;}
    public void setScenario(Scenario scenario){this.scenario = scenario;}

}
