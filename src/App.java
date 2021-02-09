import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner; // Import Scanner class so user input may be used.
import java.util.Random;


class App{

    // Create a program that will ask the user's name, age and reddit username. Have it tell the information back.
    public static void Challenge1(){
        System.out.print("What is your name? ");
        Scanner scan = new Scanner(System.in);
        String realName = scan.nextLine();
        System.out.print("How old are you? ");
        int userAge = scan.nextInt();
        Scanner scan1 = new Scanner(System.in);
        System.out.print("What is your reddit username? ");
        String userName = scan1.nextLine();
        System.out.println("Your name is " + realName + ", you are " + userAge + " years old, your reddit username is " + userName + ", and you are a pretty fantastic person!");
        scan.close();
        scan1.close();
    }

    // Create a program that will try to guess a number the user thinks of between 0-100. User does not enter the number into the program, but will only respond with "Higher" or "Lower" until program gets it right.
    public static void Challenge2(){
        int totalGuess = 0; // Tracks the number of guesses the program will make
        int lowerBound = 0; // Tracks the lower bound in range of guesses
        int upperBound = 100; // Tracks upper bound in range of guesses
        int currentGuess;
        System.out.println("Think of a number from 0 - 100. After each guess, press '1' for Lower and '2' for Higher. Press '3' once I'm right!");
        for (int i = 0; i < 100; i++){
            totalGuess++;
            if(upperBound - lowerBound == 0){
                System.out.println("After "+totalGuess+" guesses, The only option left is: "+upperBound);
                return; // Return is used here instead of break since there are no more steps for this method to do.
            }
            else{
                Random rand = new Random();
                currentGuess = rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;
                System.out.println("My guess is: "+currentGuess);
                Scanner scan = new Scanner(System.in);
                int userChoice = scan.nextInt();
                switch(userChoice){
                    case 1:
                        upperBound = currentGuess;
                        break;
                    case 2:
                        lowerBound = currentGuess;
                        break;
                    case 3:
                        System.out.println("It only took me "+totalGuess+" guesses!");
                        return; // Return is used here instead of break since there are no more steps for this method to do.
                    default:
                    System.out.println("Invalid");
                }
            }
        }    
    }

    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("Which challenge would you like to run?");
        try {
            FileReader reader = new FileReader("Challenges.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        int userChoice = scan.nextInt();
        switch(userChoice){
            case 1:
                Challenge1();
            case 2:
                Challenge2();
            default:
                System.out.println("Option not available yet!");
        }
    }
}