package com.kryword.fitmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.kryword.fitmate.Models.SessionPlan;

import java.util.ArrayList;
import java.util.List;

public class SessionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView list = findViewById(R.id.list_view);
        List<SessionPlan> sessionList = new ArrayList<>();
        sessionList.add(new SessionPlan(0, "Core", "Una sesión de ejercicios que mejoran la zona central del tronco y los abdominales"));
        SessionAdapter myAdapter = new SessionAdapter(this, sessionList);
        list.setAdapter(myAdapter);
    }
}
