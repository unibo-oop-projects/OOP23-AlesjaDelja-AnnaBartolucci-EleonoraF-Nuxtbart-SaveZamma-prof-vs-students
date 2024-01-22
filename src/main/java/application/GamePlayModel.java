package main.java.application;

import java.util.List;
import java.util.ArrayList;

public class GamePlayModel {


	    private int solarEnergy; // Energia solare
	    private int timeTot; // Tempo di gioco
	    private List<Student> studentList; // Lista di studenti presenti
	    private List<Prof> profList; // Lista di prof presenti

	    public GamePlayModel() {
	        this.solarEnergy = 0;
	        this.timeTot = 0;
	        this.studentList = new ArrayList<>();
	        this.profList = new ArrayList<>();
	    }

	    public int getSolarEnergy() {
	        return solarEnergy;
	    }

	    public int getTimeTot() {
	        return timeTot;
	    }

	    public List<Student> getStudentList() {
	        return studentList;
	    }

	    public List<Prof> getProfList() {
	        return profList;
	    }

	    public void generateWave() {
	        // Creare una nuova ondata di zombie
	    }

	    public void generateNewProf() {
	        // Creare un nuovo professore
	    }

	    public void generateNewStudent() {
	        // Creare un nuovo studente
	    }

	    public void increaseSolarEnergy(int amount) {
	        solarEnergy += amount;
	    }

	    public void decreaseSolarEnergy(int amount) {
	        if (solarEnergy >= amount) {
	            solarEnergy -= amount;
	        } else {
	        	// Manca energia
	        }
	    }
	    
	    public void increaseTimeTot(int amount) {
	    	timeTot += amount;
	    }

	    public void decreaseTimeTot(int amount) {
	        if (timeTot >= amount) {
	        	timeTot -= amount;
	        } else {
	            // Manca tempo
	        }
	    }

	    public void profKilled(Prof prof) {
	        // Logica quando un professore viene ucciso
	        
	    	decreaseTimeTot(prof.getTimeCost());
	        // Rimuovi il prof dalla lista
	        profList.remove(prof);
	    }

	    

	    // Definizione delle classi Student e Prof (da implementare)

	    public class Student {
	        
	        // ...
	    }

	    public class Prof {
	        
	        // ...

	        private int timeCost; // Tempo necessario per piantare questa pianta

	        public int getTimeCost() {
	            return timeCost;
	        }
	    }


}
