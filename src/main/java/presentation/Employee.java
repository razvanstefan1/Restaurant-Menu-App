package presentation;

import javax.swing.*;

public class Employee {

    private JFrame mainFrame;
    private JPanel p1;

    public Employee(){
        mainFrame = new JFrame();
        mainFrame.setSize(300,300);
        p1 = new JPanel();
        mainFrame.add(p1);
    }
}
