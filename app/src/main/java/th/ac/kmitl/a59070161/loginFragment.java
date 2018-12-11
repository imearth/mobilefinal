package th.ac.kmitl.a59070161;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import th.ac.kmitl.a59070161.User.User;

public class loginFragment extends Fragment {

    private static final String TAG = "LOGIN";
    private static final String isLogin = "loginStatus";
    private SharedPreferences loginCheck;
    private SharedPreferences.Editor loginChange;

    private SQLiteDatabase myDB;
    private User user;

    private EditText Username;
    private EditText Password;
    private Button Signin;
    private TextView Signup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        user = User.getUserInstance();
        myDB = getActivity().openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        loginFragmentElements();
        initSignup();
        initSignin();
    }
    private void loginFragmentElements() {
        Log.d(TAG, "Get Elements");
        Username = getView().findViewById(R.id.UserID);
        Password = getView().findViewById(R.id.PW);
        Signin = getView().findViewById(R.id.loginbutton);
        Signup = getView().findViewById(R.id.registbutton);
    }

    private void initSignup() {
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Signup : clicked");
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new registerFragment()).addToBackStack(null).commit();
            }
        });
    }

    private void initSignin() {
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(), "กรุณาใส่ข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor loginCursorCheck = myDB.rawQuery("select * from usertable where username = '" + username + "' and password = '" + password + "'", null);
                    if (loginCursorCheck.getCount() > 0) {
                        loginCursorCheck.move(1);
                        user.setPrimaryid(loginCursorCheck.getInt(0));
                        user.setUsername(loginCursorCheck.getString(1));
                        user.setPassword(loginCursorCheck.getString(2));
                        /*
                        Cursor myCheck = myDB.rawQuery("select * from my where user_id = '" + user.getPrimaryid() + "'", null);

                        if (myCheck.getCount() > 0) {
                            myCheck.move(1);
                            user.setName(myCheck.getString(1));
                            user.setAge(myCheck.getString(2));
                            myCheck.close();
                            loginCursorCheck.close();
                            loginCheck = getActivity().getSharedPreferences(isLogin, Context.MODE_PRIVATE);
                            loginChange = loginCheck.edit();
                            loginChange.putString("userId", String.valueOf(user.getPrimaryid()));
                            loginChange.putBoolean("isLogin", true);
                            loginChange.commit();
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new homeFragment()).commit();
                        }
                        */
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new homeFragment()).commit();
                    } else {
                        Toast.makeText(getActivity(), "ไม่พบข้อมูลผู้ใช้", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}