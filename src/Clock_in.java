/******************** Importing Essential Libraries ************************/

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


/*************************** MENU OF EMS ****************************/

class MainMenu
{
    public void menu()
    {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t    --------------------");
        System.out.println("\t\t\t     Original Programmer: Abhinav Dubey");
        System.out.println("\t\t\t     Modified by: Huda, Sofea & Syafie");
        System.out.println("\t\t\t    --------------------");
        System.out.println("\n\nPress 1 : To Add an Employee Details");
     //   System.out.println("Press 2 : To See an Employee Details ");
     //   System.out.println("Press 3 : To Remove an Employee");
      //  System.out.println("Press 4 : To Update Employee Details");
        System.out.println("Press 2 : To Exit the EMS Portal");
        System.out.println("Press 3 : To Add A New Case");
      //  System.out.println("Press 7 : To View Case");
        System.out.println("Press 4 : To Check In and Check Out an Employee");
        System.out.println("Press 5 : To View Employees");
    }

}

/************************ To add details of Employee *********************/

/*class Employee_Add
{
    public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        Employees emp=new Employees();
        emp.getIDLaw();
        emp.getFirstName();
        emp.getLastName();
        emp.getContact();
        emp.getPosition();
        emp.getSalary();


    }
}*/

/************************* Taking Employee Details ************************/

class Employees {
    String IDLaw;
    String firstName;
    String lastName;
    String contact;
    String position;
    String salary;

    LocalDateTime clockIn;
    LocalDateTime clockOut;


    public Employees(String IDLaw, String firstName, String lastName, String contact, String position, String salary) {
        this.IDLaw = IDLaw;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.position = position;
        this.salary = salary;
    }

    public void setClockIn(LocalDateTime clockIn) {
        this.clockIn = clockIn;
    }

    public void setClockOut(LocalDateTime clockOut) {
        this.clockOut = clockOut;
    }

    public String getIDLaw() {
        return IDLaw;
    }
    public void setIDLaw(String IDLaw) {
        this.IDLaw = IDLaw;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary(){
        return salary;
    }
    public void setSalary(String salary){
        this.salary = salary;
    }

    public LocalDateTime getClockIn() {
        return clockIn;
    }

    public LocalDateTime getClockOut() {
        return clockOut;
    }
}

class EmployeeDatabase {
    private static EmployeeDatabase instance;
    private static List<Employees> employees = new ArrayList<>();

    public EmployeeDatabase() {}

    public void addEmployee() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the employee's ID: ");
        String IDLaw = input.nextLine();
        System.out.print("Enter the employee's first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter the employee's last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter the employee's contact: ");
        String contact = input.nextLine();
        System.out.print("Enter the employee's position: ");
        String position = input.nextLine();
        System.out.print("Enter the employee's salary: ");
        String salary = input.nextLine();


        employees.add(new Employees(IDLaw, firstName, lastName, contact, position, salary));
    }

