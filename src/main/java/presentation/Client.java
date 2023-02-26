package presentation;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Client {
    private JFrame clientFrame;
    private JFrame clientFrame2;
    private JPanel clientPanel;
    private JPanel clientPanel2,clientPanel2main,clientPanelAux1,
    clientPanelAux2,clientPanelAux3;   //clientpanel2main contine clientpanel2 si Jlistul
    private JButton loginB,registerB;
    public JTextField userTF;
    private JPasswordField passTF;
    //pt clientpanel2
    private JButton viewCB,searchCB,addToOrderB,createOrderB;
    private JCheckBox keyWordChB,ratingChB,caloriesChB,
    proteinChB,fatChB,sodiumChB,priceChB;
    private JTextArea keyWordTA,ratingTA,caloriesTA,
            proteinTA,fatTA,sodiumTA,priceTA;
    private JScrollPane clientScrollPane,orderScrollPane;
    private JList jListC;
    private JTextArea orderTA;


    public Client(){
        clientFrame = new JFrame("client");
        clientFrame2 = new JFrame();
        clientPanel = new JPanel(new GridLayout(3,2));
        clientPanel2 = new JPanel(new GridLayout(1,2)); //////////
        clientPanel2main = new JPanel(new GridLayout(2,1));
        clientPanelAux2 = new JPanel(new GridLayout(2,1));
        clientPanelAux1 = new JPanel(new GridLayout(3,1));
        clientPanelAux3 = new JPanel(new GridLayout(8,2));
        loginB = new JButton("Log in");
        registerB = new JButton("Register");
        userTF = new JTextField();
        passTF = new JPasswordField();

        clientPanel.add(new JLabel("User: "));
        clientPanel.add(userTF);
        clientPanel.add(new JLabel("Password: "));
        clientPanel.add(passTF);
        clientPanel.add(loginB);
        clientPanel.add(registerB);

        clientFrame.setSize(500,200);
        clientFrame.add(clientPanel);
        clientFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        //client2 //////////////

        viewCB = new JButton("View products");
        searchCB= new JButton("Search products");
        addToOrderB = new JButton("Add to order");
        createOrderB = new JButton("Create order");
        keyWordChB = new JCheckBox("keyword");
        ratingChB = new JCheckBox("rating");
        caloriesChB = new JCheckBox("calories");
        proteinChB = new JCheckBox("protein");
        fatChB = new JCheckBox("fat");
        sodiumChB = new JCheckBox("sodium");
        priceChB = new JCheckBox("price");
        orderTA = new JTextArea();
        clientScrollPane = new JScrollPane();
        orderScrollPane = new JScrollPane(orderTA);
        keyWordTA = new JTextArea();
        ratingTA=new JTextArea();
        caloriesTA = new JTextArea();
        proteinTA = new JTextArea();
        fatTA = new JTextArea();
        sodiumTA = new JTextArea();
        priceTA = new JTextArea();
        jListC = new JList();
        clientPanelAux1.add(viewCB);
        clientPanelAux1.add(addToOrderB);
        clientPanelAux1.add(createOrderB);

        clientPanelAux2.add(clientPanelAux1);
        clientPanelAux2.add(orderScrollPane);

        clientPanelAux3.add(searchCB);
        clientPanelAux3.add(new JLabel(" "));
        clientPanelAux3.add(keyWordChB);
        clientPanelAux3.add(keyWordTA);
        clientPanelAux3.add(ratingChB);
        clientPanelAux3.add(ratingTA);
        clientPanelAux3.add(caloriesChB);
        clientPanelAux3.add(caloriesTA);
        clientPanelAux3.add(proteinChB);
        clientPanelAux3.add(proteinTA);
        clientPanelAux3.add(fatChB);
        clientPanelAux3.add(fatTA);
        clientPanelAux3.add(sodiumChB);
        clientPanelAux3.add(sodiumTA);
        clientPanelAux3.add(priceChB);
        clientPanelAux3.add(priceTA);

        clientPanel2.add(clientPanelAux2);
        clientPanel2.add(clientPanelAux3);

        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
        keyWordTA.setBorder(border);
        ratingTA.setBorder(border);
        caloriesTA.setBorder(border);
        proteinTA.setBorder(border);
        fatTA.setBorder(border);
        sodiumTA.setBorder(border);
        priceTA.setBorder(border);


        clientPanel2main.add(clientPanel2);
        clientPanel2main.add(clientScrollPane);

        clientFrame2.setSize(600,700);
        clientFrame2.add(clientPanel2main);
        clientFrame2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    public JList getjListC() {
        return jListC;
    }

    public void setjListC(JList jListC) {
        this.jListC = jListC;
    }

    public JPanel getClientPanel2main() {
        return clientPanel2main;
    }

    public void setClientPanel2main(JPanel clientPanel2main) {
        this.clientPanel2main = clientPanel2main;
    }

    public JPanel getClientPanelAux1() {
        return clientPanelAux1;
    }

    public void setClientPanelAux1(JPanel clientPanelAux1) {
        this.clientPanelAux1 = clientPanelAux1;
    }

    public JPanel getClientPanelAux2() {
        return clientPanelAux2;
    }

    public void setClientPanelAux2(JPanel clientPanelAux2) {
        this.clientPanelAux2 = clientPanelAux2;
    }

    public JPanel getClientPanelAux3() {
        return clientPanelAux3;
    }

    public void setClientPanelAux3(JPanel clientPanelAux3) {
        this.clientPanelAux3 = clientPanelAux3;
    }

    public JButton getViewCB() {
        return viewCB;
    }

    public void setViewCB(JButton viewCB) {
        this.viewCB = viewCB;
    }

    public JButton getSearchCB() {
        return searchCB;
    }

    public void setSearchCB(JButton searchCB) {
        this.searchCB = searchCB;
    }

    public JButton getAddToOrderB() {
        return addToOrderB;
    }

    public void setAddToOrderB(JButton addToOrderB) {
        this.addToOrderB = addToOrderB;
    }

    public JButton getCreateOrderB() {
        return createOrderB;
    }

    public void setCreateOrderB(JButton createOrderB) {
        this.createOrderB = createOrderB;
    }

    public JCheckBox getKeyWordChB() {
        return keyWordChB;
    }

    public void setKeyWordChB(JCheckBox keyWordChB) {
        this.keyWordChB = keyWordChB;
    }

    public JCheckBox getRatingChB() {
        return ratingChB;
    }

    public void setRatingChB(JCheckBox ratingChB) {
        this.ratingChB = ratingChB;
    }

    public JCheckBox getCaloriesChB() {
        return caloriesChB;
    }

    public void setCaloriesChB(JCheckBox caloriesChB) {
        this.caloriesChB = caloriesChB;
    }

    public JCheckBox getProteinChB() {
        return proteinChB;
    }

    public void setProteinChB(JCheckBox proteinChB) {
        this.proteinChB = proteinChB;
    }

    public JCheckBox getFatChB() {
        return fatChB;
    }

    public void setFatChB(JCheckBox fatChB) {
        this.fatChB = fatChB;
    }

    public JCheckBox getSodiumChB() {
        return sodiumChB;
    }

    public void setSodiumChB(JCheckBox sodiumChB) {
        this.sodiumChB = sodiumChB;
    }

    public JCheckBox getPriceChB() {
        return priceChB;
    }

    public void setPriceChB(JCheckBox priceChB) {
        this.priceChB = priceChB;
    }

    public JTextArea getKeyWordTA() {
        return keyWordTA;
    }

    public void setKeyWordTA(JTextArea keyWordTA) {
        this.keyWordTA = keyWordTA;
    }

    public JTextArea getRatingTA() {
        return ratingTA;
    }

    public void setRatingTA(JTextArea ratingTA) {
        this.ratingTA = ratingTA;
    }

    public JTextArea getCaloriesTA() {
        return caloriesTA;
    }

    public void setCaloriesTA(JTextArea caloriesTA) {
        this.caloriesTA = caloriesTA;
    }

    public JTextArea getProteinTA() {
        return proteinTA;
    }

    public void setProteinTA(JTextArea proteinTA) {
        this.proteinTA = proteinTA;
    }

    public JTextArea getFatTA() {
        return fatTA;
    }

    public void setFatTA(JTextArea fatTA) {
        this.fatTA = fatTA;
    }

    public JTextArea getSodiumTA() {
        return sodiumTA;
    }

    public void setSodiumTA(JTextArea sodiumTA) {
        this.sodiumTA = sodiumTA;
    }

    public JTextArea getPriceTA() {
        return priceTA;
    }

    public void setPriceTA(JTextArea priceTA) {
        this.priceTA = priceTA;
    }

    public JScrollPane getClientScrollPane() {
        return clientScrollPane;
    }

    public void setClientScrollPane(JScrollPane clientScrollPane) {
        this.clientScrollPane = clientScrollPane;
    }

    public JScrollPane getOrderScrollPane() {
        return orderScrollPane;
    }

    public void setOrderScrollPane(JScrollPane orderScrollPane) {
        this.orderScrollPane = orderScrollPane;
    }

    public JTextArea getOrderTA() {
        return orderTA;
    }

    public void setOrderTA(JTextArea orderTA) {
        this.orderTA = orderTA;
    }

    public JFrame getClientFrame() {
        return clientFrame;
    }

    public void setClientFrame(JFrame clientFrame) {
        this.clientFrame = clientFrame;
    }

    public JFrame getClientFrame2() {
        return clientFrame2;
    }

    public void setClientFrame2(JFrame clientFrame2) {
        this.clientFrame2 = clientFrame2;
    }

    public JPanel getClientPanel() {
        return clientPanel;
    }

    public void setClientPanel(JPanel clientPanel) {
        this.clientPanel = clientPanel;
    }

    public JPanel getClientPanel2() {
        return clientPanel2;
    }

    public void setClientPanel2(JPanel clientPanel2) {
        this.clientPanel2 = clientPanel2;
    }

    public JButton getLoginB() {
        return loginB;
    }

    public void setLoginB(JButton loginB) {
        this.loginB = loginB;
    }

    public JButton getRegisterB() {
        return registerB;
    }

    public void setRegisterB(JButton registerB) {
        this.registerB = registerB;
    }

    public JTextField getUserTF() {
        return userTF;
    }

    public void setUserTF(JTextField userTF) {
        this.userTF = userTF;
    }

    public JPasswordField getPassTF() {
        return passTF;
    }

    public void setPassTF(JPasswordField passTF) {
        this.passTF = passTF;
    }
}
