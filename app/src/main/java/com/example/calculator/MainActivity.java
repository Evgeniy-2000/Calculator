package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String str = "";
    String[] operands = new String[]{"+","-","*","/","^"};
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
        if(str.length() != 0 && str.charAt(str.length()-1) <= '9' && str.charAt(str.length()-1) >= '0'){
            int k = 1;
            while(str.charAt(str.length() - k) <= '9' && str.charAt(str.length() - k) >= '0'){
                if(k == str.length()){
                    str += ".";
                    setText(str);
                    return;
                }
                k++;
            }
            if(str.charAt(str.length() - k) != '.') {
                str += ".";
                setText(str);
            }
        }
    }
    public void onBreaketsButtonClick(View w){
        int leftBreakets = 0, rightBreakets = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                leftBreakets++;
            }
            else if(str.charAt(i) == ')'){
                rightBreakets++;
            }
        }
        if(str.length() == 0 || str.charAt(str.length() - 1) == '(' || isOperand(str.charAt(str.length() - 1))){
            str += "(";
        }
        else if(leftBreakets > rightBreakets){
            str += ")";
        }
        else{
            str += "*(";
        }
        setText(str);
    }
    public void addOperand(String operand){
        if(str.length() == 0 || str.charAt(str.length() - 1) == '('){
            if(operand == "+" || operand == "-"){
                str += operand;
            }
        }
        else if(isOperand(str.charAt(str.length()-1))){
            str = str.substring(0, str.length() - 1) + operand;
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
        if(str.length() == 0){
            return;
        }
        boolean fl = false;
        int lenghtOfFunction = -1;
        for(String s : functions){
            if(str.endsWith(s + "(")){
                fl = true;
                lenghtOfFunction = s.length() + 1;
            }
        }
        if(fl){
            str = str.substring(0, str.length() - lenghtOfFunction);
        }
        else if(str.endsWith("pi")){
            str = str.substring(0, str.length() - 2);
        }
        else{
            str = str.substring(0, str.length() - 1);
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
        if(str.length() == 0 || str.charAt(str.length()-1) == '(' || isOperand(str.charAt(str.length()-1))){
            str += "e";
        }
        else{
            str += "*e";
        }
        setText(str);
    }
    public void onPiButtonClick(View w){
        if(str.length() == 0 || str.charAt(str.length()-1) == '(' || isOperand(str.charAt(str.length()-1))){
            str += "pi";
        }
        else{
            str += "*pi";
        }
        setText(str);
    }

    public void onEqualsButtonClick(View w){
        if(str.length() == 0){
            return;
        }
        else if(str.length() == 1){
            if(isOperand(str.charAt(0)) || str.charAt(0) == '('){
                return;
            }
        }
        int countOfNumbers = 0;
        boolean isNumber = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'e' || str.charAt(i) == 'p'){
                countOfNumbers++;
            }
            if(isNumber){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){

                }
                else if(str.charAt(i) != '.'){
                    isNumber = false;
                }
            }
            else{
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    isNumber = true;
                    countOfNumbers++;
                }
            }
        }
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == '.' && !(str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9')){
                str = str.substring(0, i) + str.substring(i + 1);
            }
        }
        if(str.charAt(str.length() - 1) == '.'){
            str = str.substring(0, str.length() - 1);
        }
        while(countOfNumbers > 1){
            isNumber = false;
            for(int i = 0; i < str.length(); i++){

            }
        }
        setText(str);
    }
}
