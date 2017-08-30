package dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.BlogPostDAOTest;
import junit.UserDAOTests;
import junit.UserRoleDAOTest;

@RunWith(Suite.class)
@SuiteClasses({
	testSessionConnection.class,
	CommentDAOTest.class,
	BlogPostDAOTest.class,
	CommentDAOTest.class,
	UserDAOTests.class,
	UserRoleDAOTest.class
})

public class AllTestsRun {

}
