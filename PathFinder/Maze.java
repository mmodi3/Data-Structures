package hw4;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }
    
    
    //DO NOT RUN METHODS 1 AND 2 AT THE SAME TIME, DOING SO CONFUSED THE COLOURS OF THE FUNCTIONS, MAKING METHOD 2 FAIL IN COMPLETING EVERY PATH
    
    
    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
    if (x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || x < 0 || y < 0 || maze.getColor(x, y) == BACKGROUND || maze.getColor(x, y) == TEMPORARY){
        	return false;
    	} else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
    		maze.recolor(x, y, PATH);
    		return true;
    	} else if (maze.getColor(x, y) == NON_BACKGROUND){
    		maze.recolor(x, y, TEMPORARY);
    		if (this.findMazePath(x-1,y) || this.findMazePath(x+1,y) || this.findMazePath(x,y-1) || this.findMazePath(x,y+1)) {
    			maze.recolor(x, y, PATH);
    			return true;
    		}
    	}
    		return this.findMazePath(x-1,y) || this.findMazePath(x+1,y) || this.findMazePath(x,y-1) || this.findMazePath(x,y+1);
    	}
    
    
    

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post Changes colour of the path to color Temporary while traversing through paths, changes them back to background when finished
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return Returns all possible paths from the starting point to the end point, returns an empty ArrayList of an empty ArrayList if non are found
     */
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> res, Stack<PairInt> trace) {
	    	if (x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || x < 0 || y < 0 || maze.getColor(x, y) == BACKGROUND || maze.getColor(x, y) == TEMPORARY){
	    		return;
	    	} else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
	    		PairInt Dummy = new PairInt(x,y);
	    		trace.push(Dummy);
	    		ArrayList<PairInt> temp = new ArrayList<PairInt>();
	    		temp.addAll(trace);
	    		res.add(temp);
	    		trace.pop();
	    		maze.recolor(x,y, NON_BACKGROUND);
	    		return;
	    	} else {
		    	PairInt Dummy = new PairInt(x,y);
		    	trace.push(Dummy);
		    	maze.recolor(x,  y, TEMPORARY);
		    	this.findMazePathStackBased(x + 1, y, res, trace);
		    	this.findMazePathStackBased(x - 1, y, res, trace);
		    	this.findMazePathStackBased(x, y + 1, res, trace);
		    	this.findMazePathStackBased(x, y - 1, res, trace);
		    	maze.recolor(x,  y, NON_BACKGROUND);
		    	trace.pop();
		    	return;
	    	}
	    	}

    public ArrayList<ArrayList< PairInt>> findAllMazePaths(int x, int y){
    		ArrayList<ArrayList<PairInt>> res = new ArrayList<>();
    		Stack<PairInt> trace = new Stack<>();
    		this.findMazePathStackBased(0,0,res, trace);
    		return res;
    		
    }
    
    
    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post No changes made to the gui maze, uses findAllMazePaths as a helper function
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return Returns the shortest path of all possible paths
     */
    public ArrayList<PairInt> findMazePathMin(int x, int y){
    		ArrayList<ArrayList<PairInt>> res = findAllMazePaths(x, y);
    		
    		int min = res.get(0).size();
    		ArrayList<PairInt> minh = res.get(0);
    		
    		for (int i = 0; i < res.size() - 1; i++) {
    			if (res.get(i).size() < min) {
    				min = res.get(i).size();
    				minh = res.get(i);
    			}
    		}
    		return minh;
    }
    
    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
