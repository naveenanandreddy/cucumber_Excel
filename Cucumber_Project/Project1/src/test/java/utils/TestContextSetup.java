package utils;

import io.cucumber.java.Scenario;
import reports.Report;

public class TestContextSetup {

    public Scenario scenario;
    private Report report;
    private  ExcelUtils excelUtils;
    private  Generic generic;
    
    public TestContextSetup(ExcelUtils excelUtils,Report report,Generic generic) {
        this.excelUtils = excelUtils;
        this.report=report;
        this.generic=generic;
    }

	public Report getReport() {
		return report;
	}

	public ExcelUtils getExcelUtils() {
		return excelUtils;
	}

	public Generic getGeneric() {
		return generic;
	}
    
    
}
