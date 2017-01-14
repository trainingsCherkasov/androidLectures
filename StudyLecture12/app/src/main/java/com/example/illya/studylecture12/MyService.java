package com.example.illya.studylecture12;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    private MyBinder myBinder;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        PendingIntent pendingIntent = intent.getParcelableExtra("PendingIntent");

        if (action.equals("saveStudent")) {
            String text = intent.getStringExtra("student");
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

            Intent result = new Intent();
            result.putExtra("Saved", true);

            try {
                pendingIntent.send(this, Activity.RESULT_OK, result);
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (myBinder == null) {
            myBinder = new MyBinder();
        }
        return myBinder;
    }


    public void test() {
        Toast.makeText(this, "I am service", Toast.LENGTH_SHORT).show();
    }


    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

}
