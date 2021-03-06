package controllertests;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.positivity.controllers.CommentController;

public class CommentControllerTest {
	
	CommentController controller = new CommentController();
	MockMvc mockMvc = standaloneSetup(controller).build();
	
	@Test
	public void TestCreateUserComment() throws Exception {
		
		mockMvc.perform(post("/UserComment/create"));
		
	}
	
	@Test
	public void TestUpdateUserComment() throws Exception {
		
		mockMvc.perform(put("/UserComment/update"));
	}
	
	@Test
	public void TestDeleteUserComment() throws Exception {
		
		mockMvc.perform(delete("/UserComment/delete"));
		
	}
	
	@Test
	public void TestFindAllUserComments() throws Exception {
		
		mockMvc.perform(get("/UserComment/all"));
		
	}
	
	@Test
	public void TestCreateComment() throws Exception {
		
		mockMvc.perform(post("/Comment/create"));
		
	}
	
	@Test
	public void TestUpdateComment() throws Exception {
		
		mockMvc.perform(put("/Comment/update"));
		
	}
	
	@Test
	public void TestDeleteComment() throws Exception {
		
		mockMvc.perform(delete("/Comment/delete"));
		
	}
	
	@Test
	public void TestGetComment() throws Exception {
		
		mockMvc.perform(get("/Comment/find"));
		
	}
	
	
	
	

}
