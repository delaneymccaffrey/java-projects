///////////////////////////////
/// Delaney McCaffrey
/// 10/13/17
/// CSE 2 Fall 2017
/// Homework 7
/// This program displays a window into a network of boxes connected by lines.
/// The user desides the size of the display window, the size of the boxes and the length of the edges connecting the boxes.
///
import java.util.Scanner; //import a scanner in order to accept input from the user
public class Network { //begin class
      public static void main (String [] args) { //begin main method
///
            Scanner myScanner = new Scanner( System.in ); //use scanner to accept input
            boolean correct = false; //initialize variable
            int height = 0; //initialize variable
            System.out.print("Please input the height of the display window: "); //ask user for input
            while ( correct == false ) { //use while loop to ensure positive integer is entered
                  if ( myScanner.hasNextInt() ) {
                        height = myScanner.nextInt(); //if input is correct, assign it to a variable
                        if ( height > 0 ) { //test is integer is positive
                                correct = true; } //if positive integer leave the loop
                        else {
                                System.out.print("ERROR: Please enter a positive integer for the height: "); } } //ask user again for correct input
                  else {
                        myScanner.next(); //if not an integer delete what the user typed
                        System.out.print("ERROR: Please enter a positive integer for the height: "); } } //ask user again for correct input       
///
            correct = false; //reset check process
            int width = 0; //initialize variable
            System.out.print("Please input the width of the display window: "); //ask user for input
            while ( correct == false ) { //use while loop to ensure positive integer is entered
                  if ( myScanner.hasNextInt() ) {
                        width = myScanner.nextInt(); //if input is correct, assign it to a variable
                        if ( width > 0 ) { //test is integer is positive
                                correct = true; } //if positive integer leave the loop
                        else {
                                System.out.print("ERROR: Please enter a positive integer for the width: "); } } //ask user again for correct input
                  else {
                        myScanner.next(); //if not an integer delete what the user typed
                        System.out.print("ERROR: Please enter a positive integer for the width: "); } } //ask user again for correct input       
///
            correct = false; //reset check process
            int boxSize = 0; //initialize variable
            System.out.print("Please input the size of the boxes: "); //ask user for input
            while ( correct == false ) { //use while loop to ensure positive integer is entered
                  if ( myScanner.hasNextInt() ) {
                        boxSize = myScanner.nextInt(); //if input is correct, assign it to a variable
                        if ( boxSize > 0 ) { //test is integer is positive
                                correct = true; } //if positive integer leave the loop
                        else {
                                System.out.print("ERROR: Please enter a positive integer for the box size: "); } } //ask user again for correct input
                  else {
                        myScanner.next(); //if not an integer delete what the user typed
                        System.out.print("ERROR: Please enter a positive integer for the box size: "); } } //ask user again for correct input       
///
            correct = false; //reset check process
            int edge = 0; //initialize variable
            System.out.print("Please input the length of an edge: "); //ask user for input
            while ( correct == false ) { //use while loop to ensure positive integer is entered
                  if ( myScanner.hasNextInt() ) {
                        edge = myScanner.nextInt(); //if input is correct, assign it to a variable
                        if ( edge > 0 ) { //test is integer is positive
                                correct = true; } //if positive integer leave the loop
                        else {
                                System.out.print("ERROR: Please enter a positive integer for the edge: "); } } //ask user again for correct input
                  else {
                        myScanner.next(); //if not an integer delete what the user typed
                        System.out.print("ERROR: Please enter a positive integer for the edge: "); } } //ask user again for correct input       
///
           boolean evenOrOdd = true; //initialize variable (if even then true)
           if ( boxSize%2 == 1 ) { //check to see if box size is an even or odd number
                evenOrOdd = false; //if odd assign to false
           }
///             
           int inside = 0; //initialize variable
           for ( int outside = 0; outside < height; outside++ ) { //program will print until reach the determined height
                  if ( ((outside%(edge+boxSize)) == 0 || (outside%(edge+boxSize)) == (boxSize-1) ) ) { //if beginning or end of box print this line
                        while ( inside < width ) { //program will print until reach the determined width
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("#"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter1 = 0; counter1 < (boxSize-2); counter1++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print("-"); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("#"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter2 = 0; counter2 < edge; counter2++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                    }
                              } 
                        }
                  } 
                  else if ( evenOrOdd == true && ((outside%(edge+boxSize)) == ((boxSize/2)-1) || (outside%(edge+boxSize)) == (boxSize/2)) ) { //if box size is even then print this line with the edges going across at the middle of each box
                        while ( inside < width ) { //program will print until reach the determined width
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter3 = 0; counter3 < (boxSize-2); counter3++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++;  //increment width checker 
                                    }
                              }
                              if ( inside < width ) {  //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++;  //increment width checker 
                              }
                              for ( int counter4 = 0; counter4 < edge; counter4++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print("-"); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                        } 
                  }
                  else if ( evenOrOdd == false && (outside%(edge+boxSize)) == (boxSize/2) ) { //if box size is odd then print this line with the edges going across at the middle of each box
                        while ( inside < width ) {  //program will print until reach the determined width                         
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter5 = 0; counter5 < (boxSize-2); counter5++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter6 = 0; counter6 < edge; counter6++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print("-"); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                        } 
                  }
                  else if ( evenOrOdd == false && (outside%(edge+boxSize)) >= boxSize ) { //if box size is odd then print this line with the edges going down at the middle of each box
                        while ( inside < width ) {    //program will print until reach the determined width                          
                              for ( int counter7 = 0; counter7 < boxSize/2; counter7++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                          }
                              }
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter8 = 0; counter8 < ((boxSize/2)+edge); counter8++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                        }
                  } 
                  else if ( evenOrOdd == true && (outside%(edge+boxSize)) >= boxSize ) { //if box size is even then print this line with the edges going down at the middle of each box
                        while ( inside < width ) {  //program will print until reach the determined width                       
                              for ( int counter9 = 0; counter9 < boxSize/2-1; counter9++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter10 = 0; counter10 < ((boxSize/2-1)+edge); counter10++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                        }
                  }  
                  else { //print the sides of the boxes
                        while ( inside < width ) {   //program will print until reach the determined width                           
                              if ( inside < width ) { //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter11 = 0; counter11 < (boxSize-2); counter11++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                              if ( inside < width ) {  //check to see if reached determined width
                                    System.out.print("|"); //print this character
                                    inside++; //increment width checker 
                              }
                              for ( int counter12 = 0; counter12 < edge; counter12++ ) {
                                    if ( inside < width ) { //check to see if reached determined width
                                          System.out.print(" "); //print this character
                                          inside++; //increment width checker 
                                    }
                              }
                        }
                  }
                  System.out.println(); //move to next line
                  inside = 0; //reset variable for figure out width
           }
      } //end main method
} //end class