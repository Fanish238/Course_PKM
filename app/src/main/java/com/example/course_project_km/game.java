package com.example.course_project_km;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
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

public class game extends AppCompatActivity {
    Random random = new Random();
    Button answer_A, answer_B, answer_C, answer_D;
    ImageView help_friends, help_five_na_five, help_hall, timer;
    TextView question, money_number, time_number;
    String str_data;
    List<String> list = new ArrayList<String>();
    int id = 1;
    int id_podraynds = 0;
    int time = 21000;
    String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        help_friends = (ImageView) findViewById(R.id.help_friends);
        help_five_na_five = (ImageView) findViewById(R.id.help_five_na_five);
        help_hall = (ImageView) findViewById(R.id.help_hall);
        timer = (ImageView) findViewById(R.id.timer);
        question = (TextView) findViewById(R.id.question);
        money_number = (TextView) findViewById(R.id.money_number);
        time_number = (TextView) findViewById(R.id.time_number);
        answer_A = (Button) findViewById(R.id.answer_A);
        answer_B = (Button) findViewById(R.id.answer_B);
        answer_C = (Button) findViewById(R.id.answer_C);
        answer_D = (Button) findViewById(R.id.answer_D);

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
        Toast.makeText(game.this, "Правильно!", Toast.LENGTH_SHORT).show();
        id++;
        Rounds();
    }

    public void Wrong_answer() {
        Toast.makeText(game.this, "Неправильно", Toast.LENGTH_SHORT).show();
    }

    public void Question_file() {
        switch (id_podraynds) {
            case 1:
                question.setText(list.get(1) + '\n' + list.get(2) + '\n' + list.get(3));
                answer_A.setText(list.get(4));
                answer_B.setText(list.get(5));
                answer_C.setText(list.get(6));
                answer_D.setText(list.get(7));
                break;
            case 2:
                question.setText(list.get(9) + '\n' + list.get(10) + '\n' + list.get(11));
                answer_A.setText(list.get(12));
                answer_B.setText(list.get(13));
                answer_C.setText(list.get(14));
                answer_D.setText(list.get(15));
                break;
            case 3:
                question.setText(list.get(17) + '\n' + list.get(18) + '\n' + list.get(19));
                answer_A.setText(list.get(20));
                answer_B.setText(list.get(21));
                answer_C.setText(list.get(22));
                answer_D.setText(list.get(23));
                break;
            case 4:
                question.setText(list.get(25) + '\n' + list.get(26) + '\n' + list.get(27));
                answer_A.setText(list.get(28));
                answer_B.setText(list.get(29));
                answer_C.setText(list.get(30));
                answer_D.setText(list.get(31));
                break;
            case 5:
                question.setText(list.get(33) + '\n' + list.get(34) + '\n' + list.get(35));
                answer_A.setText(list.get(36));
                answer_B.setText(list.get(37));
                answer_C.setText(list.get(38));
                answer_D.setText(list.get(39));
                break;
        }
    }

    public void on_answer_A_clicked(View view) {
        switch (id) {
            case 1:
                switch (id_podraynds) {
                    case 1:
                        answer_A.setBackgroundColor(getColor(R.color.correct_answer));
                        Correct_answer();
                        break;
                    case 2:
                        answer_A.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 3:
                        answer_A.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 4:
                        answer_A.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 5:
                        answer_A.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                }
                break;
        }
    }

    public void on_answer_B_clicked(View view) {
        switch (id) {
            case 1:
                switch (id_podraynds) {
                    case 1:
                        answer_B.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 2:
                        answer_B.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 3:
                        answer_B.setBackgroundColor(getColor(R.color.correct_answer));
                        Correct_answer();
                        break;
                    case 4:
                        answer_B.setBackgroundColor(getColor(R.color.correct_answer));
                        Correct_answer();
                        break;
                    case 5:
                        answer_B.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                }
                break;
        }
    }

    public void on_answer_C_clicked(View view) {
        switch (id) {
            case 1:
                switch (id_podraynds) {
                    case 1:
                        answer_C.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 2:
                        answer_C.setBackgroundColor(getColor(R.color.correct_answer));
                        Correct_answer();
                        break;
                    case 3:
                        answer_C.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 4:
                        answer_C.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 5:
                        answer_C.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                }
                break;
        }
    }

    public void on_answer_D_clicked(View view) {
        switch (id) {
            case 1:
                switch (id_podraynds) {
                    case 1:
                        answer_D.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 2:
                        answer_D.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 3:
                        answer_D.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 4:
                        answer_D.setBackgroundColor(getColor(R.color.wrong_answer));
                        Wrong_answer();
                        break;
                    case 5:
                        answer_D.setBackgroundColor(getColor(R.color.correct_answer));
                        Correct_answer();
                        break;
                }
                break;
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

    public void Timer() {
        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                time_number.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                time_number.setText("0");
                Toast.makeText(game.this, "Время вышло!", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    public void Personalizing_buttons() {
        answer_A.setBackgroundColor(getColor(R.color.game_button));
        answer_B.setBackgroundColor(getColor(R.color.game_button));
        answer_C.setBackgroundColor(getColor(R.color.game_button));
        answer_D.setBackgroundColor(getColor(R.color.game_button));
    }

    public void Round_1_Question_and_Answer() {
        time = 21000;
        money = "500РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_2_Question_and_Answer() {
        time = 21000;
        money = "1.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_3_Question_and_Answer() {
        time = 21000;
        money = "2.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_4_Question_and_Answer() {
        time = 21000;
        money = "3.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_5_Question_and_Answer() {
        time = 21000;
        money = "5.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_6_Question_and_Answer() {
        time = 31000;
        money = "10.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_7_Question_and_Answer() {
        time = 31000;
        money = "15.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_8_Question_and_Answer() {
        time = 31000;
        money = "25.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_9_Question_and_Answer() {
        time = 31000;
        money = "50.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_10_Question_and_Answer() {
        time = 31000;
        money = "100.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_11_Question_and_Answer() {
        time = 41000;
        money = "200.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_12_Question_and_Answer() {
        time = 41000;
        money = "400.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_13_Question_and_Answer() {
        time = 41000;
        money = "800.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_14_Question_and_Answer() {
        time = 41000;
        money = "1.500.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

    public void Round_15_Question_and_Answer() {
        time = 41000;
        money = "3.000.000РУБ";
        money_number.setText(money);
        Timer();
        Question_file();
        Personalizing_buttons();
    }

}