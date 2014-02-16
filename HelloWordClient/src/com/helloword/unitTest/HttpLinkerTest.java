package com.helloword.unitTest;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.helloword.gsonObject.responseProtocol.LoginResponseProtocol;
import com.helloword.protocolTransmission.DeserializeResponse;
import com.helloword.protocolTransmission.SerializeRequest;
import com.helloword.util.HttpLinker;

/**
 * @author Liletta
 * will improve after the deployment of server
 */
public class HttpLinkerTest {
    
	/**
	 * as stringPost is a wrapper of byteArrayPost, the two are merged to one
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testStringPost() throws UnsupportedEncodingException {
	    SerializeRequest request = new SerializeRequest();
	    String uploadData = request.loginRequest("aaa", "aaaaaa"); //Depend on the data on server
	    String httpUrl = "http://halloword.sinaapp.com/user/login.json";
	    	    
	    HttpLinker httpLinker = new HttpLinker();
	    String downloadData = httpLinker.stringPost(httpUrl, uploadData);
//	    System.out.println(downloadData);
	    
	    DeserializeResponse response = new DeserializeResponse();
	    LoginResponseProtocol result = response.loginResponse(downloadData);
	    
	    assertEquals(result.getDetails().getUserInfo().getUserName(),"aaa");
	    assertEquals(result.getDetails().getUserInfo().getUserEmail(),"aaa");
//	    HttpURLConnection httpURLConnection =  mock(HttpURLConnection.class);
//	    BufferedOutputStream byteArrayOutputStream = new BufferedOutputStream();
//	    when(httpURLConnection.getOutputStream()).thenReturn(value)
	    
	}
}
