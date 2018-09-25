package hw4;

public class PairInt{
	private int x;
	private int y;
	
	//Constructs a new pairint with (x,y) format
	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//Returns the value of x
	public int getX(){
		return this.x;
	}
	//Returns the value of y
	public int getY(){
		return this.y;
	}
	//Changes the value of calling PairInt's x value
	public void setX(int x){
		this.x = x;
	}
	//Changes the value of calling PairInt's y value
	public void setY(int y) {
		this.y = y;
	}
	//Overrides the inbuilt equals method to check for equality between two PairInts, returns false if parameter Object is not a pairint
	public boolean equals(Object P) {
		if (P == this) {
			return true;
		} else if (!(P instanceof PairInt)) {
			return false;
		} else {
			PairInt O = (PairInt) P;
			return O.getX() == this.getX() && O.getY() == this.getY();
		}
	}
	//Prints the calling PairInt in the format (x,y)
	public String toString(){
		return "(" + this.x + "," + this.y + ")";
	}
	//Creates a deepcopy of the calling PairInt
	public PairInt copy(){
		return new PairInt(this.x, this.y);
	}
}
