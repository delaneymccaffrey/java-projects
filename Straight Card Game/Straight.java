///////////////////////////////
/// Delaney McCaffrey
/// 11/10/17
/// CSE 2 Fall 2017
/// Homework 12
/// The program generates a deck of 52 cards and shuffles the deck. 5 cards are then drawn and then checked for a straight.
/// Then, one million 5-card hands are generated and checked for straights, 
/// and the percentage of hands with straights is calculated. 
///
import java.util.Random; //import random number generator
public class Straight { //begin class
      public static void main (String [] args) { //begin main method
            int[] cardsByNumber = new int[52]; //create array of numbers 0-51 to represent cards in a deck
            for ( int i=0; i<52; i++ ) {
                  cardsByNumber[i] = i; //fill array with numbers 0-51
            }
            int[] shuffledCards = new int[52];
            shuffledCards = Shuffle(cardsByNumber); //shuffle the deck of cards
            System.out.println("The card deck is shuffled."); //tell user that the deck is shuffled
///
            String[] wordsSelect = new String[5]; //create array to hold the words that represent each card
            for ( int i=0; i<5; i++ ) { //use a for loop 5 times because there are 5 cards total in play
                  wordsSelect[i] = Translate( shuffledCards[i] ); //call translate method to get the words of each card
            }
///
            System.out.println("Your five card hand:"); 
            for ( int i=0; i<5; i++ ) { //use a for loop to print out the names of the 5 cards
                  System.out.println(wordsSelect[i]); //print cards
            }
///   
            int[] names = new int[5]; //create a new array to hold the names of the cards
            for ( int i=0; i<5; i++ ) { //go through all 5 cards in play
                  int a = shuffledCards[i]; 
                  names[i] = a%13; //determine the value of the card
            }
///           
            boolean straight = false; //initialize variable 
            straight = Straight(names); //check to see if you have a straight
            if ( straight == true ) { //if you have a straight then print result
                  System.out.println("This hand has a straight.");  
            }
            else {
                  System.out.println("No straight found"); 
            }
///
            System.out.println(); //print a space line
            System.out.println("Checking one million random 5-card hands for straights..."); //tell user what you're doing
            int[] shuffle2 = new int[52]; //create new array to hold shuffled cards 
            int[] names2 = new int[5]; //create a new array to hold 5 card hands
            double percent = 0; //initialize variable
            double num = 0; //initialize variable
            for ( int i=0; i<1000000; i++ ) { //use for loop to check one million 5-card hands
                  straight = false; //initialize variable
                  shuffle2 = Shuffle(cardsByNumber); //shuffle the deck of cards
                  for ( int j=0; j<5; j++ ) { //go through all 5 cards in play
                        int a = shuffle2[j]; 
                        names2[j] = a%13; //determine the value of the card
                  }
                  straight = Straight(names2); //check to see if you have a straight
                  if ( straight == true ) { //if you have a straight then increment counter
                         ++num;
                  }
            }
            percent = num/10000; //divid by 10,000 to get the percentage out of a million
            System.out.println("The chance of drawing a straight is "+percent+"%"); //print percentage 
      } //end main method
///
      public static int[] Shuffle( int[]cards ) { //begin method to shuffle deck of cards
            int place; //declare variable
            int where; //declare variable
            Random random = new Random(); //generate a random number
            for (int i=cards.length-1; i >= 0; i--) { //use loop to shuffle array 
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
      public static boolean Straight( int[] list ) { //begin method to test if hand contains a straight
            boolean straight = false; //initialize variable
            boolean success = false; //initialize variable
            int low = LowCard(list); //call method to find lowest card in the hand
            int count = 0; //initialize variable
            for ( int i=0; i<5; i++ ) { //use for loop to evaluate every card in hand
                  success = LinSearch(list, low); //call method to perform linear search to find certain cards
                  ++low; //increment low value to find next card
                  if ( success == true ) { //if card is found, increment counter
                        ++count; 
                  }
            }
            if ( count == 5 ) { //if all 5 cards are in a row
                  straight = true; //set value to true 
            }
            return straight; //return boolean
      } //end method
///
      public static boolean LinSearch( int[] list, int chosen ) { //begin method to perform a linear search
            boolean found = false; //initialize variable
            for ( int i=0; i<5; i++ ) { //use for loop for linear search
                  if ( list[i] == chosen ) { //if you find what you're looking for, set found to true
                        found = true;
                  } 
            }
            return found; //return boolean
      } //end method
///   
      public static int LowCard( int[] list ) { //begin method to find the lowest card in the hand
            int low = list [0]; //set low variable to first value in array
            for ( int i=1; i<5; i++ ) { //use for loop to search through entire array
                  if ( list[i] < low ) { //if value is lower than first variable, reset low variable
                        low = list [i]; 
                  }
            }
            return low; //return boolean
      } //end method
} //end class