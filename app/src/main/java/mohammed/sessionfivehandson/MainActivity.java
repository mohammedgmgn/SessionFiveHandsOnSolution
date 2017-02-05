package mohammed.sessionfivehandson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button login;
 private EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + ".my_pref_file", Context.MODE_PRIVATE);
        String user=sharedPreferences.getString("UserNameKey","null");
        if(!user.equals("null")){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
        login=(Button)findViewById(R.id.btnlogin);
        username=(EditText)findViewById(R.id.etname);
        password=(EditText)findViewById(R.id.etpassword);
    }
    public void openSecondActivity(View view) {
    if(username.getText().toString().isEmpty()||password.getText().toString().isEmpty())
    {
        Toast.makeText(MainActivity.this,"Enter your username and password",Toast.LENGTH_SHORT).show();
    }
    else if(!username.getText().toString().equals("support")||!password.getText().toString().equals("12345"))
    {
        Toast.makeText(MainActivity.this," your username or password not correct",Toast.LENGTH_SHORT).show();
    }
     else
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + ".my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserNameKey", username.getText().toString());
        editor.apply(); // editor.commit()
        Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    }

}
