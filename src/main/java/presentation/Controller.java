package presentation;

import bll.DeliveryService;
import bll.MenuItem;
import data.UserInfo;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class Controller implements ActionListener {
    private View view;
    private DeliveryService d;
    public Controller(View v) {
        this.view = v;
        d = new DeliveryService();
    }
    //DeliveryService d = new DeliveryService();
    @Override
    public void actionPerformed(ActionEvent e) {
//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Serializator.serialize(d.getOrders(),"comenzi_serializare.txt");
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }));

        String command = e.getActionCommand();
        if(command == "adminBView"){
            view.getClient().getClientFrame().setVisible(false);
            view.getAdministrator().getAdminFrame().setVisible(true);
        }
        if(command == "clientBView"){
            view.getClient().getClientFrame().setVisible(true);
            view.getAdministrator().getAdminFrame().setVisible(false);
        }
        if(command == "addProductAdmin"){
            String s = getTextTF();
            try {
                d.addProduct(d.toProduct(s),true);
                redrawScrollPane();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

//            for(MenuItem m: d.getMeniu()){
//           System.out.println(m.toString());
//              }
        }
        if(command == "importAdmin"){
            try {
                d.importProducts();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(command == "loginClient"){

            String user = view.getClient().getUserTF().getText();
            String pass =String.valueOf(view.getClient().getPassTF().getPassword());
            try {
                if(UserInfo.loginClient(user,pass)==1){  //daca s a efectuat cu succes login-ul
                    view.getClient().getClientFrame().setVisible(false);
                    view.getClient().getClientFrame2().setVisible(true);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(command == "registerClient"){
            String user = view.getClient().getUserTF().getText();
            String pass = String.valueOf(view.getClient().getPassTF().getPassword());
            try {
                UserInfo.registerClient(user,pass);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(command == "loginAdmin"){
            String user = view.getAdministrator().getUserTF().getText();
            String pass =String.valueOf(view.getAdministrator().getPassTF().getPassword());
           if(UserInfo.loginAdmin(user,pass)==true){
            view.getAdministrator().getAdminFrame().setVisible(false);
            view.getAdministrator().getAdminFrame2().setVisible(true);
           }
           else
               System.out.println("Parola sau user incorect");
        }
        if(command =="viewProductsB") {//pt admin
            try {
                String[] columnNames={"title","rating","calories","protein","fat","sodium","price"};
                String[][] tabel = d.viewProducts();
                redrawScrollPane();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(command == "deletePrB"){  //admin2
            Object aux = view.getAdministrator().getJlistAdmin().getSelectedValue();
            try {
                d.deleteProduct((MenuItem)aux);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            redrawScrollPane();
        }
        if(command == "editPrB"){//admin2
            Object aux = view.getAdministrator().getJlistAdmin().getSelectedValue();
            for(MenuItem m: d.getMeniu()){
                if(m.equals(aux)){
                    String t=null;
                    int c=-1,p=-1,f=-1,s=-1,pr=-1;
                    double r=-1;
                    if( view.getAdministrator().getTitleTF().getText().length()!=0)
                        t=view.getAdministrator().getTitleTF().getText();
                    if(view.getAdministrator().getRatingTF().getText().length()!=0)
                        r=Double.parseDouble(view.getAdministrator().getRatingTF().getText());
                    if(view.getAdministrator().getCaloriesTF().getText().length()!=0)
                        c= Integer.parseInt(view.getAdministrator().getCaloriesTF().getText());
                    if(view.getAdministrator().getProteinTF().getText().length()!=0)
                        p=Integer.parseInt(view.getAdministrator().getProteinTF().getText());
                    if(view.getAdministrator().getFatTF().getText().length()!=0)
                        f=Integer.parseInt(view.getAdministrator().getFatTF().getText());
                    if(view.getAdministrator().getSodiumTF().getText().length()!=0)
                        s=Integer.parseInt(view.getAdministrator().getSodiumTF().getText());
                    if(view.getAdministrator().getPriceTF().getText().length()!=0)
                        pr=Integer.parseInt(view.getAdministrator().getPriceTF().getText());
                    try {
                        d.editProduct(m,t,r,c,p,f,s,pr);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    redrawScrollPane();
                }
            }
        }
        if(command == "viewCB"){
            try {
                String[][] tabel = d.viewProducts();
                redrawScrollPaneClient(false,null);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(command == "addToOrderB"){
            Object aux = view.getClient().getjListC().getSelectedValue();
            d.addProductToOrder((MenuItem)aux);
            view.getClient().getOrderTA().append((aux).toString()+ "\n");
        }
        if(command == "createOrderB"){
            try {
                d.createOrder(view.getClient().getUserTF().getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            view.getClient().getOrderTA().setText("");
        }
        if(command == "searchCB"){   // pt client
            String keyword = null;
            double rating=-1;
            int calories=-1,protein=-1,fat=-1,sodium=-1,price=-1;
            if(view.getClient().getKeyWordChB().isSelected())
                keyword = view.getClient().getKeyWordTA().getText();
            if(view.getClient().getRatingChB().isSelected())
                rating = Double.parseDouble(view.getClient().getRatingTA().getText());
            if(view.getClient().getCaloriesChB().isSelected())
                calories = Integer.parseInt(view.getClient().getCaloriesTA().getText());
            if(view.getClient().getProteinChB().isSelected())
                protein=Integer.parseInt(view.getClient().getProteinTA().getText());
            if(view.getClient().getFatChB().isSelected())
                fat=Integer.parseInt(view.getClient().getFatTA().getText());
            if(view.getClient().getSodiumChB().isSelected())
                sodium=Integer.parseInt(view.getClient().getSodiumTA().getText());
            if(view.getClient().getPriceChB().isSelected())
                price=Integer.parseInt(view.getClient().getPriceTA().getText());

           List<MenuItem> r = d.searchProductsClient(keyword,rating,calories,protein,fat,sodium,price);
           redrawScrollPaneClient(true,r);
        }
        if(command == "addProductToComp"){  //adauga produs la composite

            Object aux = view.getAdministrator().getJlistAdmin().getSelectedValue();
            d.addProductToOrder((MenuItem) aux);
            view.getAdministrator().getAdminTextArea2().append((aux).toString() + "\n");
        }
        if(command == "createProductsB"){
            String nume =  view.getAdministrator().getNameOfProdTF().getText();
            try {
                d.createCompositeProduct(nume);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            view.getAdministrator().getAdminTextArea2().setText("");
            redrawScrollPane();

        }
        if(command == "generateReportsB"){
            int crit =view.getAdministrator().getGenReportCB().getSelectedIndex();
            String s1 = view.getAdministrator().getGenPrTF1().getText();
            String s2 = view.getAdministrator().getGenPrTF2().getText();

            try {
                d.generateReportt(crit,s1,s2);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }


    }


    public  void redrawScrollPane(){
        DefaultListModel<MenuItem> listModel = new DefaultListModel<>();
        for(MenuItem m: d.getMeniu()){
            listModel.addElement(m);
        }

        view.getAdministrator().setJlistAdmin(new JList(listModel));
        JScrollPane js = new JScrollPane(view.getAdministrator().getJlistAdmin());
        view.getAdministrator().setJScrollAdmin(js);

        view.getAdministrator().getAdminPanel2main().remove(1);//dau remove la scrollpane
        view.getAdministrator().getAdminPanel2main().add(view.getAdministrator().getJScrollAdmin());
        view.getAdministrator().getAdminPanel2main().revalidate();
        view.getAdministrator().getAdminPanel2main().repaint();
    }


    public String getTextTF(){
        String s = new String("");
        s+=view.getAdministrator().getTitleTF().getText(); s+=",";
        s+=view.getAdministrator().getRatingTF().getText(); s+=",";
        s+=view.getAdministrator().getCaloriesTF().getText(); s+=",";
        s+=view.getAdministrator().getProteinTF().getText(); s+=",";
        s+=view.getAdministrator().getFatTF().getText(); s+=",";
        s+=view.getAdministrator().getSodiumTF().getText(); s+=",";
        s+=view.getAdministrator().getPriceTF().getText();
        return s;
    }

    public void redrawScrollPaneClient(boolean search, List<MenuItem> resultList){

        DefaultListModel<MenuItem> listModel = new DefaultListModel<>();
        if(search){
            for(MenuItem n: resultList)
                listModel.addElement(n);
        }else{
            for(MenuItem m: d.getMeniu()){
            listModel.addElement(m);
        }}

        view.getClient().setjListC(new JList(listModel));
        JScrollPane js = new JScrollPane(view.getClient().getjListC());
        view.getClient().setClientScrollPane(js);

        view.getClient().getClientPanel2main().remove(1);
        view.getClient().getClientPanel2main().add(view.getClient().getClientScrollPane());
        view.getClient().getClientPanel2main().revalidate();
        view.getClient().getClientPanel2main().repaint();

    }

    public DeliveryService getD() {
        return d;
    }

    public void setD(DeliveryService d) {
        this.d = d;
    }
}
