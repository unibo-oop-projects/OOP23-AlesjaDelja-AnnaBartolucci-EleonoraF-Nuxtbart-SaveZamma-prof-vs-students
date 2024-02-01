package application;

import Game.GamePlay;
import Zombie.Zombie;

import javax.swing.*;
import java.util.Iterator;

public class Chomper extends Professor{

	public enum State {
        READY, DIGEST
    }
    State state;
    Timer biteTimer;
    Timer resetTimer;

    //构造方法
    public Chomper(GamePlay gamePlay){
        super(98,110,150,gamePlay);
        state = State.READY;
        life = 10;
        px = - 1;
        py = -25;
        plantImage = new ImageIcon(this.getClass().getResource("/Image/PlantImage/Chomper.gif")).getImage();
        biteTimer = new Timer(50,(ActionEvent)-> bite());
        biteTimer.start();
        resetTimer = new Timer(30000,(ActionEvent) -> reset());
    }

    //大嘴花吃僵尸
    public void bite() {
        if (state == State.READY) {
            //遍历僵尸对象
            Iterator zombiesIterator = gamePlay.getZombieController().getZombieArrayList((this.getY() - 90) / 100 + 1).iterator();
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
                    this.setSize(76,80);
                    plantImage = new ImageIcon(this.getClass().getResource("/Image/PlantImage/ChomperDigest.gif")).getImage();
                    this.repaint();
                    state = State.DIGEST;
                    biteTimer.stop();
                    resetTimer.start();
                }
            }
        }
    }

    public void reset(){
        px = - 1;
        py = -25;
        this.setSize(98,91);
        plantImage = new ImageIcon(this.getClass().getResource("/Image/PlantImage/Chomper.gif")).getImage();//图片还原
        this.repaint();
        state = State.READY;
        resetTimer.stop();
        biteTimer.start();
    }

    //计时器关闭
    public void timerStop(){
        biteTimer.stop();
        resetTimer.stop();
    }
}
