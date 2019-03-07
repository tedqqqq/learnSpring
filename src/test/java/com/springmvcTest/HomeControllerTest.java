package com.springmvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.springMvcController.SimpleController;
import com.springmvcservice.AddMessageImpl;


public class HomeControllerTest {

  @Test
  public void testHomePage() throws Exception {
    SimpleController controller = new SimpleController(new AddMessageImpl());
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/mainPage"))
       .andExpect(view().name("home"));
  }

}
