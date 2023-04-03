package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {".//Features//Login.feature"},
//		features= {".//Features//LoginDDT.feature"},
//		features= {"@target/rerun.txt"},   //runs only failures
		glue= "StepDefinitions",
		plugin= {"pretty","html:reports/myreport.html","json:reports/myreport.json","rerun:target/rerun.txt",},
		
//dryRun=true,
monochrome=true,
//tags="@sanity"
//tags="@regression"
tags = "@sanity and @regression"
)


public class TestRunner {

}
