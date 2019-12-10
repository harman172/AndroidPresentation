package com.example.gestures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView imageView;
    TextView textView, tvMove;
    private float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        tvMove = findViewById(R.id.tv_move);

        imageView = findViewById(R.id.imageView);


        imageView.setOnTouchListener(this);
        tvMove.setOnTouchListener(this);


    }

    public void clickImage(View view){

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch(motionEvent.getAction()){

            case (MotionEvent.ACTION_UP):

                if (view.getId() == R.id.imageView){
                    imageView.setImageResource(R.drawable.icon01_29);
                    textView.setText("Touch ActionUp is called");
                    return true;
                } else{

                    return true;
                }


            case MotionEvent.ACTION_DOWN:
                imageView.setImageResource(0);
                textView.setText("Touch ActionDown is called");
                Intent intent = new Intent(this, GesturesDetector.class);
                startActivity(intent);
                return true;

            case MotionEvent.ACTION_MOVE:

                if (view.getId() == R.id.tv_move){
                    x = motionEvent.getX() + tvMove.getX();
                    y = motionEvent.getY() + tvMove.getY();

                    tvMove.setX(x);
                    tvMove.setY(y);

                    textView.setText("X: " + motionEvent.getX() +", Y: " + motionEvent.getY());

                }
                return true;
        }

        return false;
    }
}
