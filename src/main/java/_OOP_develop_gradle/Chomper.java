package application;

import Zombie.Zombie;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class Chomper extends Professor {

    public enum State {
        READY, DIGEST
    }

    private State state;
    private Timer biteTimer;
    private Timer resetTimer;

    public Chomper(Professor prof) {
        super("/Image/PlantImage/Chomper.gif", 98, prof);
        state = State.READY;
        healthPoints = 10;
        row = -1;
        column = -25;
        biteTimer = new Timer(50, (ActionEvent) -> bite());
        biteTimer.start();
        resetTimer = new Timer(30000, (ActionEvent) -> reset());
    }

    public void bite() {
        if (state == State.READY) {
            Iterator zombiesIterator = prof.getZombieController().getZombieArrayList((this.getY() - 90) / 100 + 1).iterator();
            while (zombiesIterator.hasNext()) {
                Zombie zombie = (Zombie) zombiesIterator.next();
                if ((zombie.getLabelX() - this.getX()) < 112 && (zombie.getLabelX() - this.getX()) > 0) {
                    repaint();
                    zombie.setState(Zombie.State.DEAD);
                    zombiesIterator.remove();
                    gamePlay.remove(zombie);
                    System.gc();
                    px = -5;
                    py = -30;
                    this.setSize(76, 80);
                    setPlantImage(new ImageIcon(getClass().getResource("/Image/PlantImage/ChomperDigest.gif")).getImage());
                    state = State.DIGEST;
                    biteTimer.stop();
                    resetTimer.start();
                }
            }
        }
    }

    public void reset() {
        px = -1;
        py = -25;
        setSize(98, 91);
        setPlantImage(new ImageIcon(getClass().getResource("/Image/PlantImage/Chomper.gif")).getImage());
        state = State.READY;
        resetTimer.stop();
        biteTimer.start();
    }

    public void timerStop() {
        biteTimer.stop();
        resetTimer.stop();
    }
}
