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

//An instance of this class represents a Maze constructed from
// a 2D grid of OPEN and BLOCKED Squares.
//A solution of a Maze is a Path of orthogonally adjacent OPEN
// Squares beginning at a specially designated OPEN Square and
// ending at any OPEN Square on the boundary of the grid
//
import java.util.*;
public class Maze
{
   //Instance Variables
	private Grid grid;
	private Path path;
	private boolean traceOn;
   
   //Constructor
    public Maze(Scanner source)
    { 
        this.grid = new Grid(source);
        this.path = new Path(); 
        traceOn = true;
        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < this.grid.toString().length(); i++){ 
            if (this.grid.toString().charAt(i) == '\n' && rowCount < this.grid.getMaxRow()) { 
                colCount = 0;
                ++rowCount;
            } 
            if (this.grid.toString().charAt(i) == '+'){ 
                break;
            } 
            if (colCount < this.grid.getMaxCol()) {
            ++colCount; 
            }
        } 
        Position start = new Position(rowCount,colCount - 1);
        this.path.extend(start);
    } 
	
   public void setTraceOn()
   {
      this.traceOn = true;
   } 
   
   //Construct a solution of this Maze.
   //Return true if the construction succeeds, otherwise false
   //base cases: am i free?(if you are on a boundry), if the path is empty(Failure)
   //back up to the previous square if possible
   //update grid and path then make the recursive call
	public boolean solve()
	{  
            if (traceOn == true){ 
                System.out.println(this.grid + "\n" + this.path);
            }
            //Base cases
            if (this.path.getPath().length == 0)
            { 
                System.out.print("Empty Failure");
                return false;
            } 
            
            
            if (checkBoundry(this.path.getPath()[this.path.getPath().length - 1])) {
                System.out.print("Escape Success");
                return true;
            } 
            //Attempts to solve
            
            Position recentStep = this.path.getPath()[this.path.getPath().length - 1];
            int nxtStepRow = recentStep.getRow();
            int nxtStepCol = recentStep.getCol();
            Position nxtStep = new Position(nxtStepRow - 1, nxtStepCol);

            if (this.grid.getGrid()[nxtStepRow - 1][nxtStepCol] == Grid.Square.OPEN){ 
                nxtStep = new Position(nxtStepRow - 1, nxtStepCol);
                this.path.extend(nxtStep);
                this.grid.updateGrid(nxtStepRow - 1, nxtStepCol, false);
            } 
            else {
                if (this.grid.getGrid()[nxtStepRow][nxtStepCol + 1] == Grid.Square.OPEN) { 
                nxtStep = new Position(nxtStepRow, nxtStepCol + 1);
                this.path.extend(nxtStep);
                this.grid.updateGrid(nxtStepRow, nxtStepCol + 1, false);
            } 
                else { 
                 if (this.grid.getGrid()[nxtStepRow + 1][nxtStepCol] == Grid.Square.OPEN) { 
                nxtStep = new Position(nxtStepRow + 1, nxtStepCol);
                this.path.extend(nxtStep);
                this.grid.updateGrid(nxtStepRow + 1, nxtStepCol, false);
                } 
                 else { 
                if (this.grid.getGrid()[nxtStepRow][nxtStepCol - 1] == Grid.Square.OPEN) { 
                nxtStep = new Position(nxtStepRow, nxtStepCol - 1);
                this.path.extend(nxtStep);
                this.grid.updateGrid(nxtStepRow, nxtStepCol - 1, false);
                } 
                else { 
                    this.path.backUp();
                    this.grid.updateGrid(nxtStepRow, nxtStepCol, true);
                }
                 }
                }
            }
            
            return solve();
	}
	
	private boolean checkBoundry (Position step) { 
            if(step.getRow() == 0 || step.getRow() == 8) {
                return true;
            } 
            if (step.getCol() == 0 || step.getCol() == 8) { 
                return true;
            } 
            return false;
        }
        
	public String toString()
	{
            return "" + this.grid + "\n" + this.path;
	}
}