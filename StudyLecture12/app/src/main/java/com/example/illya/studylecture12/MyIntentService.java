package com.example.illya.studylecture12;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class MyIntentService extends IntentService {

    public static final String ACTION_SAVE_STUDENT = "com.example.illya.studylecture12.action.SAVE_STUDENT";
    public static final String ACTION_GET_STUDENT = "com.example.illya.studylecture12.action.GET_STUDENT";

    // TODO: Rename parameters
    public static final String EXTRA_STUDENT = "com.example.illya.studylecture12.extra.STUDENT";
    public static final String EXTRA_ID = "com.example.illya.studylecture12.extra.ID";
    public static final String EXTRA_PENDING_INTENT = "com.example.illya.studylecture12.extra.PENDING_INTENT";

    public static final int REQUEST_CODE_SAVE_STUDENT = 1;
    public static final int REQUEST_CODE_GET_STUDENT = 2;

    public MyIntentService() {
        super("MyIntentService");
    }

    public static void saveStudent(Context context, Student student) {
        Intent intent = new Intent(context, MyIntentService.class);

        PendingIntent pendingIntent = ((AppCompatActivity) context).createPendingResult(REQUEST_CODE_SAVE_STUDENT, intent, 0);
        intent.putExtra(EXTRA_PENDING_INTENT, pendingIntent);
        intent.setAction(ACTION_SAVE_STUDENT);
        intent.putExtra(EXTRA_STUDENT, student);
        context.startService(intent);
    }


    public static void getStudent(Context context, long id) {
        Intent intent = new Intent(context, MyIntentService.class);

        PendingIntent pendingIntent = ((AppCompatActivity) context).createPendingResult(REQUEST_CODE_GET_STUDENT, intent, 0);
        intent.putExtra(EXTRA_PENDING_INTENT, pendingIntent);
        intent.setAction(ACTION_GET_STUDENT);
        intent.putExtra(EXTRA_ID, id);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            String action = intent.getAction();
            PendingIntent pIntent = intent.getParcelableExtra(EXTRA_PENDING_INTENT);
            Intent resultIntent = new Intent();
            MyDBHelper dbHelper = new MyDBHelper(this);

            if (ACTION_GET_STUDENT.equals(action)) {
                long id = intent.getLongExtra(EXTRA_ID, 0);
                Student student = dbHelper.getStudent(id);
                resultIntent.putExtra(EXTRA_STUDENT, student);
            } else if (ACTION_SAVE_STUDENT.equals(action)) {
                Student student = intent.getParcelableExtra(EXTRA_STUDENT);
                long id = dbHelper.insertStudent(student);
                resultIntent.putExtra(EXTRA_ID, id);
                Log.d("PUT value id = ",""+id);
            }

            try {
                pIntent.send(this, Activity.RESULT_OK, resultIntent);
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
    }


    //TODO SELF WORK
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        if (intent != null) {
//            final String action = intent.getAction();
//            if (ACTION_SAVE_STUDENT.equals(action)) {
//                final Student student = intent.getParcelableExtra(EXTRA_STUDENT);
//                final PendingIntent pendingIntent= intent.getParcelableExtra(EXTRA_PENDING_INTENT);
//                handleActionSave(pendingIntent, student);
//            } else if (ACTION_GET_STUDENT.equals(action)) {
//                final long id = intent.getLongExtra(EXTRA_ID);
//                final PendingIntent pendingIntent= intent.getParcelableExtra(EXTRA_PENDING_INTENT);
//
//                handleActionBaz(pendingIntent, id);
//            }
//        }
//    }
//
//    private void handleActionSave(PendingIntent param1, Student param2) {
//        // TODO: Handle action Foo
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    /**
//     * Handle action Baz in the provided background thread with the provided
//     * parameters.
//     */
//    private void handleActionBaz(String param1, String param2) {
//        // TODO: Handle action Baz
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
}
