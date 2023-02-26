package bll;

import java.io.IOException;

public interface IDeliveryServiceProcessing {
     void importProducts() throws IOException;
     void addProduct(MenuItem m,boolean serializeaza) throws IOException;
     void editProduct(MenuItem m,String t,
                      double r, int c, int p,int f, int s, int pr) throws IOException;
     void deleteProduct(MenuItem m) throws IOException;
     void generateReport(int c);

     String[][] viewProducts() throws IOException, ClassNotFoundException;

}
