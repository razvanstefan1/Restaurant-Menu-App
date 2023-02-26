package data;


import java.io.*;

public class Serializator  {
    public static final String CALE_FISIER = "fisier_serializare.txt";

    public static void serialize(Object o, String fis) throws IOException {
        FileOutputStream fisier = new FileOutputStream(fis);
        ObjectOutputStream outstream = new ObjectOutputStream(fisier);

        outstream.writeObject(o);

        fisier.close();
        outstream.close();

    }
    public static Object deserialize(String fis) throws IOException, ClassNotFoundException {
        FileInputStream fisier = new FileInputStream(fis);
        ObjectInputStream instream = new ObjectInputStream(fisier);

        Object o = instream.readObject();

        fisier.close();
        instream.close();

        return o;
    }
}
