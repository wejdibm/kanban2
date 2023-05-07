package com.example.kanban;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class weight2 extends AppCompatActivity {
    ImageView imageView;
    DatabaseReference dref;
    TextView weight;
    String status;
    float piods;
    ProgressBar mTemperatureProgressBar ;
    public static final String channel_id = "simplified_coding";
    public static final String channel_name = "simplified coding";
    public static final String channel_desc = "simplified coding Notifaction";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight2);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel(channel_id,channel_name, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channel_desc);
            NotificationManager manger = getSystemService(NotificationManager.class) ;
            manger.createNotificationChannel(channel);
        }
        weight = findViewById(R.id.weight2);
        dref = FirebaseDatabase.getInstance().getReference();
        mTemperatureProgressBar =findViewById(R.id.temperatureProgressBar);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                status = dataSnapshot.child("weight").getValue().toString();
                piods = Float.parseFloat(status);

                weight.setText(status);
                if (piods < 20.22 ){
                    displayNotifaction();
                    //assert status != null;
                  //  mTemperatureProgressBar.setProgress(Integer.parseInt(status));

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        // imageView = findViewById(R.id.retour);

        // imageView.setOnClickListener(new View.OnClickListener() {
        // @Override
        //  public void onClick(View view) {
        //   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //   startActivity(intent);
        // finish();
        //}
        // });


    }

    private void displayNotifaction() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, channel_id)
                        .setSmallIcon(R.drawable.notification)
                        .setContentTitle("remplir le kanban ")
                        .setContentText("waaa")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotifcationMgr = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mNotifcationMgr.notify(1, mBuilder.build());
    }

}