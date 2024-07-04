import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class AtmSimualtion{
    float balance;
    float pin=1234;
    Scanner s=new Scanner(System.in);
    public void checkPin(int pin){
        if(this.pin!=pin){
            System.out.println("Please enter a valid pin!! ");
        }
        else{
            menu();
        }

    }
    public void menu(){
            System.out.println("The menu is as follows:");
            System.out.println("1. Balance Enquiry.");
            System.out.println("2. Amount Withdraw.");
            System.out.println("3. Amount Deposit");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            int choice=s.nextInt();
            switch (choice){
                case 1: balanceEnquiry();
                    break;
                case 2: amountWithdraw();
                    break;
                case 3: amountDeposit();
                    break;
                case 4: exits();
                    break;
                default: System.out.println("Enter a valid choice..");
            }
    }
    private void balanceEnquiry(){
        System.out.println("Current balance is:"+balance);
        menu();
    }
    private void amountWithdraw(){
        if(balance<=0){
            System.out.println("Please add balance to make withdrawal.");
        }
        else {
            System.out.println("Enter the required amount:");
            int withdraw = s.nextInt();
            if(withdraw<balance){
                balance = balance - withdraw;
                System.out.println("Withdraw is successful.");
                System.out.println("Do you want to display your balance yes/no!");
                String s1 = s.next();
                if (Objects.equals(s1, "yes")) {
                    balanceEnquiry();
                }
            }
            else{
                System.out.println("Insufficient balance to make this withdrawal!!");
            }
        }
        menu();
    }
    private void amountDeposit(){
        System.out.println("Enter the amount:");
        int deposit=s.nextInt();
        balance=balance+deposit;
        System.out.println("Deposit is successful.");
        System.out.println("Do you want to display your balance yes/no!");
        String s1=s.next();
        if(Objects.equals(s1, "yes")){
            balanceEnquiry();
        }
        menu();
    }
    private void exits(){
        System.out.println("Exited Successfully. Have a nice day..");
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        AtmSimualtion a=new AtmSimualtion();
        System.out.println("Enter your Pin:");
        int pin=s.nextInt();
        a.checkPin(pin);
    }
}