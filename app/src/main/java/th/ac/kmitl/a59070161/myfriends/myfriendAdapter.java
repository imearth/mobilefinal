package th.ac.kmitl.a59070161.myfriends;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import th.ac.kmitl.a59070161.R;

public class myfriendAdapter extends ArrayAdapter<myfriend> {
    List<myfriend> postList = new ArrayList<myfriend>();
    Context context;

    public  myfriendAdapter  (Context context, int resource, List<myfriend> objects) {
        super(context, resource, objects);
        this.postList = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View postItem = LayoutInflater.from(context).inflate(R.layout.fragment_myfriend_item, parent, false);

        TextView id = postItem.findViewById(R.id.myfriend_item_id);
        TextView email = postItem.findViewById(R.id.myfriend_item_email);
        TextView phone = postItem.findViewById(R.id.myfriend_item_phone);
        TextView website = postItem.findViewById(R.id.myfriend_item_website);

        myfriend row = postList.get(position);
        id.setText(row.getId() + " : " + row.getTitle());
        email.setText(row.getEmail());
        phone.setText(row.getPhone());
        website.setText(row.getWebsite());

        return postItem;
    }
}
