package com.helloword.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Base64;



/**
 * @author Liletta
 */
public class HttpLinker {
    
//    private static final String DEBUG_TAG = "Http Connection";
    
    /**
     * @param httpUrl
     * @param stringUpload
     * @return the outputstream data wraped in string
     * @throws UnsupportedEncodingException 
     */
    public String stringPost(String httpUrl, String stringUpload) {
        String stringDownload = null;
        try {
            URL url = new URL(httpUrl);
            stringUpload = "params=" + stringUpload;
            
            byte[] bytesUpload = stringUpload.getBytes();
            
            byte[] bytesDownload = byteArrayPost(url, bytesUpload);
            
            stringDownload = new String(bytesDownload);
//            System.out.println(stringDownload);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        System.out.println("" + stringDownload.trim().length());
//        int tempint = stringDownload.trim().length();
//        String tempString = "" + tempint;
        return stringDownload;
    }

    public byte[] byteArrayPost(URL url, byte[] bytesUpload) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                
                urlConnection.setUseCaches(false);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setReadTimeout(10000);
                
                urlConnection.connect();

                BufferedOutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());

                out.write(bytesUpload);
                out.flush();
                out.close();
                
                BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
                byte[] bytesDownload = new byte[in.available()];
                in.read(bytesDownload);
                in.close();
                
                return bytesDownload;
                
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                urlConnection.disconnect();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    
    
//    public static void main(String args[]) {
//        HttpLinker linker = new HttpLinker();
//        String httpUrl = "http://halloword.sinaapp.com/user/login.json";
//        String request = "{\"loginInfo\":{\"userName\":\"aaa\",\"password\":\"aaaaaa\"},";
//        request += "\"request\":\"/user/login.json\"}";
//        String result = linker.stringPost(httpUrl, request);
//        System.out.println(result);
//    }
	
} 
