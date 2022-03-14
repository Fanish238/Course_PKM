package com.example.course_project_km;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {
    Random random = new Random();
    AlertDialog.Builder dialog;
    Button answer_A, answer_B, answer_C, answer_D;
    ImageView help_friends, help_five_na_five, help_hall, timer;
    TextView question, money_number, time_number;
    String str_data;
    List<String> list = new ArrayList<String>();
    int[][] mas_files = new int[6][5];
    int id = 1;
    int corretAns;
    int id_podraynds = 0;
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

        Rounds();
    }

    public void help_friends_onClick(View view) {
        help_friends.setImageResource(R.drawable.telephone_red);
        //   Log.d("Логи","Кнопка нажата");
        help_friends.setClickable(false);
    }

    public void help_five_na_five_onClick(View view) {
        help_five_na_five.setImageResource(R.drawable.five_na_five_red);
        help_five_na_five.setClickable(false);
    }

    public void help_hall_onClick(View view) {
        help_hall.setImageResource(R.drawable.piople_red);
        help_hall.setClickable(false);
    }

    public void exit_onClick(View view) {
        finish();
    }

    public void Rounds() {
        id_podraynds = random.nextInt(5) + 1;
        Log.d("ID Podraynds", String.valueOf(id_podraynds));
        list.clear();
        Working_with_files();
        switch (id) {
            case 1:
                Round_1_Question_and_Answer();
                break;
            case 2:
                Round_2_Question_and_Answer();
                break;
            case 3:
                Round_3_Question_and_Answer();
                break;
            case 4:
                Round_4_Question_and_Answer();
                break;
            case 5:
                Round_5_Question_and_Answer();
                break;
            case 6:
                Round_6_Question_and_Answer();
                break;
            case 7:
                Round_7_Question_and_Answer();
                break;
            case 8:
                Round_8_Question_and_Answer();
                break;
            case 9:
                Round_9_Question_and_Answer();
                break;
            case 10:
                Round_10_Question_and_Answer();
                break;
            case 11:
                Round_11_Question_and_Answer();
                break;
            case 12:
                Round_12_Question_and_Answer();
                break;
            case 13:
                Round_13_Question_and_Answer();
                break;
            case 14:
                Round_14_Question_and_Answer();
                break;
            case 15:
                Round_15_Question_and_Answer();
                break;

        }

    }

    public void Correct_answer() {
        dialog = new AlertDialog.Builder(Game.this);
        dialog.setTitle("Раунд 1");
        dialog.setIcon(R.drawable.round_1);
        dialog.setMessage("Правильно!\nБаланс: " + 500);
        dialog.setPositiveButton("Ок", (v, dialog) -> {
            v.cancel();
            id++;
            Rounds();
        });
        dialog.show();
    }

    public void Wrong_answer() {
        dialog = new AlertDialog.Builder(Game.this);
        dialog.setTitle("Раунд 1");
        dialog.setIcon(R.drawable.round_1);
        dialog.setMessage("Неправильно!");
        dialog.setPositiveButton("Ок", (v, dialog) -> finish());
        dialog.show();
    }

    public void Question_file() {
        mas_files[1][0] = 1;
        mas_files[1][1] = 3;
        mas_files[1][2] = 4;
        mas_files[1][3] = 5;
        mas_files[1][4] = 6;
        for (int i = 2; i <= 5; i++) {
            mas_files[i][0] = mas_files[i - 1][0] + 7;
            mas_files[i][1] = mas_files[i - 1][1] + 7;
            mas_files[i][2] = mas_files[i - 1][2] + 7;
            mas_files[i][3] = mas_files[i - 1][3] + 7;
            mas_files[i][4] = mas_files[i - 1][4] + 7;
        }
        question.setText(list.get(mas_files[id_podraynds][0]));
        answer_A.setText(list.get(mas_files[id_podraynds][1]));
        answer_B.setText(list.get(mas_files[id_podraynds][2]));
        answer_C.setText(list.get(mas_files[id_podraynds][3]));
        answer_D.setText(list.get(mas_files[id_podraynds][4]));
        Answers answers;
        List<Answers> list_ans = new ArrayList();
        list_ans.add(new Answers(0, 2, 1, 1, 3));
        list_ans.add(new Answers(0, 2, 1, 1, 3));
        list_ans.add(new Answers(2, 0, 0, 0, 2));
        answers = list_ans.get(id);
        corretAns = answers.mas_ans[id_podraynds];
    }

    public void Check_Answer(int idx) {
        if (idx == corretAns) {
            Correct_answer();
        } else {
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

        String str_data = new String(buffer);
        return str_data;
    }

    public void InSave() {
        try {
            FileOutputStream FileSave = openFileOutput("rounds_" + id + "_COP.txt", MODE_PRIVATE);
            FileSave.write(str_data.getBytes());
            FileSave.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OutSave() {
        try {
            FileInputStream FileSave = openFileInput("rounds_" + id + "_COP.txt");
            InputStreamReader reader = new InputStreamReader(FileSave);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer strBuffer = new StringBuffer();
            String lines;
            while ((lines = buffer.readLine()) != null) {
                strBuffer.append(lines);
                list.add(lines);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Personalizing_buttons() {
        answer_A.setBackgroundColor(getColor(R.color.game_button));
        answer_B.setBackgroundColor(getColor(R.color.game_button));
        answer_C.setBackgroundColor(getColor(R.color.game_button));
        answer_D.setBackgroundColor(getColor(R.color.game_button));
    }

    public void Round_1_Question_and_Answer() {
        money = "500РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_2_Question_and_Answer() {
        money = "1.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_3_Question_and_Answer() {
        money = "2.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_4_Question_and_Answer() {
        money = "3.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_5_Question_and_Answer() {
        money = "5.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_6_Question_and_Answer() {
        money = "10.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_7_Question_and_Answer() {
        money = "15.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_8_Question_and_Answer() {
        money = "25.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_9_Question_and_Answer() {
        money = "50.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_10_Question_and_Answer() {
        money = "100.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_11_Question_and_Answer() {
        money = "200.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_12_Question_and_Answer() {
        money = "400.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_13_Question_and_Answer() {
        money = "800.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_14_Question_and_Answer() {
        money = "1.500.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

    public void Round_15_Question_and_Answer() {
        money = "3.000.000РУБ";
        money_number.setText(money);
        Question_file();
        Personalizing_buttons();
    }

}