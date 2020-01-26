
public class QuickSort {

	public void swap(Player[] array, int a, int b) {
		Player temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public int partition(Player[] array, int head, int rear) {
		Player pivot = array[head];// pivot
		int i = head;
		for (int j = head + 1; j <= rear; j++) {
			if (array[j].getValue() < pivot.getValue()) { // pivottan küçükler için swap
				i++;
				swap(array, i, j);
			}
			else if (array[j].getValue() == pivot.getValue()) { // pivot ile ayný deðerler için swap
				if(array[j].getPrice() >= pivot.getPrice())		{ //eþit price için max rating
					i++;
					swap(array, i, j);					
				}
			}
		}
		swap(array, i, head);// pivot swap
		return i;
	}

	public void buildQuickSort(Player[] array, int head, int rear) {

		if (head < rear) {
			int p = partition(array, head, rear);
			buildQuickSort(array, head, p - 1);
			buildQuickSort(array, p + 1, rear);

		}
	}

	public void sort(Player[] array) {
		int n = array.length; // arrayde kaç elemanýn dolu olduðu
		buildQuickSort(array, 0, n - 1);
	}
}
