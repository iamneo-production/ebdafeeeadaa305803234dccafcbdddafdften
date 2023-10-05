package com.examly.springapp;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc

class SpringappApplicationTests {

	@Autowired
	private  MockMvc mockMvc;

	@Test
    public void add() throws Exception {
		 
		String st = "{\"villageId\": 100,\"villageName\": \"kanpur\", \"numOfMen\": 30, \"numOfWomen\": 20, \"villagePopulation\": 50, \"numOfSchools\": 5}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(st)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
				.andExpect(jsonPath("$").value(true))
	        	.andReturn();
	    
    }


	@Test
	void getbyid() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/village/100")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						// .andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void getbypop() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/population/50")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						// .andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void getbyname() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/name/kanpur")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						// .andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void getbyMW() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/30/20")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	 @Test

    public void controllerfolder() {

        String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

	@Test

    public void controllerfile() {

        String filePath = "src/main/java/com/examly/springapp/controller/VillageController.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


	@Test

    public void testModelFolder() {

        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

	@Test

    public void testModelFile() {

        String filePath = "src/main/java/com/examly/springapp/model/Village.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

	@Test

    public void testrepositoryfolder() {

        String directoryPath = "src/main/java/com/examly/springapp/repository"; 

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testrepositoryFile() {

        String filePath = "src/main/java/com/examly/springapp/repository/VillageRepo.java";
		
        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


    @Test

    public void testServiceFolder() {

        String directoryPath = "src/main/java/com/examly/springapp/service"; 

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testServieFile() {

        String filePath = "src/main/java/com/examly/springapp/service/Apiservice.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


}
