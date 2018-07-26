package com.kryword.fitmate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kryword.fitmate.Models.Exercise;
import com.kryword.fitmate.Models.SessionExercise;

import pl.droidsonroids.gif.GifImageView;

public class SessionExerciseActivity extends AppCompatActivity {

    SessionExercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_exercise);
        exercise = new SessionExercise();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Exercise bundleExercise = (Exercise) bundle.getSerializable("exercise");
        exercise.setName(bundleExercise.getName());
        exercise.setDescription(bundleExercise.getDescription());
        exercise.setImage(bundleExercise.getImage());
        TextView nameText = findViewById(R.id.title);
        TextView descriptionText = findViewById(R.id.description);
        GifImageView gifView = findViewById(R.id.gifView);
        nameText.setText(exercise.getName());
        descriptionText.setText(exercise.getDescription());
        gifView.setImageURI(exercise.getImage());
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void addExercise(View view){
        EditText minSets = findViewById(R.id.minSets);
        EditText minRepetitions = findViewById(R.id.minRepetitions);
        EditText minWait = findViewById(R.id.minWait);
        EditText minWeight = findViewById(R.id.minWeight);
        EditText maxSets = findViewById(R.id.maxSets);
        EditText maxRepetitions = findViewById(R.id.maxRepetitions);
        EditText maxWait = findViewById(R.id.maxWait);
        EditText maxWeight = findViewById(R.id.maxWeight);

        exercise.setSetsMin(Integer.parseInt(minSets.getText().toString()));
        exercise.setRepetitionsMin(Integer.parseInt(minRepetitions.getText().toString()));
        exercise.setWaitMin(Integer.parseInt(minWait.getText().toString()));
        exercise.setWeightMin(Integer.parseInt(minWeight.getText().toString()));
        exercise.setSetsMax(Integer.parseInt(maxSets.getText().toString()));
        exercise.setRepetitionsMax(Integer.parseInt(maxRepetitions.getText().toString()));
        exercise.setWaitMax(Integer.parseInt(maxWait.getText().toString()));
        exercise.setWeightMax(Integer.parseInt(maxWeight.getText().toString()));

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("exercise", exercise);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
