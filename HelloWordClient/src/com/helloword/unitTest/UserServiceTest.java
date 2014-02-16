package com.helloword.unitTest;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.helloword.service.UserService;

public class UserServiceTest {

    @Test
    public void testLogin() {
        UserService userService = new UserService();
        String result1 = userService.login("aaa", "aaaaaa");
        String result2 = userService.login("aaa", "aaabbb");
        
        assertEquals(result1, "success");
        assertEquals(result2, "false username or password");
    }
}
