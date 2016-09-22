package com.naren.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "login success", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    public void validateUser(View v)
    {
        EditText et = (EditText)findViewById(R.id.txt_uname);
        EditText et1 = (EditText) findViewById(R.id.txt_pwd);
        TextView tv = (TextView)findViewById(R.id.lbl_error);
        String username = et.getText().toString();
        String pwd = et1.getText().toString();

        boolean check = false;

        if(!username.isEmpty() && !pwd.isEmpty()) {
            if(username.equals("Naren") && pwd.equals("1234")) {
                check = true;

            }
        }
        if(!check)
        {
            tv.setVisibility(View.VISIBLE);
        }
        else
        {
            //This code redirects the from login page to the home page.
            Intent nav = new Intent(this, HomeActivity.class);
            startActivity(nav);
        }

    }

}
