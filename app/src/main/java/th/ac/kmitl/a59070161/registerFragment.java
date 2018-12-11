package th.ac.kmitl.a59070161;


import android.content.ContentValues;
import android.content.Context;
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
import android.widget.Toast;

import th.ac.kmitl.a59070161.User.User;

public class registerFragment extends Fragment{
    private SQLiteDatabase myDB;
    private User user;

    private EditText UserID;
    private EditText Password;
    private EditText Name;
    private EditText Age;
    private Button Regist;
    private static final String TAG = "REGISTER";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myDB = getActivity().openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        user = User.getUserInstance();
        registerFragmentElements();
        initSignup();
    }
    private void registerFragmentElements() {
        UserID = getView().findViewById(R.id.RGUserID);
        Password = getView().findViewById(R.id.RGPW);
        Name = getView().findViewById(R.id.RGName);
        Age = getView().findViewById(R.id.RGAge);
        Regist = getView().findViewById(R.id.RGBotton);
    }

    private void initSignup() {
        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = UserID.getText().toString();
                String password = Password.getText().toString();
                String name = Name.getText().toString();
                String age = Age.getText().toString();
                if (username.isEmpty() || password.isEmpty() ||  name.isEmpty() || age.isEmpty()) {
                    Toast.makeText(getActivity(), "กรุณาใส่ข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6 || password.length() > 12) {
                    Toast.makeText(getActivity(), "รหัสผ่านต้องอยู่ในช่วง 6-12 ตัวอักษร", Toast.LENGTH_SHORT).show();
                } else if (username.length() < 6 || username.length() > 12) {
                    Toast.makeText(getActivity(), "User Id ต้องอยู่ในช่วง 6-12 ตัวอักษร", Toast.LENGTH_SHORT).show();
                }
                else if(age.length() != 2) {
                    Toast.makeText(getActivity(), "กรุณาใส่อายุให้ถูกต้อง", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor cursor = myDB.rawQuery("select * from usertable where username = '" + username + "'", null);
                    if (cursor.getCount() != 1) {
                        ContentValues registerAccount = new ContentValues();
                        registerAccount.put("username", username);
                        registerAccount.put("password", password);
                        myDB.insert("usertable", null, registerAccount);
                        user.setUsername(username);
                        user.setPassword(password);
                        Cursor cursorPrimaryid = myDB.rawQuery("select * from usertable where username = '" + username + "'", null);
                        while (cursorPrimaryid.moveToNext()) {
                            ContentValues registerMy = new ContentValues();
                            registerMy.put("name", name);
                            registerMy.put("age", age);
                            registerMy.put("user_id", cursorPrimaryid.getInt(0));
                            myDB.insert("my", null, registerMy);
                            user.setPrimaryid(cursorPrimaryid.getInt(0));
                            user.setName(name);
                            user.setAge(age);
                        }
                        cursorPrimaryid.close();
                        cursor.close();
                        Toast.makeText(getActivity(), "สมัครสมาชิกสำเร็จ", Toast.LENGTH_LONG).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new loginFragment()).commit();
                    } else {
                        Toast.makeText(getActivity(), "User Id ซ้ำ", Toast.LENGTH_LONG).show();
                        cursor.close();
                    }
                }
            }
        });
    }
}
