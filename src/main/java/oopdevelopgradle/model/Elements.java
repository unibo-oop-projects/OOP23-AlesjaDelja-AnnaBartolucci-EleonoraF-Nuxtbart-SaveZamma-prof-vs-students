package oopdevelopgradle.model;


import java.util.Objects;

public class Elements<X, Y> implements ElementsInterface<X, Y> {
	 private final X x;
	 private final Y y;
	    /**
	     * Constructs a pair of elements.
	     * 
	     * @param x The first element.
	     * @param y The second element.
	     */
	    public Elements(final X x, final Y y) {
	        this.x = x;
	        this.y = y;
	    }
	    /**
	     * Returns the first element of the element.
	     * 
	     * @return The first element of the element.
	     */
	    @Override
	    public X getX() {
	        return this.x;
	    }
	    /**
	     * Returns the second element of the Element Object.
	     * 
	     * @return second element of elements.
	     */
	    @Override
	    public Y getY() {
	        return this.y;
	    }
	    /**
	     * Computes a hash code for this elements.
	     * 
	     * @return A hash code value for this elements.
	     */
	    @Override
	    public int hashCode() {
	        return Objects.hash(this.x, this.y);
	    }
	    /**
	     * Checks if the specified object is equal to this object.
	     * Two objects are considered equal if:
	     * <ul>
	     *     <li>They are the same reference object.</li>
	     *     <li>The specified object is not null and has the same type as this instance.</li>
	     *     <li>Both objects' {@code x} and {@code y} properties are equal.</li>
	     * </ul>
	     *
	     * @param obj the object to be compared with this instance
	     * @return {@code true} if the specified object is equal to this instance; {@code false} otherwise
	     */
	    @SuppressWarnings("rawtypes")
		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Elements other = (Elements) obj;
			if (x == null) {
				if (other.x != null) {
					return false;
				}
			} else if (!x.equals(other.x)) {
				return false;
			}
			if (y == null) {
				if (other.y != null) {
					return false;
					}
			} else if (!y.equals(other.y)) {
				return false;
			}
			return true;
		}
	    /**
	     * Returns a string representation of the element.
	     * 
	     * @return A string representation of the element.
	     */
	    @Override
	    public String toString() {
	        return "Pair [X = " + this.x + ", Y = " + this.y + "]";
	    }
}
