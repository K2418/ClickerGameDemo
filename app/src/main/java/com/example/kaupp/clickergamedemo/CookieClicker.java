package com.example.kaupp.clickergamedemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.visibility;

public class CookieClicker extends Activity {

    private int[] clicks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie_clicker);
        TextView cookieCounter = (TextView) findViewById(R.id.cookie_counter);
        Bundle extras = getIntent().getExtras();
        clicks = extras.getIntArray("clicks");
        cookieCounter.setText(String.valueOf(clicks[0]));
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
                Toast.makeText(getBaseContext(), "You're clicking cookies already?", Toast.LENGTH_SHORT).show();
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

    public void CookieClick(View view){
        TextView cookieCounter = (TextView) findViewById(R.id.cookie_counter);
        clicks[0]++;
        cookieCounter.setText(String.valueOf(clicks[0]));
        if(clicks[0] == 10){
            createNotification(clicks[0]);
        }
        if(clicks[0] > 20){
            createBigNotification(clicks[0]);
        }
    }

    public void createNotification(int number){
        // create a new notification
        Notification notification  = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("PTM notification")
                .setContentText("Cookie clicked " + number + " times! Please stop already..")
                .setSmallIcon(R.drawable.cookie1)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PUBLIC).build();
// connect notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// make a new notification with a new unique id
        clicks[3]++;
        notificationManager.notify(clicks[3], notification);
    }
    public void createBigNotification(int number){
        // create a new notification
        Notification notification  = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("PTM notification")
                .setStyle(new Notification.BigTextStyle().bigText("Cookie clicked " + number + " times! Please stop already.. Click me to save yourself!"))
                .setSmallIcon(R.drawable.cookie1)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PUBLIC).build();
// connect notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// make a new notification with a new unique id
        clicks[3]++;
        notificationManager.notify(clicks[3], notification);
    }
}

