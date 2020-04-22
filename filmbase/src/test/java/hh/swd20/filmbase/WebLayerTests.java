package hh.swd20.filmbase;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void testDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Welcome to FilmBase!")));
	}
	
	@Test
	public void testListpageMessage() throws Exception {
		this.mockMvc.perform(get("/filmlist")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Listing of Films")));
	}

}
