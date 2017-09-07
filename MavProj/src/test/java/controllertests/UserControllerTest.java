package controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import  static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.positivity.controllers.UserController;

public class UserControllerTest {
	
	UserController controller = new UserController();
	MockMvc mockMvc = standaloneSetup(controller).build();

	
	@Test
	public void testCreateUser() throws Exception {
		
		mockMvc.perform(post("/user/create"));
		
		
	}
	
	@Test
	public void testUpdateUser() throws Exception {
		
		mockMvc.perform(put("/user/update"));
		
	}
	
	@Test
	public void testDeleteUSer() throws Exception {
		
		mockMvc.perform(delete("/user/delete"));
		
	}
	
	@Test
	public void testGetFullName() throws Exception {
		
		mockMvc.perform(get("/user/fullname"));
		
	}
	
	
}
