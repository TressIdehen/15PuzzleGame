/*VIEW
This particular class is responsible for the code display properties. so when it comes to printing something onto the screen, the methods within this class should do just that.
*/
package fifteenpuzzlegame;

public class Display extends Muscle{
    
    
   //using a multidimenssional array i had hope to speed up the table creating process, and simplify the code lenght itself. however... it turned out to be quite the hassle to manipulate, seeing as the tutorial does it with a single array. this hereby made working around the code instruction from the tutorial, a bit difficult if not impossible to follow. 
    
    int[][]  squares = new int[4][4];//creates an integer multidimenssional array called square 
     int a, b;                       //a being the row, and b being the column.
    
    public String blank(int number){//the blank method for space square
        if(number == 0){//this checks that the zero int value is known as the numer variable.
        return  " ";}//this returns that value to blank
        return Integer.toString(number);//converts the blank string to int
        
        
      
    }
    
    public void Display(){//start of Constructor
        int count = 0;
        for (int a = 0; a < 4; a++){//start "a"(row) for loop
            for(int b = 0; b < 4; b++){//start "b"(column) for loop
                squares[a][b] = count;
                System.out.print(blank(squares[a][b]) + "\t");
                count++;
            }//end "b" for loop
            System.out.println("\n ");//spaces the column or the "a" i should say
        }//end "a" for loop
        
       
        
    }//end of constructor
    public void move( int number ) {//start of move method
    if (number >= squares.length)
      return;
    int a;    ////// find the slot this number is in //////
    int b;
    for (a=0; a < squares.length; a++){
        for (b=0; b < squares.length; b++)
      if (squares[a][b] == number)
        break;
    if (tryAbove(b)) return;
    if (tryBelow(b)) return;
    if (tryLeft(a))  return;
    if (tryRight(a)) return;
    }
    scramble();
  }//end of move method  
    
} 

    
   
