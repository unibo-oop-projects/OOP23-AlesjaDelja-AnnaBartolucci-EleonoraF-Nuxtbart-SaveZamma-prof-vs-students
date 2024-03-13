package _OOP_develop_gradle;

import java.util.List;
import java.util.ArrayList;

import _OOP_develop_gradle.model.Professor;
import _OOP_develop_gradle.model.Student;

public class GamePlayModel {

	    private int matchScore; // Punteggio partita
	    private int timeTot; // Tempo di gioco
	    private List<Student> studentList; // Lista di studenti presenti
	    private List<Tutor> tutorList; // Lista di tutor presenti
	    private List<NormalProfessor> normalProfList; // Lista di normal p presenti
	    private List<Rector> rectorList; // Lista di rector presenti
	    private List<Bullet> bulletListNormal;
	    private List<Bullet> bulletListDiagonal;
	    
	    public GamePlayModel() {
	        this.matchScore = 0;
	        this.timeTot = 0;
	        this.studentList = new ArrayList<>();
	        this.tutorList = new ArrayList<>();
	        this.normalProfList = new ArrayList<>();
	        this.rectorList = new ArrayList<>();
	        this.bulletListNormal = new ArrayList<>();
	        this.bulletListDiagonal = new ArrayList<>();
	    }

		public List<Bullet> getBulletListNormal() {
			return bulletListNormal;
		}


		public void setBulletListNormal(List<Bullet> bulletListNormal) {
			this.bulletListNormal = bulletListNormal;
		}

		public List<Bullet> getBulletListDiagonal() {
			return bulletListDiagonal;
		}

		public void setBulletListDiagonal(List<Bullet> bulletListDiagonal) {
			this.bulletListDiagonal = bulletListDiagonal;
		}

		public int getMatchScore() {
			return matchScore;
		}

		public void setMatchScore(int matchScore) {
			this.matchScore = matchScore;
		}

		public int getTimeTot() {
	        return timeTot;
	    }

	    public void setTimeTot(int time) {
	    	timeTot=time;
	    }
	    
	    public List<Student> getStudentList() {
	        return this.studentList;
	    }


	    public void generateWave(int waveSize) {
	        // Creare una nuova ondata di studenti
	        for (int i = 0; i < waveSize; i++) {
	            generateNewStudent();
	        }
	    	
	    }

	   public List<Tutor> getTutorList() {
			return tutorList;
		}

		public void setTutorList(List<Tutor> tutorList) {
			this.tutorList = tutorList;
		}

		public List<NormalProfessor> getNormalProfList() {
			return normalProfList;
		}

		public void setNormalProfList(List<NormalProfessor> normalProfList) {
			this.normalProfList = normalProfList;
		}

		public List<Rector> getRectorList() {
			return rectorList;
		}

		public void setRectorList(List<Rector> rectorList) {
			this.rectorList = rectorList;
		}

		public void setStudentList(List<Student> studentList) {
			this.studentList = studentList;
		}

		public Tutor generateNewTutor(Elements<Integer, Integer> position) {
			Tutor newTutor = new Tutor(position.getX(), position.getY());
    		tutorList.add(newTutor);
    		return newTutor;
	    }
		
		public NormalProfessor generateNewNormalP(int damage, double healthPoints, Elements<Integer, Integer> position, String pathImg, int costProfessor, int idProf) {
			NormalProfessor newnormalProf = new NormalProfessor(position.getX(), position.getY());
			normalProfList.add(newnormalProf);
    		return newnormalProf;
	    }
		
		public Rector generateNewRector(Elements<Integer, Integer> position ) {
			Rector newRector = new Rector(position.getX(), position.getY());
    		rectorList.add(newRector);
    		return newRector;
	    }

	    public void generateNewStudent() {
	    	Student student = new Student();
	    	this.studentList.add(student);
	    }

	    public void increaseMatchScore(int amount) {
	    	matchScore += amount;
	    }

	    public boolean decreaseMatchScore(int amount) {
	        if (matchScore >= amount) {
	        	matchScore -= amount;
	        	return true;
	        } 
	        return false;
	    }
	    
	    public void increaseTimeTot(double amount) {
	    	timeTot += amount;
	    }

	    public boolean decreaseTimeTot(double amount) {
	        if (timeTot >= amount) {
	        	timeTot -= amount;
	        	return true;
	        } 
	        return false;
	    }
}
