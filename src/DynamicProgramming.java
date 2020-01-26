
public class DynamicProgramming {

	public void run(Player[] players, int x, int n, int k) {// x: max budget |n: first n position |k: first k players.

		int[][] table = new int[n * k][x];
		char[][] arrow = new char[n * k][x];

		for (int i = 0; i < n * k; i++) {
			table[i][0] = 0;
			arrow[i][0] = 'U';

		}
		for (int i = 0; i < x; i++) {
			table[0][i] = 0;
			arrow[0][i] = 'U';
		}

		long startTime = System.nanoTime();
		
		int t = 0;
		for (int i = 1; i < n * k; i++) {
			if (t == k)
				t = 0;
			t++;
			for (int j = 1; j < x; j++) {
				if (players[i - 1].getPrice() <= j) {
					if (players[i - 1].getRating() + table[i - t][j - players[i - 1].getPrice()] > table[i - 1][j]) {
						// yeni deðer eski deðerden büyük mü.

						table[i][j] = players[i - 1].getRating() + table[i - t][j - players[i - 1].getPrice()];
						// en güncel sonucu yerleþtir //çapraz gelenler.
						arrow[i][j] = 'C'; // cross

					} else {
						table[i][j] = table[i - 1][j]; // yukarýdan eski sonucu al
						arrow[i][j] = 'U'; // up
					}
				} else {
					table[i][j] = table[i - 1][j];
					arrow[i][j] = 'U'; // up
				}
			}
		}

		// print DP start
		int i = n * k;
		int j = x;
		int totalCost = 0;
		while (i > 0 && j > 0) {
			if (arrow[i - 1][j - 1] == 'U') {
				i--;
			} else if (arrow[i - 1][j - 1] == 'C') {
				System.out.println(players[i - 2].toString());
				totalCost = totalCost + players[i - 2].getPrice();
				j = j - players[i - 2].getPrice();
				if (i % k != 0) {
					i = i - (i % k);
				} else {
					i = i - k;
				}
			}
		}
		// print DP end
		double estimatedTime = System.nanoTime() - startTime;
		estimatedTime = estimatedTime / 1000;

		System.out.println("The maximum value of Rating is: " + table[n * k - 1][x - 1]);
		System.out.println("total money spent :" + totalCost);
		System.out.println("Estimated Time: "+ estimatedTime);
	}
}
