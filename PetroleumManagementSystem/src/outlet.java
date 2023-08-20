import java.util.Scanner;

public class outlet {
    int rows = 20;
    String[][] Date = new String[rows][5];
    int[][] O_ID = new int[rows][5];
    String[][] district = new String[rows][5];
    int[][] Quantity_of_Liters = new int[rows][5];
    float[][] Paid_Amount = new float[rows][5];
    int i = 1;

    CRUDDemo crudobj = new CRUDDemo();

    void control(){

        outlet homePageObj = new outlet();
        int homePage_num = homePageObj.homePage();

        switch (homePage_num){
            case 1 :
                addOutlet();
                break;
            case 2 :
                viewOutlet();
                break;
            case 3 :
                searchOutlet();
                break;
            case 4 :
                deleteOutlet();
                break;
            case 5:
                crudobj.home();
                break;
            default:
                System.out.println("Wrong Input");
                outlet controlObj = new outlet();
                controlObj.control();
        }
    }

    int homePage(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("       *********     OUTLET MANAGEMENT     **********");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Select the number what you want ");
        System.out.println("--------------------------------");
        System.out.println("\t\t1 - Add Outlet");
        System.out.println("\t\t2 - View Outlet");
        System.out.println("\t\t3 - Search Outlet");
        System.out.println("\t\t4 - Delete Outlet");
        System.out.println("\t\t5 - Back to home Page");
        System.out.println("--------------------------------");
        System.out.print("Enter the number : ");
        Scanner num = new Scanner(System.in);
        int number = num.nextInt();


        return number;
    }

    void addOutlet(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           ADD NEW OUTLET     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter The Date (yyyy/mm/dd) : ");
        Scanner d = new Scanner(System.in);
        Date[i][0] = d.next();

        System.out.print("Enter Output ID (xxxxxxx) : ");
        Scanner id = new Scanner(System.in);
        O_ID[i][1] = id.nextInt();

        System.out.print("Enter The District Name      : ");
        Scanner c = new Scanner(System.in);
        district[i][2] = c.next();

        System.out.print("Enter Quantity of Liters   : ");
        Scanner q = new Scanner(System.in);
        Quantity_of_Liters[i][3] = q.nextInt();

        System.out.print("Enter Paid Amount by Rs      : ");
        Scanner p = new Scanner(System.in);
        Paid_Amount[i][4] = p.nextInt();

        i++;
        System.out.println("----------------------------------------");
        System.out.println("   Successfully Added a new Outlet!");
        System.out.println("----------------------------------------");
        System.out.print("Do you want to Add new Outlet(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                addOutlet();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }

    }

    void viewOutlet(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           VIEW ALL OUTLETS     ");
        System.out.println("----------------------------------------------------------------------------");

        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n","Date","ID","District","Number of Liters","Paid Amount");
        System.out.println("----------------------------------------------------------------------------");

        for (int k = 1; k < this.i; k++) {
            System.out.printf("%10s\t%10d\t%10s\t\t%10d\t%20f\n",Date[k][0],O_ID[k][1],district[k][2],Quantity_of_Liters[k][3],Paid_Amount[k][4]);

        }
        System.out.println("----------------------------------------------------------------------------");

        System.out.print("Do you want Exit View Outlet(y) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                control();
                break;
            case "n":
                viewOutlet();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }


    void searchOutlet(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           SEARCH OUTLET     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the Outlet ID What you want to search : ");
        Scanner id = new Scanner(System.in);
        int O_id = id.nextInt();
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n","Date","ID","District","Number of Liters","Paid Amount");
        System.out.println("----------------------------------------------------------------------------");
        for(int j = 1 ; j < this.i ; j++){
            if(O_id == O_ID[j][1]){
                System.out.printf("%10s\t%10d\t%10s\t\t%10d\t%20f\n",Date[j][0],O_ID[j][1],district[j][2],Quantity_of_Liters[j][3],Paid_Amount[j][4]);
            }
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Do you want Search another Outlet(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                searchOutlet();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }

    void deleteOutlet(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           DELETE OUTLET     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the outlet_ID what you want to delete : ");
        Scanner id = new Scanner(System.in);
        int O_id = id.nextInt();
        System.out.print("Enter the Date what you want to delete        : ");
        Scanner d = new Scanner(System.in);
        String date = d.next();

        for(int j=0 ; j<this.i;j++){
            if(O_id == this.O_ID[j][1]){
                if(date.equals(this.Date[j][0])) {
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.printf("%10s\t%10d\t%10s\t\t%10d\t%20f\n", Date[j][0], O_ID[j][1], district[j][2], Quantity_of_Liters[j][3], Paid_Amount[j][4]);
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.print("Are you sure(y/n) : ");
                    Scanner a = new Scanner(System.in);
                    String ans = a.next();
                    switch (ans){
                        case "y":
                            this.Date[j][0] = this.Date[j+1][0];
                            this.O_ID[j][1] = this.O_ID[j+1][1];
                            this.district[j][2] = this.district[j+1][2];
                            this.Quantity_of_Liters[j][3] = this.Quantity_of_Liters[j+1][3];
                            this.Paid_Amount[j][4] = this.Paid_Amount[j+1][4];
                            break;
                        case "n":
                            control();
                    }


                }
            }

        }
        this.i = i - 1;
        System.out.print("Do you want to delete another Outlet(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                deleteOutlet();
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
