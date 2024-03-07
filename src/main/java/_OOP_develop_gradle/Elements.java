package _OOP_develop_gradle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.Serializable;

public class Elements {
	    protected int x;
	    protected int y;
	    protected transient ImageView img;
	    protected String path;
	    protected int width;
	    protected int height;

	    public Elements(int x, int y, String path, int width, int height) {
	        this.x = x;
	        this.y = y;
	        this.path = path;  // Non è necessario usare getClass().getResource(path).toString()
	        this.width = width;
	        this.height = height;
	    }

	    public void makeImage(Pane pane) {
	        img = new ImageView(new Image(path, width, height, false, false));
	        img.setX(x);
	        img.setY(y);
	        pane.getChildren().add(img);
	    }

	    public int getX() {
	        return x;
	    }

	    public void setX(int x) {
	        this.x = x;
	        if (img != null) {
	            img.setX(x);
	        }
	    }

	    public int getY() {
	        return y;
	    }

	    public void setY(int y) {
	        this.y = y;
	        if (img != null) {
	            img.setY(y);
	        }
	    }
	

}
