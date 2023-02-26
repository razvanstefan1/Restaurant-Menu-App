package bll;
import data.FileWriter;
import data.Serializator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    private HashSet<MenuItem> meniu;
    private HashMap<Order,List<MenuItem>> orders;

    public static ArrayList<MenuItem> auxList;
    public int orderNr=0;

    public DeliveryService(){
        meniu = new HashSet<MenuItem>();
        orders = new HashMap<>();
        auxList = new ArrayList<>();
    }

    @Override
    public void importProducts() throws IOException {
        Path file = Paths.get("products.csv");
        try(Stream<String>lines = Files.lines(file)
                .onClose(() -> System.out.println("Finished reading the file"))) {
            lines.forEach(s -> {
                        try {
                            addProduct(toProduct(s),false);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        Serializator.serialize(meniu,"meniu_serializare.txt");
    }

    @Override
    public void addProduct(MenuItem m,boolean serializeaza) throws IOException {  //daca serializeaza e true imi face
        if(m!=null)
        {meniu.add(m);
           if(serializeaza) Serializator.serialize(meniu,"meniu_serializare.txt");
        }
    }

    @Override
    public void editProduct(MenuItem m,String t,
                            double r, int c, int p,int f, int s, int pr) throws IOException {
        if(t!=null) m.setTitle(t);
        if(r!=-1) m.setRating(r);
        if(c!=-1) m.setCalories(c);
        if(p!=-1) m.setProtein(p);
        if(f!=-1) m.setFat(f);
        if(s!=-1) m.setSodium(s);
        if(pr!=-1) m.setPrice(pr);
        Serializator.serialize(meniu,"meniu_serializare.txt");
    }

    @Override
    public void deleteProduct(MenuItem m) throws IOException {
        meniu.removeIf(n -> n.equals(m));
        Serializator.serialize(meniu,"meniu_serializare.txt");
    }

    @Override
    public void generateReport(int c) {

    }

    public void generateReportt(int criteria, String s1, String s2) throws IOException, ClassNotFoundException {
        //criteria = 0 => time interval blabla
        //List<Order>
      //  orders = (HashMap<Order, List<MenuItem>>) Serializator.deserialize("comenzi_serializare.txt");
        Map<Order, List<MenuItem>> map = new HashMap<>();
            if(criteria==1) {
                map = orders.entrySet()
                        .stream()
                        .filter(k -> reportFilter1(criteria, k.getKey(), s1, s2,null) == true)
                        .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
                FileWriter.createReportFile(map, s1, s2);
            }
            if(criteria==2){
                HashMap<MenuItem , Integer> auxFrecv  = new HashMap<>(); //aici numar aparitiile
                ArrayList<MenuItem> aux = new ArrayList<>();
                orders.entrySet().stream().forEach(k-> {
                                                        for(MenuItem m: k.getValue()){
                                                            if(auxFrecv.containsKey(m)){
                                                                auxFrecv.put(m,auxFrecv.get(m)+1);
                                                            }
                                                            else
                                                                auxFrecv.put(m, 1);
                                                        }});
                auxFrecv.entrySet().forEach(k-> {  //adaugam intr un arraylist auxiliar menuitem urile care au fost comandate de mai mult de nb ori
                                                if(k.getValue()>=Integer.valueOf(s1)){
                                                    aux.add(k.getKey());
                                                }});
                FileWriter.createReportFile2(aux,s1);
            }
            if(criteria == 3){  //clientii care au comandat de mai mult de nbc ori si comanda de min priceMin
                int priceMin = Integer.parseInt(s2);
                HashMap<String , Integer> auxFrecvCl  = new HashMap<>();
                orders.entrySet().stream().forEach(k-> { if(totalPrice((ArrayList<MenuItem>)k.getValue())>=priceMin)
                                                                if(auxFrecvCl.containsKey(k.getKey().getClientID()))
                                                                    auxFrecvCl.put(k.getKey().getClientID(),auxFrecvCl.get(k.getKey().getClientID()) + 1);
                                                                    else
                                                                        auxFrecvCl.put(k.getKey().getClientID(),1);});
                FileWriter.createReportFile3(auxFrecvCl,s1,priceMin);
            }
            if(criteria == 4){
                HashMap<MenuItem, Integer> auxFrecv2 = new HashMap<>();
                orders.entrySet().stream().forEach(k-> {    if(k.getKey().getDateFormat().substring(0,10).equals(s1))
                                                                 for(MenuItem m: k.getValue()){
                                                                   if(auxFrecv2.containsKey(m)){
                                                                            auxFrecv2.put(m,auxFrecv2.get(m)+1);
                                                                     }
                                                                    else
                                                                    auxFrecv2.put(m, 1);
                }});
                FileWriter.createReport4(auxFrecv2,s1);
            }
    }

    public static boolean reportFilter1(int nr,Order o, String s1, String s2,ArrayList<MenuItem> aux){
        if(nr==1){
            int ora1 = getMinutes(s1,false);
            int ora2 = getMinutes(s2,false);
            int oraMea = getMinutes(o.getDateFormat().substring(11,16),true);
            if(ora2<ora1){   //daca avem gen 23-40 si 02-20
                if(!(oraMea>=ora2 && oraMea<=ora1))
                    return true;
            }else{
                if(oraMea>=ora1 && oraMea<=ora2)
                    return true;
            }
            return false;
        }
        return false;
    }

    public static int totalPrice(ArrayList<MenuItem> lista){
        int k=0; for(MenuItem m: lista) k+=m.getPrice();  return k;}

    public static int getMinutes(String s,boolean tab){  // s e de forma "15-30"  daca tab e false facem pt input de la gui, altfel pt stringul de la order care are _ ca delim
        String[] aux = new String[2];
       if(tab==false) aux = s.split("-");
       else
           aux=s.split("_");
        int ore = Integer.parseInt(aux[0]);
        int min = Integer.parseInt(aux[1]);
        return ore*60 + min;

    }

    public List<MenuItem> ssearchProductsClient(String keyword,double rating,int calories
            , int protein, int fat, int sodium, int price){
        List<MenuItem> result =meniu.stream().filter(c -> c.clientFilter(keyword, rating, calories, protein, fat
                        , sodium, price))
                .collect(Collectors.toList());
        return result;
    }

    public void addProductToOrder(MenuItem m){
        auxList.add(m);
    }
    public void createOrder(String userID) throws IOException, ClassNotFoundException {
        File file = new File("comenzi_serializare.txt");
        //if (file.length() != 0)
            //orders= (HashMap<Order, List<MenuItem>>) Serializator.deserialize("comenzi_serializare.txt");
        FileWriter fw = new FileWriter();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
        String data = df.format(new Date());
        Order o = new Order(orders.size(),userID,data);
        fw.createFile(auxList,orders.size(),userID,data,totalPrice(auxList));
        ArrayList<MenuItem>auxList2 = new ArrayList<>(auxList);  //daca nu fac asa, imi sterge si din hashmap cand dau auxList.clear();
        orders.put(o,auxList2);
        auxList.clear();
        Serializator.serialize(orders,"comenzi_serializare.txt");
    }

    public void createCompositeProduct( String n) throws IOException {
        ArrayList<MenuItem> auxList3 = new ArrayList<>(auxList);
        auxList.clear();
        CompositeProduct p = new CompositeProduct(n, auxList3);
      //  System.out.println();
       // System.out.println(p.toString());
        meniu.add(p);
        Serializator.serialize(meniu,"meniu_serializare.txt");
    }
    @Override
    public String[][] viewProducts() throws IOException, ClassNotFoundException {
        meniu = (HashSet<MenuItem>) Serializator.deserialize("meniu_serializare.txt");
        int n = meniu.size();
        String[][] tabel = new String[n][7];
        int i=-1;
        for( MenuItem m: meniu){
           // System.out.println(m.toStringComma());
            ++i;
            String aux = m.toStringComma();
            String[] auxx =aux.split(",");
            for(int l=0;l<7;l++)
                tabel[i][l]=auxx[l];
        }
        return tabel;
    }

    public List<MenuItem> searchProductsClient(String keyword,double rating,int calories
    , int protein, int fat, int sodium, int price){
        List<MenuItem> result =meniu.stream().filter(c -> c.clientFilter(keyword, rating, calories, protein, fat
                        , sodium, price))
                .collect(Collectors.toList());
        return result;
    }

    public MenuItem toProduct(String s){
        String[] str = new String[7];
        str = s.split(",");

        if(!str[0].equals("Title")){  //creem obiect doar daca nu suntem la primul rand
        MenuItem b = new BaseProduct(str[0], Double.parseDouble(str[1]),Integer.parseInt(str[2]),
                                     Integer.parseInt(str[3]),Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6]));
        return b;
        }
        return null;
    }

    public String toStringOrders() {
        String s = "";
        for (Map.Entry<Order, List<MenuItem>> entry : orders.entrySet()) {
            s += entry.getKey().toString();
            for (MenuItem m : entry.getValue())
            {s += m.toString();
                s+="\n";
                }
            s+="\n\n";
        }
        return s;
    }
    public HashSet<MenuItem> getMeniu() {
        return meniu;
    }

    public void setMeniu(HashSet<MenuItem> meniu) {
        this.meniu = meniu;
    }

    public HashMap<Order, List<MenuItem>> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Order, List<MenuItem>> orders) {
        this.orders = orders;
    }


    @Override
    public void update() {

    }
}
