package com.helloword.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author Liletta
 */
public class HttpLinker {

//    private static final String DEBUG_TAG = "Http Connection";
    
    /**
     * @param httpUrl
     * @param stringUpload
     * @return the outputstream data wraped in string
     */
    public String stringPost(String httpUrl, String stringUpload) {
        String stringDownload = null;
        try {
            URL url = new URL(httpUrl);
            stringUpload = "params=" + stringUpload;
            byte[] bytesDownload = byteArrayPost(url, stringUpload.getBytes());
            stringDownload = new String(bytesDownload);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return stringDownload;
    }

    public byte[] byteArrayPost(URL url, byte[] bytesUpload) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                urlConnection.setDoOutput(true);
                urlConnection.setUseCaches(false);


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
