package com.example.prime.primecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator extends AppCompatActivity {
    Button mOne;
    Button mTwo;
    Button mThree;
    Button mFour;
    Button mFive;
    Button mSix;
    Button mSeven;
    Button mEight;
    Button mNine;
    Button mZero;
    Button mEqual;
    Button mClear;
    Button mDel;
    Button mPeriod;
    Button mDivide;
    Button mMult;
    Button mSubtract;
    Button mAdd;
    TextView mDisplay;
    String value = "";
    double total = 0;

    boolean lastNumber = false;
    boolean lastOperand = false;
    boolean period = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        mDisplay = findViewById(R.id.display);

        mClear = findViewById(R.id.clear);
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplay.setText("");
                lastNumber = false;
                lastOperand = false;
                total = 0;
                period = false;
            }
        });


        mOne = findViewById(R.id.one);
        mOne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("1");
            }
        });

        mTwo = findViewById(R.id.two);
        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplay.append("2");
            }
        });

        mThree = findViewById(R.id.three);
        mThree.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("3");
            }
        });

        mFour = findViewById(R.id.four);
        mFour.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("4");
            }
        });

        mFive = findViewById(R.id.five);
        mFive.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("5");
            }
        });

        mSix = findViewById(R.id.six);
        mSix.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("6");
            }
        });

        mSeven = findViewById(R.id.seven);
        mSeven.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("7");
            }
        });

        mEight = findViewById(R.id.eight);
        mEight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("8");
            }
        });

        mNine = findViewById(R.id.nine);
        mNine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("9");
            }
        });

        mZero = findViewById(R.id.zero);
        mZero.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mDisplay.append("0");
            }
        });

        mAdd = findViewById(R.id.add);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplay.append("+");
                period = false;
            }
        });

        mMult = findViewById(R.id.mult);
        mMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplay.append("*");
                period = false;
            }
        });

        mDivide = findViewById(R.id.divide);
        mDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplay.append("/");
                period = false;
            }
        });

        mSubtract = findViewById(R.id.subtract);
        mSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplay.append("-");
                period = false;
            }
        });

        mPeriod = findViewById(R.id.period);
        mPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!period) {
                    mDisplay.append(".");
                    period = true;
                }

            }
        });

        mEqual = findViewById(R.id.equal);
        mEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
                if ((total == Math.floor(total)) && !Double.isInfinite(total)) {
                    mDisplay.setText(Integer.toString((int) total));
                }
                else{
                    mDisplay.setText(Double.toString(total));
                }

            }
        });

        mDel = findViewById(R.id.del);
        mDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = mDisplay.getText().toString();
                if (value.length() > 0){
                    //gets substring minus the last character
                    value = value.substring(0, value.length() - 1);
                    mDisplay.setText(value);
                }
            }
        });

    }


    void performCalculation(){
        value = mDisplay.getText().toString();
        Expression expression = new ExpressionBuilder(value).build();

        try{
            total = expression.evaluate();
        } catch (ArithmeticException ex){
            mDisplay.setText("Error");
        }

    }
}
