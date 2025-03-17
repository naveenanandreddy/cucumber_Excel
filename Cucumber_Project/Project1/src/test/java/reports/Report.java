package reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class Report {
	


	
	public static void generateReport() {
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/Cucumber.json");

        Configuration config = new Configuration(reportOutputDirectory, "My Project");
        config.setBuildNumber("1.0");
        config.addClassifications("Platform", "Windows");
        config.addClassifications("Browser", "Chrome");
        config.addClassifications("Branch", "main");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
	
	
	public static void log(Scenario scenario, String description) {
		
		scenario.log(description);
		
		
	}
	
	public static void fail(Scenario scenario, String errdescription) {
		
		try {
			Assert.assertTrue(false);
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			scenario.log(errdescription);
		}
		
		
		
	}
	
	
	
	

}
