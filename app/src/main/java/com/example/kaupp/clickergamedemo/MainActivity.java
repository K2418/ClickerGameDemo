package com.example.kaupp.clickergamedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int[] clicks = {0,0,0,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clicker1:
                Toast.makeText(getBaseContext(), "Cookies!", Toast.LENGTH_SHORT).show();
                Intent cookieClicker = new Intent(this, CookieClicker.class);
                cookieClicker.putExtra("clicks", clicks);
                startActivity(cookieClicker);
                return true;
            case R.id.clicker2:
                Toast.makeText(getBaseContext(), "Monsters!", Toast.LENGTH_SHORT).show();
                Intent monsterClicker = new Intent(this, MonsterClicker.class);
                monsterClicker.putExtra("clicks", clicks);
                startActivity(monsterClicker);
                return true;
            case R.id.clicker3:
                Toast.makeText(getBaseContext(), "Noses!", Toast.LENGTH_SHORT).show();
                Intent noseClicker = new Intent(this, NoseClicker.class);
                noseClicker.putExtra("clicks", clicks);
                startActivity(noseClicker);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
