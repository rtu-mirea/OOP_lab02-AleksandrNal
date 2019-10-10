package com.code;
import java.util.Arrays;
import java.util.Comparator;

public class Task1 {

    private String x[][];

    public Task1()
    {
        x = null;
    }

    public Task1(String text) throws Exception
    {
        String y[] = text.split(";");
        x = new String[y.length][2];
        for (int i = 0; i < y.length; i++) {
            String z[] = y[i].split(" ");
            if (z.length > 2)
                throw new Exception();
            x[i][0] = z[0];
            x[i][1] = z[1];
            int test = Integer.parseInt(x[i][1]);
            if (test < 0){
                throw new Exception();
            }
        }
    }

    public String toString()
    {
        if (x == null)
            return null;
        String out = "";
        for (int i = 0; i < x.length; i++)
            out += x[i][0] + " " + x[i][1] + ";";
        return out.substring(0, out.length()-1);
    }

    public int found_sum()
    {
        if (x == null)
            return 0;
        int out = 0;
        for (int i = 0; i < x.length; i++)
            out += Integer.parseInt(x[i][1]);
        return out;
    }

    public void first_to_upper()
    {
        if (x == null)
            return;
        for (int i = 0; i < x.length; i++)
            x[i][0] = x[i][0].substring(0, 1).toUpperCase() + x[i][0].substring(1);
    }

    public String rating()
    {
        if (x == null)
            return null;
        String out = "";
        String y[][] = x;
        Arrays.sort(y, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {

                Integer itemIdOne = Integer.parseInt(entry1[1]);
                Integer itemIdTwo = Integer.parseInt(entry2[1]);
                return itemIdTwo.compareTo(itemIdOne);
            }
        });
        for (int i = 0; i < y.length; i++)
            out += y[i][0] + " ";
        return out;
    }

    public String show_by_rating(int n)
    {
        if (x == null || n > x.length || n <= 0)
            return null;
        String y[] = rating().split(" ");
        return y[n-1];
    }
}
