package presentation;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Administrator {
    private JFrame adminFrame,adminFrame2;
    private JPanel adminPanel,adminPanel2,adminPanel2main,adminPanel3,adminPanel4;
    private JButton addProductB,importProductsB,createProductsB,editPrB,deletePrB,generateReportB,viewProductsB,addProductToComp;
    private JButton loginB;
    private JComboBox genReportCB;
    private JTextField userTF, titleTF,ratingTF,caloriesTF,proteinTF,fatTF,sodiumTF,priceTF,genPrTF1,genPrTF2,nameOfProdTF;
    private JTextArea adminTextArea1,adminTextArea2;
    private JList JlistAdmin;
    private JScrollPane JScrollAdmin;
    private JPasswordField passTF;
    private JLabel labelAux,labelAux2,labelAux3;
    public Administrator(){

        String[] genRepStr = {"Select criteria","Time interval","Products ordered more than \n selected times"
                               , "Clients that have ordered more \n than specified no. of times\n + order value higher \nthan specified",
                "Products ordered \nwithin a specified day"
                 };//pt combobox cu selectie criteriu generare rap

        //adminPanel1
        adminFrame = new JFrame("administrator");
        adminFrame2 = new JFrame("Operatii administrator");
        adminPanel2 = new JPanel(new GridLayout(13,3));  // panel pt operatii
        adminPanel = new JPanel(new GridLayout(3,2));
        adminPanel2main = new JPanel(new GridLayout(2,1));
        adminPanel4 = new JPanel(new GridLayout(1,2));
        adminPanel3 = new JPanel();

        adminFrame.setSize(500,200);
        adminFrame2.setSize(1200,700);

        loginB = new JButton("Log in");
        userTF = new JTextField();
        passTF = new JPasswordField();

        adminPanel.add(new JLabel("User: "));
        adminPanel.add(userTF);
        adminPanel.add(new JLabel("Password: "));

        adminPanel.add(passTF);
        adminPanel.add(loginB);
        adminPanel.add(loginB);

        adminFrame.add(adminPanel);
        adminFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);



        // Adminpanel 2
        importProductsB = new JButton("Import products");
        addProductB= new JButton("Add product:");
        createProductsB = new JButton("Create product:");
        editPrB = new JButton("Edit product:");
        deletePrB = new JButton("Delete product: ");
        generateReportB = new JButton("Generate report:");
        viewProductsB = new JButton("View products");
        addProductToComp = new JButton("Add product to " + "\n" + "composite");

        genReportCB = new JComboBox(genRepStr);
        adminTextArea1 = new JTextArea();


        JlistAdmin = new JList();

        titleTF = new JTextField();
        ratingTF = new JTextField();
        caloriesTF = new JTextField();
        proteinTF = new JTextField();
        fatTF = new JTextField();
        sodiumTF = new JTextField();
        priceTF = new JTextField();
        genPrTF1 = new JTextField();
        genPrTF2 = new JTextField();
        adminTextArea2 = new JTextArea();
        labelAux = new JLabel("---");
        labelAux2 = new JLabel("<html>For criteria that require only one input fill the first text field. <br/> For date or time use \"-\" as a separator.</html>");
        nameOfProdTF = new JTextField();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        adminPanel2.setBorder(border);
        adminPanel3.setBorder(border);


        adminPanel2.add(importProductsB);
        adminPanel2.add(viewProductsB);
        adminPanel2.add(new JLabel(" "));

        adminPanel2.add(addProductB);
        adminPanel2.add(new JLabel("Title:"));
        adminPanel2.add(titleTF);

        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel("Rating:"));
        adminPanel2.add(ratingTF);

        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel("Calories:"));
        adminPanel2.add(caloriesTF);

        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel("Protein:"));
        adminPanel2.add(proteinTF);

        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel("Fat:"));
        adminPanel2.add(fatTF);

        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel("Sodium:"));
        adminPanel2.add(sodiumTF);

        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel("Price:"));
        adminPanel2.add(priceTF);

        JScrollAdmin = new JScrollPane(JlistAdmin);

        adminPanel2.add(deletePrB);
        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel(" "));

        adminPanel2.add(editPrB);
        adminPanel2.add(new JLabel(" "));
        adminPanel2.add(new JLabel(" "));

       // adminPanel2.add(createProductsB);


      //  adminPanel2.add(generateReportB);
      //  adminPanel2.add(genReportCB);
      //  adminPanel2.add(adminTextArea1);
        labelAux3 = new JLabel("Name of new Product:");

        addProductToComp.setBounds(4,2,150,50);
        createProductsB.setBounds(4,53,150,25);
        labelAux3.setBounds(4,80,150,25);
        nameOfProdTF.setBounds(4,107,150,25);
        adminTextArea2.setBounds(160,2,425,200);
        generateReportB.setBounds(4,205,150,25);
        genReportCB.setBounds(160,205,425,25);
        genPrTF1.setBounds(160,235,150,25);
        genPrTF2.setBounds(330,235,150,25);
        labelAux.setBounds(315,235,10,25);
        labelAux2.setBounds(4,235,150,100);

        adminPanel3.setLayout(null);
        adminPanel3.add(addProductToComp);
        adminPanel3.add(createProductsB);
        adminPanel3.add(adminTextArea2);
        adminPanel3.add(generateReportB);
        adminPanel3.add(genReportCB);
        adminPanel3.add(genPrTF1);
        adminPanel3.add(genPrTF2);
        adminPanel3.add(labelAux);
        adminPanel3.add(labelAux2);
        adminPanel3.add(labelAux3);
        adminPanel3.add(nameOfProdTF);

        adminPanel4.add(adminPanel2);
        adminPanel4.add(adminPanel3);

        adminPanel2main.add(adminPanel4);
        adminPanel2main.add(JScrollAdmin);




        adminFrame2.add(adminPanel2main);
        adminFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    public JPanel getAdminPanel3() {
        return adminPanel3;
    }

    public void setAdminPanel3(JPanel adminPanel3) {
        this.adminPanel3 = adminPanel3;
    }

    public JPanel getAdminPanel4() {
        return adminPanel4;
    }

    public void setAdminPanel4(JPanel adminPanel4) {
        this.adminPanel4 = adminPanel4;
    }

    public JButton getAddProductToComp() {
        return addProductToComp;
    }

    public void setAddProductToComp(JButton addProductToComp) {
        this.addProductToComp = addProductToComp;
    }

    public JScrollPane getJScrollAdmin() {
        return JScrollAdmin;
    }

    public void setJScrollAdmin(JScrollPane JScrollAdmin) {
        this.JScrollAdmin = JScrollAdmin;
    }

    public JFrame getAdminFrame() {
        return adminFrame;
    }

    public void setAdminFrame(JFrame adminFrame) {
        this.adminFrame = adminFrame;
    }

    public JFrame getAdminFrame2() {
        return adminFrame2;
    }

    public void setAdminFrame2(JFrame adminFrame2) {
        this.adminFrame2 = adminFrame2;
    }

    public JPanel getAdminPanel() {
        return adminPanel;
    }

    public void setAdminPanel(JPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    public JPanel getAdminPanel2() {
        return adminPanel2;
    }

    public void setAdminPanel2(JPanel adminPanel2) {
        this.adminPanel2 = adminPanel2;
    }

    public JButton getAddProductB() {
        return addProductB;
    }

    public void setAddProductB(JButton addProductB) {
        this.addProductB = addProductB;
    }

    public JButton getImportProductsB() {
        return importProductsB;
    }

    public void setImportProductsB(JButton importProductsB) {
        this.importProductsB = importProductsB;
    }

    public JButton getCreateProductsB() {
        return createProductsB;
    }

    public void setCreateProductsB(JButton createProductsB) {
        this.createProductsB = createProductsB;
    }

    public JButton getEditPrB() {
        return editPrB;
    }

    public void setEditPrB(JButton editPrB) {
        this.editPrB = editPrB;
    }

    public JButton getDeletePrB() {
        return deletePrB;
    }

    public void setDeletePrB(JButton deletePrB) {
        this.deletePrB = deletePrB;
    }

    public JButton getGenerateReportB() {
        return generateReportB;
    }

    public void setGenerateReportB(JButton generateReportB) {
        this.generateReportB = generateReportB;
    }

    public JButton getLoginB() {
        return loginB;
    }

    public void setLoginB(JButton loginB) {
        this.loginB = loginB;
    }

    public JTextField getNameOfProdTF() {
        return nameOfProdTF;
    }

    public void setNameOfProdTF(JTextField nameOfProdTF) {
        this.nameOfProdTF = nameOfProdTF;
    }

    public JLabel getLabelAux() {
        return labelAux;
    }

    public void setLabelAux(JLabel labelAux) {
        this.labelAux = labelAux;
    }

    public JLabel getLabelAux2() {
        return labelAux2;
    }

    public void setLabelAux2(JLabel labelAux2) {
        this.labelAux2 = labelAux2;
    }

    public JLabel getLabelAux3() {
        return labelAux3;
    }

    public void setLabelAux3(JLabel labelAux3) {
        this.labelAux3 = labelAux3;
    }

    public JComboBox getGenReportCB() {
        return genReportCB;
    }

    public void setGenReportCB(JComboBox genReportCB) {
        this.genReportCB = genReportCB;
    }

    public JTextField getUserTF() {
        return userTF;
    }

    public void setUserTF(JTextField userTF) {
        this.userTF = userTF;
    }

    public JTextField getTitleTF() {
        return titleTF;
    }

    public void setTitleTF(JTextField titleTF) {
        this.titleTF = titleTF;
    }

    public JTextField getRatingTF() {
        return ratingTF;
    }

    public void setRatingTF(JTextField ratingTF) {
        this.ratingTF = ratingTF;
    }

    public JTextField getCaloriesTF() {
        return caloriesTF;
    }

    public void setCaloriesTF(JTextField caloriesTF) {
        this.caloriesTF = caloriesTF;
    }

    public JTextField getProteinTF() {
        return proteinTF;
    }

    public void setProteinTF(JTextField proteinTF) {
        this.proteinTF = proteinTF;
    }

    public JTextField getFatTF() {
        return fatTF;
    }

    public void setFatTF(JTextField fatTF) {
        this.fatTF = fatTF;
    }

    public JTextField getSodiumTF() {
        return sodiumTF;
    }

    public void setSodiumTF(JTextField sodiumTF) {
        this.sodiumTF = sodiumTF;
    }

    public JTextField getPriceTF() {
        return priceTF;
    }

    public void setPriceTF(JTextField priceTF) {
        this.priceTF = priceTF;
    }

    public JTextArea getAdminTextArea() {
        return adminTextArea1;
    }

    public void setAdminTextArea(JTextArea adminTextArea) {
        this.adminTextArea1 = adminTextArea;
    }

    public JTextField getGenPrTF1() {
        return genPrTF1;
    }

    public void setGenPrTF1(JTextField genPrTF1) {
        this.genPrTF1 = genPrTF1;
    }

    public JTextField getGenPrTF2() {
        return genPrTF2;
    }

    public void setGenPrTF2(JTextField genPrTF2) {
        this.genPrTF2 = genPrTF2;
    }

    public JTextArea getAdminTextArea1() {
        return adminTextArea1;
    }

    public void setAdminTextArea1(JTextArea adminTextArea1) {
        this.adminTextArea1 = adminTextArea1;
    }

    public JTextArea getAdminTextArea2() {
        return adminTextArea2;
    }

    public void setAdminTextArea2(JTextArea adminTextArea2) {
        this.adminTextArea2 = adminTextArea2;
    }

    public JPasswordField getPassTF() {
        return passTF;
    }

    public void setPassTF(JPasswordField passTF) {
        this.passTF = passTF;
    }

    public JButton getViewProductsB() {
        return viewProductsB;
    }

    public void setViewProductsB(JButton viewProductsB) {
        this.viewProductsB = viewProductsB;
    }

    public JList getJlistAdmin() {
        return JlistAdmin;
    }

    public void setJlistAdmin(JList JlistAdmin) {
        this.JlistAdmin = JlistAdmin;
    }

    public JPanel getAdminPanel2main() {
        return adminPanel2main;
    }

    public void setAdminPanel2main(JPanel adminPanel2main) {
        this.adminPanel2main = adminPanel2main;
    }
}
