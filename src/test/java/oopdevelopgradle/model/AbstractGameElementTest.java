package oopdevelopgradle.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AbstractGameElementTest {
    private final AbstractGameElement gameElement = new ConcreteGameElement(10, new Elements<>(0, 0));
    private static final int NEW_DAMAGE = 20;
    private static final int OLD_DAMAGE = 10;
    private static final int X = 20;
    private static final int Y = 20;
    @Test
    void testGetPosition() {
        assertEquals(new Elements<>(0, 0), gameElement.getPosition());
    }

    @Test
    void testSetPosition() {
        gameElement.setPosition(new Elements<>(Y, X));
        assertEquals(new Elements<>(Y, X), gameElement.getPosition());
    }

    @Test
    void testGetDamage() {
        assertEquals(OLD_DAMAGE, gameElement.getDamage());
    }

    @Test
    void testSetDamage() {
        gameElement.setDamage(NEW_DAMAGE);
        assertEquals(NEW_DAMAGE, gameElement.getDamage());
    }

    private static class ConcreteGameElement extends AbstractGameElement {
        ConcreteGameElement(final int damage, final Elements<Integer, Integer> position) {
            super(damage, position);
        }
    }
}
