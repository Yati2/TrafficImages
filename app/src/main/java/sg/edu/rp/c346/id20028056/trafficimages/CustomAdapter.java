package sg.edu.rp.c346.id20028056.trafficimages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Traffic> tafficList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);

        this.parent_context =context;
        layout_id=resource;
        this.tafficList =objects;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView area=rowView.findViewById(R.id.tvArea);
        ImageView image=rowView.findViewById(R.id.imageView);

        // Obtain the Android Version information based on the position
        Traffic traffic = tafficList.get(position);

        // Set values to the TextView to display the corresponding information
        area.setText(traffic.getArea());
        String imageUrl=traffic.getImageURL();
        Picasso.with(parent_context).load(imageUrl).into(image);
        return rowView;
    }

}
