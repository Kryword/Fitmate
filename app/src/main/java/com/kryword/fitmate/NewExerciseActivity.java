package com.kryword.fitmate;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class NewExerciseActivity extends AppCompatActivity {

    private static final int REQUEST_PICTURE = 0;
    EditText titleText;
    EditText descriptionText;
    Uri imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise);
        titleText = findViewById(R.id.title);
        descriptionText = findViewById(R.id.description);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_PICTURE && resultCode == RESULT_OK){
            Log.d("FILE", "onActivityResult: " + data.getDataString());
            imagePath = data.getData();
            GifImageView gifView = findViewById(R.id.gifViewer);
            gifView.setImageURI(imagePath);
        }
    }

    public void addImage(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select picture or gif"), REQUEST_PICTURE);
    }

    public void createExercise(View view){
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("name", titleText.getText().toString());
        bundle.putString("description", descriptionText.getText().toString());
        bundle.putString("image", imagePath.getPath());
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
