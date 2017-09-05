package integrationtests;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runners.Suite;

import com.positivity.servlets.BlogConfig;

@RunWith(Suite.class)
@Suite.SuiteClasses({AddingUserCommentTest.class, TestsToRetrieveEverything.class, TestsToUpdateEverything.class, DeletingUserCommentTest.class})
@ContextConfiguration(classes=BlogConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunCrudTests {
	
	

}
