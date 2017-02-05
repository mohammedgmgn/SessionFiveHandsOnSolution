package mohammed.sessionfivehandson;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void openFirstActivity(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + ".my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("UserNameKey");
        editor.apply();	// Or commit()

     finish();
    }

}
