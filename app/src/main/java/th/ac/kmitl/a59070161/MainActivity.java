package th.ac.kmitl.a59070161;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String isLogin = "loginStatus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Database
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS usertable (id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(200), password VARCHAR(200))");
        myDB.execSQL("CREATE TABLE IF NOT EXISTS my (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200),user_id INTEGER,age VARCHAR(200))");
        SharedPreferences loginCheck = MainActivity.this.getSharedPreferences(isLogin, Context.MODE_PRIVATE);
        Boolean isLogin = loginCheck.getBoolean("isLogin", false);
        if(isLogin) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new homeFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new loginFragment()).commit();
        }
    }
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }
}