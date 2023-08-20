import java.util.Scanner;

public class supplier {


    //supplier management attributes
    int rows = 20;
    String[][] Date = new String[rows][5];
    int[][] S_ID = new int[rows][5];
    String[][] country = new String[rows][5];
    int[][] Quantity_of_Barrels = new int[rows][5];
    float[][] Paid_Amount = new float[rows][5];
    int i = 1;





    CRUDDemo crudobj = new CRUDDemo();

    void control(){

        supplier homePageObj = new supplier();
        int homePage_num = homePageObj.homePage();

        switch (homePage_num){
            case 1 :
                addSupplier();
                break;
            case 2 :
                viewSupplier();
                break;
            case 3 :
                searchSupplier();
                break;
            case 4 :
                deleteSupplier();
                break;
            case 5 :
                crudobj.home();
                break;
            default:
                System.out.println("Wrong Input");
                supplier controlObj = new supplier();
                controlObj.control();
        }
    }

    int homePage(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("       *********      SUPPLIER MANAGEMENT     **********");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Select the number what you want ");
        System.out.println("--------------------------------");
        System.out.println("\t\t1 - Add Supplier");
        System.out.println("\t\t2 - View Supplier");
        System.out.println("\t\t3 - Search Supplier");
        System.out.println("\t\t4 - Delete Supplier");
        System.out.println("\t\t5 - Back to home Page");
        System.out.println("--------------------------------");
        System.out.print("Enter the number : ");
        Scanner num = new Scanner(System.in);
        int number = num.nextInt();


        return number;
    }

    void addSupplier(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           ADD NEW SUPPLIER     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter The Date (yyyy/mm/dd) : ");
        Scanner d = new Scanner(System.in);
        this.Date[this.i][0] = d.next();

        System.out.print("Enter Supplier ID (xxxxxxx) : ");
        Scanner id = new Scanner(System.in);
        this.S_ID[this.i][1] = id.nextInt();

        System.out.print("Enter The Country Name      : ");
        Scanner c = new Scanner(System.in);
        this.country[this.i][2] = c.next();

        System.out.print("Enter Quantity of Barrels   : ");
        Scanner q = new Scanner(System.in);
        this.Quantity_of_Barrels[this.i][3] = q.nextInt();

        System.out.print("Enter Paid Amount by $      : ");
        Scanner p = new Scanner(System.in);
        this.Paid_Amount[this.i][4] = p.nextInt();

        this.i++;
        System.out.println("----------------------------------------");
        System.out.println("   Successfully Added a new Supplier!");
        System.out.println("----------------------------------------");
        System.out.print("Do you want to Add new Supplier(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                addSupplier();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }

    }

    void viewSupplier(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           VIEW ALL SUPPLIERS     ");
        System.out.println("----------------------------------------------------------------------------");

        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n","Date","ID","Country","Number of Barrels","Paid Amount");
        System.out.println("----------------------------------------------------------------------------");

        for (int k = 1; k < this.i; k++) {
            System.out.printf("%10s\t%10d\t%10s\t\t%10d\t%20f\n", this.Date[k][0], this.S_ID[k][1], this.country[k][2], this.Quantity_of_Barrels[k][3], this.Paid_Amount[k][4]);

        }
        System.out.println("----------------------------------------------------------------------------");

        System.out.print("Do you want Exit View Supplier(y) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                control();
                break;
            case "n":
                viewSupplier();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }


    void searchSupplier(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           SEARCH SUPPLIER     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the Supplier ID What you want to search : ");
        Scanner id = new Scanner(System.in);
        int S_id = id.nextInt();
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n","Date","ID","Country","Number of Barrels","Paid Amount");
        System.out.println("----------------------------------------------------------------------------");
        for(int j = 1 ; j < this.i ; j++){
            if(S_id == this.S_ID[j][1]){
                System.out.printf("%10s\t%10d\t%10s\t\t%10d\t%20f\n", this.Date[j][0], this.S_ID[j][1], this.country[j][2], this.Quantity_of_Barrels[j][3], this.Paid_Amount[j][4]);
            }
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Do you want Search another Supplier(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                searchSupplier();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }

    void deleteSupplier(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           DELETE SUPPLIER     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the supplier_ID what you want to delete : ");
        Scanner id = new Scanner(System.in);
        int S_id = id.nextInt();
        System.out.print("Enter the Date what you want to delete        : ");
        Scanner d = new Scanner(System.in);
        String date = d.next();

        for(int j=0 ; j<this.i;j++){
            if(S_id == this.S_ID[j][1]){
                if(date.equals(this.Date[j][0])) {
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.printf("%10s\t%10d\t%10s\t\t%10d\t%20f\n", this.Date[j][0], this.S_ID[j][1], this.country[j][2], this.Quantity_of_Barrels[j][3], this.Paid_Amount[j][4]);
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.print("Are you sure(y/n) : ");
                    Scanner a = new Scanner(System.in);
                    String ans = a.next();
                    switch (ans){
                        case "y":
                            this.Date[j][0] = this.Date[j+1][0];
                            this.S_ID[j][1] = this.S_ID[j+1][1];
                            this.country[j][2] = this.country[j+1][2];
                            this.Quantity_of_Barrels[j][3] = this.Quantity_of_Barrels[j+1][3];
                            this.Paid_Amount[j][4] = this.Paid_Amount[j+1][4];
                            break;
                        case "n":
                            control();
                    }


                }
            }

        }
        this.i = this.i - 1;
        System.out.print("Do you want to delete another Supplier(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                deleteSupplier();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }

}

