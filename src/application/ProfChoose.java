package application;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.util.HashMap;
/*
 *	Classe che ho cfreato per gestire la selezione dei prof messi nella barra laterale 
 */
public class ProfChoose extends Elements {
	
		public enum ProfType{
			PROFMINE("", 1, 1, 1),
			PROFPASSIVE("", 1, 1, 2),
			RECTOR("", 1, 1, 3),
			TUTOR("", 1, 1, 4),
			PROFSHOOTER("", 1, 1, 5);
			
			String path;
	    	int x;
	    	int y;
	    	int ID;
	    	
			private ProfType(String path, int x, int y, int ID) {
				this.path = path;
				this.x = x;
				this.y = y;
				this.ID = ID;
			}

			public int getID() {
				return ID;
			}

			public void setID(int iD) {
				ID = iD;
			}

			public String getPath() {
				return path;
			}

			public void setPath(String path) {
				this.path = path;
			}

			public int getX() {
				return x;
			}

			public void setX(int x) {
				this.x = x;
			}

			public int getY() {
				return y;
			}

			public void setY(int y) {
				this.y = y;
			}
			
		}
	
		private static int idChoosenProf = -1;
		private static ImageView choosenProf;
		private static HashMap<Integer, ProfChoose> profList = new HashMap<>();//lista di tutti i prof tra cui scegliere
		private double timeCost;

	    public ProfChoose(int x, int y, String path, int width, int height, double timeCost) {
	        super(x, y, path, width, height);
	        this.timeCost=timeCost;// tempo che costa un professore, una tipologia
	    }
	    
	    public double getTimeCost() {
	    	return this.timeCost;
	    }
	    
	    public static void getProfTypes(AnchorPane pane) {
	    	// setto le diverse tipologie di prof nella barra laterale e posso selezionarne uno con il click --> settando  setIDProfChoosen(ID)
	    	// mi restituisce le tipologie di professori che posso prendere dalla scelta messa a disposizione
	    	for(ProfType type : ProfType.values()){
	    		ProfChoose currentType = new ProfChoose(type.getX(), type.getY(), type.getPath(), 1, 1, 0.5); //da capire come fare per "width, height, timeCost" 
	    		currentType.makeImage(pane);
	    		profList.put(type.getID(), currentType);
	    		currentType.img.setOnMouseClicked(e->{
		    		setIDProfChoosen(type.getID());
		    	});
	    	}
	    }
	    
	    public static ProfType getProf(int profID) {
	    	for(ProfType type : ProfType.values()) {
	    		if(type.getID() == profID) {
	    			return type;
	    		}
	    	}
	    	return null;
	    }

	    public static void setIDProfChoosen(int id) {
	    	choosenProf.setVisible(false);
	    	choosenProf.setX(profList.get(id).getX());
	    	choosenProf.setY(profList.get(id).getY());
	    	idChoosenProf=id;
	    	
	    }
	    public static int getIDProfChoosen() {
	    	return idChoosenProf;
	    }
}
