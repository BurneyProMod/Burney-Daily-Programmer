import java.util.Scanner; // Import Scanner class so user input may be used.

class App{
    public static void Day1(){
        // Declare variables for name, age, and reddit username.
            
            // Ask user for their name.
            System.out.print("What is your name? ");
            Scanner scan = new Scanner(System.in);
            String realName = scan.nextLine();
            
            // Ask user for their age.
            System.out.print("How old are you? ");
            int userAge = scan.nextInt();
            
            // Ask user for their reddit username.
            Scanner scan1 = new Scanner(System.in);
            System.out.print("What is your reddit username? ");
            String userName = scan1.nextLine();
            
            // Tell user their name, age, and username. Tell them they are fantastic.
            System.out.println("Your name is " + realName + ", you are " + userAge + " years old, your reddit username is " + userName + ", and you are a pretty fantastic person!");
    }
    public static void main(String[] args){
        // Challenge 1) Ask a user for their name, age, and reddit username. Then print it back out to them!
        Day1();
    }
}