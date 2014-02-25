package com.helloword.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        return stringPost(httpUrl, stringUpload, 0);
    }
    
    public String stringPost(String httpUrl, String stringUpload, int flag) {
        String stringDownload = null;
        try {
            URL url = new URL(httpUrl);
            stringUpload = "params=" + stringUpload;
            
            byte[] bytesUpload = stringUpload.getBytes();
            
//            Log.e("http link", "" + bytesUpload);
            
            byte[] bytesDownload = byteArrayPost(url, bytesUpload, flag);
            
//            Log.e("http link", "" + bytesDownload);
            
            stringDownload = new String(bytesDownload);
            
//            Log.e("http link", stringDownload);
            
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        return stringDownload;
    }

    public byte[] byteArrayPost(URL url, byte[] bytesUpload, int flag) {
        // if flag = 0 (default), short connection, if flag = 1 long connection
        final int TIMELIMIT = 250;
        
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                
                urlConnection.setUseCaches(false);
                
                if (flag == 0)
                    urlConnection.setConnectTimeout(15000);
                else
                    urlConnection.setConnectTimeout(TIMELIMIT * 1000);
                
                urlConnection.connect();
                
                // ==================output data==================================

                BufferedOutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());

                out.write(bytesUpload);
                out.flush();
                out.close();
                
                // =======================read input data=================================
                
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                
                int size = 1024;
                int len;
                byte[] bytesDownload;
                
                if (in instanceof ByteArrayInputStream) {
                    size = in.available();
                    bytesDownload = new byte[size];
                    len = in.read(bytesDownload, 0, size);
                  } else {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bytesDownload = new byte[size];
                    while ((len = in.read(bytesDownload, 0, size)) != -1)
                      bos.write(bytesDownload, 0, len);
                    bytesDownload = bos.toByteArray();
                  }
               
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
    
} 
