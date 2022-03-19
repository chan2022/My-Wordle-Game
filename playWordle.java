
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class playWordle {

    public static void main(String[] args) throws Exception {

      InsideWordle insideJob = new InsideWordle();
      //ShowWordle show = new ShowWordle();

      /**
      * commonlyUsed7LetterWords is for generating Today's word to guess
    	* Insert every line of Commonly used 7 letter words into an String ArrayList for easier access
    	*/
      String CommonWordsFN = "commonlyUsed7LetterWords.txt";
      File file = new File(CommonWordsFN);
      Scanner sc = new Scanner(file);

      List<String> lines = new ArrayList<String>();
      while (sc.hasNextLine()) {
        lines.add(sc.nextLine());
      }
      //change to array
      String[] stringArr = lines.toArray(new String[0]);

      String every7LetterWordsFN = "Every7LetterWords.txt";

      // Today's word
      String keyWord = insideJob.Key(stringArr);
      String keyWord1 = keyWord.toLowerCase();

      System.out.println(keyWord);

      System.out.println("\n*** Welcome to my Wordle *** \n");
      System.out.println(" =============================================== Rueles ===============================================");
      System.out.println(" You have 5 tries to guess a 7 letters word");
      System.out.println(" - Letters that are in the correct place will be shown on your answer");
      System.out.println(" - Letters that are in the different place will be shown on the keyboard as lower case around quotes");
      System.out.println(" - Letters that are not in today's word will be deleted from the keyboard");
      System.out.println(" ====================================================================================================== \n");

      // number of tries
      int tries = 0;
      // If they got the word
      boolean correct = false;

      String keyboard = "Q W E R T Y U I O P\n A S D F G H J K L\n  Z X C V B N M";
      String answer = "_ _ _ _ _ _ _";

      while(!correct && tries<5) {

        Scanner inputSC= new Scanner(System.in);
        System.out.print("Enter a 7 letter word: ");
        String input = inputSC.nextLine();
        input = input.toLowerCase();

        boolean found = insideJob.isFound(input, every7LetterWordsFN);

        // check if they input a 7 letter word
        if(input.length() != 7){
          System.out.println("No! Enter a 7 letter word");

        } else if(!found){ //if the word is not found in the file
          System.out.println("Put in a valid word");

        } else if(keyWord1.equals(input)) {  // if the input and the answer is correct

          String message = "";

          // generate different message with different number of tries
          switch(tries){
            case 0: message = "     ## Fantastic, You got it! Here's your number of tries: " + (tries+1) + " ##";
                    break;
            case 1: message = "     ## Congrats, You got it! Here's your number of tries: " + (tries+1) + " ##";
                    break;
            case 2: message = "     ## Nice, You got it! Here's your number of tries: " + (tries+1) + " ##";
                    break;
            case 3: message = "     ## Phew, You got it! Here's your number of tries: " + (tries+1) + " ##";
                    break;
            case 4: message = "     ## Phew, You got it! Here's your number of tries: " + (tries+1) + " ##";
                    break;

          }

          System.out.println(message + "\n");
          // break out of the while loop
          correct = true;

        } else { //if the input and the answer is not correct
          String[] output = insideJob.whatWasCorrect(keyWord1, input, keyboard, answer);
          answer = output[0];
          keyboard = output[1];
          tries++;

        }

      }

      if(!correct){
        System.out.println("Sorry, you are out of tries. Better luck next time");
        System.out.println("Today's word was: " + keyWord);
      }

    }

}
