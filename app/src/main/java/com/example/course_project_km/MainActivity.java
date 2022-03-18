package com.example.course_project_km;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button button_game, button_info_old_games, button_setting, button_info_games, button_reference, button_exit;
    AlertDialog.Builder dialog;
    String SaveUser = "Тут пусто";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_game = findViewById(R.id.button_game);
        button_info_old_games = findViewById(R.id.info_old_games);
        button_setting = findViewById(R.id.setting);
        button_info_games = findViewById(R.id.info_games);
        button_reference = findViewById(R.id.sprayka);
        button_exit = findViewById(R.id.exit);
    }

    public void button_game_onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Game.class);
        startActivity(intent);
    }

    public void button_info_old_games_onClick(View view) {
        OutSave();
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.drawable.ic_baseline_info_24);
        dialog.setTitle("Информация о последних играх");
        dialog.setMessage(SaveUser);
        dialog.setCancelable(false);
        dialog.setPositiveButton("Закрыть", (v, dialog) -> v.cancel());
        dialog.setNegativeButton("Очистка", (v, dialog) -> {
            try {
                FileOutputStream save = openFileOutput("save.txt", MODE_PRIVATE);
                save.write("Тут пусто!".getBytes());
                save.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        dialog.show();
    }

    public void button_setting_onClick(View view) {
        Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
    }

    public void button_info_games_onClick(View view) {
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.drawable.ic_baseline_info_24);
        dialog.setTitle("Об игре");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Закрыть", (v, dialog) -> v.cancel());
        dialog.setMessage(R.string.ob_games);
        dialog.show();
    }

    public void button_reference_onClick(View view) {
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.drawable.ic_baseline_info_24);
        dialog.setTitle("Справка");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Закрыть", (v, dialog) -> v.cancel());
        dialog.setMessage(R.string.sprayka_text);
        dialog.show();
    }

    public void OutSave() {
        SaveUser = "";
        try {
            FileInputStream FileSave = openFileInput("save.txt");
            InputStreamReader reader = new InputStreamReader(FileSave);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder strBuffer = new StringBuilder();
            String lines;
            while ((lines = buffer.readLine()) != null) {
                SaveUser = strBuffer.append(lines + "\n") + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void button_exit_onClick(View view) {
        System.exit(0);
    }
}