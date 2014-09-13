package com.xu;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.test.web.ModelAndViewAssert;
import org.junit.Before;
import org.junit.Test;

public class UserControllerTest {

    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testView() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        ModelAndView mv = userController.view(1L, req);

        ModelAndViewAssert.assertViewName(mv, "user/view");
        ModelAndViewAssert.assertModelAttributeAvailable(mv, "user");

    }
}
/**
 *这个是最纯粹的单元测试，很容易懂看看吧
 *
 *
 */
