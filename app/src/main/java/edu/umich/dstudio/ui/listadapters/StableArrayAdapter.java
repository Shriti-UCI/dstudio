package edu.umich.dstudio.ui.listadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import edu.umich.dstudio.R;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class StableArrayAdapter extends ArrayAdapter<ActionObject> {
    private final Context context;
    private final ActionObject[] items;

    public StableArrayAdapter(Context context, ActionObject[] itemname) {
        super(context, R.layout.listitem_homescreen, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.items=itemname;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.listitem_homescreen, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.firstLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(items[position].label);
        imageView.setImageResource(items[position].imageResourceId);
        return rowView;
    }

}
