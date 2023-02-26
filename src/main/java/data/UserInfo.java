package data;

import java.io.File;
import java.io.IOException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UserInfo implements Serializable {
    private static final transient String USER_ADMIN = "admin";
    private static final transient String USER_PASS = "admin";
    private static final transient String EMPL_ADMIN = "employee";
    private static final transient String EMPL_PASS = "employee";
 //   private static final transient String FISIER_SERIALIZARE = "employee";
    private HashMap<String,String> clientInfo;  // user, pass si userul e unic

    public UserInfo() {
        clientInfo = new HashMap<>();
    }

    public static boolean loginAdmin(String u, String p){
        if(u.equals(USER_ADMIN) && p.equals(USER_PASS))
            return true;
        return false;
    }

    //folosita la inregistrarea clientului
    public static boolean registerClient(String user, String password) throws IOException, ClassNotFoundException {
        UserInfo a;
        File file = new File("clientInfo_serializare.txt");
        if(file.length()>0) //daca deja am ceva serializat in acel fisier (ca sa nu dea EOF)
        a = (UserInfo)Serializator.deserialize("clientInfo_serializare.txt");  //in acest obiect am clientii inregistrati pana acum
        else a = new UserInfo(); //daca nu am nimic in fisier, fac un obiect

        if(!a.getClientInfo().containsKey(user))  //daca nu exista acel user deja
        {a.getClientInfo().put(user,password);  //adaug clientul
        Serializator.serialize(a,"clientInfo_serializare.txt"); //serializez pt persistare
            System.out.println("client inregistrat cu succes");
            return true;
         }
        System.out.println("Acest username exista deja");
        return false;  //daca exista acel user deja, returnam false


    }

    //returneaza true daca se gaseste userul si pass ul in lista (ca sa se faca login)
    public static int loginClient(String user, String password) throws IOException, ClassNotFoundException {
        UserInfo a = (UserInfo)Serializator.deserialize("clientInfo_serializare.txt");
        if(a.getClientInfo().containsKey(user)){  //daca exista acel user
            if(Objects.equals(a.getClientInfo().get(user), password))   // daca acel user are acea parola
                return 1;  //daca se poate efectua login ul

            System.out.println("Parola introdusa este incorecta");
             return 2;
        }
        System.out.println("Userul " + user + " nu exista.");
        return 3;
    }

    public HashMap<String, String> getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(HashMap<String, String> clientInfo) {
        this.clientInfo = clientInfo;
    }
}
