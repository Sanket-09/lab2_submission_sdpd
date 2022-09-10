package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString()))
                {
                    display.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd)
    {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if(getString(R.string.display).equals(display.getText().toString()))
        {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
             }

    }


    public void zeroBTN(View view)
    {
        updateText("0");
    }

    public void oneBTN(View view)
    {
        updateText("1");
    }

    public void twoBTN(View view)
    {
        updateText("2");
    }

    public void threeBTN(View view)
    {
        updateText("3");
    }

    public void fourBTN(View view)
    {
        updateText("4");
    }

    public void fiveBTN(View view)
    {
        updateText("5");
    }

    public void sixBTN(View view)
    {
        updateText("6");
    }

    public void sevenBTN(View view)
    {
        updateText("7");
    }

    public void eightBTN(View view)
    {
        updateText("8");
    }

    public void nineBTN(View view)
    {
        updateText("9");
    }

    public void addBTN(View view)
    {
        updateText("+");
    }

    public void subBTN(View view)
    {
        updateText("-");
    }

    public void mulBTN(View view)
    {
        updateText("*");
    }

    public void divBTN(View view)
    {
        updateText("/");
    }

    public void delBTN(View view)
    {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen !=0 )
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void clrBTN(View view)
    {
       display.setText("");
    }

    public void pointBTN(View view)
    {
        updateText(".");
    }

    public void expBTN(View view)
    {
        updateText("^");
    }


    public void equalBTN(View view)
    {
        String userExpression = display.getText().toString();

        Expression expression = new Expression(userExpression);
        String result = String.valueOf(expression.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }














}