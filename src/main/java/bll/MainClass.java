package bll;

import data.Serializator;

import presentation.View;

import java.io.File;
import java.io.IOException;

import java.util.*;

public class MainClass {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        View v = new View();
        File file = new File("comenzi_serializare.txt");
        if(file.length()!=0)
        v.getController().getD().setOrders ((HashMap<Order, List<MenuItem>>) Serializator.deserialize("comenzi_serializare.txt"));
//        DeliveryService d = new DeliveryService();
//        Order o = new Order(1,"aa","bbb");
//        List<MenuItem> a= new ArrayList<>();
//        MenuItem m1 = new MenuItem("supa",1,2,3,4,5,6);
//        MenuItem m2 = new MenuItem("ciorba",3,4,5,6,7,8);
//        a.add(m1);
//        a.add(m2);
//        d.getOrders().put(o,a);
//        System.out.println(d.toStringOrders());
//
//        for (Map.Entry<Order, List<MenuItem>> entry : d.getOrders().entrySet()) {
//            System.out.println(entry.getKey().toString() + "\n");
//              for (MenuItem m : entry.getValue())
//               {
//                   System.out.println(m.toString());
//               }
//            System.out.println("\n\n\n\n");
//        }

      //  String a = new String("22-05-2022_00_51_35");
       // System.out.println(a.substring(11,16));
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
//        String data = df.format(new Date());
//        System.out.println(data);


//        d.importProducts();
//        HashSet<MenuItem> hh = d.getMeniu();
//        MenuItem mn = null;
//        int k=0;
//        for(MenuItem m : hh){
//            k++;
//            if(k==3)
//                mn=m;
//            System.out.println(m.toStringComma());}
//        System.out.println("/////////////////////////////////////////////////////////////////");
//
//        hh.remove(mn);
//        for(MenuItem m : hh){
//            System.out.println(m.toStringComma());}




//        ArrayList<String> a = new ArrayList<>();
//        a.add("abc");
//        a.add("def");
//        a.add("ghi");
//        for(String s:a){
//            System.out.println(s);
//        }
//        String auxx = new String();
//        for(String s: a){
//            if(s.equals("def"))
//                auxx=s;
//        }
//        System.out.println("/n/n/n");
//        a.remove(auxx);
//        for(String s:a){
//            System.out.println(s);
//        }

    }
}
