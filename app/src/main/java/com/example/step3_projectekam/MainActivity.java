package com.example.step3_projectekam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private Button toSecondActivity;
    private TextView reviewTv;
    public static final int REQUESTCODE = 2999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.firstName_editText);
        lastName = findViewById(R.id.lastName_editText);
        age = findViewById(R.id.age_editText);
        toSecondActivity = findViewById(R.id.sendToSecond_button);
        reviewTv = findViewById(R.id.review_textView);

        toSecondActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String fName = firstName.getText().toString().trim();
        String lName = lastName.getText().toString().trim();
        int uAge = Integer.parseInt(age.getText().toString().trim());


        if(!fName.isEmpty() || !lName.isEmpty()){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("firstName",fName);
        intent.putExtra("lastName",lName);
        intent.putExtra("age",uAge);
        startActivityForResult(intent,REQUESTCODE);
        }
        else{
            Toast.makeText(getApplicationContext(),"Enter Details",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUESTCODE){
            assert data != null;
            String review = data.getStringExtra("comment");
            reviewTv.setText(review);
        }
    }
}
