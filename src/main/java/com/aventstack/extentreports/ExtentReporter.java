package com.aventstack.extentreports;

import java.util.Date;

/**
 * Primary interface implemented by each reporter. This interface implements {@link TestListener} and 
 * {@link ReportAggregatesListener} interface to provide additional functionality to each reporter.
 */
public interface ExtentReporter extends TestListener, ReportAggregatesListener, IAnalysisStrategy {
    
    /**
     * Starts passing run information to the reporter
     */
    void start();
    
    /**
     * Stops the reporter. Ensures no information is passed to the reporter.
     */
    void stop();
    
    /*
     * Write/update the target (file, database etc.)
     */
    void flush();
    
    /*
     * Time of when ExtentReports instance was created
     */
    void setStartTime(Date d);
    
    /*    
     * Time when the last log event occurred to determine the time report was ended
     */
    void setEndTime(Date d);
}