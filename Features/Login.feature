Feature: Login with valid credentials

@sanity @regression
Scenario Outline: Successful login with valid credentials
	Given User launch browser
	And Opens URL "https://www.amazon.com/"
	And Hover over sign in 
	And click sign in
	And Enter mobile number "4125922529"
	And Click Continue
	And Enter password "escx4200"
	And Click sign in
	Then Verify amazon Home page is opened
	
@sanity
Scenario Outline: Successful login with valid credentials
	Given User launch browser
	And Opens URL "https://www.amazon.com/"
	And Hover over sign in 
	And click sign in
	And Enter mobile number "<mobile_number>"
	And Click Continue
	And Enter password "<password>"
	And Click sign in
	Then Verify amazon Home page is opened
	
    Examples: 
      | mobile_number      | password |
      | 4125922529         | escx4200 |
      | 4125922529         | escx42000 |      
      | 4125922526         | escx4200 |      

@regression
Scenario Outline: Login data driven Excel
	Given User launch browser
	And Opens URL "https://www.amazon.com/"
	And Hover over sign in 
	And click sign in
	Then Verify amazon Home page is opened by passing Mobile_number and Password with excel row "<row_index>"
	
    Examples:
      |row_index|
      |1|
      |2|
      |3|
