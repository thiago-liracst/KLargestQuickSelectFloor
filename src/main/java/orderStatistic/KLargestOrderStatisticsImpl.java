package orderStatistic;

import static util.Util.swap;

import java.io.ObjectInputStream.GetField;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */

public class KLargestOrderStatisticsImpl<Integer extends Comparable<Integer>> implements KLargest<Integer>{
	
	@Override
	public Integer[] getKLargest(Integer[] array, int k) {
		Integer[] result = null;

		if (isValid(array, k)) {

			Integer[] newArray = (Integer[]) new Comparable[k];

			int indexNewArray = 0;

			Integer orderStatistic = orderStatistics(array, k);

			if (orderStatistic!=null) {

				for (int i = k; i< array.length-1; i++) {

					if (array[i].compareTo(orderStatistic)>0) {

						newArray[indexNewArray] = array[i];
						indexNewArray++;
					}
				}

				result = newArray;
			}

		}

		return result;
		//este metodo deve obrigatoriamente usar o orderStatistics abaixo.
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public Integer orderStatistics(Integer[] array, int k){
		Integer result = null;

		selectionSort(array, 0, array.length-1);

		result = array[k-1];

		return result;
	}

	public void selectionSort(Integer[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i<=rightIndex; i++) {

			int minorIndex = i;

			for (int j = i+1; j<=rightIndex; j++) {

				if (array[j].compareTo(array[minorIndex])<0) {

					minorIndex = j;
				}
			}

			swap(array, i, minorIndex);
		}
	}

	private boolean isValid(Integer[] array, int k) {
		boolean result = true;

		if (array.length<1 || array==null) {
			result = false;
		} else if (k<1 || k> array.length) {
			result = false;
		}

		return result;
	}
	
}
