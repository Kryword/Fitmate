package com.kryword.fitmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.kryword.fitmate.Models.SessionPlan;

import java.util.ArrayList;
import java.util.List;

public class SessionListActivity extends AppCompatActivity {

    private static final int REQUEST_NEW_SESSION = 1;

    List<SessionPlan> sessionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView list = findViewById(R.id.list_view);
        sessionList = new ArrayList<>();
        sessionList.add(new SessionPlan(0, "Core", "Una sesión de ejercicios que mejoran la zona central del tronco y los abdominales"));
        SessionAdapter myAdapter = new SessionAdapter(this, sessionList);
        list.setAdapter(myAdapter);
    }

    public void createSession(View view){
        Intent intent = new Intent(getApplicationContext(), NewSessionActivity.class);
        startActivityForResult(intent, REQUEST_NEW_SESSION);
    }
}
