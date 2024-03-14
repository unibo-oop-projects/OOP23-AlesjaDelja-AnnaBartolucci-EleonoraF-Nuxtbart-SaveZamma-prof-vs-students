package _OOP_develop_gradle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.Objects;

public class Elements<X, Y> {
	 private final X x;
	    private final Y y;

	    public Elements(final X x, final Y y) {
	        this.x = x;
	        this.y = y;
			
	    }

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

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.x, this.y);
	    }
	    
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

	    @Override
	    public String toString() {
	        return "Pair [X = " + this.x + ", Y = " + this.y + "]";
	    }

}
