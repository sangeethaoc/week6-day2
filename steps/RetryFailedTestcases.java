package steps;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestcases implements IRetryAnalyzer {

	int count = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (count < 1) {
			count++;
			return true;
		}

		return false;
	}

}
