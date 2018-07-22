package com.kryword.fitmate;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kryword.fitmate.Models.Exercise;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class ExerciseAdapter extends BaseAdapter{
    List<Exercise> data;
    private static LayoutInflater inflater = null;
    Context context;

    public ExerciseAdapter(Context context) {
        this.data = new ArrayList<>();
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ExerciseAdapter(Context context, List<Exercise> data) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null){
            vi = inflater.inflate(R.layout.exercise_item, null);
        }
        TextView name = vi.findViewById(R.id.title);
        TextView description = vi.findViewById(R.id.description);
        GifImageView gifView = vi.findViewById(R.id.gifView);
        Exercise exercise = data.get(position);
        name.setText(exercise.getName());
        description.setText(exercise.getDescription());
        gifView.setImageURI(exercise.getImage());
        return vi;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public void add(Exercise exercise){
        data.add(exercise);
    }
}
