
public class Greedy {
	private Player[] result;
	private boolean[] slot;
	

	public Player[] getResult() {
		return result;
	}

	public boolean[] getSlot() {
		return slot;
	}

	

	public Greedy(int n) {
		this.result = new Player[n];
		this.slot = new boolean[n];

		for (int i = 0; i < n; i++) // Initialize all slots to be free
			slot[i] = false;
	}

	public void run(Player[] players, int x, int n, int k) { // x: max budget |n: first n position |k: first k players.
		
		long startTime = System.nanoTime();
		
		int totalCost = 0;
		int totalRating = 0;
		for (int i = 0; i < n * k; i++) { // n*k #players
			if (!slot[players[i].getPosition() - 1]) { // farklý pozisyonlarda oyuncu almak için
				if ((totalCost += players[i].getPrice()) >= x) { // run out of budget
					totalCost -= players[i].getPrice();
					continue;
				}

				result[players[i].getPosition() - 1] = players[i];
				slot[players[i].getPosition() - 1] = true;
				totalRating = totalRating + players[i].getRating();

			}
		}
		double estimatedTime = System.nanoTime() - startTime;
		estimatedTime = estimatedTime / 1000;
		
		for (int i = 0; i < result.length; i++) {
			if (slot[i])
				System.out.println(result[i].toString());
		}
		System.out.println("The maximum value of Rating is: "+ totalRating);
		System.out.println("total money spent :" + totalCost);
		System.out.println("Estimated Time: "+ estimatedTime);
	}
}
