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

public class MonsterClicker extends Activity {

    private int[] clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_clicker);
        TextView monsterCounter = (TextView) findViewById(R.id.monster_counter);
        Bundle extras = getIntent().getExtras();
        clicks = extras.getIntArray("clicks");
        monsterCounter.setText(String.valueOf(clicks[1]));
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
                Toast.makeText(getBaseContext(), "You're clicking monster already?", Toast.LENGTH_SHORT).show();
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

    public void MonsterClick(View view){
        TextView monsterCounter = (TextView) findViewById(R.id.monster_counter);
        clicks[1]++;
        monsterCounter.setText(String.valueOf(clicks[1]));
        if(clicks[1] == 10){
            createNotification(clicks[1]);
        }
        if(clicks[1] > 20){
            createBigNotification(clicks[1]);
        }
    }

    public void createNotification(int number){
        // create a new notification
        Notification notification  = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("PTM notification")
                .setContentText("Monster clicked " + number + " times! Please stop already..")
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
                .setStyle(new Notification.BigTextStyle().bigText("Monster clicked " + number + " times! Please stop already.. Click me to save yourself!"))
                .setSmallIcon(R.drawable.cookie1)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PRIVATE).build();
// connect notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// make a new notification with a new unique id
        clicks[3]++;
        notificationManager.notify(clicks[3], notification);
    }
}
