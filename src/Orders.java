import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Orders extends Function{
    int arraySize = 100;

    String[] date;
    String[] username;
    String[] itemsName;
    String[] itemsPricePerQuantity;
    String[] itemsQuantity;
    double[] totalPrice;
    
    int newOrderID=-1;
    
    Orders() throws Exception{
        date = new String[arraySize];
        username = new String[arraySize];
        itemsName = new String[arraySize];
        itemsQuantity = new String[arraySize];
        itemsPricePerQuantity = new String[arraySize];
        totalPrice = new double[arraySize];

        File file = new File("../Orders.txt");
        if(file.createNewFile()){
            System.out.println("File created: " + file.getName());
        }

        Scanner fr = new Scanner(file);

        while(fr.hasNextLine()){
            this.newOrderID = fr.nextInt();
            this.date[newOrderID] = fr.next();
            this.username[newOrderID] = fr.next();
            this.itemsName[newOrderID] = fr.next();
            this.itemsPricePerQuantity[newOrderID] = fr.next();
            this.itemsQuantity[newOrderID] = fr.next();
            this.totalPrice[newOrderID] = fr.nextDouble();
        }

        fr.close();

    }

    void createOrder(String date, String username, String itemsName, String itemsPricePerQuantity, String itemsQuantity, double totalPrice){
        this.newOrderID++;
        this.date[newOrderID] = date;
        this.username[newOrderID] = username;
        this.itemsName[newOrderID] = itemsName;
        this.itemsPricePerQuantity[newOrderID] = itemsPricePerQuantity;
        this.itemsQuantity[newOrderID] = itemsQuantity;
        this.totalPrice[newOrderID] = totalPrice;
    }

    String[] getOrderinfo(String date){
        String[] orderInfo = new String[6];

        for(int i=0; i<this.newOrderID; i++){
            if(date.equals(this.username[i])){
                orderInfo[0] = String.valueOf(i);
                orderInfo[1] = this.username[i];
                orderInfo[2] = this.itemsName[i];
                orderInfo[3] = this.itemsPricePerQuantity[i];
                orderInfo[4] = this.itemsQuantity[i];
                orderInfo[5] = String.valueOf(this.totalPrice[i]);
                break;
            }
        }

        return orderInfo;
    }

    void editOrder(int orderID, String date, String username, String itemsName, String itemsPricePerQuantity, String itemsQuantity){
        this.date[orderID] = date;
        this.username[orderID] = username;
        this.itemsName[orderID] = itemsName;
        this.itemsPricePerQuantity[orderID] = itemsPricePerQuantity;
        this.itemsQuantity[orderID] = itemsQuantity;
    }

    void saveOrderInfo() throws Exception{
        File file = new File("../Orders.txt");
        
        if(file.createNewFile()){
            System.out.println("File created");
        }

        FileWriter fw = new FileWriter(file);
        fw.write(this.toString());
        fw.close();
    }

    void removeOrder(int orderID){
        String[] tempdate = new String[arraySize];
        String[] tempusername = new String[arraySize];
        String[] tempitemsName = new String[arraySize];
        String[] tempitemsPricePerQuantity = new String[arraySize];
        String[] tempitemsQuantity = new String[arraySize];
        double[] temptotalPrice = new double[arraySize];

        for(int i=0, j=0; i<=this.newOrderID; i++){
            if(i != orderID){
                tempdate[j] = this.date[i];
                tempusername[j] = this.username[i];
                tempitemsName[j] = this.itemsName[i];
                tempitemsPricePerQuantity[j] = this.itemsPricePerQuantity[i];
                tempitemsQuantity[j] = this.itemsQuantity[i];
                temptotalPrice[j] = this.totalPrice[i];
                j++;
            }
        }

        this.newOrderID--;

        for(int i=0; i<=newOrderID; i++){
            this.date[i] = tempdate[i];
            this.username[i] = tempusername[i];
            this.itemsName[i] = tempitemsName[i];
            this.itemsPricePerQuantity[i] = tempitemsPricePerQuantity[i];
            this.itemsQuantity[i] = tempitemsQuantity[i];
            this.totalPrice[i] = temptotalPrice[i];
        }
    }

    boolean illegalUserTextInput(String text){
        return super.illegalUserTextInput(text);
    }

    @Override
    public String toString(){
        String info = "";

        for(int i=0; i<=this.newOrderID; i++){
            info += i + " " + this.date[i] + " " + this.username[i] + " " + this.itemsName[i] + " " + this.itemsPricePerQuantity[i] + " " + this.itemsQuantity[i] + " " + this.totalPrice[i];
            
            if(i != this.newOrderID){
                info += "\n";
            }
        }

        return info;
    }

}

/*
Orders

- arraySize : int
- date : String[]
- username : String[]
- itemsName : String[]
- itemsPricePerQuantity : String[]
- itemsQuantity : String[]
- totalPrice : double[]
- newOrderID : int

+ Orders()
+ createOrder(date : String, username : String, itemsName : String, itemsPricePerQuantity : String, itemsQuantity : String, totalPrice : double) : void
+ getOrderinfo(date : String) : String[]
+ editOrder(orderID : int, date : String, username : String, itemsName : String, itemsPricePerQuantity : String, itemsQuantity : String) : void
+ saveOrderInfo() : void
+ removeOrder(orderID : int) : void
+ illegalUserTextInput(text : String) : boolean
+ toString() : String

 */