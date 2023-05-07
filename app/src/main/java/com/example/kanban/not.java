package com.example.kanban;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class not extends AppCompatActivity {
    private List<NotificationModel> notifications;
    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not);
        // Initialise le RecyclerView
        recyclerView = findViewById(R.id.notifications_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialise l'adaptateur personnalisé
        adapter = new NotificationAdapter(notifications);
        recyclerView.setAdapter(adapter);

        // Ajoute les notifications à la liste
        notifications.add(new NotificationModel(1, "Contenu de notification 1", "10:00", "01/05/2023"));
        notifications.add(new NotificationModel(2, "Contenu de notification 2", "12:00", "02/05/2023"));


        // Notifie l'adaptateur que les données ont été modifiées
        adapter.notifyDataSetChanged();
    }
}
