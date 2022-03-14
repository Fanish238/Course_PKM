package com.example.course_project_km;

public class Answers {
    int id_ans_one, id_ans_two, id_ans_three, id_ans_four, id_ans_five;
    int[] mas_ans;

    public Answers(int id_ans_one, int id_ans_two, int id_ans_three, int id_ans_four, int id_ans_five) {
        this.id_ans_one = id_ans_one;
        this.id_ans_two = id_ans_two;
        this.id_ans_three = id_ans_three;
        this.id_ans_four = id_ans_four;
        this.id_ans_five = id_ans_five;
        mas_ans = new int[]{0, id_ans_one, id_ans_two, id_ans_three, id_ans_four, id_ans_five};
    }
}
