package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPrefActivity extends AppCompatActivity {
    SharedPreferences myPreferenceRef;
    SharedPreferences.Editor  myPreferenceEditor;
    EditText newPrefText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        myPreferenceRef = getSharedPreferences("MyAppPreferenceString", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        Button button = findViewById(R.id.goBackButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePref(view);
                Intent intent = new Intent(SharedPrefActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

/*
        //myPreferenceRef = getPreferences(MODE_PRIVATE);
        //myPreferenceEditor = myPreferenceRef.edit();

        newPrefText=new EditText(this);
        newPrefText=(EditText)findViewById(R.id.editText);
        myPreferenceEditor.putString("MyAppPreferenceString", newPrefText.getText().toString());
        myPreferenceEditor.apply();

        // Display the new preference
        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.testText);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));

        // Clear the EditText
        newPrefText.setText("");
        */

    }

    public void savePref(View v){
        // Get the text
        //EditText newPrefText=new EditText(this);
        newPrefText=(EditText)findViewById(R.id.editText);

        // Store the new preference
        myPreferenceEditor.putString("MyAppPreferenceString", newPrefText.getText().toString());
        myPreferenceEditor.apply();

        // Display the new preference
        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.testText);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));

        // Clear the EditText
        newPrefText.setText("");
    }
}