
import java.util.Scanner;

public class Main {
	// use the following global variables for the program
    static String wordStatus;
    static String word;
    static String guessedLetters="";

    static int wordLength = 0;
    static Scanner user_input;
    static boolean solved = false;
    static int wrongCount = 0;

    public static void main(String[] args) {

        System.out.println("Welcome to Hangman");
        System.out.println();
        System.out.println("The rules are simple.. guess the word before time runs out.");
        System.out.println();
        System.out.println("Choosing word....");

        setup();


        run();

    }


    public static void setup() {
    // the following method should call the setupRandomWord method and set up any variables.
    word = getRandomWord();
    setupWordStatus();
    //System.out.println(word);
    displayCurrentStatus();
    }

    public static void run() {
    // the main program should include the following: 1) a while loop that keeps the user guessed letters until all
    // letters of the word are guessed. or the user makes too many incorrect guesses.
    // If a letter is found, all instances of the letter are shown in the word.
    // if an incorrect guess is made, the new hangman is shown.  Give feedback after every guess.
    // A final output when games ends.
    while(!(solved) && wrongCount < 5){

      showStatus();
      char c = getLetter();
      boolean letterguess = checkGuessedLetter(c);
      guessedLetters += c + ", ";

      //checks letter given by user, and replaces if correct, showsHangman if not
      if(letterguess){
        int instances = findInstancesOfLetter(c);
        for(int i = 0; i < instances; i++){
          int j = word.indexOf(c);
          replaceCharAt(j*2, c);
          replaceCharAtOg(j, c);
        }
        displayCurrentStatus();
      }else{
        System.out.println("Nope! Wrong letter");
        wrongCount++;
        showHangman(wrongCount);
      }

      //checks for winning condition
      if(!(wordStatus.contains("_"))){
        solved = true;
      }

    }

    //checks if win or loss
    if(wrongCount == 5){
      System.out.println("You lost!");
    }else if(solved){
      System.out.println("You won!");
    }
     
    }



    public static String getRandomWord() {
    	// the following method randomizes the choice of a word for the game.. use 10 possible words
      String [] wordList = {"oxygen", "cholesterol", "diabetes", "photosynthesis", "bingbong", "flat", "white", "yellow", "brown","Ice-cream"};
      int randNum = (int) Math.floor(Math.random() * wordList.length);
      return wordList[randNum];
    }

    private static void setupWordStatus() {
      String ws = "";
      for (int i=0; i < word.length(); i ++) {
          ws += "_";
          ws += " ";
      }
      wordStatus = ws;
    }

    private static String displayCurrentStatus() {
      //System.out.println(wordStatus);

      return wordStatus;
      
    }

    private static boolean checkGuessedLetter(char c) {
    for(int i = 0; i < word.length(); i++){
      if(word.charAt(i) ==(c)){
        return true;
      }
    }
        
    return false;
    }


    public static void showStatus() {
    	// the following method displays the following to the user: 
    	// 1) how many letters in the word 2) what letters the user has already guessed, and
    	// 3) the current status of the word ( _ _ _ a _ t _ s )

      System.out.println("There are " + word.length() + " characters in the word.");
      System.out.println("You have guessed these letters: " + guessedLetters);
      System.out.println("Current status: " + displayCurrentStatus());

    }


    private static int findInstancesOfLetter(char c) {
    	// the following method returns an integer of how many a particular letter appears in string\
      int count = 0;
      for(int i = 0; i < word.length();i++){
        if(word.charAt(i) ==(c)){
          count++;
        }
      }
       
    return count;
    }


    private static void replaceCharAt(int i, char c) {
    	// the following method replaces a character in a string (i.e. change position 3 of string to 'a')
      String newWord = wordStatus.substring(0,i) + c + wordStatus.substring(i + 1);
      wordStatus = newWord;
      //System.out.println(wordStatus);
        
    }

    private static void replaceCharAtOg(int i, char c) {
    	// the following method replaces a character in a string (i.e. change position 3 of string to 'a')
    
      String newWord = word.substring(0,i) + "_" + word.substring(i + 1);
      word = newWord;
      //System.out.println(word);
        
    }


    private static char getLetter() {
    	// the following method asks the user for a letter and returns the character entered.
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter a letter:");
      String str = scan.nextLine();
      char c = str.charAt(0);
    return c;
    }


    private static void showHangman(int wrong) {
    	// displays the current hangman. Five wrong guesses and man is hanged and game ends.

        switch (wrong) {
            case 0:
                break;

            case 1:
                System.out.println("We've got the scaffold ready...");
                System.out.println("   _______");
                System.out.println("    |/      |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("   _|___");
                break;

            case 2:
                System.out.println("Second wrong.. he's hanging...");
                System.out.println("   _______");
                System.out.println("    |/      |");
                System.out.println("    |      (_)");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("   _|___");
                break;

            case 3:
                System.out.println("He's raising his hands for help.. Help him!...");
                System.out.println("   _______");
                System.out.println("    |/      |");
                System.out.println("    |      (_)");
                System.out.println("    |      \\|/");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("   _|___");
                break;

            case 4:
                System.out.println("one false step...");
                System.out.println("   _______");
                System.out.println("    |/      |");
                System.out.println("    |      (_)");
                System.out.println("    |      \\|/");
                System.out.println("    |       |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("   _|___");
                break;

            case 5:
                System.out.println("Oh no!");
                System.out.println("   _______");
                System.out.println("    |/      |");
                System.out.println("    |      (_)");
                System.out.println("    |      \\|/");
                System.out.println("    |       |");
                System.out.println("    |      / \\");
                System.out.println("    |");
                System.out.println("   _|___");

                break;

        }
    }

}
