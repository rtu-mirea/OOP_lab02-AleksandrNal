package com.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private String x;

    Task3(){
        x = null;
    }

    Task3(String text){
        x = text;
    }

    public String toString(){
        return x;
    }

    public boolean check(){
        Pattern p = Pattern.compile("^(2[0-3]|[0-1][0-9])\\:[0-5][0-9]$");
        Matcher m = p.matcher(x);
        return m.matches();
    }

    public void delete(){
        String y[] = x.split(" ");
        Pattern p = Pattern.compile("^(0[0-1]\\:[0-5][0-9])|02:00$");
        Matcher m;
        for (String i : y){
            m = p.matcher(i);
            if(m.matches()){
                x = x.replaceAll(i + " ", "");
            }
        } m = p.matcher(y[y.length - 1]);
        if (m.matches())
            x = x.replaceAll(y[y.length - 1], "");
    }

}
