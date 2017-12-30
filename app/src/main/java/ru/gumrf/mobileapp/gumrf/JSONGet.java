package ru.gumrf.mobileapp.gumrf;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by roman on 11.09.17.
 */

public class JSONGet extends AsyncTask<Void, String, String> {

    private HttpURLConnection urlConnection = null;
    private BufferedReader reader = null;
    private String resultJson = "";
    private String url="";
    private boolean isPost = false;
    private String paramsPost = "";

    public void setUrl(String u) {
        url=u;
    }

    public String getUrl() {
        return url;
    }

    public void setType(String t) {
        switch (t) {
            case "POST":
                isPost = true;
                break;
            case "GET":
                isPost = false;
                break;
            default:
                isPost = false;
                break;
        }
    }

    public String getType() {
        return isPost ? "POST" : "GET";
    }

    public void setParams(String par) {
        paramsPost = par;
    }

    public String getParams() {
        return paramsPost;
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            URL url = new URL(getUrl());
            urlConnection = (HttpURLConnection) url.openConnection();

            if(isPost) {
                String p = getParams();
                //Log.e("PlaceholderFragment", "post"+p);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty( "Content-type", "application/x-www-form-urlencoded");
                urlConnection.setRequestProperty( "Accept", "*/*" );
                urlConnection.setFixedLengthStreamingMode(
                        p.getBytes().length);
                PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                out.print(p);
                out.close();
            } else {
                urlConnection.setRequestMethod("GET");
            }
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();


        } catch (Exception e) {
            e.printStackTrace();

            //finish();
        }
        //Log.e("PlaceholderFragment", "Really? "+resultJson);
        return resultJson;
    }

    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);
    }
}
