package th.ac.kmitl.a59070161.myfriends;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import th.ac.kmitl.a59070161.R;
//import th.ac.kmitl.a59070161.myfriends.myfriendFragment;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/*
public class myfriendFragment extends Fragment {

    private static final String TAG = "POST";

    private final String url = "https://jsonplaceholder.typicode.com/posts";

    private ArrayList<myfriend> myfriendArrayList = new ArrayList<>();
    private ListView myfriendList;
    private myfriendAdapter myfriendAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_myfriend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initBackBtn();

        myfriendList = getView().findViewById(R.id.fragment_myfriend_list);
        myfriendAdapter = new myfriendAdapter(getActivity(), R.layout.fragment_myfriend_item, myfriendArrayList);

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(getActivity(), "error - " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    try {
                        final JSONArray jsonArray = new JSONArray(response.body().string());
                        Log.d(TAG, "JSON ARRAY SIZE : " + jsonArray.length());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    try {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        Log.d(TAG, jsonObject.getString("title"));
                                        //myfriend post = new myfriend(jsonObject.getInt("id"), jsonObject.getString("name"), jsonObject.getString("email"));
                                        //myfriendArrayList.add(myfriend);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                myfriendAdapter.notifyDataSetChanged();
                                myfriendList.setAdapter(myfriendAdapter);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
        /*
        postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myfriend post = (myfriend) parent.getAdapter().getItem(position);
                Fragment fragment = new CommentFragment();
                Bundle bundle = new Bundle();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
                bundle.putInt("postid", post.getId());
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main_view, fragment);
                fragmentTransaction.commit();
            }
        });

    }


    private void initBackBtn() {
        Button back = getView().findViewById(R.id.backbot);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

}
*/