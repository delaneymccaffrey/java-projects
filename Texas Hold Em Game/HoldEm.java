///////////////////////////////
/// Delaney McCaffrey
/// 11/10/17
/// CSE 2 Fall 2017
/// Homework 11
/// The program is the game Texas Hold 'Em. First an array of 52 cards are generated. The cards are then shuffled.
/// Then the first card is drawn for player one. Player two gets the second card, player 1 gets the third card, 
/// and player 2 gets the fourth card. Then 5 flop cards are chosen. The program then calculates the best 5-card poker hand 
/// from the 7 possible cards for each player. A winner is declared unless the game ends in a draw. 
///
import java.util.Random;
public class HoldEm { //begin class
      public static void main (String [] args) { //begin main method
            int[] cardsByNumber = new int[52]; //create array of numbers 0-51 to represent cards in a deck
            for ( int i=0; i<52; i++ ) {
                  cardsByNumber[i] = i; //fill array with numbers 0-51
            }
            int[] shuffledCards = new int[52];
            shuffledCards = Shuffle(cardsByNumber); //shuffle the deck of cards
            System.out.println("The card deck is shuffled."); //tell user that the deck is shuffled
///
            String[] wordsSelect = new String[9]; //create array to hold the words that represent each card
            for ( int i=0; i<9; i++ ) { //use a for loop 9 times because there are 9 cards total in play
                  wordsSelect[i] = Translate( shuffledCards[i] ); //call translate method to get the words of each card
            }
            System.out.println("First card drawn goes to Player 1: "+wordsSelect[0]); //tell user info about card 1
            System.out.println("Second card drawn goes to Player 2: "+wordsSelect[1]); //tell user info about card 2
            System.out.println("Third card drawn goes to Player 1: "+wordsSelect[2]); //tell user info about card 3
            System.out.println("Fourth card drawn goes to Player 2: "+wordsSelect[3]); //tell user info about card 4
            System.out.println("Five flop cards:"); 
            for ( int i=4; i<9; i++ ) { //use a for loop to print out the 5 flop cards
                  System.out.println(wordsSelect[i]); //print flop cards
            }
///   
            int b = 0;
            int[] player1PossibleSuits = new int[7]; //create a new array to hold the 7 possible suits for player 1
            for ( int i=0; i<9; i++ ) { //go through all 9 cards in play
                  if ( i!=1 && i!=3 ) { //select only the cards that player 1 can use
                        int a = shuffledCards[i]; 
                        player1PossibleSuits[b] = a/13; //determine the suit of the card
                        ++b;
                  }
            }
///
            b = 0;
            int[] player1PossibleNames = new int[7]; //create a new array to hold the 7 possible card values for player 1
            for ( int i=0; i<9; i++ ) { //go through all 9 cards in play
                  if ( i!=1 && i!=3 ) { //select only the cards that player 1 can use
                        int a = shuffledCards[i];
                        player1PossibleNames[b] = a%13; //determine the value of the card
                        ++b;
                  }
            }
///
            b = 0;
            int[] player2PossibleSuits = new int[7]; //create a new array to hold the 7 possible suits for player 2
            for ( int i=0; i<9; i++ ) { //go through all 9 cards in play
                  if ( i!=0 && i!=2 ) { //select only the cards that player 2 can use
                        int a = shuffledCards[i];
                        player2PossibleSuits[b] = a/13; //determine the suit of the card
                        ++b;
                  }
            }
///
            b = 0;
            int[] player2PossibleNames = new int[7]; //create a new array to hold the 7 possible card values for player 1
            for ( int i=0; i<9; i++ ) { //go through all 9 cards in play
                  if ( i!=0 && i!=2 ) { //select only the cards that player 2 can use
                        int a = shuffledCards[i];
                        player2PossibleNames[b] = a%13; //determine the value of the card
                        ++b;
                  }
            }
///           
            boolean fourOfKind = false; //initialize variable 
            boolean fullHouse = false; //initialize variable
            boolean flush = false; //initialize variable
            boolean threeOfKind = false; //initialize variable
            boolean twoPair = false; //initialize variable
            boolean pair = false; //initialize variable
            int player1 = 0; //initialize variable
            int player2 = 0; //initialize variable
///
            int[] countNames1 = new int[13]; //create a new array to hold counters 
            countNames1 = CountNames(player1PossibleNames); //use method to get counts of all player 1 cards
            int[] countSuits1 = new int[4]; //create a new array to hold counters
            countSuits1 = CountSuit(player1PossibleSuits); //use method to get counts of all player 1 suits
/// 
            fourOfKind = FourOfKind( countNames1 ); //check to see if you have four of a kind
            if ( fourOfKind == true ) { //if you have four of a kind then print result
                  player1 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 1 );  
            }
            else {
                  fullHouse = FullHouse( countNames1 ); //check to see if you have a full house
                  if ( fullHouse == true ) { //if you have a full house then print result
                        player1 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 1);
                  }
                  else {
                        flush = Flush( countSuits1 ); //check to see if you have a flush
                        if ( flush == true ) { //if you have a flush then print result
                              player1 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 1);
                        }
                        else {
                              threeOfKind = ThreeOfKind( countNames1 ); //check to see if you have three of a kind
                              if ( threeOfKind == true ) { //if you have three of a kind then print result
                                    player1 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 1);
                              }
                              else {
                                    twoPair = TwoPair( countNames1 ); //check to see if you have two pairs
                                    if ( twoPair == true ) { //if you have two paris then print result
                                          player1 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 1);
                                    }
                                    else { 
                                          pair = Pair( countNames1 ); //check to see if you have a pair 
                                          player1 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 1);
                                    }
                              }
                        }
                  }
            }
