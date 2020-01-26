import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Approach {

	private Player[] playerTable = new Player[200];
	private int count = 0;
	private Player[] players;

	public void add(Player player) {
		playerTable[count] = player;
		count++;
	}

	public Player[] getPlayerTable() {
		return playerTable;
	}

	public void setPlayerTable(Player[] playerTable) {
		this.playerTable = playerTable;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public void read() {

		File file = new File("input.txt"); // input file separated by commas
		Scanner scanner;

		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split(",");

				try {
					Player player = new Player(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
							Integer.parseInt(data[3]));
					add(player);
				} catch (NumberFormatException e) {

				}
			}

			System.out.println("File reading is succesfully!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void printTable(Player[] table) {
		for (int i = 0; i < table.length; i++) {
			System.out.println(table[i].toString());
		}
	}

	public void transfer(Player[] playerTable, int n, int k) {
		this.players = new Player[n * k];
		int nTemp = 1;
		int kTemp = k; //first k player
		int j = 0;
		for (int i = 0; i < count; i++) {
			
			if (kTemp == 0 && playerTable[i].getPosition() != nTemp) { //ayný pozisyondan k tane oyuncu aldýysak
				kTemp = k;
				nTemp++;
			}	
			if (nTemp == n + 1) { //bütün pozisyonlarý aldýkysak bitir
				break;
			}
			if (kTemp != 0) {
				players[j] = playerTable[i];
				kTemp--;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		//oðuzhan yardýmcý
		Scanner scn = new Scanner(System.in);
		Approach apr = new Approach();
		QuickSort quick = new QuickSort();
		Greedy greedy = new Greedy(10);
		DynamicProgramming dp = new DynamicProgramming();
		apr.read();
		
		System.out.println("Enter the amount to spend (X):");
		int x = scn.nextInt();
		System.out.println("Enter the number of the positions (N):");
		int n = scn.nextInt();
		System.out.println("Enter the number of the available players for each position (K):");
		int k = scn.nextInt();
		apr.transfer(apr.getPlayerTable(), n, k);

		System.out.println("\nDynamic Programming Aproach");	
		dp.run(apr.getPlayers(), x+1, n, k);
		quick.sort(apr.players);
		System.out.println("\nGreedy Aproach");	
		greedy.run(apr.getPlayers(), x, n, k);
	}

}
