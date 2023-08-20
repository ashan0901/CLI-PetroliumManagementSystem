import java.util.Scanner;

public class stock {
    int rows = 20;
    String[][] stockDate = new String[rows][5];
    int[][] S_ID = new int[rows][5];
    String[][] stockDescription= new String[rows][5];
    int[][] Stock_Barrels = new int[rows][5];
    float[][] Stock_Capacity = new float[rows][5];
    int i = 1;

    CRUDDemo crudobj = new CRUDDemo();

    void control(){

        stock homePageObj = new stock();
        int homePage_num = homePageObj.homePage();

        switch (homePage_num){
            case 1 :
                addStock();
                break;
            case 2 :
                viewStock();
                break;
            case 3 :
                searchStock();
                break;
            case 4 :
                deleteStock();
                break;
            case 5:
                crudobj.home();
                break;

            default:
                System.out.println("Wrong Input");
                stock controlObj = new stock();
                controlObj.control();
        }
    }

    int homePage(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("       *********     STOCK MANAGEMENT     **********");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Select the number what you want ");
        System.out.println("--------------------------------");
        System.out.println("\t\t1 - Add Stock");
        System.out.println("\t\t2 - View Stock");
        System.out.println("\t\t3 - Search Stock");
        System.out.println("\t\t4 - Delete Stock");
        System.out.println("\t\t5 - Go Back");
        System.out.println("--------------------------------");
        System.out.print("Enter the number : ");
        Scanner num = new Scanner(System.in);
        int number = num.nextInt();


        return number;
    }

    void addStock(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           ADD NEW STOCK     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter The Stock Received Date :");
        Scanner d = new Scanner(System.in);
        stockDate [i][0] = d.next();

        System.out.print("Enter Stock ID: ");
        Scanner id = new Scanner(System.in);
        S_ID[i][1] = id.nextInt();

        System.out.print("Enter The stockDescription: ");
        Scanner c = new Scanner(System.in);
        stockDescription [i][2] = c.next();

        System.out.print("Enter Stock Barrels   : ");
        Scanner q = new Scanner(System.in);
        Stock_Barrels[i][3] = q.nextInt();

        System.out.print("Enter Stock Capacity      : ");
        Scanner p = new Scanner(System.in);
        Stock_Capacity [i][4] = p.nextInt();

        i++;
        System.out.println("----------------------------------------");
        System.out.println("   Successfully Added a new Stock!");
        System.out.println("----------------------------------------");
        System.out.print("Do you want to Add new Stock(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                addStock();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }

    }

    void viewStock(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           VIEW ALL StockS     ");
        System.out.println("----------------------------------------------------------------------------");

        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n"," stockDate ","ID"," stockDescription ","Stock Barrels","Paid Amount");
        System.out.println("----------------------------------------------------------------------------");

        for (int k = 1; k < this.i; k++) {
            System.out.printf("%10s\t%10d\t%10s\t\t%20d\t%12f\n", stockDate [k][0],S_ID[k][1], stockDescription [k][2], Stock_Barrels[k][3], Stock_Capacity [k][4]);

        }
        System.out.println("----------------------------------------------------------------------------");

        System.out.print("Do you want Exit View STOCK(y) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                control();
                break;
            case "n":
                viewStock();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }


    void searchStock(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           SEARCH STOCK     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the Stock ID What you want to search : ");
        Scanner id = new Scanner(System.in);
        int S_id = id.nextInt();
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n"," stockDate ","ID"," stock Description ","Stock Barrels","Paid Amount");
        System.out.println("----------------------------------------------------------------------------");
        for(int j = 1 ; j < this.i ; j++){
            if(S_id == S_ID[j][1]){
                System.out.printf("%10s\t%10d\t%10s\t\t%20d\t%12f\n", stockDate [j][0],S_ID[j][1], stockDescription [j][2], Stock_Barrels[j][3], Stock_Capacity [j][4]);
            }
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Do you want Search another Stock(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                searchStock();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("Error");
                control();
        }
    }

    void deleteStock(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           DELETE STOCK     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the stock_ID what you want to delete : ");
        Scanner id = new Scanner(System.in);
        int S_id = id.nextInt();
        System.out.print("Enter the stock Description  what you want to delete        : ");
        Scanner d = new Scanner(System.in);
        String stock_Date = d.next();

        for(int j=0 ; j<this.i;j++){
            if(S_id == this.S_ID[j][1]){
                if(stock_Date.equals(this.stockDate [j][0])) {
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.printf("%10s\t%10d\t%10s\t\t%10d\t%20f\n", stockDate[j][0],S_ID[j][1], stockDescription [j][2], Stock_Barrels[j][3], Stock_Capacity [j][4]);
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.print("Are you sure(y/n) : ");
                    Scanner a = new Scanner(System.in);
                    String ans = a.next();
                    switch (ans){
                        case "y":
                            this. stockDate [j][0] = this. stockDate [j+1][0];
                            this.S_ID[j][1] = this.S_ID[j+1][1];
                            this. stockDescription [j][2] = this. stockDescription [j+1][2];
                            this. Stock_Barrels[j][3] = this. Stock_Barrels[j+1][3];
                            this. Stock_Capacity [j][4] = this. Stock_Capacity [j+1][4];
                            break;
                        case "n":
                            control();
                    }


                }
            }

        }
        this.i = i - 1;
        System.out.print("Do you want to delete another Stock(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                deleteStock();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println(" Error");
                control();
        }

    }
}




