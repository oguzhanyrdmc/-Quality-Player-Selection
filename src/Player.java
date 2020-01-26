
public class Player {

	private String name;
	private int position;
	private int rating;
	private int price;
	private int  value;

	public Player(String name, int position, int rating, int price) {
		this.name = name;
		this.position = position;
		this.rating = rating;
		this.price = price;
		this.value = price / rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + name + "]\t[position: " + position + "]\t[rating: " + rating + "]\t[price: " + price + "]";
	}

}
