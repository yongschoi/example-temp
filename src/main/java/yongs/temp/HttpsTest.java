package yongs.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

public class HttpsTest {

	public static void main(String[] args) {
		String urlString = "https://www.google.com";
		String line = null;
		InputStream in = null;
		BufferedReader reader = null; 
		HttpsURLConnection httpsConn = null;
		
		try {
			// Get HTTPS URL connection
			URL url = new URL(urlString);
			httpsConn = (HttpsURLConnection) url.openConnection();
			
			// Set Hostname verification
			httpsConn.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					// Ignore host name verification. It always returns true.
					return true;
				}
			});
			
			// Input setting
			httpsConn.setDoInput(true);
			// Output setting
			//httpsConn.setDoOutput(true);
			// Caches setting
			httpsConn.setUseCaches(false);
			// Read Timeout Setting
			httpsConn.setReadTimeout(1000);
			// Connection Timeout setting
			httpsConn.setConnectTimeout(1000);
			// Method Setting(GET/POST)
			httpsConn.setRequestMethod("GET");
			// Header Setting
			httpsConn.setRequestProperty("HeaderKey","HeaderValue");
			
			int responseCode = httpsConn.getResponseCode();
			System.out.println("응답코드 : " + responseCode);
			System.out.println("응답메세지 : " + httpsConn.getResponseMessage());
			
			// SSL setting
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, null, null); // No validation for now
			httpsConn.setSSLSocketFactory(context.getSocketFactory());
			
			// Connect to host
			httpsConn.connect();
			httpsConn.setInstanceFollowRedirects(true);
			
			// Print response from host
			if (responseCode == HttpsURLConnection.HTTP_OK) { // 정상 호출 200
				in = httpsConn.getInputStream();
			} else { // 에러 발생
				in = httpsConn.getErrorStream();
			}
			reader = new BufferedReader(new InputStreamReader(in));
			while ((line = reader.readLine()) != null) {
				System.out.printf("%s\n", line);
			}
			
			reader.close();
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException : " + e);
		} catch (MalformedURLException e) {
			System.out.println(urlString + " is not a URL I understand");
        } catch (IOException e) {
        	System.out.println("IOException :" + e);
        } catch (Exception e) {
        	System.out.println("error : " + e);
        } finally {
            if (reader != null) {
            	try {
            		reader.close();
            	} catch (Exception e) {
            		
            	}
            }
            if (httpsConn != null) {
                httpsConn.disconnect(); 
            }
        }
	}

}
