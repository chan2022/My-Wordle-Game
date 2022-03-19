# My-Wordle-Game
My Wordle game is a word guessing game of a 7 letter word within 5 tries. I designed and programmed with Java.     
One of my challenges was to find a word from a huge text file with efficient time complexity. I used Binary Search method instead of Linear Search method to improve the time complexity of 99.99%.    
In the future, I want to improve my game by implementing Java Swing to visualize the game, so that users can easily understand.

To start my Wordle game, I first introduce my game by showing the rules.
<img src="https://user-images.githubusercontent.com/101159967/159134711-39f4bb72-c23a-4fdf-897e-01c587f3e4dc.png">       
I inform the players to guess a 7 letter word within 5 tries and the rules and how it will show on the screen. 

The answers will be shown like this,
<img src="https://user-images.githubusercontent.com/101159967/159134821-e76ef609-96f9-4721-a776-04734bf2c393.png">.  
Where letters that are not in today's word will be deleted from the keyboard.   
Letters that are in today's word and in the correct place will be presented on the answer line.   
And the letters that are in today's word but not in correct places will be shown on the keyboard with quotes around it.

When the player enters a word that does not exists or a word that is not a 7 letter length word, the program will inform the player like this,
<img src="https://user-images.githubusercontent.com/101159967/159134318-c93ea60b-b592-4d7d-8215-f3b406501e1d.png">

If the player guessed the right word, the program will congratulate the player with these messages,
<img src="https://user-images.githubusercontent.com/101159967/159134365-ca979b7a-0b5b-4ae8-aaa6-40678789ef97.png">   
or
<img src="https://user-images.githubusercontent.com/101159967/159134407-0eb51971-175b-4262-b4b2-ebb75b121e57.png">    
With number of tries to get to today's word.  

If the player couldn't guess today's word within 5 tries, the program will generate a meesage with today's word
<img src="https://user-images.githubusercontent.com/101159967/159134505-d0a8769f-33bb-4676-bc2c-d87b085be953.png">
