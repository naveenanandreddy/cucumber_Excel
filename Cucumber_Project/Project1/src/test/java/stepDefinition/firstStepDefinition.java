package stepDefinition;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reports.Report;
import utils.TestContextSetup;

public class firstStepDefinition {
	
	private TestContextSetup testContextSetup;
	private Map<String,String> testData;
	
	
	public firstStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	
	@Given("Updation of data in excel sheet")
	public void updation_of_data_in_excel_sheet() {
	   
		System.out.println("Preparation of message is in progresss");
		Report.log(testContextSetup.scenario, "Preparation of message is in progresss");
	
	}
	@When("Generation of ISO message from excelSheet {string} and subSheet {string} with rowNumber {int}")
	public void generaReion_of_iso_message_from_excel_sheet_and_sub_sheet(String filePath, String sheetName, Integer int1) throws Exception {
	   
		System.out.println("Message Generated");
	String dir=	System.getProperty("user.dir");
	String path= dir+"\\src\\test\\resources\\TestData\\"+filePath;
	System.out.println(dir+"\\src\\test\\resources\\TestData\\"+filePath);
		
		testContextSetup.getExcelUtils().updateExcel(path, sheetName, "instructionid", testContextSetup.getGeneric().generateUniqueReference(),int1);
		testContextSetup.getExcelUtils().updateExcel(path, sheetName, "endToendId",testContextSetup.getGeneric().generateUniqueReference(), int1);
		
		
		testData=testContextSetup.getExcelUtils().readData(path, sheetName, int1);
		
		String modifiedPayload=testContextSetup.getExcelUtils().replaceValues(testData.get("payload").toString().trim());
		testContextSetup.getExcelUtils().updateExcel(path, sheetName, "modifiedPayload",modifiedPayload, int1);
		
		
		
		
		
		Report.log(testContextSetup.scenario, "Message Generated :"+testData.get("modifiedPayload"));
	}
	@Then("Posting the message in queue")
	public void posting_the_message_in_queue_row_number() {
	 
		System.out.println("Message Posted Successfully in queue using API");
	//	System.out.println("Postig the message using API............."+ testData.get("modifiedPayload"));
		Report.log(testContextSetup.scenario, "Message Posted Successfully");
	}

}
