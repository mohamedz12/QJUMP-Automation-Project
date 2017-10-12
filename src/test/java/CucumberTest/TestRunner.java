package CucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"Features/02-Restaurant Management.feature"}	
		,glue={"StepDefinition"}
		,tags={"@Search_Restaurant"}
		,dryRun= false
		)
public class TestRunner {

}
