package com.example.course_project_km;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_game, button_info_old_games, button_setting, button_info_games, button_sprayka, button_exit;
    AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_game = (Button) findViewById(R.id.button_game);
        button_info_old_games = (Button) findViewById(R.id.info_old_games);
        button_setting = (Button) findViewById(R.id.setting);
        button_info_games = (Button) findViewById(R.id.info_games);
        button_sprayka = (Button) findViewById(R.id.sprayka);
        button_exit = (Button) findViewById(R.id.exit);
    }

    public void button_game_onClick(View view) {
        Intent intent = new Intent(MainActivity.this, game.class);
        startActivity(intent);
    }

    public void button_info_old_games_onClick(View view) {
        Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
    }

    public void button_setting_onClick(View view) {
        Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
    }

    public void button_info_games_onClick(View view){
        ob_games();
    }

    public void button_sprayka_onClick(View view) {
        Log.d("Сообщение", "Кнопка нажата");
        sprayka_messeng();
    }

    public void button_exit_onClick(View view) {

        System.exit(0);
    }

    public void sprayka_messeng(){
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.drawable.lagatip);
        dialog.setTitle("Справка");
        dialog.setMessage(R.string.sprayka_text);
        dialog.show();
    }

    public void ob_games(){
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.drawable.lagatip);
        dialog.setTitle("Об игре");
        dialog.setMessage(R.string.ob_games);
        dialog.show();
    }
}