package com.example.jeremiah.tantrum;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    public int xVariable;
    final Button leftButton = (Button) findViewById(R.id.leftButton);
    final Button rightButton = (Button) findViewById(R.id.rightButton);
    final ImageView penguin = (ImageView) findViewById(R.id.penguin);
    public Boolean shouldstop = false;



    ;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // final Button leftButton = (Button) findViewById(R.id.leftButton);
        // final Button rightButton = (Button) findViewById(R.id.rightButton);
        // final ImageView penguin = (ImageView) findViewById(R.id.penguin);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        //penguin.setX(267);
        int widthPenguin = penguin.getWidth();
        xVariable = 0;


        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                xVariable = xVariable - 5;
                penguin.setX(xVariable);

                while(leftButton.isPressed()){
                    xVariable = xVariable - 5;
                    penguin.setX(xVariable);
                }
                return true;
            }
        });

        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                switch(e.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        shouldstop = false;

                            start();

                        break;
                    case MotionEvent.ACTION_UP:
                        stop();
                        break;
                }

                return true;

            }
        });
    }

    public void start() {
        while(shouldstop != true){
            xVariable = xVariable +5;

        }
    }

    public void stop(){
        shouldstop = true;
    }
}
