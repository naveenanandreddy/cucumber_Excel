package runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import reports.Report;


@CucumberOptions(features = "src/test/java/features",
				 glue={"cucumberOptions", "stepDefinition"},
				 tags="@Sanity",
				 plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
				 monochrome = true
				 )
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	
	
	@BeforeSuite
	public void initialize() {
		
	System.out.println("-------------Test Started...................");	
		
	}
	
	@AfterSuite
	public void tearDown() {
		Report.generateReport();
		System.out.println("-------------Test Ended...................");	
		
		
	
	} 

}
