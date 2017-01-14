package com.example.illya.studyapplecure7.activities;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.illya.studyapplecure7.R;

public class MainActivity extends AppCompatActivity {

    private TextView textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textField = (TextView) findViewById(R.id.inputText);

        registerForContextMenu(textField);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(MainActivity.this, "Item 1 pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this, "Item 2 pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "Item 3 pressed", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override //Клик на пункт меню
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_name1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_name2:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub1:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    public void onClickButton(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification;
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        switch (view.getId()) {
            case R.id.button1:
                PopupMenu popupMenu = new PopupMenu(this, view);
                popupMenu.inflate(R.menu.context_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item1:
                                Toast.makeText(MainActivity.this, "Item 1 pressed", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item2:
                                Toast.makeText(MainActivity.this, "Item 2 pressed", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item3:
                                Toast.makeText(MainActivity.this, "Item 3 pressed", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
                break;
            case R.id.button2:
                Toast toast = Toast.makeText(this, "Hello toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                break;
            case R.id.button3:
                Toast toast1 = Toast.makeText(this, "Hello toast", Toast.LENGTH_LONG);
                LinearLayout tLayout = (LinearLayout) toast1.getView();
                ImageView iView = new ImageView(this);
                iView.setImageResource(R.mipmap.ic_launcher);
                tLayout.addView(iView);
                toast1.show();
                break;
            case R.id.button4:
                LayoutInflater inflater = getLayoutInflater();
                View vLayout = inflater.inflate(R.layout.my_toast_layout, null);
                TextView toastView = (TextView) vLayout.findViewById(R.id.toastText);
                toastView.setText("SOME TOAST TEXT");
                Toast t4 = new Toast(this);
                t4.setView(vLayout);
                t4.setDuration(Toast.LENGTH_SHORT);
                t4.show();
                break;
            case R.id.button5:
                notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Notification!")
                        .setContentTitle("Notification title")
                        .setContentText("Notification text")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pIntent).build();
                notificationManager.notify(1, notification);

                break;
            case R.id.button6:
                RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.notification_layout);
                remoteViews.setTextViewText(R.id.notificationTitle, "Custom title");
                remoteViews.setTextViewText(R.id.notificationText, "Custom text");
                notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Notification custom!")
                        .setContentIntent(pIntent).build();
                notification.contentView = remoteViews;
                notificationManager.notify(3, notification);
                break;
            case R.id.button7:
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                        Toast.makeText(MainActivity.this, hours + ":" + minutes, Toast.LENGTH_SHORT).show();
                    }
                }, 0, 0, true).show();
                break;
            case R.id.button8:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Title");
                builder.setMessage("Message");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setCancelable(false);
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "OK pressed", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();


                break;
            case R.id.button9:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Title");
                progressDialog.setMessage("Message");
                progressDialog.setButton(Dialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                progressDialog.show();

                break;
        }

    }
}
