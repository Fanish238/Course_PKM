package com.example.course_project_km;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Help_friends_and_hall extends AppCompatActivity {
    TextView OneFriends, TwoFriends, ThreeFriends;
    int id, id_podraynds;
    List<String> list = new ArrayList<>();
    String str_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_friends_and_hall);
        OneFriends = findViewById(R.id.OneFriends);
        TwoFriends = findViewById(R.id.TwoFriends);
        ThreeFriends = findViewById(R.id.ThreeFriends);
        id = getIntent().getIntExtra("id", 0);
        id_podraynds = getIntent().getIntExtra("id_podraynds", 0);
        Working_with_files();
        OneFriends.setText(list.get(0));
        TwoFriends.setText(list.get(7));
        ThreeFriends.setText(list.get(14));
    }

    public void Working_with_files() {
        str_data = gg();
        InSave();
        OutSave();
    }

    public String gg() {
        String text = "help_friends_rounds_" + id + ".txt";
        byte[] buffer = null;
        InputStream is;
        try {
            is = getAssets().open(text);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(buffer);
    }

    public void InSave() {
        try {
            FileOutputStream FileSave = openFileOutput("help_friends_rounds_" + id + "_COP.txt", MODE_PRIVATE);
            FileSave.write(str_data.getBytes());
            FileSave.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OutSave() {
        try {
            FileInputStream FileSave = openFileInput("help_friends_rounds_" + id + "_COP.txt");
            InputStreamReader reader = new InputStreamReader(FileSave);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder strBuffer = new StringBuilder();
            String lines;
            while ((lines = buffer.readLine()) != null) {
                strBuffer.append(lines);
                list.add(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}