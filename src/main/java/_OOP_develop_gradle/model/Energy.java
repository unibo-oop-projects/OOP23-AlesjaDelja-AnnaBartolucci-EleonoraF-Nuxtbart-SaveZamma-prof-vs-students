package _OOP_develop_gradle.model;

import java.util.Timer;
import java.util.TimerTask;

interface Energy {
    void incrementaConPassareDelTempo();
}

class EnergiaImplementazione implements Energy {
    private int livelloEnergia;
    private int DEFAULT_ENERGY = 10;

    public EnergiaImplementazione() {
    	//The energy is init to 100
        this.livelloEnergia = 100;
        avviaIncrementoPeriodico();
    }

    @Override
    public void incrementaConPassareDelTempo() {
        livelloEnergia++;
        System.out.println("Livello di energia incrementato a " + livelloEnergia);
    }
    
    //incremento dell'enegia ogni minuto che passa
    private void avviaIncrementoPeriodico() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                incrementaConPassareDelTempo();
            }
        }, 0, 60000); // 60000 millisecondi = 1 minuto
    }
    
    /**
     * Increses the energy by the deafult value when a student is killed.
     */
    public void increase() {
    	this.livelloEnergia = this.livelloEnergia + DEFAULT_ENERGY;
    }
    /**
     * Decreases the energy by the deafult value when a prof is killed.
     */
    public void decrease() {
    	this.livelloEnergia = this.livelloEnergia - DEFAULT_ENERGY;
    }
    /**
     * Decreases the energy by the papameter 'livel' when a prof is spawned.
     * @param livel Value of needed energy that will be decreased
     */
    public void profDecrease(int livel) {
    	this.livelloEnergia = this.livelloEnergia - livel;
    }
}