package com.kryword.fitmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void listSessions(View view){
        Intent intent = new Intent(getApplicationContext(), SessionListActivity.class);
        startActivity(intent);
    }

    public void listExercises(View view){
        Intent intent = new Intent(getApplicationContext(), ExerciseListActivity.class);
        startActivity(intent);
    }
}
