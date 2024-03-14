package _OOP_develop_gradle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.Objects;

public class Elements<X, Y> {
	 private final X x;
	    private final Y y;

	    /**
	     * Constructs a pair of elements.
	     * 
	     * @param x The first element.
	     * @param y The second element.
	     */
	    public Elements(final X x, final Y y) {
	        this.x = x;
	        this.y = y;
			
	    }

	    /**
	     * Returns the first element of the pair.
	     * 
	     * @return The first element of the pair.
	     */
	    public X getX() {
	        return this.x;
	    }

	    /**
	     * Returns the second element of the Pair Object.
	     * 
	     * @return second element of pair.
	     */
	    public Y getY() {
	        return this.y;
	    }

	    /**
	     * Computes a hash code for this pair.
	     * 
	     * @return A hash code value for this pair.
	     */
	    @Override
	    public int hashCode() {
	        return Objects.hash(this.x, this.y);
	    }
	    
	    /**
	     * Indicates whether some other object is "equal to" this one.
	     * 
	     * @param obj The reference object with which to compare.
	     * @return true if this pair is the same as the obj argument; false otherwise.
	     */
	    @SuppressWarnings("rawtypes")
	    @Override
	    public boolean equals(final Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Elements other = (Elements) obj;
	        return Objects.equals(this.x, other.x) && Objects.equals(this.y, other.y);
	    }

	    /**
	     * Returns a string representation of the pair.
	     * 
	     * @return A string representation of the pair.
	     */
	    @Override
	    public String toString() {
	        return "Pair [X = " + this.x + ", Y = " + this.y + "]";
	    }

}
