package com.example.trivia_questions_game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Game_Activity extends AppCompatActivity{
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;

    private RadioButton radioButton;
    private int question_num = 0;
    private int score = 0;

    private Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textViewQuestion.setText(questions.getQuestion(0).getTextQuestion());
        rb1.setText(questions.getQuestion(0).getAnswer1());
        rb2.setText(questions.getQuestion(0).getAnswer2());
        rb3.setText(questions.getQuestion(0).getAnswer3());
        rb4.setText(questions.getQuestion(0).getAnswer4());

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rbGroup.getCheckedRadioButtonId();
                if(selectedId == -1){
                    Toast.makeText(Game_Activity.this, "You have to choose answer",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    radioButton = findViewById(selectedId);
                    if (question_num >= 9)
                        question_num = 9;
                    if(radioButton.getText().equals(questions.getQuestion(question_num).getCorrectAnswer())){
                        Toast.makeText(Game_Activity.this, "Correct",Toast.LENGTH_SHORT).show();
                        score = score + 10;
                        textViewScore.setText("Score: " + String.valueOf(score));
                    }
                    else{
                        Toast.makeText(Game_Activity.this, "NOT Correct",Toast.LENGTH_SHORT).show();
                    }
                }
                if(question_num < 9)
                    nextQuestion(question_num);
                if(question_num == 9)
                    gameOver();
                question_num++;
            }
        });
    }

    private void nextQuestion(int i){
            textViewQuestion.setText(questions.getQuestion(i + 1).getTextQuestion());
            rb1.setText(questions.getQuestion(i + 1).getAnswer1());
            rb2.setText(questions.getQuestion(i + 1).getAnswer2());
            rb3.setText(questions.getQuestion(i + 1).getAnswer3());
            rb4.setText(questions.getQuestion(i + 1).getAnswer4());
            textViewQuestionCount.setText("Question: " + String.valueOf(i + 2) + "/10");
    }

    private void gameOver() {
        new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage("Your Score is: " + String.valueOf(score))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Game_Activity.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .show();
    }
}
