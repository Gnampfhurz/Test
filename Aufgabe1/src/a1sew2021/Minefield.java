package a1sew2021;

import java.util.ArrayList;

import javax.xml.datatype.DatatypeConstants.Field;

public class Minefield {

	public ArrayList<ArrayList<Cell>> field = new ArrayList<>();
	public String fieldInString;

	public Minefield(String s) {
		this.field = setField(s);
		fieldInString = s;
	}

	public ArrayList<ArrayList<Cell>> setField(String s) {
		String[] str = s.split("\n");
		ArrayList<ArrayList<Cell>> field = new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			field.add(new ArrayList<Cell>());
			for (int j = 0; j < str[i].length(); j++) {
				if (str[i].charAt(j) == '.')
					field.get(i).add(new Cell());
				else
					field.get(i).add(new Bombcell());
			}
		}
		setHint(field, addPadding(field));
		return field;
	}

	public boolean isField() {
		String[] str = fieldInString.split("\n");
		int n = str[0].length();
		for (String st : str) {
			if (n != st.length()) {
				return false;
			}
			n = st.length();
			for (char c : st.toCharArray()) {
				if (c != '.' && c != '*') {
					return false;
				}
			}
		}
		if (n < str.length) {
			return false;
		}
		return true;
	}

	public int bombAmount() {
		int n = 0;
		if (field.size() > 0) {
			for (int i = 0; i < field.size(); i++) {
				for (int j = 0; j < field.size(); j++) {
					if (field.get(i).get(j) instanceof Bombcell) {
						n++;
					}
				}
			}
			return n;
		} else
			return -1;
	}

	public int getLength() {
		if (field.size() > 0)
			return field.size();
		return -1;
	}

	public Cell getCell(int row, int col) {
		return field.get(row).get(col);
	}

	private ArrayList<ArrayList<Cell>> addPadding(ArrayList<ArrayList<Cell>> field) {
		ArrayList<ArrayList<Cell>> help = new ArrayList<>(field.size() + 2);
		for (ArrayList<Cell> c : field) {
			ArrayList<Cell> helpAL = new ArrayList<>();
			helpAL.add(new Cell());
			helpAL.addAll(c);
			helpAL.add(new Cell());
			help.add(helpAL);
		}
		return help;
	}

	private ArrayList<Cell> addPaddingCol(int size) {
		ArrayList<Cell> arrayList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			arrayList.add(new Cell());
		}
		return arrayList;
	}

	public void setHint(ArrayList<ArrayList<Cell>> field, ArrayList<ArrayList<Cell>> help) {
		int hint = 0;
		
		for (int i = 1; i <= field.size(); i++) {
			for (int j = 1; j <= field.get(i).size(); j++) {
				if (help.get(i).get(j) instanceof Bombcell) {
					field.get(i - 1).get(j - 1).setHint(-1);
					;
				} else {
					for (int a = i - 1; a <= i + 1; a++) {
						for (int b = j - 1; b <= j + 1; b++) {
							if (help.get(a).get(b) instanceof Bombcell) {
								hint++;
							}
						}
					}
					field.get(i - 1).get(j - 1).setHint(hint);
					hint = 0;
				}
			}
		}
	}

}