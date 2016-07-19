/*CONTROLLER:
this class is particularly responsible for the heavy lifting componenet of the code itself. so when it comes to moving, calculating and analyzing location based on a set of rules, this class should handle that.
*/   



package fifteenpuzzlegame;

import java.util.Random;
import java.util.Scanner;
/*
oh boy, honestly i have no idea what happened here with this attempt. i can't even phantom what it is that i am doing. at this rate it is all just a mistery to me. 

anyway in here lies my muscle and movement rule method. the move method itself is located within my display method and i am having a hard time connecting the two
*/

public class Muscle extends FifteenPuzzleGame{
    private Random randomizer = new Random();
    private int[][]  squares = new int[16][16];
    
    
   int[]neighborsArray = new int[4];
   int numberOfNeighbors;
int   numNeighbors, temp, moveTo, blank = 15;
    public Muscle() {
        this.numberOfNeighbors = findNeighbors( blank, neighborsArray);
    }
/*
    
    
    
    
    
    
*/
    
public boolean tryAbove( int pos ) {
    if (pos < 4)
      return false;
    if (squares[pos-4][pos-4] != 0)
      return false;
    // the square above is blank
    swap( pos, pos-4 );
    return true;
  }
  public boolean tryBelow( int pos ) {
    if (pos > 11)
      return false;
    if (squares[pos+4][pos+4] != 0)
      return false;
    swap( pos, pos+4 );
    return true;
  }
  public boolean tryLeft( int pos ) {
    if (pos%4 == 0)
      return false;
    if (squares[pos-1][pos-1] != 0)
      return false;
    swap( pos, pos-1 );
    return true;
  }
  public boolean tryRight( int pos ) {
    if (pos%4 == 3)
      return false;
    if (squares[pos+1][pos+1] != 0)
      return false;
    swap( pos, pos+1 );
    return true;
  }

  /*
  
  
  
  
  
  
  
  */
 
  public void swap( int one, int two ) {
    int   temp = squares[one][two];
    squares[one][two] = squares[two][one];
    squares[two][one] = temp;
  }
/*
  
  
  
  
  
  
  
  
  
  
 */
   
    public void Muscle(){//constructor for the muscle class
       Scanner input = new Scanner(System.in);
        
        Display view = new Display();//creates new object based off from Display class (blueprint)!!
        
        int number;
         
        while (true) {
        view.Display();//reference the Display contructor to create the View Object
        
        System.out.print("\nMove: ");   
        number = input.nextInt();
         
        if (number == 0)
                break;
            view.move(number); 
            }
       for (int a=1; a < squares.length; a++){
            for(int b=1; b < squares.length; b++)
      squares[a-1][b-1] = a;}
    scramble();
        for (int a=0; a < 400; a++){
            for (int b=0; b < 400; b++)
      move( randomizer.nextInt(squares.length-1) + 1 );
        }     
 }
 /*
    
    
    
    
    
 
 */ 
    public void scramble() {
    int[] neighbors = new int[4];
    for (int i=0; i < 200; i++) {
      numNeighbors = findNeighbors( blank, neighbors );
      moveTo = neighbors[ randomizer.nextInt(numNeighbors) ];
      temp = squares[moveTo][moveTo];
      squares[moveTo] = squares[blank];
      squares[blank][moveTo]  = temp;
      blank = moveTo;
            } 
}
/*

    
    
    
*/ 
  public int findNeighbors( int blank, int[] array ) {
    if (blank >  3)     array[numNeighbors++] = blank - 4;
    if (blank < 12)     array[numNeighbors++] = blank + 4;
    if (blank % 4 != 0) array[numNeighbors++] = blank - 1;
    if (blank % 4 != 3) array[numNeighbors++] = blank + 1;
    return numNeighbors;
    
    
  }

    
    
    
}
    

