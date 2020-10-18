package orderStatistic;

/**
 * Returns the K largest elements of the input array
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public interface KLargest<Integer extends Comparable<Integer>> {
	
	/**
	 * Returns the K largest elements of the input array
	 * @param array input array
	 * @param k number o largest elementos to be returned
	 * @return the k largest elements of the input array
	 */
	public Integer[] getKLargest(Integer[] array, int k);

}
