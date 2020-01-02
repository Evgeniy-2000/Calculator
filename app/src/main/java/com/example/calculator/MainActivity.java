package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String str = "";
    String[] operands = new String[]{"+","-","*","/","*"};
    String[] functions = new String[]{"sin","cos","tg","ln","lg","sqrt"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setText(String result){
        TextView t = (TextView)findViewById(R.id.resultText);
        t.setText(result);
    }
    public void onOneButtonClick(View w){
        str += "1";
        setText(str);
    }
    public void onTwoButtonClick(View w){
        str += "2";
        setText(str);
    }
    public void onThreeButtonClick(View w){
        str += "3";
        setText(str);
    }
    public void onFourButtonClick(View w){
        str += "4";
        setText(str);
    }
    public void onFiveButtonClick(View w){
        str += "5";
        setText(str);
    }
    public void onSixButtonClick(View w){
        str += "6";
        setText(str);
    }
    public void onSevenButtonClick(View w){
        str += "7";
        setText(str);
    }
    public void onEightButtonClick(View w){
        str += "8";
        setText(str);
    }
    public void onNineButtonClick(View w){
        str += "9";
        setText(str);
    }
    public void onZeroButtonClick(View w){
        str += "0";
        setText(str);
    }
    public void onPointButtonClick(View w){
        str += ".";
        setText(str);
    }
    public void onBreaketsButtonClick(View w){
        //
        setText(str);
    }
    public void onEqualsButtonClick(View w){
        int leftBreakets = 0, rightBreakets = 0;
        for(int i = 0; i < str.length(); i++){

        }
        setText(str);
    }
    public void addOperand(String operand){
        if(str == "" || str.charAt(str.length() - 1) == '('){
            if(operand == "+" || operand == "-"){
                str += operand;
            }
        }
        else if(operands.toString().contains(str.substring(str.length()-1))){
            str = str.substring(0, str.length() - 2) + operand;
        }
        else{
            str += operand;
        }
        setText(str);
    }
    public void onPlusButtonClick(View w){
        addOperand("+");
    }
    public void onMinusButtonClick(View w){
        addOperand("-");
    }
    public void onMultButtonClick(View w){
        addOperand("*");
    }
    public void onDivButtonClick(View w){
        addOperand("/");
    }
    public void onPowButtonClick(View w){
        addOperand("^");
    }
    public void onDelButtonClick(View w){
        boolean fl = false;
        int lenghtOfFunction = -1;
        for(String s : functions){
            if(str.endsWith(s+"(")){
                fl = true;
                lenghtOfFunction = s.length() + 1;
            }
        }
        if(fl){
            str = str.substring(0, str.length() - lenghtOfFunction);
        }
        else{
            str = str.substring(0, str.length() - 2);
        }
        setText(str);
    }
    public void onClearButtonClick(View w){
        str = "";
        setText(str);
    }
    public boolean isOperand(char operand){
        for(String s : operands){
            if(s.charAt(0) == operand){
                return true;
            }
        }
        return false;
    }
    public void addFunction(String function){
        if(str == "" || str.charAt(str.length()-1) == '(' || isOperand(str.charAt(str.length()-1))){
            str += function + "(";
        }
        else{
            str += "*" + function + "(";
        }
        setText(str);
    }
    public void onSinButtonClick(View w){
        addFunction("sin");
    }
    public void onCosButtonClick(View w){
        addFunction("cos");
    }
    public void onTgButtonClick(View w){
        addFunction("tg");
    }
    public void onLnButtonClick(View w){
        addFunction("ln");
    }
    public void onLgButtonClick(View w){
        addFunction("lg");
    }
    public void onSqrtButtonClick(View w){
        addFunction("sqrt");
    }
    public void onE_ButtonClick(View w){
        addFunction("e");
    }
    public void onPiButtonClick(View w){
        addFunction("pi");
    }
}
