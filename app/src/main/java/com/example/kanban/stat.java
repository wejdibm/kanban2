package com.example.kanban;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class stat extends AppCompatActivity {
    FirebaseDatabase database ;
    Button btn ;
    EditText yValue ;
    DatabaseReference reference ;
    SimpleDateFormat sdf= new SimpleDateFormat("hh:mm");
    GraphView graphView ;
    LineGraphSeries series ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        graphView = (GraphView) findViewById(R.id.graph);
        btn = (Button)  findViewById(R.id.button) ;
        yValue = (EditText) findViewById(R.id.e12) ;
        series = new LineGraphSeries();
        graphView.addSeries(series);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("weigh") ;
        wa = database.getReference("weight") ;
        setListeners();
        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX){
                    return  sdf.format(new Date((long)value));
                }else{
                return super.formatLabel(value, isValueX);}
            }
        });
    }
    private void setListeners(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

String id=reference.push().getKey();
long x= new Date().getTime();
int y = Integer.parseInt(yValue.getText().toString());
PointValue pointValue = new PointValue(x,y);
reference.child(id).setValue(pointValue) ;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataPoint[]  dp =new DataPoint[(int)snapshot.getChildrenCount()];
                int index=0;
                for(DataSnapshot myDataSnapshot : snapshot.getChildren())
                {
                    PointValue pointValue=myDataSnapshot.getValue(PointValue.class) ;
                    dp[index]=new DataPoint(pointValue.getxValue(),pointValue.getyValue());
                    index++;
                }
series.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}