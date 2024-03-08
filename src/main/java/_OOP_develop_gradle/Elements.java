package _OOP_develop_gradle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.Objects;

public class Elements<X, Y> {
	 private final X x;
	    private final Y y;
	/*
	 * protected int x; protected int y; protected transient ImageView img;
	 * protected String path; protected int width; protected int height;
	 */

	    public Elements(final X x, final Y y) {
	        this.x = x;
	        this.y = y;
			/*
			 * this.path = path; // Non è necessario usare
			 * getClass().getResource(path).toString() this.width = width; this.height =
			 * height;
			 */
	    }

		/*
		 * public void makeImage(Pane pane) { img = new ImageView(new Image(path, width,
		 * height, false, false)); img.setX(x); img.setY(y);
		 * pane.getChildren().add(img); }
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

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.x, this.y);
	    }

		/*
		 * public void setX(int x) { this.x = x; if (img != null) { img.setX(x); } }
		 * 
		 * public void setY(int y) { this.y = y; if (img != null) { img.setY(y); } }
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

	    @Override
	    public String toString() {
	        return "Pair [X = " + this.x + ", Y = " + this.y + "]";
	    }

}
