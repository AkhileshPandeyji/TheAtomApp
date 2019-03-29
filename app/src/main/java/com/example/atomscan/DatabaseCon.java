package com.example.atomscan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@SuppressLint("StaticFieldLeak")
class DatabaseCon extends AsyncTask<String, Void, Boolean> {
    private Context context;
    private String line;

    DatabaseCon(Context context) {
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        boolean result = false;
        try {

            URL url = new URL(strings[0]);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection != null) {
                Log.i("Connection","Established");
                connection.setRequestMethod("POST");

                connection.setDoInput(true);
                connection.setDoOutput(true);
                Log.i("strings",strings[1]+":"+strings[2]);
                String data = URLEncoder.encode("enrol", "UTF-8") + "=" + URLEncoder.encode(strings[1],"UTF-8") +"&&"+ URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(strings[2],"UTF-8");
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.write(data,0,data.length());
                Log.i("Connection","Data Sent: "+data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));


               line = bufferedReader.readLine();
                Log.i("Read",line);
                if(line.equals("0")){
                    result = true;

                }
                else{
                    result = false;
                }
                bufferedReader.close();
                inputStream.close();
                connection.disconnect();
            } else {
                result = false;
                Log.i("Connection","Null");
            }
        } catch (MalformedURLException e) {
            result = false;
            Log.i("Connection",e.getMessage());
        } catch (IOException e) {
            result = false;
            Log.i("Connection",e.getMessage());

        }

        return result;
    }
    @Override
    protected void onPostExecute(Boolean res) {
        super.onPostExecute(res);
        if (!res) {
            Toast.makeText(context, "Invalid Credentials!!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }

}