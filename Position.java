
import java.util.Arrays;

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

//An instance of this class represents a position in a 2-D grid
// and has 2 integer attributes, a row and a column; these may 
// assume any int value, positive, zero, or negative
//An instance of this class is immutable
//
public class Position
{
   //Instance Variables
	private final int row;
	private final int col;
	
   public Position(int row, int col)
   {
      this.row = row;
      this.col = col;
   }
   
   public int getRow()
   { 
       return this.row;
   } 
   
   public int getCol() 
   { 
       return this.col;
   }
   
  	//Return all Positions orthogonally adjacent to this Position
   public Position[] neighbors()
   {
      Position n1 = new Position(this.row + 1,this.col);
      Position n2 = new Position(this.row - 1,this.col);
      Position n3 = new Position(this.row,this.col + 1);
      Position n4 = new Position(this.row,this.col - 1);
      
      
      Position [] array = {n1, n2, n3, n4 };
      return array;
   }
   
   //Return true if parameter other is orthogonally adjacent to 
   // this Position, false otherwise
	public boolean isAdjacentTo(Position other)
	{ 
            for (int i = 0; i < 4; i++)
            { 
                if (neighbors()[i].equals(other))
                { 
                    return true;
                }
            }
            
            return false;
	}
	
   //Override
	public String toString()
	{
            return "[" + this.row + "," + this.col + "]";
	}
	
   //Override
	
        public boolean equals(Object other)
	{
          if (other == null)
           return false;
         
          if (this.getClass() != other.getClass())
           return false;
         
          Position that = (Position)other;
           return this.row == that.row && this.col == that.col;
	} 
}