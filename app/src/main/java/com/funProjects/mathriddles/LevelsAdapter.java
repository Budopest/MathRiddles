package com.funProjects.mathriddles;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class LevelsAdapter extends ArrayAdapter<Level> {
    public LevelsAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        // Check if the existing view is being reused, otherwise inflate the view
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.levels_list_item, parent, false);
        }
        // Get the {@link Level} object located at this position in the list
        Level currentlevel = getItem(position);

        //get and set the views for the current list item
        final TextView levelNumber = (TextView) listItemView.findViewById(R.id.levelNumberText);
        levelNumber.setText("LEVEL "+currentlevel.getLevelNumber());
        TextView levelstatus = (TextView) listItemView.findViewById(R.id.levelStatusText);
        levelstatus.setText(currentlevel.getStatus()==0 ? "UNSOLVED" : "SOLVED");

        final Context context = getContext();
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context,levelNumber.getText()+context.toString(),Toast.LENGTH_SHORT);
                toast.show();
                Intent Level = new Intent(context,LevelActivity.class);
                context.startActivity(Level);
            }
        });

        return listItemView;

    }
}
