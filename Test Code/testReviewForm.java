package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TCSS360.ReviewForm;
import TCSS360.User;

public class testReviewForm {
	private ReviewForm testReviewForm;
	private static final String TEST_PATH = "Test Path";
	private static final String TEST_AUTHOR = "Test Author";
	private static final String TEST_DATE = "05/06/2016";
	private static final String TEST_TITLE = "Test Title";
	private static final String TEST_NAME = "Test name";
	private static final String TEST_LOGIN_NAME = "Login Name";
	private static final String TEST_EMAIL = "Test email";
	private User testReviewer;
	
	
	@Before
	public void setupTests() {
		testReviewer = new User(TEST_NAME, TEST_LOGIN_NAME, TEST_EMAIL);
		testReviewForm = new ReviewForm(TEST_PATH, TEST_AUTHOR, TEST_DATE, TEST_TITLE, testReviewer);
	}
	
	@Test
	public void testConstructor() {
		assertTrue(testReviewForm.getPath().equals(TEST_PATH));
		assertTrue(testReviewForm.getAuthor().equals(TEST_AUTHOR));
		assertTrue(testReviewForm.getSubmitDate().equals(TEST_DATE));
		assertTrue(testReviewForm.getTitle().equals(TEST_TITLE));
	}

}


