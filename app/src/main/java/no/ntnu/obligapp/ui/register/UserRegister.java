package no.ntnu.obligapp.ui.register;

import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.ntnu.obligapp.User;
import no.ntnu.obligapp.data.Result;
import no.ntnu.obligapp.data.model.LoggedInUser;

public class UserRegister {

    public static Result registerUser(int uid,String firstName, String lastName, String email, String password){

        HttpURLConnection c = null;
        try {
            URL url = new URL("http://10.0.2.2:8080/oblig1/api/auth/create_user");


            Map<String, Object> params = new LinkedHashMap<>();
            params.put("uid", uid);
            params.put("firstName",firstName);
            params.put("pwd",password);
            params.put("email", email);
            params.put("lastName",lastName);

            /*
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if(postData.length() != 0){
                    postData.append('&');
                    postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
                    postData.append('=');
                    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                }
            }


            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
             */

            c = (HttpURLConnection) url.openConnection();
            c.setUseCaches(true);
            c.setRequestMethod("POST");
            c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            c.setDoOutput(true);
           // c.getOutputStream().write(postDataBytes);
            int statusCode = c.getResponseCode();

            if(c.getResponseCode() == HttpURLConnection.HTTP_OK) {
                User user = new User(firstName,lastName,email,password);
                return new Result.Success<>(user);
            }

            return new Result.Error(new IOException("Error logging in " + c.getResponseMessage()));
        } catch (Exception e) {
            System.err.println("Failed to call " + e);
            return new Result.Error(new IOException("Error logging in", e));
        } finally {
            if(c != null) c.disconnect();
        }
    }
    }

