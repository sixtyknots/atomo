package com.sixtyknots.atomo.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for manipulating collections.
 *
 * @author Miroslav Plese
 */
public class CollectionsUtils {

    /**
     * Instantiation is not permitted.
     */
	protected CollectionsUtils() { }

	/**
	 * Returns union of two collections.
	 *
	 * @param <T> the generic type
	 * @param coll1 the coll1
	 * @param coll2 the coll2
	 * @return the collection
	 */
	public static <T> Collection<T> union(Collection<T> coll1, Collection<T> coll2) {
	    Set<T> union = new HashSet<T>(coll1);
	    union.addAll(new HashSet<T>(coll2));
	    
	    return union;
	}

	/**
	 * Returns intersection of two collections.
	 *
	 * @param <T> the generic type
	 * @param coll1 the coll1
	 * @param coll2 the coll2
	 * @return the collection
	 */
	public static <T> Collection<T> intersect(Collection<T> coll1, Collection<T> coll2) {
	    Set<T> intersection = new HashSet<T>(coll1);
	    intersection.retainAll(new HashSet<T>(coll2));
	    
	    return intersection;
	}

	/**
	 * Returns non-overlapping elements of two collections.
	 *
	 * @param <T> the generic type
	 * @param coll1 the coll1
	 * @param coll2 the coll2
	 * @return the collection
	 */
	public static <T> Collection<T> nonOverLap(Collection<T> coll1, Collection<T> coll2) {
		Collection<T> result = union(coll1, coll2);
	   result.removeAll(intersect(coll1, coll2));
	   
	   return result;
	}
}
