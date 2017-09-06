package integrationtests;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runners.Suite;

import com.positivity.servlets.BlogConfig;
import controllertests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({AddingUserCommentTest.class, TestsToRetrieveEverything.class, TestsToUpdateEverything.class, DeletingUserCommentTest.class, BlogPostControllerTest.class, CommentControllerTest.class, UserControllerTest.class, UserRoleControllerTest.class})
@ContextConfiguration(classes=BlogConfig.class)
public class RunCrudTests {
	
	

}
