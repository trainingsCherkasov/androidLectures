package com.example.illya.studylecture12;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean serviceConnected;
    private MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, MyService.class);
                intent.setAction("saveStudent");
                intent.putExtra("student", "I am student");
                PendingIntent pendingIntent = createPendingResult(1, intent, 0);
                intent.putExtra("PendingIntent", pendingIntent);
                startService(intent);
                break;

            case R.id.button2:
                ServiceConnection connection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        serviceConnected = true;
                        myService = ((MyService.MyBinder) service).getService();
                        Toast.makeText(MainActivity.this, "Service connected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        serviceConnected = false;
                    }
                };

                Intent intent2 = new Intent(this, MyService.class);
                bindService(intent2, connection, BIND_AUTO_CREATE);

                break;


            case R.id.button3:
                if (serviceConnected) {
                    myService.test();
                } else {
                    Toast.makeText(MainActivity.this, "Cant't test dead service", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.button4:
                MyIntentService.saveStudent(this, new Student("Ivan11", "Ivanov11", 22));

                break;

            case R.id.button5:
                MyIntentService.getStudent(this, 1);
                break;

            case R.id.button6:
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == MyIntentService.REQUEST_CODE_SAVE_STUDENT){
                long id  = data.getLongExtra(MyIntentService.EXTRA_ID,0);
                Log.d("Extras ",data.getExtras().toString());
                Log.d("GOT RESULT ", "id = "+id);
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();

            }else if (requestCode == MyIntentService.REQUEST_CODE_GET_STUDENT){
                Student student = data.getParcelableExtra(MyIntentService.EXTRA_STUDENT);
                Log.d("Extras ",data.getExtras().toString());
                Toast.makeText(this, student.toString(), Toast.LENGTH_SHORT).show();
            }



//            if (requestCode == 1) {
//                boolean result = data.getBooleanExtra("Saved", false);
//                Toast.makeText(this, String.valueOf(requestCode), Toast.LENGTH_SHORT).show();
//            }


        }
    }


    class SaveTask extends AsyncTask<Student, Void, Long>{
        @Override
        protected Long doInBackground(Student... params) {
            return null;
        }
    }
}
