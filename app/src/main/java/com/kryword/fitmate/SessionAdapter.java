package com.kryword.fitmate;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kryword.fitmate.Models.SessionElement;

import java.util.List;

public class SessionAdapter extends BaseAdapter {
    List<SessionElement> data;
    private static LayoutInflater inflater = null;

    public SessionAdapter(Context context, List<SessionElement> data) {
        this.data = data;
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
        SessionElement session = data.get(position);
        title.setText(session.getTitle());
        description.setText(session.getDescription());
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
