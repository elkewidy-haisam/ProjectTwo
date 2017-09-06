package controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.positivity.controllers.UserRoleController;

public class UserRoleControllerTest {
	
	UserRoleController controller = new UserRoleController();
	
	MockMvc mockMvc = standaloneSetup(controller).build();
	
	
	@Test
	public void TestGetRole() throws Exception {
		
		mockMvc.perform(get("/role/get"));
		
	}
	
	

}
