package com.example.step3_projectekam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView firstName;
    private TextView lastName;
    private TextView age;
    private EditText comment;
    private Button sendToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firstName = findViewById(R.id.setFirstName_textView);
        lastName = findViewById(R.id.setLastName_textView);
        age = findViewById(R.id.setAgeName_textView);
        comment = findViewById(R.id.comment_editText);
        sendToMain = findViewById(R.id.sendToMain_button);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            firstName.setText(bundle.getString("firstName"));
            lastName.setText(bundle.getString("lastName"));
            age.setText(String.valueOf(bundle.getInt("age")));
            Log.d("GETDATA", "onCreate: "+ bundle.getString("firstName")+","+bundle.getString("lastName")+", "+bundle.getInt("age"));
        }

        sendToMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String newComment = comment.getText().toString().trim();
        if(!newComment.isEmpty()){


        Intent intent = getIntent();
        intent.putExtra("comment",newComment);
        setResult(RESULT_OK,intent);
        finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Do Comment.", Toast.LENGTH_SHORT).show();
        }
    }
}
