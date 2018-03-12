//  PROGRAMMER:  Jean Paul Lobon  5729060
//
//  CLASS:       COP 3337   TR 11:00am
//
//  INSTRUCTOR:  Norman Pestaina  ECS 364
//
//  ASSIGNMENT:  #5 Maze/Recursion.   DUE Thursday 11/28
//
// CERTIFICATION: I certify that this work is my own and that
//                 none of it is the work of any other person.
//

//An instance of this class represents a 2D grid of Squares
// that are initially either OPEN or BLOCKED to from a Maze
//The status of an OPEN Square may become SELECTED when the
// the Square is selected for an escape path from the Maze
//
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Grid
{
   //Instance Variables
	private final int maxRow;  //Highest index of any row
	private final int maxCol;  //Highest index of any colums
	
	private Square[][] grid; //The 2D grid of Squares
	
   //Constructor
   //Parameter source is initialized to scan the input file
	public Grid(Scanner source)
	{
        this.maxRow = source.nextInt();
        this.maxCol = source.nextInt();
        System.out.println(this.maxRow + " " + this.maxCol);
        this.grid = new Square[this.maxRow][this.maxCol];
        int row = -2;
        int startingRow = 0;
        int startingCol = 0;
        while (source.hasNextLine())
        { 
            row++;
            String nL = source.nextLine();
            
            Scanner stream = new Scanner(nL);

            while (stream.hasNextInt())
            { 
                int col = stream.nextInt();
                if (row < this.maxRow){
                this.grid[row][col - 1] = Square.BLOCKED;
                } 
                if (row == this.maxRow - 1 && col == this.maxCol){
                    startingRow = source.nextInt();
                    startingCol = source.nextInt(); 
                    openFiller();
                    this.grid[startingRow - 1][startingCol - 1] = Square.SELECTED;
                }
            }
          } 
         } 
        
        public int getMaxRow() { 
            return this.maxRow;
        } 
        
        public int getMaxCol() { 
            return this.maxCol;
        } 
        
        public Square[][] getGrid () { 
            return this.grid;
        }
        
        public void updateGrid(int rowStep,int colStep, boolean blocked) { 
            if (blocked == false){
            this.grid[rowStep][colStep] = Square.SELECTED;
            } 
            
            if (blocked == true) { 
                this.grid[rowStep][colStep] = Square.REJECTED;
            }
        }
   		
	public String toString()
	{ 
            String image = "";
            int r = -1;
            for(int i = 0; i < this.maxRow; i++){
                r++;
                int c = 0;
                for(int j = 0; j < this.maxCol; j++) { 
                    if (r < this.maxRow && c < this.maxCol){
                    image += this.grid[r][c];
//                    if (this.maxCol - 1 == c){
//                        image += "\n";
//                    }
                    c++;
                    } 
                } 
              image += "\n";  
            } 
		return image;
	} 
        
        private void openFiller () { 
              int r = -1;
              for(int i = 0; i < this.maxRow; i++){
                r++;
                int c = 0;
                for(int j = 0; j < this.maxCol; j++) { 
                    if (r < this.maxRow && c < this.maxCol){ 
                    if (this.grid[r][c] == null){ 
                        this.grid[r][c] = Square.OPEN;
                    }
                    c++;
                    } 
                } 
            }
        }
   
   //An enum type to represent the state of a square in a Grid
   public enum Square
   {
	   OPEN(' '), BLOCKED('#'), SELECTED('+'), REJECTED('X');
	
	   private char symbol;
	
	   private Square(char symbol)
	   {
		   this.symbol = symbol;
	   }
	
	   public char getSymbol()
	   {
		   return this.symbol;
	   } 
           
           public String toString() 
           { 
               return "" + this.symbol;
           } 
   } 
}