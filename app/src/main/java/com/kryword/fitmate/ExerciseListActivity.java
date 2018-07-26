package com.kryword.fitmate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kryword.fitmate.Models.Exercise;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseListActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NEW_EXERCISE = 1;
    private boolean sendExercise;
    ExerciseAdapter adapter;
    List<Exercise> exercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        exercises = new ArrayList<>();
        adapter = new ExerciseAdapter(getApplicationContext());
        ListView listView = findViewById(R.id.list_exercises);
        listView.setAdapter(adapter);
        File fileDir = getFilesDir();
        File[] list = fileDir.listFiles();
        if (list.length == 0) {
            Log.d("Empty?", "Is totally empty");
        } else {
            for (File exerciseFile :
                    list) {
                // Uncomment next line when you need to delete all exercises
                // exerciseFile.delete();
                String exerciseJSONString = "";
                try {
                    FileInputStream fis = new FileInputStream(exerciseFile);
                    byte[] b = new byte[fis.available()];
                    fis.read(b);
                    exerciseJSONString = exerciseJSONString + new String(b);
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    JSONObject exerciseJSON = new JSONObject(exerciseJSONString);
                    Exercise exercise = new Exercise();
                    exercise.setName(exerciseJSON.getString("name"));
                    exercise.setDescription(exerciseJSON.getString("description"));
                    exercise.setImage(Uri.parse((String) exerciseJSON.get("image")));
                    exercises.add(exercise);
                    adapter.add(exercise);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        try {
            int getAnExercise = bundle.getInt("intention");
            sendExercise = true;
        }catch (NullPointerException e){
            sendExercise = false;
        }finally {
            if (sendExercise){
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Exercise exercise = exercises.get(position);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("name", exercise.getName());
                        bundle.putString("description", exercise.getDescription());
                        bundle.putParcelable("image", exercise.getImage());
                        intent.putExtras(bundle);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NEW_EXERCISE && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            try {
                Exercise exerciseObject = new Exercise();
                exerciseObject.setName(bundle.getString("name"));
                exerciseObject.setDescription(bundle.getString("description"));
                exerciseObject.setImage((Uri)bundle.getParcelable("image"));
                JSONObject exercise = exerciseObject.toJSON();
                String filename = exerciseObject.getName() + ".json";
                FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                fos.write(exercise.toString().getBytes());
                fos.close();
                adapter.add(exerciseObject);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void newExercise(View view){
        Intent intent = new Intent(getApplicationContext(), NewExerciseActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NEW_EXERCISE);
    }
}
