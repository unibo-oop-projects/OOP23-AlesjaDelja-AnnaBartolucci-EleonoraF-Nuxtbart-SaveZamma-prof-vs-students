package oopdevelopgradle.model;

/**
 * Interface representing a pair of elements.
 *
 * @param <X> The type of the first element.
 * @param <Y> The type of the second element.
 */
public interface ElementsInterface<X, Y> {
    /**
     * Returns the first element of the pair.
     * 
     * @return The first element of the pair.
     */
    X getX();

    /**
     * Returns the second element of the pair.
     * 
     * @return The second element of the pair.
     */
    Y getY();

    /**
     * Computes a hash code for this pair.
     * 
     * @return A hash code value for this pair.
     */
    @Override
    int hashCode();

    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * @param obj The reference object with which to compare.
     * @return true if this pair is the same as the obj argument; false otherwise.
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns a string representation of the pair.
     * 
     * @return A string representation of the pair.
     */
    @Override
    String toString();
}
