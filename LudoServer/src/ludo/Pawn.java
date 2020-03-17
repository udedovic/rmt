package ludo;

public class Pawn {

	private String naziv;
	private Color color;
	private int index;
	
	
	public Pawn(String naziv, Color color, int index) {
		super();
		this.naziv = naziv;
		this.color = color;
		this.index = index;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
