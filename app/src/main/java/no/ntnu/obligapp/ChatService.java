package no.ntnu.obligapp;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;

import java.util.Map;

public class ChatService implements Response.ErrorListener {
    public static final String BASE_URL = "http://10.0.2.2:8080/oblig1/api/";
    static ChatService SINGLETON;

    String token;
    RequestQueue requestQueue;

    public ChatService(Context context, String token) {
        this.token = token;
        this.requestQueue = Volley.newRequestQueue(context);
    }


    public static ChatService initialize(Context context, String token) {
        SINGLETON = new ChatService(context, token);
        return SINGLETON;
    }

    public static ChatService getInstance() {
        return SINGLETON;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println("Error: " + error);
    }

    public User getUser() {
       /* String url = BASE_URL + "auth/currentuser";

        //User result = new User();

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        result.setUserid(response.getString("userid"));
                        result.setFirstName(response.getString("firstName"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, this) {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return Map.of("Authorization", "Bearer " + token);
            }
        };

        requestQueue.add(jor);

        return result;*/
       return null;
    }

}
