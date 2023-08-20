import java.util.Scanner;

public class Transport{
    int rows = 100;
    String[][] Date = new String[rows][5];
    String[][] Dr_ID = new String[rows][5];
    String[][] Dr_Name = new String[rows][5];
    String[][]  Bow_ID  = new String[rows][5];
    String[][] Des = new String[rows][5];
    int i = 1;

    CRUDDemo crudobj = new CRUDDemo();

    void control(){

        Transport homePageObj = new Transport();
        int homePage_num = homePageObj.homePage();

        switch (homePage_num){
            case 1 :
                addTransporter();
                break;
            case 2 :
                viewTransporter();
                break;
            case 3 :
                searchTransporter();
                break;
            case 4 :
                deleteTransporter();
                break;
            case 5:
                crudobj.home();
                break;

            default:
                System.out.println("Wrong Input");
                Transport controlObj = new Transport();
                controlObj.control();
        }
    }

    int homePage(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("       *********      TRANSPORT MANAGEMENT     **********");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Select the number what you want ");
        System.out.println("--------------------------------");
        System.out.println("\t\t1 - Add Transport");
        System.out.println("\t\t2 - View Transport");
        System.out.println("\t\t3 - Search Transport");
        System.out.println("\t\t4 - Delete Transport");
        System.out.println("\t\t5 - Back to home Page");
        System.out.println("--------------------------------");
        System.out.print("Enter the number : ");
        Scanner num = new Scanner(System.in);
        int number = num.nextInt();


        return number;
    }

    void addTransporter(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           ADD NEW TRANSPORT     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter The Date (yyyy/mm/dd) : ");
        Scanner d = new Scanner(System.in);
        Date[i][0] = d.next();

        System.out.print("Enter Driver ID (xxxxxxx) : ");
        Scanner id = new Scanner(System.in);
        Dr_ID[i][1] = id.next();

        System.out.print("Enter The Driver Name : ");
        Scanner c = new Scanner(System.in);
        Dr_Name[i][2] = c.next();

        System.out.print("Enter Bowser ID : ");
        Scanner q = new Scanner(System.in);
        Bow_ID[i][3] = q.next();

        System.out.print("Enter Destination  : ");
        Scanner p = new Scanner(System.in);
        Des[i][4] = p.next();

        i++;
        System.out.println("----------------------------------------");
        System.out.println("   Successfully Added a new Transporter!");
        System.out.println("----------------------------------------");
        System.out.print("Do you want to Add new Transporter(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                addTransporter();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }

    }

    void viewTransporter(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           VIEW ALL TRANSPORTER     ");
        System.out.println("----------------------------------------------------------------------------");

        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n","Date","Driver ID","Driver Name","Bowser ID","Destination");
        System.out.println("----------------------------------------------------------------------------");

        for (int k = 1; k < this.i; k++) {
            System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%20s\n",Date[k][0],Dr_ID[k][1],Dr_Name[k][2],Bow_ID[k][3],Des[k][4]);

        }
        System.out.println("----------------------------------------------------------------------------");

        System.out.print("Do you want Exit View Transporters(y) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                control();
                break;
            case "n":
                viewTransporter();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }


    void searchTransporter(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           SEARCH TRANSPORT     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the Bowser ID What you want to search : ");
        Scanner id = new Scanner(System.in);
        String Bow_Id  = id.next();
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%12s\n","Date","Driver ID","Driver Name","Bowser ID","Destination");
        System.out.println("----------------------------------------------------------------------------");
        for(int j = 1 ; j < this.i ; j++){
            if(Bow_Id == Bow_ID[j][1]){
                System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%20s\n",Date[j][0],Dr_ID[j][1],Dr_Name[j][2],Bow_ID[j][3],Des[j][4]);
            }
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Do you want Search another Transporter(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                searchTransporter();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("               Error");
                control();
        }
    }

    void deleteTransporter(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                           DELETE TRANSPORTER     ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the Bow_ID what you want to delete : ");
        Scanner id = new Scanner(System.in);
        String Bow_id = id.next();
        System.out.println("Enter the date what you want to delete: ");
        Scanner d = new Scanner(System.in);
        String date = d.next();

        for(int j=0 ; j<this.i;j++){
            if(Bow_id == this.Bow_ID[j][1]){
                if(date.equals(this.Date[j][0])) {
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.printf("%10s\t%10s\t%10s\t\t%10s\t%20s\n", Date[j][0], Dr_ID[j][1], Dr_Name[j][2], Bow_ID[j][3], Des[j][4]);
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.print("Are you sure(y/n) : ");
                    Scanner a = new Scanner(System.in);
                    String ans = a.next();
                    switch (ans){
                        case "y":
                            this.Date[j][0] = this.Date[j+1][0];
                            this.Dr_ID[j][1] = this.Dr_ID[j+1][1];
                            this.Dr_Name[j][2] = this.Dr_Name[j+1][2];
                            this.Bow_ID[j][3] = this.Bow_ID[j+1][3];
                            this.Des[j][4] = this.Des[j+1][4];
                            break;
                        case "n":
                            control();
                    }


                }
            }

        }
        this.i = i - 1;
        System.out.print("Do you want to delete another Transporter(y/n) :  ");
        Scanner a = new Scanner(System.in);
        String ans = a.next();

        switch (ans){
            case "y":
                deleteTransporter();
                break;
            case "n":
                control();
                break;
            default:
                System.out.println("Error");
                control();
        }
    }
}


