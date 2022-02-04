package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import steps.SubClass;

@CucumberOptions(features = "src/test/java/features/CreateContactWithDataProvider.feature", glue = "steps", monochrome = true, 
dryRun = false, snippets = SnippetType.CAMELCASE, tags = "@Functional")
public class Runner extends SubClass {

	@DataProvider(indices = 0)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
