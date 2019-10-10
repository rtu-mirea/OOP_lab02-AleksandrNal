package com.code;

public class Task2 {

    private StringBuffer x;

    public Task2(){
        x = new StringBuffer("");
    }

    public Task2(String text){
        x = new StringBuffer(text);
    }

    public String toString(){
        return x.toString();
    }

    public void del_0(){
        if (x.toString().compareTo("") == 0)
            return;
        String y[] = x.toString().split(";");
        for (String i : y){
            if ((i.substring(i.length()-1).compareTo("0") == 0) && (i.substring(i.length()-2, i.length()-1).compareTo(" ") == 0)){
                String replacing = i;
                x = new StringBuffer(x.toString().replaceAll(replacing,""));
            }
            x = new StringBuffer(x.toString().replaceAll(";;",";"));
            if (!x.toString().equals("")) {
                if (x.substring(x.length() - 1).compareTo(";") == 0)
                    x = new StringBuffer(x.toString().replaceAll(";", ""));
                if (x.substring(0, 1).compareTo(";") == 0)
                    x = new StringBuffer(x.toString().replaceAll(";",""));
            }
        }
    }

    public void replace_shortest(){
        String y[] = x.toString().split(";");
        String shortest = "", longest = "";
        for (String i : y){
            if (shortest.equals(""))
                shortest = i;
            if (shortest.length() > i.length())
                shortest = i;
            if (longest.length() < i.length())
                longest = i;
        }
        if (shortest.length() == longest.length()){
            System.out.println("Длина всех элементов одинакова");
            return;
        }
        int shortest_first, shortest_last;
        shortest_first = x.toString().indexOf(shortest);
        shortest_last = shortest_first+shortest.length();
        x.replace(shortest_first, shortest_last, longest);
        x = new StringBuffer(x.toString().replaceAll("  "," "));
    }

    public void add(String text){
        x.append(text);
    }
}
