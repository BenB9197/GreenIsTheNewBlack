package com.example.mikey.loginvideo;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class DetailsRequest extends StringRequest{

    private static final String GRAB_REQUEST_URL = "https://monophthongal-arriv.000webhostapp.com/grab.php";
    private Map<String, String> params;


    public DetailsRequest(String scientificName, Response.Listener<String> listener){
        super (Request.Method.POST, GRAB_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("scientific", scientificName);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
