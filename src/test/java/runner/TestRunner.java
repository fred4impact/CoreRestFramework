package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",plugin = "json:target/jsonReports/CORE-report.json", glue = {"stepDefinitions"}, monochrome = true
)
public class TestRunner {
}
