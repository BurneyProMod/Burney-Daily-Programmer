import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner; // Import Scanner class so user input may be used.
import java.util.Random;
import java.util.ArrayList;

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

        // Read challenges from file and put into ArrayList
        try {
            ArrayList<String> list = new ArrayList<String>();
            FileReader reader = new FileReader("Challenges.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
                //System.out.println(line);
            }
            reader.close();

            // Sort Challenges
            System.out.println("How would you like to sort the challenges?");
            System.out.println("1. Chronological");
            System.out.println("2. By Difficulty");
            Scanner userInput = new Scanner(System.in);
            int userSort = userInput.nextInt();
            switch(userSort){
                case 1: 
                    // Honestly it's already in Chronological order so this is a placeholder. 
                    break;
                case 2: 
                    // Each line is started with (Easy) (Medium) or (Hard)
                    // Make 3 Arraylists for Easy, Medium, and Hard. Iterate through master list and put each category into corresponding ArrayList. Clear master ArrayList, then add each small ArrayList to master ArrayList.
                    // Also word previous comment better.
                    ArrayList<String> hardList = new ArrayList<String>();
                    ArrayList<String> mediumList = new ArrayList<String>();
                    ArrayList<String> easyList = new ArrayList<String>();
                    for(int i=0; i < list.size(); i++){ // Iterate through entire list
                        String substring = list.get(i).toString(); // Convert current index to a string so it may be searched

                        // Check the 2nd character for H, I, or E. 
                        substring = substring.substring(1,2); 
                        switch(substring){
                            case "H":
                                hardList.add(list.get(i)); // If 2nd character is H, add to ArrayList "HardList"
                                break;
                            case "I":
                                mediumList.add(list.get(i)); // If 2nd character is I, add to ArrayList "mediumList"
                                break;
                            case "E":
                                easyList.add(list.get(i)); // If 2nd character is E, add to ArrayList "easyList"
                                break;
                            default:
                                System.out.println("Error in sorting arraylists");
                                System.out.println("Current iteration: "+i+". Current element: "+list.get(i));
                                return;
                        }
                    }
                    list.clear(); // Delete all elements in master list
                    for(int i = 0; i < hardList.size(); i++){ // Iterate through Hard List and add to master list
                        list.add(hardList.get(i).toString());
                    }
                    for(int i = 0; i < mediumList.size(); i++){ // Iterate through Medium List and add to master list
                        list.add(mediumList.get(i).toString());
                    }
                    for(int i = 0; i < easyList.size(); i++){ // Iterate through Easy List and add to master list
                        list.add(easyList.get(i).toString());
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            // Print ArrayList
            for(int i=0; i < list.size(); i++){ // Access each item in ArrayList
                String str = list.get(i); // Assign variable str to index 'i' of ArrayList.
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}