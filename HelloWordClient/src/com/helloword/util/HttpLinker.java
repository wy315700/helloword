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
     * @param uploadString
     * @return the outputstream data wraped in string
     */
    public String postString(String httpUrl, String uploadString) {
        return postString(httpUrl, uploadString, 0);
    }

    public String postString(String httpUrl, String uploadString, int flag) {
        String downloadString = null;
        try {
            URL url = new URL(httpUrl);
            uploadString = "params=" + uploadString;
            byte[] uploadBytes = uploadString.getBytes();
            byte[] downloadBytes = postByteArray(url, uploadBytes, flag);
            downloadString = new String(downloadBytes);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return downloadString;
    }

    public byte[] postByteArray(URL url, byte[] uploadBytes, int flag) {
        // if flag = 0 (default), short connection, if flag = 1 long connection
        final int TIMELIMIT = 250;
        HttpURLConnection urlConnection = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
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

            out.write(uploadBytes);
            out.flush();
            out.close();

            // =======================read input data=================================

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            int size = 1024;
            int len;
            byte[] downloadBytes;

            if (in instanceof ByteArrayInputStream) {
                size = in.available();
                downloadBytes = new byte[size];
                len = in.read(downloadBytes, 0, size);
            } else {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                downloadBytes = new byte[size];
                while ((len = in.read(downloadBytes, 0, size)) != -1)
                    bos.write(downloadBytes, 0, len);
                downloadBytes = bos.toByteArray();
            }
            in.close();
            return downloadBytes;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }
}
