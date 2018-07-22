package com.kryword.fitmate;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kryword.fitmate.Models.SessionPlan;

import java.util.List;

public class SessionAdapter extends BaseAdapter {
    List<SessionPlan> data;
    private static LayoutInflater inflater = null;
    Context context;

    public SessionAdapter(Context context, List<SessionPlan> data) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null){
            vi = inflater.inflate(R.layout.session_item, null);
        }
        TextView title = vi.findViewById(R.id.title);
        TextView description = vi.findViewById(R.id.description);
        TextView nrExercises = vi.findViewById(R.id.nr_exercises);
        SessionPlan session = data.get(position);
        title.setText(session.getTitle());
        description.setText(session.getDescription());
        nrExercises.setText(context.getString(R.string.nr_exercises) + ": " + session.getExercises().size());
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
}
