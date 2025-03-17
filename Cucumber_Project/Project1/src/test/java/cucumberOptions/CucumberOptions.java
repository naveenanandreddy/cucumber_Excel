package cucumberOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reports.Report;
import utils.TestContextSetup;

public class CucumberOptions {
	
	
	public TestContextSetup testContextSetup;
	
	
	public CucumberOptions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		
	} 
	
	@Before
	public void beforeMethod(Scenario scenario) {
	
	testContextSetup.scenario=scenario;
		
	System.out.println("beforeMethod invoked");	
	}
	
	@After
	public void afterMethod() {
		
	System.out.println("afterMethod invoked");	
		
	}
	
	@AfterAll
	public static void tearDown() {
	//	Report.generateReport();
		System.out.println("I have been exeucted at last");
	}

}
