package data;

import bll.MenuItem;
import bll.Order;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileWriter {

    public void createFile(ArrayList<MenuItem> menu,int nr,String user, String data, int price){
        PrintWriter out = null;
        try {
            out = new PrintWriter("order_" + nr +"_" + user + "_" + data + ".txt");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
       //
        for(MenuItem m: menu)
        out.println(m.toString());
        out.println("Pret total: " + price + " lei.");
        out.close();

    }

    public static void createReportFile(Map<Order, List<MenuItem>> map, String s1, String s2){
        PrintWriter out = null;
        try {
            out = new PrintWriter("hour_interval_report_" + s1 + "_to_" + s2 + ".txt");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for(Map.Entry<Order, List<MenuItem>> entry: map.entrySet()) {
            out.print(entry.getKey().toString());
            for(MenuItem m: entry.getValue())
                out.println(m.toString());
            out.print("\n ------------------------------------------------------------------------\n\n");
        }
        out.close();
    }
    public static void createReportFile2( ArrayList<MenuItem> aux, String s){
        PrintWriter out = null;
        try {
            out = new PrintWriter("pr_ordered_more_than_" + s + "_times"+ ".txt" );

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for(MenuItem m : aux){
            out.println(m.toString());
        }
        out.close();
    }
    public static void createReportFile3( HashMap<String , Integer> h, String min,int pretMin){
        PrintWriter out = null;
        int x = Integer.parseInt(min);
        try {
            out = new PrintWriter("Cl_ordered_more_than_" + x + "_times_"+ pretMin +"_USD" +  ".txt" );

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for(Map.Entry<String, Integer> entry: h.entrySet()) {
            if(entry.getValue()>=x)
                if (out != null) {
                    out.println("Price of order greater than " + pretMin + " USD. \n");
                    out.println(entry.getKey() + " ordered " + entry.getValue() + " times. \n");
                }
        }
        out.close();
    }
    public static void createReport4(HashMap<MenuItem , Integer> h, String s1){
        PrintWriter out = null;
        try {
            out = new PrintWriter("Products_ordered_on_" + s1 + ".txt" );
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for(Map.Entry<MenuItem, Integer> entry: h.entrySet()) {
            out.println(entry.getKey().toString() + " ordered " + entry.getValue() + " times.");
        }
        out.close();
    }

}
