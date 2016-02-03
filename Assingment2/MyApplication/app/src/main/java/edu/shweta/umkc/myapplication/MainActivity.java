package edu.shweta.umkc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void checkCredential(View V)
    {
        EditText usernameCt = (EditText)findViewById(R.id.username);
        EditText passwordCt = (EditText)findViewById(R.id.password);
        TextView errorText = (TextView)findViewById(R.id.lbl_Error);
        TextView successText = (TextView)findViewById(R.id.lbl_loginSucess);
        String userName = usernameCt.getText().toString();
        String password = passwordCt.getText().toString();

        boolean validationFlag = false;
        if(!userName.isEmpty() && !password.isEmpty())
        {
            if(userName.equals("Admin")&& password.equals("Admin"))
            {
                validationFlag = true;
            }
        }

        if(validationFlag == false)
        {
            errorText.setVisibility(View.VISIBLE);
        }
        if(validationFlag == true)
        {
            errorText.setVisibility(View.INVISIBLE);
            successText.setVisibility(View.VISIBLE);
            Intent i = new Intent(MainActivity.this, MapsActivity.class);
            //i.putExtra()
            startActivity(i);
        }
    }
}
