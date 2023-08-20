import java.util.*;

public class CRUDDemo {
    public static void main(String[] args) {
        CRUDDemo crud = new CRUDDemo();
        crud.home();
    }

    public void home(){

        List<employee> c = new ArrayList<employee>();
        String route;
        do {

            Scanner s = new Scanner(System.in);
            Scanner k = new Scanner(System.in);

            //home page
            Calendar calendar = Calendar.getInstance();
            String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("            *** Welcome to Petroleum Management System ***");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + ", " + calendar.get(Calendar.YEAR));
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\t\t 1. Employee Management");
            System.out.println("\t\t\t\t\t\t\t 2. Supplier Management");
            System.out.println("\t\t\t\t\t\t\t 3. Outlet Management");
            System.out.println("\t\t\t\t\t\t\t 4. Transport Management");
            System.out.println("\t\t\t\t\t\t\t 5. Stock Management");

            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("What do you want to manage : ");
            int management = s.nextInt();



            String home;
            //employee management
            switch (management) {
                case 1:


                    int selection;
                    do {
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\t\t\t\t\t\t\t EMPLOYEE MANAGEMENT");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\t\t\t\t\t\t\t 1. Add New Employee");
                        System.out.println("\t\t\t\t\t\t\t 2. View All Employees");
                        System.out.println("\t\t\t\t\t\t\t 3. Search Employee");
                        System.out.println("\t\t\t\t\t\t\t 4. Update Employee");
                        System.out.println("\t\t\t\t\t\t\t 5. Delete Employee");
                        System.out.println("--------------------------------------------------------------------------------");

                        System.out.print("Enter option : ");
                        selection = s.nextInt();

                        switch (selection) {
                            case 1://Add Employee
                                String choose;
                                do {
                                    System.out.print("Enter Employee ID : ");
                                    int eno = s.nextInt();
                                    System.out.print("Enter Employee Name : ");
                                    String ename = k.nextLine();
                                    System.out.print("Enter Employee Phone Number : ");
                                    String ephone = k.nextLine();
                                    System.out.print("Enter Employee Email Address : ");
                                    String eemail = k.nextLine();
                                    System.out.print("Enter Employee Salary : ");
                                    int esalary = s.nextInt();
                                    c.add(new employee(eno, ename, ephone, eemail, esalary));
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.println("Employee Added to the system successfully... ");
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.print("Do you want to add another employee(y/n) : ");
                                    choose = k.nextLine();
                                } while (choose.equals("y"));
                                break;


                            case 2://View Employee
                                do {
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.printf("%-10s %-20s %-15s %-20s %-15s\n", "ID", "Name", "Phone Number", "Email", "Salary");
                                    Iterator<employee> i = c.iterator();
                                    while (i.hasNext()) {
                                        employee e = i.next();
                                        System.out.printf("%-10s %-20s %-15s %-20s %-15s\n", e.getEID(), e.getEName(), e.getEPhoneNumber(), e.getEEmail(), e.getESalary());
                                    }
                                    System.out.println("--------------------------------------------------------------------------------");

                                    System.out.print("Do you want to Go Employee Management System Back(y/n) : ");
                                    choose = k.nextLine();
                                } while (!(choose.equals("y")));
                                break;

                            case 3://Search Employee
                                do {
                                    boolean found = false;
                                    System.out.print("Enter employee's eno that you want to search : ");
                                    int empno = s.nextInt();

                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.printf("%-10s %-20s %-15s %-20s %-15s\n", "ID", "Name", "Phone Number", "Email", "Salary");
                                    Iterator<employee> i = c.iterator();
                                    while (i.hasNext()) {
                                        employee e = i.next();
                                        if (e.getEID() == empno) {
                                            System.out.printf("%-10s %-20s %-15s %-20s %-15s\n", e.getEID(), e.getEName(), e.getEPhoneNumber(), e.getEEmail(), e.getESalary());
                                            found = true;
                                        }

                                    }

                                    if (!found) {
                                        System.out.println("Something went wrong..Record not found...");
                                    }
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.print("Do you want to Search another employee(y/n) : ");
                                    choose = k.nextLine();
                                } while (choose.equals("y"));
                                break;

                            case 4://Update Employee
                                boolean found = false;
                                System.out.print("Enter employee's eno that you want to update : ");
                                int empno = s.nextInt();

                                System.out.println("--------------------------------------------------------------------------------");
                                ListIterator<employee> li = c.listIterator();
                                while (li.hasNext()) {
                                    employee e = li.next();
                                    if (e.getEID() == empno) {
                                        System.out.print("Enter new employee name "+"(Old : "+e.getEName()+")"+" : ");
                                        String ename = k.nextLine();
                                        System.out.print("Enter new employee Phone Number "+"(Old : "+e.getEPhoneNumber()+")"+" : ");
                                        String ephone = k.nextLine();
                                        System.out.print("Enter new employee Email "+"(Old : "+e.getEEmail()+")"+" : ");
                                        String eemail = k.nextLine();
                                        System.out.print("Enter new employee Salary "+"(Old : "+e.getESalary()+")"+" : ");
                                        int esalary = s.nextInt();
                                System.out.println("--------------------------------------------------------------------------------");
                                        li.set(new employee(empno, ename, ephone, eemail, esalary));
                                        found = true;
                                    }
                                }

                                if (!found) {
                                    System.out.println("Something went wrong..Record not found...");
                                } else {
                                    System.out.println("Employee updated successfully...");
                                }
                                break;

                            case 5://Delete Employee
                                do {
                                    found = false;
                                    System.out.print("Enter employee's eno that you want to delete : ");
                                    empno = s.nextInt();

                                    System.out.println("--------------------------------------------------------------------------------");
                                    Iterator<employee> i = c.iterator();
                                    while (i.hasNext()) {
                                        employee e = i.next();
                                        if (e.getEID() == empno) {
                                            i.remove();
                                            found = true;
                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Something went wrong..Record not found...");
                                    } else {
                                        System.out.println("Employee deleted successfully...");
                                    }
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.print("Do You Want to Delete Another Employee(y/n) : ");
                                    choose = k.nextLine();
                                } while (choose.equals("y"));
                                break;


                        }
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.print("Do you want to Exit from the Employee Management System(y/n) : ");
                        home = k.nextLine();
                    } while (!(home.equals("y")));
                    break;
                case 2:
                    //supplier management
                    supplier obj = new supplier();
                    obj.control();
                    break;

                case 3:
                    //outlet management
                    outlet obj2 = new outlet();
                    obj2.control();
                    break;

                case 4:
                    //transport management
                    Transport obj1 = new Transport();
                    obj1.control();
                    break;

                case 5:
                    //stock management
                    stock stockobj = new stock();
                    stockobj.control();

            }
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("Do you want to Exit from the System(y/n) : ");
            route = k.nextLine();
            System.out.println("\n");
        } while (!(route.equals("y")));
    }
}


