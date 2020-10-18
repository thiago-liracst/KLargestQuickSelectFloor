package orderStatistic;

import static util.Util.swap;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * 
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 * 
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os daods em duas partes baseado no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso redua a completixade de O(n.log n) para O(n).
	 * 
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 * 
	 * 
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento.
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 */
	
	public static Integer quickSelect(Integer[] array, int k) {
		Integer result = null;

		if (isValid(array, k)) {

			Integer index = recursiveQuickSelect(array, k, 0, array.length-1);

			if (index!=null) {
				result = array[index];
			}

		}

		return result;
	}

	private static Integer recursiveQuickSelect(Integer[] array, Integer k, int leftIndex, int rightIndex) {
		Integer result = null;
		
		int median = defineMedian(array, leftIndex, rightIndex);

		swap(array, median, leftIndex);

		int pivotIndex = partition(array, leftIndex, rightIndex);
		
			if ((k-1)!=pivotIndex) {

				if ((k-1)<pivotIndex) {
					result = recursiveQuickSelect(array, k, leftIndex, pivotIndex-1);
				} else {
					result = recursiveQuickSelect(array, k, pivotIndex+1, rightIndex);
				}
			} else {
				result = pivotIndex;
			}

		

		return result;
	}

	private static int partition(Integer[] array, int leftIndex, int rightIndex) {
		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex+1; j<=rightIndex; j++) {
			if (array[j].compareTo(pivot)<0) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, leftIndex, i);
		return i;
	}

	private static int defineMedian(Integer[] array, int leftIndex, int rightIndex) {

		int median = (leftIndex+rightIndex)/2;

		if (array[rightIndex].compareTo(array[leftIndex])<0) {
			swap(array, rightIndex, leftIndex);
		}
		if (array[rightIndex].compareTo(array[median])<0) {
			swap(array, rightIndex, median);
		}
		if (array[median].compareTo(array[leftIndex])<0) {
			swap(array, leftIndex, median);
		}


		return median;
	}

	private static boolean isValid(Integer[] array, int k) {
		boolean result = true;

		if (array.length<1) {
			result = false;
		} else if (k<1 || k> array.length-1) {
			result = false;
		}

		return result;
	}
}
