package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles\\CP_2_Homepage.feature",
glue = "stepDefinition",
monochrome = true,
//dryRun = true,
//tags="@TC_14",
		plugin = {"pretty",
				"html:target/cucumber/Homepage_cucumberhtml-report.html",
				"json:target/cucumber/Homepage_cucumber.json",
				"rerun:target/failedScenarios/Homepage_Failed.txt"
				})
public class CP_2_HomepageRunnerTest {

}



