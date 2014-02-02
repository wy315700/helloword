package httpConnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author Liletta
 */
public class HttpLinker {

    public String postCharacters(String httpUrl, String uploadData) {
        String resultData = "";  
        URL url = null;  
        try {  
            url = new URL(httpUrl);   
        }  
        catch (MalformedURLException e) {  
            // Log.e(DEBUG_TAG, "MalformedURLException");  
        }  
        if (url != null) {  
            try {  
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();  
                // ============the settings to make post request work=================
                urlConnection.setDoOutput(true);  
                urlConnection.setDoInput(true);  
                urlConnection.setRequestMethod("POST");  
                urlConnection.setUseCaches(false);  
                urlConnection.setInstanceFollowRedirects(true);  
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
                // =============================================================
                urlConnection.connect();  
                DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());

                out.writeBytes(uploadData);  
                out.flush();  
                out.close(); 

                InputStreamReader in = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader buffer = new BufferedReader(in);  
                String inputData = null;  
                while (((inputData = buffer.readLine()) != null)) {  
                    resultData += inputData;
                }     
                  
                if (!resultData.equals("")) {  
                    return resultData; 
                }  
                else {  
                    return null;
                }
  
            }  
            catch (IOException e) {
                System.out.println("IOException");
                // Log.e(DEBUG_TAG, "IOException");  
            }  
        }  
        else { 
            System.out.println("Url NULL");
            // Log.e(DEBUG_TAG, "Url NULL");  
        }  
        return null;
    } 
	
	/*public static void main(String args[]) {
        HttpLinker httpLinker = new HttpLinker();
		String data = httpLinker.postCharacters("http://localhost:8000", "helloooooo");
		System.out.println(data);
	}*/
} 
