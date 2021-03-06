// CSE 373 Homework 6: The Rotating Dead
// YOU DO NOT NEED TO MODIFY THIS INSTRUCTOR-PROVIDED FILE.
// Your code should work properly with an unmodified version of this file.

import java.util.Collection;
import java.util.Set;

/**
 * Interface Map represents an abstract data type (ADT) for a map storing
 * a collection of key-value pairs.
 * A map allows efficient insertion, removal, and lookup of pairs by keys.
 * 
 * Classes implementing Map are generally expected to provide the core
 * operations of put, containsKey, and remove in O(1) or O(log N) average runtime.
 */
public interface Map<K, V> {
	/** @see Homework spec for details */
	void clear();

	/** @see Homework spec for details */
	boolean containsKey(K key);

	/** @see Homework spec for details */
	V get(K key);
	
	/** @see Homework spec for details */
	boolean isEmpty();
	
	/** @see Homework spec for details */
	Set<K> keySet();
	
	/** @see Homework spec for details */
	void put(K key, V value);
	
	/** @see Homework spec for details */
	void remove(K key);
	
	/** @see Homework spec for details */
	int size();
	
	/** @see Homework spec for details */
	String toString();
	
	/** @see Homework spec for details */
	Collection<V> values();
}
