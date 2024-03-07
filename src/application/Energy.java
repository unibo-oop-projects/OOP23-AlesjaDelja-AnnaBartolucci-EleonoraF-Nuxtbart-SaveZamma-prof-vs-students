import java.util.Timer;
import java.util.TimerTask;

interface Energy {
    void incrementaConPassareDelTempo();
}

class EnergiaImplementazione implements Energy {
    private int livelloEnergia;

    public EnergiaImplementazione() {
        this.livelloEnergia = 0;
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
    
    //TO-DO metodo che fa incrementare l'energia in game avanzato quando i prof uccidono gli studenti
    public void increase() {
    	this.livelloEnergia = this.livelloEnergia + 10;
    }
    //TO-DO metodo che fa diminuire l'energia in game avanzato quando gli studenti uccidono i prof
    public void decrease() {
    	this.livelloEnergia = this.livelloEnergia - 10;
    }
    //TO-DO metodo che fa diminuire l'enrgia a seconda dei diversi spawn dei prof
    public void profDecrease(int livel) {
    	this.livelloEnergia = this.livelloEnergia - livel;
    }
}