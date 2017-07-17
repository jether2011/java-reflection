package test.class1;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jetherrodrigues.class1.NullValidator;
import com.jetherrodrigues.class1.SearchValidator;
import com.jetherrodrigues.class1.User;

/**
 * 
 * @author JETHER ROIS
 *
 */
public class TestClass1 {

	private static final Logger logger = LoggerFactory.getLogger(TestClass1.class);

	@Test
	public void ObjectTestNotNull() {
		User user = new User();
		user.setName("Jether Rodrigues");
		user.setUsername("jether.rodrigues");

		List<String> list = null;
		try {
			list = NullValidator.getAllNotNullAttributes(user);

			/**
			 * Here is 3 to compare with list.size() because 
			 * the member serialVersionUID is included
			 */
			Assert.assertEquals(3, list.size());
			Assert.assertTrue(list.contains("name"));
			Assert.assertTrue(list.contains("username"));

		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error(e.getMessage());
		}

	}

	@Test
	public void ObjectTestNull() {
		User user = new User();
		user.setName("Jether Rodrigues");

		List<String> list = null;
		try {
			list = NullValidator.getAllNullAttributes(user);

			Assert.assertEquals(3, list.size());
			Assert.assertTrue(list.contains("email"));
			Assert.assertTrue(list.contains("username"));
			Assert.assertTrue(list.contains("password"));

		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void ObjectTestIfContain() {
		User user = new User();
		user.setName("Jether Rodrigues");

		List<String> list = null;
		try {
			list = SearchValidator.getAttributesIfContains(user, "username");

			Assert.assertEquals(1, list.size());
			Assert.assertTrue(list.contains("username"));

		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void ObjectTestSearch() {
		List<String> list = null;
		try {
			list = SearchValidator.getAttributesIfContains(new User(), "name");

			Assert.assertEquals(2, list.size());
			Assert.assertTrue(list.contains("name"));
			Assert.assertTrue(list.contains("username"));

		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error(e.getMessage());
		}
	}
}
