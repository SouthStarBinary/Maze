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

//An instance of this class represents a sequence of Positions
//Each member of the sequence is orthogonally adjacent to its
// predecessor and successor.
//A Position in this Path occurs no more than once in this Path
import java.util.ArrayList;
public class Path
{
   //Instance Variable
	private ArrayList<Position> path;
	
   //Constructor
	public Path()
	{ 
		this.path = new ArrayList<Position>();
	}
	
   //Accessor: 
   //Returns COPIES of the Positions in this Path in the
   // same order in which they occur in this Path
	public Position[] getPath()
	{ 
            Position [] copy = new Position [this.path.size()];
            int i = 0;
            for(Position path: this.path)
            { 
                copy[i] = path;
                i++;
            }
            return copy;
	}
	
   //Mutator:
   //Add a new Position after the current last Position in this Path
   //A Runtime Exception is thrown if
   // - the new Position duplicates a Position already in this Path
   // - the new Position is not adjacent to the last Position
	public void extend(Position step)
	{ 
            System.out.println(step);
            if (getPath().length != 1){
            for (Position path : this.path)
            { 
                if (step.equals(path))
                { 
                    throw new RuntimeException("New position duplicates a position"
                            + " already in this Path.");
                } 
            } 
            }
            if (getPath().length == 1){
            if (step.isAdjacentTo(getPath()[getPath().length - 1]) == false)
            { 
                throw new RuntimeException("New position is not adjacent to"
                         + " the last postion.");
            } 
            }
            
            
            this.path.add(step);
	}
	
   //Mutator:
   //Remove and return the last Position from this Path
   //A Runtime Exception is thrown if this Path is empty
	public Position backUp()
	{ 
            return this.path.remove(this.path.size() -1);
	}
	
   //Override
	public String toString()
	{
		return "" + this.path;
	} 
}
