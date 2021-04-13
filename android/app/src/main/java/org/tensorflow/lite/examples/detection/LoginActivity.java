package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button goBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        goBtn = findViewById(R.id.register);
        goBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"로그인 되었습니다.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}