///
            fourOfKind = false; //reset variable
            fullHouse = false; //reset variable
            flush = false; //reset variable
            threeOfKind = false; //reset variable
            twoPair = false; //reset variable
            pair = false; //reset variable
            int[] countNames2 = new int[13]; //create a new array to hold counters
            countNames2 = CountNames(player2PossibleNames); //use method to get counts of all player 2 cards
            int[] countSuits2 = new int [4]; //create a new array to hold counters
            countSuits2 = CountSuit(player2PossibleSuits); //use method to get counts of all player 2 suits
///
            fourOfKind = FourOfKind( countNames2 ); //check to see if you have four of a kind
            if ( fourOfKind == true ) { //if you have four of a kind then print result
                  player2 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 2 );  
            }
            else {
                  fullHouse = FullHouse( countNames2 ); //check to see if you have a full house
                  if ( fullHouse == true ) { //if you have a full house then print result
                        player2 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 2);
                  }
                  else {
                        flush = Flush( countSuits2 ); //check to see if you have a flush
                        if ( flush == true ) { //if you have a flush then print result
                              player2 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 2);
                        }
                        else {
                              threeOfKind = ThreeOfKind( countNames2 ); //check to see if you have three of a kind
                              if ( threeOfKind == true ) { //if you have three of a kind then print result
                                    player2 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 2);
                              }
                              else {
                                    twoPair = TwoPair( countNames2 ); //check to see if you have two pairs
                                    if ( twoPair == true ) { //if you have two pairs then print result
                                          player2 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 2);
                                    }
                                    else {
                                          pair = Pair( countNames2 ); //check to see if you have a pair
                                          player2 = Print ( fourOfKind, fullHouse, flush, threeOfKind, twoPair, pair, 2);
                                    }
                              }
                        }
                  }
            }
///
            if ( player1 > player2 ) { //check to see who has the higher score
                  System.out.println("Player 1 wins."); //print result
            }
            else if ( player1 < player2 ) { //check to see who has the higher score
                  System.out.println("Player 2 wins."); //print result
            }
            else if ( player1 == player2 ) { //check to see who has the higher score
                  System.out.println("Draw no winner."); //print result
            }
      } //end main method
///
      public static int[] Shuffle( int[]cards ) { //begin method to shuffle deck of cards
            int place; //declare variable
            int where; //declare variable
            Random random = new Random(); //generate a random number
            for (int i=cards.length-1; i >= 0; i--){ //use loop to shuffle array 
                  place = random.nextInt(i+1); 
                  where = cards[place];
                  cards[place] = cards[i];
                  cards[i] = where;
            }
            return cards; //return array of shuffled cards
      } //end method
