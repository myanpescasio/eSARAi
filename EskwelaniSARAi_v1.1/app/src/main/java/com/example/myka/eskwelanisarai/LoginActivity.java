package com.example.myka.eskwelanisarai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void redirectLoginHome(View view){
        //Set-up redirection

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        if(username.getText().toString().equalsIgnoreCase("tester") && password.getText().toString().equalsIgnoreCase("tester")){
            Intent login = new Intent(this, TraineeHomeActivity.class);
            startActivity(login);
            finish();
        }
        else{
            username.setText("");
            password.setText("");
        }


    }
}
