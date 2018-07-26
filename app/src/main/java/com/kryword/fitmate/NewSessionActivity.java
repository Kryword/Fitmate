package com.kryword.fitmate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kryword.fitmate.Models.Exercise;
import com.kryword.fitmate.Models.SessionExercise;

import java.util.ArrayList;
import java.util.List;

public class NewSessionActivity extends AppCompatActivity {


    private static final int REQUEST_EXERCISE = 1;
    private static final int REQUEST_SESSION_EXERCISE = 2;
    List<SessionExercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_session);
        exercises = new ArrayList<>();
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void addExercise(View view){
        Intent intent = new Intent(getApplicationContext(), ExerciseListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("intention", 1);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_EXERCISE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_EXERCISE && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            Exercise exercise = new Exercise();
            exercise.setName(bundle.getString("name"));
            exercise.setDescription(bundle.getString("description"));
            exercise.setImage((Uri)bundle.getParcelable("image"));
            Intent intent = new Intent(getApplicationContext(), SessionExerciseActivity.class);
            Bundle bundle2 = new Bundle();
            bundle.putSerializable("exercise", exercise);
            intent.putExtras(bundle);
            startActivityForResult(intent, REQUEST_SESSION_EXERCISE);
        }else if(requestCode == REQUEST_SESSION_EXERCISE && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            SessionExercise exercise = (SessionExercise) bundle.getSerializable("exercise");
            exercises.add(exercise);
            Log.d("EXERCISES", "onActivityResult: " + exercises);
        }
    }
}
