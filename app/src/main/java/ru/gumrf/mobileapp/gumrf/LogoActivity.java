package ru.gumrf.mobileapp.gumrf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by romanzonov on 30.12.2017.
 */

public class LogoActivity extends AppCompatActivity {

    ImageView logoView;
    TextView chislitel, znamenatel;

    Singleton mSingleton;

    int[] arr = {R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        mSingleton = Singleton.getInstance();
        logoView = (ImageView) findViewById(R.id.logo);
        logoView.setImageResource(arr[(int)(Math.random()*arr.length)]);
        chislitel = (TextView) findViewById(R.id.chislitel);
        znamenatel = (TextView) findViewById(R.id.znamenatel);
        switch (mSingleton.getWeek()) {
            case Singleton.WEEK_CHISLITEL:
                chislitel.setText("ЧИСЛИТЕЛЬ");
                break;
            case Singleton.WEEK_ZNAMENATEL:
                znamenatel.setText("ЗНАМЕНАТЕЛЬ");
        }
    }
    /*
    UserLoginTask mAuthTask = new UserLoginTask();
            mAuthTask.setUrl("http://cartridges.gumrf.ru/admin/login.html");
            mAuthTask.setType("POST");
            mAuthTask.setParams("login="+mEmailView.getText().toString()+"&password="+mPasswordView.getText().toString()+"&mobile=true&token="+sPref.getFBToken(context));
            mAuthTask.execute();
private class UserLoginTask extends JSONGet {

        @Override
        protected void onPostExecute(String strJson) {
            int length = strJson.length();

            for(int i=0; i<length; i+=1024)
            {
                if(i+1024<length)
                    Log.d("PlaceholderFragment", strJson.substring(i, i+1024));
                else
                    Log.d("PlaceholderFragment", strJson.substring(i, length));
            }
            Log.e("PlaceholderFragment", "Result: "+strJson);
            mAuthTask = null;
            showProgress(false);
            try {
                JSONObject resObject = new JSONObject(strJson);
                if(resObject.get("result").toString().equals("true")) {
                    sPref.saveToken(context, resObject.get("token").toString());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    mPasswordView.requestFocus();
                }
            } catch (JSONException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                e.printStackTrace();
            }

        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

     */
}
