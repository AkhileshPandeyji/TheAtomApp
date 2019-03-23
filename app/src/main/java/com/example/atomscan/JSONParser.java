package com.example.atomscan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JSONParser {
    static String JSONString ="";
    static JSONObject jsonObject;

    static public void connect(String url) {
        try {
            URL urll = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urll.openConnection();
            InputStream stream = httpURLConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String terminator="";
            do{
                terminator = bufferedReader.readLine();
                JSONString += terminator;
            }while (terminator!=null);

            jsonObject = new JSONObject(JSONString);
            bufferedReader.close();
            reader.close();
            stream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    static public String getJSONString(String Key) {
        String value = "N.I.L";
        try {
            value = jsonObject.getString(Key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    static public JSONObject getJSONObject(String key) {

        return null;
    }

    static public String getJSONString(JSONObject object, String key) {


        String value = null;
        try {
            value = object.getString(key);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }
    static public JSONArray getJSONArray(JSONObject object,String key){
        JSONArray array = null;
        try {
            array = object.getJSONArray(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }

    static public JSONArray getJSONArray(String key){
        JSONArray array = null;
        try {
            array = jsonObject.getJSONArray(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }
}
