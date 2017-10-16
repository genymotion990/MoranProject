package com.example.hp1.cit2radio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    TabHost tabHost;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.registerbt);
        login.setOnClickListener(this);


        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Login & Register");
        spec.setContent(R.id.login);
        spec.setIndicator("Login & Register");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Radio Player");
        spec.setContent(R.id.radio);
        spec.setIndicator("Radio Player");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Contact us");
        spec.setContent(R.id.contact);
        spec.setIndicator("Contact us");
        host.addTab(spec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(getApplicationContext(),settings.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(),djpanel.class);
        startActivity(intent);

    }

    }


