import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class InsideWordle {

  // constructor
	public InsideWordle() {

  }

	/**
	* Generate today's secret word from the commonlyUsed7LetterWords text file
	* get a random number from 0-500
	* return random number index word from the input string array
	*/
  public String Key(String[] StringArray) {
    Random rand = new Random();
		int rand_num = rand.nextInt(1372);
		return StringArray[rand_num];
  }

	/**
	* check if the word is in the Every7LetterWords text file
	* Using the binary search method
	*/
  public static boolean isFound(String input, String fileName) throws Exception  {

		// "r" as in read mode
		RandomAccessFile raf = new RandomAccessFile(fileName, "r");

		int lineSize = 8;
		int numberOfLines = 40087;

		// perform the binary search...
		byte[] lineBuffer = new byte[lineSize];
		int low = 0;
		int high = numberOfLines;
		int mid;

		while (low <= high){

		  mid = (low+high)/2;
		  raf.seek(mid*lineSize); // jump to this line in the file
		  raf.read(lineBuffer); // read the line from the file
		  String line = new String(lineBuffer); // convert the line to a String
			line = line.substring(0, 7);

		  int comparison = line.compareTo(input);

		  if (comparison < 0){
		    // line comes before searchValue
		    low = mid + 1;

			} else if (comparison > 0) {
		    // line comes after searchValue
		    high = mid - 1;

		  } else {
				//comparison == 0, line == input
				return true;
			}
		}

		raf.close(); // close the file when you're finished

		return false;

  }

	/**
	* output the message of which letters are in the correct place and which are not
	* Using keyboard to show the result
	*/
  public static String[] whatWasCorrect(String keyWord, String input, String keyboard, String answer) {

		// String array where first index will contain the answer that user inputed
		// Second index will contain keyboard of letters that are used
		String[] keyboardAndAnswer = new String[2];

    for(int i=0; i<keyWord.length(); i++) {

			String inputChar = String.valueOf(input.charAt(i));

      //if the letter at index i is in same place as keyWord's index i
      if(keyWord.charAt(i) == input.charAt(i)){

			 char[] chars = answer.toCharArray();
			 chars[i*2] = input.charAt(i);
			 answer = String.valueOf(chars);


      } else if(keyWord.contains(inputChar)){
				// if the letter exists in the key word but not in the right place
				String withQuotes = "\'" + inputChar.toLowerCase() + "\'";
				keyboard = keyboard.replace(inputChar.toUpperCase(), withQuotes);

      } else {
				//if the letter does not exist, delete from the keyboard
				keyboard = keyboard.replace(inputChar.toUpperCase(), "_");
			}

    }

		keyboardAndAnswer[0] = answer;
		keyboardAndAnswer[1] = keyboard;

		System.out.println("\nAnswer: "+answer);
		System.out.println("\n"+keyboard+"\n");

    return keyboardAndAnswer;

  }

}
