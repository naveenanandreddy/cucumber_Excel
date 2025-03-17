Feature: ISO Payments Generation
  @Sanity
  Scenario Outline: Pacs.008 Inward Payments Generation and Posting
    Given Updation of data in excel sheet
    When Generation of ISO message from excelSheet "Payments.xlsx" and subSheet "payment" with rowNumber <rowNumber>
    Then Posting the message in queue

    Examples: 
      | rowNumber  | 
     	|1|									
			|2|
			|3|

 