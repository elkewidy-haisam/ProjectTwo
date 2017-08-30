package dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.BlogPostDAOTests;
import junit.UserDAOTests;
import junit.UserRoleDAOTests;

@RunWith(Suite.class)
@SuiteClasses({
	testSessionConnection.class,
	CommentDAOTest.class,
	BlogPostDAOTests.class,
	CommentDAOTest.class,
	UserDAOTests.class,
	UserRoleDAOTests.class
})

public class AllTestsRun {

}
