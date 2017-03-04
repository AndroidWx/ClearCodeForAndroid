package com.ninegor.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joye on 2017/2/27.
 */

public class JsonParser {
    public static int parse(String jsonString){
        try{
            JSONObject jsonObject = new JSONObject(jsonString);
           return jsonObject.getInt("resultCode");
        }catch (JSONException e){
            e.printStackTrace();
        }

        return -1;
    }
}