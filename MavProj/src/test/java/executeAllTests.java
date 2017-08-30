import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


import dao.AllTestsRun;

public class executeAllTests {
	public static void main(String[] args) {
		Result allResults = JUnitCore.runClasses(AllTestsRun.class);
	}
}
