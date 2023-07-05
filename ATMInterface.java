import java.util.*;
class Accountdetails{
    static void enroll(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Name :");
        ATM.name=sc.nextLine();
        System.out.print("Enter Userid :");
        String user=sc.nextLine();
        System.out.print("Enter pin :");
        String pass=sc.nextLine();
        System.out.print("Enter your Account Number :");
        ATM.accnumber=sc.nextLine();
        System.out.print("ENROLLED SUCCESSFULLY!");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1)
            {
                login(user,pass);
                break;
            }
            else
            {
                if(choice==2)
                {
                    System.exit(0);
                }
                else
                {
                    System.out.println("Enter a valid input again");
                }
            }
        }
    }
    static void display(String name)
    {

    }
    static void login(String user,String pass)
    {

    }
}
class transaction
{
    static void withdraw()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance)
        {
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
        }
        else
        {
            System.out.println("insufficient balance");
        }
        ATM.prompt();
    }
    static void deposit()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        ATM.prompt();
    }
    static void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter recipient:");
        String s=sc.nextLine();
        System.out.print("Enter the account number of the recipient");
        int num=sc.nextInt();
        System.out.print("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance)
        {
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- Transferred successfully");
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
    }
}
class check
{
    static void checkbalance()
    {
        System.out.println("The current balance in the bank account :");
        ATM.showbalance();
        ATM.prompt();
    }
}
class his
{
    static void transactionhistory()
    {
        System.out.println("Transaction History :");
        int k=0;
        if(ATM.balance>0)
        {
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
            }
        }
        else
        {
            System.out.println("your account is empty");
        }
        ATM.prompt();
    }
}
class ATM {
    public static String name;
    public static int balance = 0;
    public static String accnumber;
    public static ArrayList<String> history = new ArrayList<String>();

    static void updatebalance(int dcash) {
        balance = balance + dcash;
    }

    static void showbalance() {
        System.out.println(balance);
    }

    public static void homepage() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO AXIS BANK ATM");
        System.out.println("select option :");
        System.out.println("1. Enroll");
        System.out.println("2. Exit");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        if (choice == 1) {
            Accountdetails.enroll();
        } else {
            if (choice == 2) {
                System.exit(0);
            } else {
                System.out.println("Select one from the given options :");
                homepage();
            }
        }
    }

    static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select option: ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}