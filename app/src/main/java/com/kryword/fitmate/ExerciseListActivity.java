package com.kryword.fitmate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.kryword.fitmate.Models.Exercise;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExerciseListActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NEW_EXERCISE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        ExerciseAdapter adapter = new ExerciseAdapter(getApplicationContext());
        ListView listView = findViewById(R.id.list_exercises);
        listView.setAdapter(adapter);
        File fileDir = getFilesDir();
        File[] list = fileDir.listFiles();
        if (list.length == 0) {
            Log.d("Empty?", "Is totally empty");
        }else{
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
                    Log.d("A SABER", (String)exerciseJSON.get("image"));
                    exercise.setImage(Uri.parse((String)exerciseJSON.get("image")));
                    adapter.add(exercise);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_NEW_EXERCISE && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            try {
                JSONObject exercise = new JSONObject();
                String objectName = bundle.getString("name");
                exercise.put("name", objectName);
                exercise.put("description", bundle.getString("description"));
                exercise.put("image", bundle.getParcelable("image"));
                String filename = objectName + ".json";
                FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                fos.write(exercise.toString().getBytes());
                fos.close();
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
