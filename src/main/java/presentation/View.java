package presentation;



import javax.swing.*;
import java.awt.*;

public class View {
    Administrator administrator;
    Client client;
    Employee employee;

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel label;
    private JButton adminB, clientB, angajatB;

    Controller controller = new Controller(this);
    public View(){
        // initializam obiectele
        administrator = new Administrator();
        client = new Client();
        employee = new Employee();

        //adaugam actionlistener la butoanele din clasele admin
        administrator.getAddProductB().addActionListener(controller);
        administrator.getAddProductB().setActionCommand("addProductAdmin");
        administrator.getLoginB().addActionListener(controller);
        administrator.getLoginB().setActionCommand("loginAdmin");

        //butoanele admin2 (cu operatii)  ADMIN 2

        administrator.getImportProductsB().addActionListener(controller);
        administrator.getImportProductsB().setActionCommand("importAdmin");
        administrator.getCreateProductsB().addActionListener(controller);
        administrator.getCreateProductsB().setActionCommand("createProductsB");
        administrator.getEditPrB().addActionListener(controller);
        administrator.getEditPrB().setActionCommand("editPrB");
        administrator.getDeletePrB().addActionListener(controller);
        administrator.getDeletePrB().setActionCommand("deletePrB");
        administrator.getGenerateReportB().addActionListener(controller);
        administrator.getGenerateReportB().setActionCommand("generateReportsB");
        administrator.getViewProductsB().addActionListener(controller);
        administrator.getViewProductsB().setActionCommand("viewProductsB");
        administrator.getAddProductToComp().addActionListener(controller);
        administrator.getAddProductToComp().setActionCommand("addProductToComp");
        //butoanele client 1
        client.getLoginB().addActionListener(controller);
        client.getLoginB().setActionCommand("loginClient");
        client.getRegisterB().addActionListener(controller);
        client.getRegisterB().setActionCommand("registerClient");
        //butoanele clien2
        client.getViewCB().addActionListener(controller);
        client.getViewCB().setActionCommand("viewCB");
        client.getSearchCB().addActionListener(controller);
        client.getSearchCB().setActionCommand("searchCB");
        client.getAddToOrderB().addActionListener(controller);
        client.getAddToOrderB().setActionCommand("addToOrderB");
        client.getCreateOrderB().addActionListener(controller);
        client.getCreateOrderB().setActionCommand("createOrderB");




        mainFrame = new JFrame(" ");
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new GridLayout(2,3));
        adminB = new JButton("Administrator");
        clientB = new JButton("Client");
        angajatB = new JButton("Employee");
        mainPanel.add(new JLabel(" "));
        mainPanel.add(new JLabel("Selectati utilizatorul:"));
        mainPanel.add(new JLabel(" "));
        mainPanel.add(adminB);
        mainPanel.add(clientB);
        mainPanel.add(angajatB);

        adminB.setActionCommand("adminBView");
        adminB.addActionListener(controller);
        clientB.setActionCommand("clientBView");
        clientB.addActionListener(controller);
        angajatB.setActionCommand("angajatBView");
        angajatB.addActionListener(controller);



        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JButton getAdminB() {
        return adminB;
    }

    public void setAdminB(JButton adminB) {
        this.adminB = adminB;
    }

    public JButton getClientB() {
        return clientB;
    }

    public void setClientB(JButton clientB) {
        this.clientB = clientB;
    }

    public JButton getAngajatB() {
        return angajatB;
    }

    public void setAngajatB(JButton angajatB) {
        this.angajatB = angajatB;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
