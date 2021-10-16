package a1sew2021;

public class Cell {

	public int hint;
	public boolean visible = false;

	public Cell() {

	}

	public void makeVisible() {
		visible = true;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setHint(int i) {
		hint = i;
	}

	public int getHint() {
		if (visible)
			return hint;
		return -1;
	}

	public String toString() {
		return "" + getHint();
	}
}
