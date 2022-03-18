package com.example.course_project_km;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Game extends AppCompatActivity {
    Random random = new Random();
    AlertDialog.Builder dialog;
    Button answer_A, answer_B, answer_C, answer_D;
    ImageView help_friends, help_five_na_five, help_hall, timer;
    TextView question, money_number, time_number;
    String str_data;
    List<String> list = new ArrayList<>();
    List<Button> list_button = new ArrayList<>();
    int[][] mas_files = new int[6][6];
    final static String[] mas_money = {"0", "500", "1.000", "2.000", "3.000", "5.000", "10.000", "15.000", "25.000", "50.000", "100.000", "200.000", "400.000", "800.000", "1.500.000", "3.000.000"};
    int id = 1;
    int corretAns, wrongAns;
    int id_podraynds = 0;
    String last_game_info = "";
    String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        help_friends = findViewById(R.id.help_friends);
        help_five_na_five = findViewById(R.id.help_five_na_five);
        help_hall = findViewById(R.id.help_hall);
        timer = findViewById(R.id.timer);
        question = findViewById(R.id.question);
        money_number = findViewById(R.id.money_number);
        time_number = findViewById(R.id.time_number);
        answer_A = findViewById(R.id.answer_A);
        answer_B = findViewById(R.id.answer_B);
        answer_C = findViewById(R.id.answer_C);
        answer_D = findViewById(R.id.answer_D);
        list_button.add(answer_A);
        list_button.add(answer_B);
        list_button.add(answer_C);
        list_button.add(answer_D);

        Rounds();
    }

    public void help_friends_onClick(View view) {
        last_game_info += "\nПодсказка: ''Помощь друга''";
        help_friends.setImageResource(R.drawable.telephone_red);
        help_friends.setClickable(false);
        Intent intent = new Intent(Game.this, Help_friends_and_hall.class);
        intent.putExtra("id", id);
        intent.putExtra("id_podraynds", id_podraynds);
        startActivity(intent);
    }

    public void help_five_na_five_onClick(View view) {
        last_game_info += "\nПодсказка: ''50 на 50''";
        help_five_na_five.setImageResource(R.drawable.five_na_five_red);
        help_five_na_five.setClickable(false);
        int rand_five_na_five, last_rand = 5, g = 2;
        for (int i = 0; i < g; i++) {
            rand_five_na_five = random.nextInt(4);
            if (rand_five_na_five == corretAns) {
                g++;
                continue;
            }
            if (last_rand == rand_five_na_five) {
                g++;
                continue;
            }
            last_rand = rand_five_na_five;
            list_button.get(rand_five_na_five).setVisibility(View.GONE);
        }
    }

    public void help_hall_onClick(View view) {
        last_game_info += "\nПодсказка: ''Помощь зала''";
        help_hall.setImageResource(R.drawable.piople_red);
        help_hall.setClickable(false);
    }

    public void Last_game() {
        if (last_game_info == "") {
            last_game_info = "\nНи Одна из подсказок не была использована!";
        }
        Date date = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String SaveProgress = "Имя игрока: GGG\nДата проведения игры: " + dateFormat.format(date) + "\nВремя проведения игры: " + timeFormat.format(date) + "\nДошёл до: Раунда " + id + "\nМаксимальный выигрышь: " + money + "\nИспользованыые подсказки: " + last_game_info + "\n";
        try {
            FileOutputStream save = openFileOutput("save.txt", MODE_PRIVATE);
            save.write(SaveProgress.getBytes());
            save.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit_onClick(View view) {
        Last_game();
        finish();
    }

    public void Rounds() {
        id_podraynds = random.nextInt(5) + 1;
        Log.d("ID Podraynds", String.valueOf(id_podraynds));
        list.clear();
        Working_with_files();
        money = mas_money[id] + "РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Correct_answer() {
        list_button.get(corretAns).setBackgroundColor(getColor(R.color.correct_answer));
        dialog = new AlertDialog.Builder(Game.this);
        dialog.setTitle("Раунд " + id);
        dialog.setIcon(R.drawable.ic_baseline_check_24);
        dialog.setMessage("Правильно!\nБаланс: " + money);
        dialog.setCancelable(false);
        dialog.setPositiveButton("Ок", (v, dialog) -> {
            v.cancel();
            id++;
            Rounds();
        });
        dialog.show();
    }

    public void Wrong_answer() {
        Last_game();
        list_button.get(wrongAns).setBackgroundColor(getColor(R.color.wrong_answer));
        dialog = new AlertDialog.Builder(Game.this);
        dialog.setTitle("Раунд " + id);
        dialog.setIcon(R.drawable.ic_baseline_close_24);
        dialog.setMessage("Неправильно!");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Ок", (v, dialog) -> finish());
        dialog.show();
    }

    public void Question_file() {
        mas_files[1][0] = 1;
        mas_files[1][1] = 3;
        mas_files[1][2] = 4;
        mas_files[1][3] = 5;
        mas_files[1][4] = 6;
        mas_files[1][5] = 2;
        for (int i = 2; i <= 5; i++) {
            mas_files[i][0] = mas_files[i - 1][0] + 7;
            mas_files[i][1] = mas_files[i - 1][1] + 7;
            mas_files[i][2] = mas_files[i - 1][2] + 7;
            mas_files[i][3] = mas_files[i - 1][3] + 7;
            mas_files[i][4] = mas_files[i - 1][4] + 7;
            mas_files[i][5] = mas_files[i - 1][5] + 7;
        }
        question.setText(list.get(mas_files[id_podraynds][0]));
        answer_A.setText(list.get(mas_files[id_podraynds][1]));
        answer_B.setText(list.get(mas_files[id_podraynds][2]));
        answer_C.setText(list.get(mas_files[id_podraynds][3]));
        answer_D.setText(list.get(mas_files[id_podraynds][4]));
        corretAns = Integer.parseInt(list.get(mas_files[id_podraynds][5]));
    }

    public void Check_Answer(int idx) {
        if (idx == corretAns) {
            Correct_answer();
        } else {
            wrongAns = idx;
            Wrong_answer();
        }
    }

    public void on_answer_A_clicked(View view) {
        Check_Answer(0);
    }

    public void on_answer_B_clicked(View view) {
        Check_Answer(1);
    }

    public void on_answer_C_clicked(View view) {
        Check_Answer(2);
    }

    public void on_answer_D_clicked(View view) {
        Check_Answer(3);
    }

    public void Personalizing_buttons() {
        answer_A.setBackgroundColor(getColor(R.color.game_button));
        answer_B.setBackgroundColor(getColor(R.color.game_button));
        answer_C.setBackgroundColor(getColor(R.color.game_button));
        answer_D.setBackgroundColor(getColor(R.color.game_button));
        for (int i = 0; i < 4; i++) {
            list_button.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void Working_with_files() {
        str_data = gg();
        InSave();
        OutSave();
    }

    public String gg() {
        String text = "rounds_" + id + ".txt";
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
            FileOutputStream FileSave = openFileOutput("rounds_" + id + "_COP.txt", MODE_PRIVATE);
            FileSave.write(str_data.getBytes());
            FileSave.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OutSave() {
        try {
            FileInputStream FileSave = openFileInput("rounds_" + id + "_COP.txt");
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