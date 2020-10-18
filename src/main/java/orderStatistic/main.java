package orderStatistic;

import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		KLargestOrderStatisticsImpl kl = new KLargestOrderStatisticsImpl<>();
		
		Integer[] ordenadoInvertido = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] totalmenteOrdenado = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer[] igual = {1, 1, 1, 1, 1, 1, 1, 1, 1};
		Integer[] vazio = {};
		Integer[] desordenado = {25,4,15,9,48,96};
		System.out.println(Arrays.toString(kl.getKLargest(desordenado, 2)));
	}
}
