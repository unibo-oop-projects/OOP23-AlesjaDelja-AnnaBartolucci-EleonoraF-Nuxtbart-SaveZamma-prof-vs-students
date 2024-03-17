package _OOP_develop_gradle.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractGameElementTest {
    private AbstractGameElement gameElement = new ConcreteGameElement(10, new Elements<>(0, 0));

    @Test
    public void testGetPosition() {
        assertEquals(new Elements<>(0, 0), gameElement.getPosition());
    }

    @Test
    public void testSetPosition() {
        gameElement.setPosition(new Elements<>(5, 5));
        assertEquals(new Elements<>(5, 5), gameElement.getPosition());
    }

    @Test
    public void testGetDamage() {
        assertEquals(10, gameElement.getDamage());
    }

    @Test
    public void testSetDamage() {
        gameElement.setDamage(20);
        assertEquals(20, gameElement.getDamage());
    }

    private static class ConcreteGameElement extends AbstractGameElement {
        public ConcreteGameElement(int damage, Elements<Integer, Integer> position) {
            super(damage, position);
        }
    }
}
