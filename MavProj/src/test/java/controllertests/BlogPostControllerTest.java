package controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import  static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;

import com.positivity.controllers.BlogPostController;


public class BlogPostControllerTest {
	
	
	BlogPostController controller = new BlogPostController();
	
	MockMvc mockMvc = standaloneSetup(controller).build();
	
	@Test
	public void testHomePage() throws Exception {
		
		mockMvc.perform(get("/"));
		
	}
	
	@Test
	public void testAddBlogPost() throws Exception {
		
		mockMvc.perform(post("/blogpost/create"));
		
	}
	
	@Test
	public void updateBlogPost() throws Exception {
		
		mockMvc.perform(put("/blogpost/update"));
		
	}
	
	@Test
	public void testDeleteBlogPost() throws Exception {
		
		mockMvc.perform(delete("/blogpost/delete"));
		
	}
	
	@Test
	public void testGetBlogPostById() throws Exception {
		
		mockMvc.perform(get("/blogpost/getbyid"));
		
	}
	

}
