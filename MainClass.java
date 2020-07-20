import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class MainClass {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("ENTER YOUR CHOICE, SIR!!");
		System.out.println("1 --> LogIn");
		System.out.println("2 --> Register");
                
		choice = sc.nextInt();
		functionClass fun = new functionClass();
                while(choice != 0){
                    if(choice == 1) {
			//System.out.println("We are very happy to have you back, SIR");
                        System.out.println("Please Enter your UserId and Password");
                        String id = sc.next();
                        String password = sc.next();
                        if(fun.verification(id, password)){
                            System.out.println("Login Successfull");
                            operations(id,fun);
                        }
                        else{
                            System.out.println("Invalid ceredentials");
                        }
                    }
                    else if(choice == 2) {
			System.out.println("Enter UserId and Password");
                        String userId = sc.next();
                        String password = sc.next();
                        if(fun.addUser(userId, password)){
                            System.out.println("Hurrah!, Your are part of us.");
                        }
                        else{
                            System.out.println("Sorry, Sir. The UserId already exits");
                        }
                    }
                    System.out.println("1 --> LogIn");
                    System.out.println("2 --> Register");
                    System.out.println("3 --> Exit");
                    choice = sc.nextInt();
        }
	}
        public static void operations(String id,functionClass fun){
            int choice;
            Scanner sc = new Scanner(System.in);
            do{
            System.out.println("1 --> Deposit");
            System.out.println("2 --> Withdrawal");
            System.out.println("3 --> Balance Check");
            System.out.println("4 --> Log Out");
            choice =  sc.nextInt();
            if(choice == 1){
                System.out.println("Enter the Amount");
                int amount = sc.nextInt();
                fun.addMoney(id, amount);
            }
            else if(choice == 2){
                System.out.println("Enter the Amount");
                int amount = sc.nextInt();
                fun.withdrawMoney(id, amount);
            }
            else if(choice == 3){
                fun.balanceCheck(id);
            }
            else if(choice == 4){
                System.out.println("Logout Successfull");
            }
            }while(choice != 4);
        }
	
}
class functionClass{
	HashMap<String,ArrayList<String>> map = new HashMap<>();
	public boolean addUser(String id, String password) {
		if(map.containsKey(id)) {
			return false;
		}
                else{
                        ArrayList<String> arr = new ArrayList();
                        arr.add(password);
                        arr.add("0");
			map.put(id,arr);
                }
		return true;
	}
	public boolean verification(String id, String password){
            if(map.containsKey(id)){
                if((map.get(id).get(0)).equals(password)){
                    return true;
                }
            }
            return false;
        }
	public void addMoney(String user, int amount){
            ArrayList<String> arr = map.get(user);
            int amo = Integer.parseInt(arr.get(1));
            arr.set(1,Integer.toString(amo+amount));
            map.put(user, arr);
            System.out.println("Deposit Successfull");
        }
        public void withdrawMoney(String user, int amount){
            ArrayList<String> arr = map.get(user);
            int amo = Integer.parseInt(arr.get(1));
            if(amo < amount){
                System.out.println("Not Enough Balance");
            }
            else{
                arr.set(1,Integer.toString(amo-amount));
                map.put(user, arr);
                System.out.println("Successfull");
                System.out.println("Current Balance  : "+(amo-amount));
            }
        } 
        public void balanceCheck(String user){
            System.out.println("userId: "+user);
            System.out.println("cureent balance : "+map.get(user).get(1));
        }
}
