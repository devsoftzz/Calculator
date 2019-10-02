package com.devcalc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button zero,one,two,three,four,five,six,seven,eight,nine,dot,
            divide,module,clear,equl;
    ImageButton plus,minus,multiplication,erase;
    TextView expression,result;
    HorizontalScrollView scroll2,scroll1;

    String data="";
    String r;
    int flag=0;

    Stack<Integer> stackOfdot = new Stack<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        dot = findViewById(R.id.dot);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        module = findViewById(R.id.module);
        divide = findViewById(R.id.divide);
        multiplication = findViewById(R.id.multiplication);

        clear = findViewById(R.id.clear);
        erase = findViewById(R.id.back);
        equl = findViewById(R.id.equl);

        expression = findViewById(R.id.expression);
        result = findViewById(R.id.result);
        scroll2 = findViewById(R.id.scroll2);
        scroll1 = findViewById(R.id.scroll1);

        stackOfdot.push(0);

        expression.setText(data);
        result.setText(data);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("1");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                setExpression("9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                    flag=0;
                }
                if(stackOfdot.peek()==0) {
                    setExpression(".");
                    stackOfdot.pop();
                    stackOfdot.push(1);
                }
            }
        });
        module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data="";
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    result.setText("");
                }
                setExpression("00");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data="";
                flag=0;
                stackOfdot.clear();
                stackOfdot.push(0);
                expression.setText(data+"  ");
                result.setText(data);
            }
        });
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data!=String.valueOf("")) {
                    if (data.length() == 1) {
                        data = "";
                    } else if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%') {
                        stackOfdot.pop();
                        data = data.substring(0, data.length() - 1);
                    } else if (data.charAt(data.length() - 1) == '.') {
                        data = data.substring(0, data.length() - 1);
                        stackOfdot.pop();
                        stackOfdot.push(0);
                    } else {
                        data = data.substring(0, data.length() - 1);
                    }
                }
                flag=0;
                expression.setText(data+"  ");
                scroll2.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data=r;
                    result.setText("");
                    if(r.indexOf('E')!=-1 || Double.valueOf(r)%1!=0){
                        stackOfdot.clear();
                        stackOfdot.push(1);
                    }
                    else {
                        stackOfdot.clear();
                        stackOfdot.push(0);
                    }
                    flag=0;
                }
                if(data.length()==1 && data.charAt(0)=='.'){
                    data="";
                    expression.setText(data);
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    return;
                }
                if(!data.equals("")) {
                    if (data.charAt(0) == '-' && data.length() == 1) {
                        data = "";
                        stackOfdot.pop();
                        expression.setText(data+"  ");
                    } else if(data.length()==1 && !Double.isNaN(Double.valueOf(data))){
                        setExpression("+");
                        stackOfdot.push(0);
                        return;
                    }
                    else if(data.length()==2 && (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%')){
                        data = data.substring(0, data.length() - 1);
                        stackOfdot.pop();
                        setExpression("+");
                        stackOfdot.push(0);
                        return;
                    }
                    else{
                        if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%') {
                            data = data.substring(0, data.length() - 1);
                            stackOfdot.pop();
                        }
                        if(data.length()>1) {
                            if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%') {
                                data = data.substring(0, data.length() - 1);
                                stackOfdot.pop();
                            }
                        }
                        else{
                            data="";
                            stackOfdot.clear();
                            stackOfdot.push(0);
                            expression.setText(data);
                            return;
                        }
                        setExpression("+");
                        stackOfdot.push(0);
                    }
                }
            }

        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data=r;
                    result.setText("");
                    if(r.indexOf('E')!=-1 || Double.valueOf(r)%1!=0){
                        stackOfdot.clear();
                        stackOfdot.push(1);
                    }
                    else {
                        stackOfdot.clear();
                        stackOfdot.push(0);
                    }
                    flag=0;
                }
                if(data.length()==1 && data.charAt(0)=='.'){
                    data="-";
                    expression.setText(data);
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    return;
                }
                    if(data.equals("")){
                        setExpression("-");
                        stackOfdot.push(0);
                    }
                    else if(data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-'){
                        data = data.substring(0,data.length()-1);
                        stackOfdot.pop();
                        setExpression("-");
                        stackOfdot.push(0);
                    }
                    else{
                        setExpression("-");
                        stackOfdot.push(0);
                    }
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data=r;
                    result.setText("");
                    if(r.indexOf('E')!=-1 || Double.valueOf(r)%1!=0){
                        stackOfdot.clear();
                        stackOfdot.push(1);
                    }
                    else {
                        stackOfdot.clear();
                        stackOfdot.push(0);
                    }
                    flag=0;
                }
                if(data.length()==1 && data.charAt(0)=='.'){
                    data="";
                    expression.setText(data);
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    return;
                }
                if(!data.equals("")) {
                    if (data.charAt(0) == '-' && data.length() == 1) {
                        data = "";
                        stackOfdot.pop();
                        expression.setText(data+"  ");
                    } else if(data.length()==1 && !Double.isNaN(Double.valueOf(data))){
                        setExpression("*");
                        stackOfdot.push(0);
                        return;
                    }
                    else if(data.length()==2 && (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%')){
                        data = data.substring(0, data.length() - 1);
                        stackOfdot.pop();
                        setExpression("*");
                        stackOfdot.push(0);
                        return;
                    }else {
                        if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%') {
                            data = data.substring(0, data.length() - 1);
                            stackOfdot.pop();
                        }
                        if(data.length()>1) {
                            if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%') {
                                data = data.substring(0, data.length() - 1);
                                stackOfdot.pop();
                            }
                        }
                        else{
                            data="";
                            stackOfdot.clear();
                            stackOfdot.push(0);
                            expression.setText(data);
                            return;
                        }
                        setExpression("*");
                        stackOfdot.push(0);
                    }
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    data=r;
                    result.setText("");
                    if(r.indexOf('E')!=-1 || Double.valueOf(r)%1!=0){
                        stackOfdot.clear();
                        stackOfdot.push(1);
                    }
                    else {
                        stackOfdot.clear();
                        stackOfdot.push(0);
                    }
                    flag=0;
                }
                if(data.length()==1 && data.charAt(0)=='.'){
                    data="";
                    expression.setText(data);
                    stackOfdot.clear();
                    stackOfdot.push(0);
                    return;
                }
                if(!data.equals("")) {
                    if (data.charAt(0) == '-' && data.length() == 1) {
                        data = "";
                        stackOfdot.pop();
                        expression.setText(data+"  ");
                    }else if(data.length()==1 && !Double.isNaN(Double.valueOf(data))){
                        setExpression("/");
                        stackOfdot.push(0);
                        return;
                    }
                    else if(data.length()==2 && (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%')){
                        data = data.substring(0, data.length() - 1);
                        stackOfdot.pop();
                        setExpression("/");
                        stackOfdot.push(0);
                        return;
                    }
                    else {
                        if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%') {
                            data = data.substring(0, data.length() - 1);
                            stackOfdot.pop();
                        }
                        if(data.length()>1) {
                            if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '%') {
                                data = data.substring(0, data.length() - 1);
                                stackOfdot.pop();
                            }
                        }
                        else{
                            stackOfdot.clear();
                            stackOfdot.push(0);
                            data="";
                            expression.setText(data);
                            return;
                        }
                        setExpression("/");
                        stackOfdot.push(0);
                    }
                }
            }
        });
        equl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.length()>0) {
                    if (data.charAt(data.length() - 1) == '+' || data.charAt(data.length() - 1) == '-' || data.charAt(data.length() - 1) == '/' || data.charAt(data.length() - 1) == '*' || data.charAt(data.length() - 1) == '%') {
                        data = data.substring(0, data.length() - 1);
                    }
                    Expression e = new Expression(data);
                    double val = e.calculate();
                    r = String.valueOf(val);
                    if (r.indexOf('E')==-1 && val%1==0) {
                        r = r.substring(0, r.length() - 2);
                    }
                    expression.setText(data+"  ");
                    result.setText(r+"  ");
                    scroll1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                    flag=1;
                }
            }
        });
    }
    void setExpression(String value){
        data=data+value;
        expression.setText(data+"  ");
        scroll2.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
    }
}
