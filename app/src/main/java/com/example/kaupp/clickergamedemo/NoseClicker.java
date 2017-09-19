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

public class NoseClicker extends Activity {

    private int[] clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nose_clicker);
        TextView noseCounter = (TextView) findViewById(R.id.nose_counter);
        Bundle extras = getIntent().getExtras();
        clicks = extras.getIntArray("clicks");
        noseCounter.setText(String.valueOf(clicks[2]));
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
                Toast.makeText(getBaseContext(), "You're picking noses already?", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void NoseClick(View view){
        TextView noseCounter = (TextView) findViewById(R.id.nose_counter);
        clicks[2]++;
        noseCounter.setText(String.valueOf(clicks[2]));
        if(clicks[2] == 10){
            createNotification(clicks[2]);
        }
        if(clicks[2] > 20){
            createBigNotification(clicks[2]);
        }
    }

    public void createNotification(int number){
        // create a new notification
        Notification notification  = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Clicker notification")
                .setContentText("Nose picked " + number + " times! Your nose gets loose!")
                .setSmallIcon(R.drawable.nose1)
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
                .setContentTitle("Clicker notification")
                .setStyle(new Notification.BigTextStyle().bigText("Nose picked " + number + " times! You are boogerman!"))
                .setSmallIcon(R.drawable.cookie1)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_SECRET).build();
// connect notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// make a new notification with a new unique id
        clicks[3]++;
        notificationManager.notify(clicks[3], notification);
    }
}

