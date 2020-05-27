package com.aventstack.extentreports.api;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import com.aventstack.extentreports.gherkin.model.And;
import com.aventstack.extentreports.gherkin.model.But;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

public class BddLevelsTest extends Base {
    
    @Test
    public void verifyLevelsUsingGherkinKeyword(Method method) throws ClassNotFoundException, UnsupportedEncodingException {
    	extent.setGherkinDialect("en");
        ExtentTest feature = extent.createTest(method.getName());
        ExtentTest scenario = feature.createNode(new GherkinKeyword("Scenario"), "Child");
        ExtentTest given = scenario.createNode(new GherkinKeyword("Given"), "Given").info("info");
        ExtentTest and = scenario.createNode(new GherkinKeyword("And"), "And").info("info");
        ExtentTest when = scenario.createNode(new GherkinKeyword("When"), "When").info("info");
        ExtentTest then = scenario.createNode(new GherkinKeyword("Then"), "Then").pass("pass");
        ExtentTest but = scenario.createNode(new GherkinKeyword("But"), "But").pass("pass");
        
        Assert.assertEquals(feature.getModel().getLevel(), 0);
        Assert.assertEquals(scenario.getModel().getLevel(), 1);
        Assert.assertEquals(given.getModel().getLevel(), 2);
        Assert.assertEquals(and.getModel().getLevel(), 2);
        Assert.assertEquals(when.getModel().getLevel(), 2);
        Assert.assertEquals(then.getModel().getLevel(), 2);
        Assert.assertEquals(but.getModel().getLevel(), 2);
    }

    @Test
    public void verifyLevelsUsingClass(Method method) {
        ExtentTest feature = extent.createTest(method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Child");
        ExtentTest given = scenario.createNode(Given.class, "Given").info("info");
        ExtentTest and = scenario.createNode(And.class, "And").info("info");
        ExtentTest when = scenario.createNode(When.class, "When").info("info");
        ExtentTest then = scenario.createNode(Then.class, "Then").pass("pass");
        ExtentTest but = scenario.createNode(But.class, "But").pass("pass");
        
        Assert.assertEquals(feature.getModel().getLevel(), 0);
        Assert.assertEquals(scenario.getModel().getLevel(), 1);
        Assert.assertEquals(given.getModel().getLevel(), 2);
        Assert.assertEquals(and.getModel().getLevel(), 2);
        Assert.assertEquals(when.getModel().getLevel(), 2);
        Assert.assertEquals(then.getModel().getLevel(), 2);
        Assert.assertEquals(but.getModel().getLevel(), 2);
    }
}