///
      public static String Translate( int card ) { //begin method to translate card values and suits into words
            String suit = " "; //initialize variable
            String cardNum = " "; //initalize varible
            switch ( card/13 ) { //use switch to designate the suit of each card
                  case 0:       
                        suit = "diamonds";
                        break;
                  case 1:
                        suit = "clubs";
                        break;
                  case 2:       
                        suit = "hearts";
                        break;
                  case 3:
                        suit = "spades";
                        break;
            }
            switch ( card%13 ) { //use suit to designate the value of each card
                  case 0:
                        cardNum = "ace"; 
                        break;
                  case 1:
                        cardNum = "2"; 
                        break;
                  case 2:
                        cardNum = "3"; 
                        break;
                  case 3:
                        cardNum = "4"; 
                        break;
                  case 4:
                        cardNum = "5"; 
                        break;
                  case 5:
                        cardNum = "6"; 
                        break;
                  case 6:
                        cardNum = "7"; 
                        break;
                  case 7:
                        cardNum = "8"; 
                        break;
                  case 8:
                        cardNum = "9"; 
                        break;
                  case 9:
                        cardNum = "10"; 
                        break;
                  case 10:
                        cardNum = "jack"; 
                        break;
                  case 11:
                        cardNum = "queen"; 
                        break;
                  case 12:  
                        cardNum = "king"; 
                        break;
            }
            String transCardName = "The "+cardNum+" of "+suit; //put together phrase to describe each card
            return transCardName; //return array of card name and suit phrases
      } //end method
///
      public static int[] CountSuit( int[] suits ) { //begin method to get counters of suits for your hand
            int[] counterSuit = new int[4]; //create new array to hold suit counters
            for ( int i=0; i<4; i++ ) { //initialize all values of counter array
                  counterSuit[i] = 0; //set all values of counter array to zero
            }
            for ( int i=0; i<7; i++ ) { //use for loop to check the suit of each card in hand
                  switch ( suits[i] ) { //use switch to increment the counters
                        case 0:
                              ++counterSuit[0];
                              break;
                        case 1:
                              ++counterSuit[1];
                              break;
                        case 2:
                              ++counterSuit[2];
                              break;
                        case 3:
                              ++counterSuit[3];
                              break;
                  }
            }
            return counterSuit; //return array of suit counters
      } //end method
///
      public static int[] CountNames( int[] names ) { //begin method to get counters of card values for your hand
            int[] counterCardNames = new int[13]; //create new array to hold card value counters
            for ( int i=0; i<13; i++ ) { //initialize all values of counter array 
                  counterCardNames[i] = 0; //set all values of counter array to zero
            }
            for ( int i=0; i<7; i++ ) { //use for loop to check the suit of each card in hand
                  switch ( names[i] ) { //use switch to increment the counters
                        case 0:
                              ++counterCardNames[0];
                              break;
                        case 1:
                              ++counterCardNames[1];
                              break;
                        case 2:
                              ++counterCardNames[2];
                              break;
                        case 3:
                              ++counterCardNames[3];
                              break;
                        case 4:
                              ++counterCardNames[4];
                              break;
                        case 5:
                              ++counterCardNames[5];
                              break;
                        case 6:
                              ++counterCardNames[6];
                              break;
                        case 7:
                              ++counterCardNames[7];
                              break;
                        case 8:
                              ++counterCardNames[8];
                              break;
                        case 9:
                              ++counterCardNames[9];
                              break;
                        case 10:
                              ++counterCardNames[10];
                              break;
                        case 11:
                              ++counterCardNames[11];
                              break;
                        case 12:
                              ++counterCardNames[12];
                              break;
                  }
            }
            return counterCardNames; //return array of card value counters
      } //end method
