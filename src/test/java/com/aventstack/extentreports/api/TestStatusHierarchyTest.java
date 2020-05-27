package com.aventstack.extentreports.api;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestStatusHierarchyTest extends Base {
    
    @Test
    public void verifyPassHasHigherPriorityThanInfo(Method method) {
        ExtentTest test = extent.createTest(method.getName());
        test.info("info");
        test.pass("pass");
        
        Assert.assertEquals(test.getStatus(), Status.PASS);
    }
    
    @Test
    public void verifySkipHasHigherPriorityThanPass(Method method) {
        ExtentTest test = extent.createTest(method.getName());
        test.pass("pass");
        test.skip("skip");
        
        Assert.assertEquals(test.getStatus(), Status.SKIP);
    }
    
    @Test
    public void verifyWarningHasHigherPriorityThanSkip(Method method) {
        ExtentTest test = extent.createTest(method.getName());
        test.skip("skip");
        test.warning("warning");
        
        Assert.assertEquals(test.getStatus(), Status.WARNING);
    }
    
    @Test
    public void verifyErrorHasHigherPriorityThanWarning(Method method) {
        ExtentTest test = extent.createTest(method.getName());
        test.warning("warning");
        test.error("error");
        
        Assert.assertEquals(test.getStatus(), Status.ERROR);
    }
    
    @Test
    public void verifFailHasHigherPriorityThanError(Method method) {
        ExtentTest test = extent.createTest(method.getName());
        test.error("error");
        test.fail("fail");
        
        Assert.assertEquals(test.getStatus(), Status.FAIL);
    }
    
    @Test
    public void verifFatalHasHigherPriorityThanFail(Method method) {
        ExtentTest test = extent.createTest(method.getName());
        test.fail("fail");
        test.fatal("fatal");
        
        Assert.assertEquals(test.getStatus(), Status.FATAL);
    }
}