    public void readCsv(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String IDLaw = values[0];
                String firstName = values[1];
                String lastName = values[2];
                String contact = values[3];
                String position = values[4];
                String salary = values[5];
                Employees employee = new Employees(IDLaw, firstName, lastName, contact, position, salary);
                employees.add(employee);
            }
            for(Employees u: employees) {
                System.out.printf("[userId=%s, firstName=%s, lastName=%s, contact=%s, position=%s, salary=%s]\n",
                        u.getIDLaw(), u.getFirstName(), u.getLastName(),
                        u.getContact(), u.getPosition(), u.getSalary());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public void writeCsv(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Employees employee : employees) {

                bw.write(employee.getIDLaw() + "," + employee.getFirstName() + "," + employee.getLastName() +"," + employee.getContact() +
                        "," + employee.getPosition() + "," + employee.getSalary());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    public Employees verifyEmployeeId(String employeeId) {
        for (Employees employee : employees) {
            if (employee.getIDLaw().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }
    public static EmployeeDatabase getInstance() {
        if (instance == null) {
            instance = new EmployeeDatabase();
        }
        return instance;
    }

//    public void matchEmployee(String IDLaw) {
//        employees.add(new Employees(IDLaw));
//    }

    public static boolean checkCredentials(String IDLaw) {
        for (Employees employee : employees) {
            if (employee.getIDLaw().equals(IDLaw)) {
                return true;
            }
        }
        return false;
    }
    public void setAccounts(List<Employees> accounts) {
        this.employees = employees;
    }
    public List<Employees> getAccounts() {
        return employees;
    }
}

/************************ To Show details of Employee *********************/

//class Employee_Show
//{
//    public void viewFile(String s) throws Exception
//    {
//        File file = new File("file"+s+".txt");
//        Scanner sc = new Scanner(file);
//
//        while (sc.hasNextLine())
//        {
//            System.out.println(sc.nextLine());
//        }
//    }
//}

/***************************** To Remove Employee *************************/

//class Employee_Remove
//{
//    public void removeFile(String ID)
//    {
//
//        File file = new File("file"+ID+".txt");
//        if(file.exists())
//        {
//            if(file.delete());
//            {
//                System.out.println("\nEmployee has been removed Successfully");
//            }
//        }
//        else
//        {
//            System.out.println("\nEmployee does not exists :( ");
//        }
//    }
//}

/************************ To Update details of Employee ********************/

//class Employee_Update
//{
//    public void updateFile(String s,String o,String n) throws IOException
//    {
//        File file = new File("file"+s+".txt");
//        Scanner sc = new Scanner(file);
//        String fileContext="";
//        while (sc.hasNextLine())
//        {
//            fileContext =fileContext+"\n"+sc.nextLine();
//        }
//        FileWriter myWriter = new FileWriter("file"+s+".txt");
//        fileContext = fileContext.replaceAll(o,n);
//        myWriter.write(fileContext);
//        myWriter.close();
//
//    }
//}


/************************ To Exit from the EMS Portal *********************/

class CodeExit
{
    public void out()
    {
        System.out.println("\n*****************************************");
        System.out.println("$ cat Thank You For Using my Software :) ");
        System.out.println("*****************************************");
        System.out.println("\t\t/~ <0d3d by Abhinav Dubey\n");
        System.exit(0);
    }
}


/***************************** Main Class *******************************/
class EmployManagementSystem
{
    public static void main(String arv[]) throws IOException {
        /** To clear the output Screen **/
        System.out.print("\033[H\033[2J");

        Scanner sc=new Scanner(System.in);
    //    Employee_Show epv =new Employee_Show();
     //   Case_Show cShowOb= new Case_Show();

        List<Employees> employees = new ArrayList<>();
       // employees = Employee_Add.readCsv();
       // EmployeeDatabase.getInstance().setEmpl
//        EmployeeDatabase db = new EmployeeDatabase();
//        EmployeeDatabase.readCsv("employees.csv");

        int i=0;

        /*** Calling Mainmenu Class function ****/
        MainMenu obj1 = new MainMenu();
        obj1.menu();

        /*** Initialising loop for Menu Choices ***/
        while(i<12)
        {

            System.out.print("\nPlease Enter choice :");
            i=Integer.parseInt(sc.nextLine());

            /** Switch Case Statements **/
            switch(i)
            {
                case 1: //adding new employees and saving into csv file
                {
                    /** Creating class's object and calling Function using that object **/
                    EmployeeDatabase db = new EmployeeDatabase();
                    Scanner input = new Scanner(System.in);
                    System.out.print("How many employees do you want to add? ");
                    int numEmployees = input.nextInt();
                    for (int j = 0; j < numEmployees; j++) {
                        db.addEmployee();
                    }
                    System.out.print("The name of the CSV file to write: ");
                    String fileName = "employees.csv";
                    db.writeCsv(fileName);
                    System.out.print("\n ");
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
//                case 2:
//                {
//                    System.out.print("\nPlease Enter Employee's ID :");
//                    String s=sc.nextLine();
//                    try
//                    {
//                        epv.viewFile(s);}
//                    catch(Exception e){System.out.println(e);}
//
//
//                    System.out.print("\nPress Enter to Continue...");
//                    sc.nextLine();
//                    System.out.print("\033[H\033[2J");
//                    obj1.menu();
//                    break;
//                }

//                case 3:
//                {
//                    System.out.print("\nPlease Enter Employee's ID :");
//                    String s=sc.nextLine();
//                    Employee_Remove epr =new Employee_Remove();
//                    epr.removeFile(s);
//
//                    System.out.print("\nPress Enter to Continue...");
//                    sc.nextLine();
//                    System.out.print("\033[H\033[2J");
//                    obj1.menu();
//                    break;
//                }
//                case 4:
//                {
//                    System.out.print("\nPlease Enter Employee's ID :");
//                    String I=sc.nextLine();
//                    try
//                    {
//                        epv.viewFile(I);
//                    }
//                    catch(Exception e)
//                    {
//                        System.out.println(e);
//                    }
//                    Employee_Update epu = new Employee_Update();
//                    System.out.print("Please Enter the detail you want to Update :");
//                    System.out.print("\nFor Example :\n");
//                    System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
//                    String s=sc.nextLine();
//                    System.out.print("Please Enter the Updated Info :");
//                    String n=sc.nextLine();
//                    try
//                    {
//                        epu.updateFile(I,s,n);
//
//                        System.out.print("\nPress Enter to Continue...");
//                        sc.nextLine();
//                        System.out.print("\033[H\033[2J");
//                        obj1.menu();
//                        break;
//                    }
//                    catch(IOException e)
//                    {
//                        System.out.println(e);
//                    }
//                }
                case 2:
                {
                    CodeExit obj = new CodeExit();
                    obj.out();
                }
                case 3: //add new case
                {
                    Case_Add caseOb =new Case_Add();
                    caseOb.csv();

                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
//                case 7:
//                {
//                    System.out.print("\nPlease Enter Case ID :");
//                    String s=sc.nextLine();
//                    try
//                    {
//                        cShowOb.viewCase(s);}
//                    catch(Exception e){System.out.println(e);}
//
//
//                    System.out.print("\nPress Enter to Continue...");
//                    sc.nextLine();
//                    System.out.print("\033[H\033[2J");
//                    obj1.menu();
//                    break;
//                }
                case 4: //clocking in and out
                {
                    Clock_in cl = new Clock_in();
                    cl.ClockIn();
                    break;
                }
                case 5: //view employee
                {
                    EmployeeDatabase db = new EmployeeDatabase();
                    String fileName = "employees.csv";
                    System.out.println("starting read user.csv file: " + fileName + "\n");
                    db.readCsv(fileName);

                    break;

                }
                case 6: //search via employee ID
                {
                    EmployeeDatabase ed = new EmployeeDatabase();
                    ed.readCsv("employees.csv");
                    System.out.println("Enter the Employee ID to check: ");
                    String checkID = sc.nextLine();
                    Employees employee = ed.verifyEmployeeId(checkID);
                    if (employee != null) {
                        System.out.println("Employee found: " + employee.getFirstName() + " " + employee.getLastName());
                    } else {
                        System.out.println("Employee ID not found.");
                    }

                    break;

                }
            }
        }
    }
}

/****************************** CODED BY ABHINAV DUBEY ************************/
class Case{
    String employeeID;
    String caseID;
    String caseName;
    String caseDate;
    String clientName;
    int client_contact;
    int paymentTotal;
    String paymentDate;

    public String getEmployeeID() {return employeeID;}
    public void setEmployeeID(String employeeID) {this.employeeID = employeeID;}
    public String getCaseID() {
        return caseID;
    }
    public void setCaseID(String caseID) {this.caseID = caseID;}
    public String getCaseName() {return caseName;}
    public void setCaseName(String caseName) {this.caseName = caseName;}
    public String getCaseDate() {return caseDate;}
    public void setCaseDate(String caseDate) {this.caseDate = caseDate;}
    public String getClientName() {return clientName;}
    public void setClientName(String clientName) {this.clientName = clientName;}
    public int getClient_contact() {return client_contact;}
    public void setClient_contact(int client_contact) {this.client_contact = client_contact;}
    public int getPaymentTotal() {return paymentTotal;}
    public void setPaymentTotal(int paymentTotal) {this.paymentTotal = paymentTotal;}
    public String getPaymentDate() {return paymentDate;}
    public void setPaymentDate(String paymentDate) {this.paymentDate = paymentDate;}


}
class Case_Add
{
    public static void csv () {

        String filePath = "case.csv";

        System.out.println("starting write user.csv file: " + filePath);
        writeCsv(filePath);

        System.out.println("starting read user.csv file");
        readCsv(filePath);
    }

        public static void writeCsv(String filePath) {
        ArrayList<Case> cases = new ArrayList<Case>();
        int val;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of users you want to add: ");
        val = Integer.parseInt(sc.nextLine());
        for(int i=0;i<val;i++)
        {
            String emp_id;
            System.out.print("Enter the employee ID: ");
            emp_id = sc.nextLine();
            String case_id;
            System.out.print("Enter the case ID: ");
            case_id = sc.nextLine();
            String case_name;
            System.out.print("Enter the case name: ");
            case_name = sc.nextLine();
            String case_date;
            System.out.print("Enter case date: ");
            case_date = sc.nextLine();
            String client_name;
            System.out.print("Enter the client's name: ");
            client_name = sc.nextLine();
            int client_contact;
            System.out.print("Enter Contact: ");
            client_contact = Integer.parseInt(sc.nextLine());
            int payment_total;
            System.out.print("Enter payment total: ");
            payment_total = Integer.parseInt(sc.nextLine());
            String payment_date;
            System.out.print("Enter the payment date: ");
            payment_date = sc.nextLine();

            Case obj = new Case();
            obj.setEmployeeID(emp_id);
            obj.setCaseID(case_id);
            obj.setCaseName(case_name);
            obj.setCaseDate(case_date);
            obj.setClientName(client_name);
            obj.setClient_contact(client_contact);
            obj.setPaymentTotal(payment_total);
            obj.setPaymentDate(payment_date);
            cases.add(obj);
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.append("ID Lawyer, ID Case, Case Name, Case Date, Client Name, Client Contact, Payment Total, Payment Date\n");
            for(Case c: cases) {
                fileWriter.append(c.getEmployeeID());
                fileWriter.append(",");
                fileWriter.append(c.getCaseID());
                fileWriter.append(",");
                fileWriter.append(c.getCaseName());
                fileWriter.append(",");
                fileWriter.append(c.getCaseDate());
                fileWriter.append(",");
                fileWriter.append(c.getClientName());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(c.getClient_contact()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(c.getPaymentTotal()));
                fileWriter.append(",");
                fileWriter.append(c.getPaymentDate());
                fileWriter.append("\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        public static void readCsv(String filePath) {
        BufferedReader reader = null;

        try {
            List<Case> cases = new ArrayList<Case>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if(fields.length > 0) {
                    Case obj = new Case();
                    obj.setEmployeeID(fields[0]);
                    obj.setCaseID(fields[1]);
                    obj.setCaseName(fields[2]);
                    obj.setCaseDate(fields[3]);
                    obj.setClientName(fields[4]);
                    obj.setClient_contact(Integer.parseInt(fields[5]));
                    obj.setPaymentTotal(Integer.parseInt(fields[6]));
                    obj.setPaymentDate(fields[7]);
                    cases.add(obj);
                }
            }

            for(Case c:cases) {
                System.out.printf("[employeeId=%s, caseId=%s, caseName=%s, caseDate=%s, clientName=%s, " +
                                "clientContact=%d, paymentTotal=%d, paymentDate=%s]\n",
                        c.getEmployeeID(), c.getCaseID(), c.getCaseName(), c.getCaseDate(),
                        c.getClientName(), c.getClient_contact(), c.getPaymentTotal(), c.getPaymentDate());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

class Case_Show
{
    public void viewCase(String c) throws Exception
    {
        File file = new File("file"+c+".txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
        {
            System.out.println(sc.nextLine());
        }
    }
}

class Clock_in
{
    public LocalDateTime CheckIn;
    public String formatCheckIn;

    public void ClockIn() throws IOException {
        List<Employees> users = new ArrayList<Employees>();
        String IDLaw;
        String answer_clock_out;

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


        EmployeeDatabase ed = new EmployeeDatabase();
        ed.readCsv("employees.csv");
        System.out.println("Enter the Employee ID to check: ");
        String checkID = sc.nextLine();
        Employees employee = ed.verifyEmployeeId(checkID);
        if (employee != null) {
            System.out.println("Employee exists: " + employee.getFirstName() + " " + employee.getLastName());
            if (CheckIn == null) {
                CheckIn = LocalDateTime.now();
                formatCheckIn = CheckIn.format(format);
                System.out.println("Your Check In: " + formatCheckIn);
              //  ed.writeCsv("employees.csv", checkID, formatCheckIn, null);
            } else {
                System.out.println("You have already checked in.");
                System.out.println("Your Check In: " + formatCheckIn);
            }


        } else {
            System.out.println("Employee ID not found.");
        }


            System.out.println("Enter Y to Check out or Enter any key to Main Menu: ");
            answer_clock_out = sc.nextLine();
            if (Objects.equals(answer_clock_out, "Y")) {
                Clock_Out cl = new Clock_Out();
                cl.ClockOut();
            } else {

            }
        }
    }



class Clock_Out{
    public LocalDateTime CheckOut;
    public Duration duration;
    public String formatCheckOut;
    public void ClockOut(){
        Clock_in ob = new Clock_in();
        CheckOut = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formatCheckOut = CheckOut.format(format);
        System.out.println("Your Check Out Time: " + formatCheckOut);
        duration = Duration.between(ob.CheckIn, CheckOut);

        System.out.println("You have worked for: " + duration.toHours() + " hours, " + duration.toMinutes() + " minutes, " + duration.toSeconds() + " seconds, for today's work.");


    }

}

class Case_Update
{
    public void updateFile(String x,String y,String z) throws IOException
    {
        File file = new File("file"+x+".txt");
        Scanner sc = new Scanner(file);
        String fileContext="";
        while (sc.hasNextLine())
        {
            fileContext =fileContext+"\n"+sc.nextLine();
        }
        FileWriter myWriter = new FileWriter("file"+x+".txt");
        fileContext = fileContext.replaceAll(y,z);
        myWriter.write(fileContext);
        myWriter.close();
    }
}

class Case_Remove
{
    public void removeFile(String ID)
    {

        File file = new File("file"+ID+".txt");
        if(file.exists())
        {
            if(file.delete());
            {
                System.out.println("\nCase has been removed Successfully");
            }
        }
        else
        {
            System.out.println("\nCase does not exists :( ");
        }
    }
}

//class Employee_Add {
//
//    public static void csv() {
//
//        String filePath = "employees.csv";
//
//        System.out.println("starting write user.csv file: " + filePath);
//        writeCsv(filePath);
//
//        System.out.println("starting read user.csv file");
//        readCsv(filePath);
//    }

//    public void addEmployee() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter the employee's ID: ");
//        String IDLaw = input.nextLine();
//        System.out.print("Enter the employee's first name: ");
//        String firstName = input.nextLine();
//        System.out.print("Enter the employee's last name: ");
//        String lastName = input.nextLine();
//        System.out.print("Enter the employee's contact: ");
//        String contact = input.nextLine();
//        System.out.print("Enter the employee's position: ");
//        String position = input.nextLine();
//        System.out.print("Enter the employee's salary: ");
//        String salary = input.nextLine();
//
//
//        employees.add(new Employees(IDLaw, firstName, lastName, contact, position, salary));
//    }
//
//    public void readCsv(String fileName) {
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                String IDLaw = values[0];
//                String firstName = values[1];
//                String lastName = values[2];
//                String contact = values[3];
//                String position = values[4];
//                String salary = values[5];
//                Employees employee = new Employees(IDLaw, firstName, lastName, contact, position, salary);
//                employees.add(employee);
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while reading the file: " + e.getMessage());
//        }
//    }
//
//    public void writeCsv(String fileName) {
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
//            for (Employees employee : employees) {
//                bw.write(employee.getIDLaw() + "," + employee.getFirstName() + "," + employee.getLastName() +"," + employee.getContact()
//                        "," + employee.getPosition() + "," + employee.getSalary());
//                bw.newLine();
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while writing the file: " + e.getMessage());
//        }
//    }
//}
//
//}