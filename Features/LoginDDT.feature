Feature: Login data driven using Excel


Scenario Outline: Login data driven Excel
	Given User launch browser
	And Opens URL "https://www.amazon.com/"
	And Hover over sign in 
	And click sign in
	Then Verify amazon Home page is opened by passing Mobile_number and Password with excel row "<>row_index>"
	
    Examples:
      |row_index|
      |1|
      |2|
      |3|
      