///   
      public static boolean FourOfKind( int[] list ) { //begin method to test if hand contains 4 of a kind
            boolean fourOfKind = false; //initialize variable
            for ( int i=0; i<13; i++ ) { //test all counters
                  if ( list[i] == 4 ) { //if a counter = 4 then contains 4 of a kind
                        fourOfKind = true; //set value to true if 4 of a kind
                  }
            }
            return fourOfKind; //return boolean
      } //end method
///
      public static boolean FullHouse( int[] list ) { //begin method to test if hand contains a full house
            boolean fullhouse = false; //initialize variable
            boolean test = false; //initialize variable
            for ( int i=0; i<13; i++ ) { //test all counters
                  if ( list[i] == 3 ) { //if three of a kind mark test variable as true
                        test = true;
                  }
            }
            if ( test == true ) { 
                  for ( int i=0; i<13; i++ ) { //test again to see if pair as well
                        if ( list[i] == 2 ) {
                              fullhouse = true; //if full house set variable as true
                        }
                  }
            }
            return fullhouse; //return boolean
      } //end method
///
      public static boolean Flush( int[] list ) {
            boolean flush = false; //initialize variable
            for ( int i=0; i<4; i++ ) {
                  if ( list[i] == 5 ) { //if any suit counter is 5 then flush
                        flush = true;
                  }
            }
            return flush; //return boolean
      } //end method
///
      public static boolean ThreeOfKind( int[] list ) {
            boolean threeOfKind = false; //initialize variable
            for ( int i=0; i<13; i++ ) {
                  if ( list[i] == 3 ) { //check if 3 of a kind
                        threeOfKind = true;
                  }
            }
            return threeOfKind; //return boolean
      } //end method
///
      public static boolean TwoPair( int[] list ) {
            boolean twoPair = false; //initialize variable
            boolean test = false; //initialize variable
            int where = 0; //initialize variable
            for ( int i=0; i<13; i++ ) {
                  if ( list[i] == 2 ) { //check to find first pair
                        test = true;
                        where = i; //mark spot where you found first pair
                  }
            }
            if ( test == true ) {
                  for ( int i=0; i<13; i++ ) { 
                        if ( list[i] == 2 ) { //check for second pair
                              if ( i != where ) { //make sure you don't count first pair twice
                                  twoPair = true;
                              }
                        }
                  }
            }
            return twoPair; //return boolean
      } //end method
///
      public static boolean Pair( int[] list ) {
            boolean pair = false; //initialize variable
            for ( int i=0; i<13; i++ ) {
                  if ( list[i] == 2 ) { //check for pair
                        pair = true;
                  }
            }
            return pair; //return boolean
      } //end method
///
      public static int Print( boolean fourOfKind, boolean fullHouse, boolean flush, boolean threeOfKind, boolean twoPair, boolean pair, int whichPlayer ) {
            int whatTheyHave = 0; //initialize variable
            if ( fourOfKind == true ) { //if four of a kind print result
                  System.out.println("Player "+whichPlayer+" has four of a kind.");
                  whatTheyHave = 7; //set score rank 
            }
            else if ( fullHouse == true ) { //if full house print result
                  System.out.println("Player "+whichPlayer+" has a full house.");
                  whatTheyHave = 6; //set score rank 
            }
            else if ( flush == true ) { //if flush print result
                  System.out.println("Player "+whichPlayer+" has a flush.");
                  whatTheyHave = 5; //set score rank 
            }
            else if ( threeOfKind == true ) { //if three of a kind print result
                  System.out.println("Player "+whichPlayer+" has three of a kind.");
                  whatTheyHave = 4; //set score rank 
            }
            else if ( twoPair == true ) { //if two pairs print result
                  System.out.println("Player "+whichPlayer+" has two pairs.");
                  whatTheyHave = 3; //set score rank 
            }
            else if ( pair == true ) { //if pair print result
                  System.out.println("Player "+whichPlayer+" has a pair.");
                  whatTheyHave = 2; //set score rank 
            }
            else { //if none of special cases then score is just highest card
                  System.out.println("Player "+whichPlayer+" has a high card hand.");
                  whatTheyHave = 1; //set score rank 
            }
            return whatTheyHave; //return score rank
      } //end method
} //end class