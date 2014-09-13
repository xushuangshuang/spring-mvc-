package com.xu;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration(value = "src/main/webapp")  
@ContextHierarchy({  
        @ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),  
        @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")  
})  

public class UserControllerWebAppContextSetupTest {  
  
    @Autowired  
    private WebApplicationContext wac;  
    private MockMvc mockMvc;  
  
    @Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }

    @Test  
    public void testView() throws Exception {  
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))  
            .andExpect(MockMvcResultMatchers.view().name("user/view"))  
            .andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
            .andDo(MockMvcResultHandlers.print())  
            .andReturn();  
      
        Assert.notNull(result.getModelAndView().getModel().get("user"));  
    }    
} 

/**
 *这个是继承测试，就是模拟出服务器用来进行测试，这个由于没有写Uri的验证以及
 *过滤器和监听器，所以体现不出来，这个后面会学到的，但是这种测试可以模拟出
 *服务器所以测试的时候这个更加真实，你们可以看看，我这个有一些异常，是这个
 *测试抛出的，因为我还没有对异常进行处理，所以，看看就好了
 *
 * /
