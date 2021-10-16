package a1sew2021;

public class Minesweeper {
	
	public Minefield field;
 /* Empty constructor
 */
	public Minesweeper() {
		
	}

/**
 * Initializes the mine filed from given multiline string representation
 * A line represents a row of the field
 * All lines must have the same number of characters, which is the number of columns of the field
 * A character can be either '*' for a mine cell, or '.' for an empty cell
 * The number of rows must be smaller than or equal to the number of columns
 * Rows are indexed top-down with the top row index equal to zero.
 * @param s the string
 * @return true if initialization succeeds, i.e., field is valid, or false otherwise.
 */
	public boolean setMinefield(String s) {
		field = new Minefield(s);
		if(field.isField()) {
			return true;
		}
		return false;
	}
	
/**
 * 	
 * @return the number of bombs in the field, or -1 if the field is invalid
 */
	public int getNumberOfBombs() {
		return field.bombAmount();
	}
	
/**
 * Returns the hint at coordinate (row, column)
 * @param row 
 * @param col
 * @return the hint (>=0) if successful and cell has no bomb, -1 otherwise 
 */
	public int getHintAt(int row, int col) {
		return field.getCell(row, col).getHint();
	}
/**
 * Checks the visibility of a cell. 	
 * @param row
 * @param col
 * @return true if the cell (row,column) is visible, false otherwise
 */
	public boolean isVisible(int row, int col) {
		return field.getCell(row, col).getVisible();
	}
/**
 * Simulates a user click on a cell. If this is a bomb cell, all the bomb cells in the entire field become visible.
 * Otherwise only this cell becomes visible.
 * @param row
 * @param col
 * @return true if the cell has no bomb, false if it's a bomb cell
 */
	public boolean clickOn(int row, int col) {
		if(field.getCell(row, col) instanceof Bombcell) {
			clickedOnBomb();
			return false;
		}
		field.getCell(row, col).makeVisible();
		return true;
	}
/**
 * 	
 * @return the number of rows of the field
 */
	public int getHeight() {
		return field.getLength();
	}
/**
 * 	
 * @return the number of columns of the field
 */
	public int getWidth() {
		return field.getLength();
	}
	
	public void clickedOnBomb() {
		for(int i = 0; i < field.getLength(); i++) {
			for(int j = 0; j < field.getLength(); j++) {
				if(field.getCell(i, j) instanceof Bombcell) {
					field.getCell(i, j).makeVisible();
				}
			}
		}
	}
	
	/*public boolean properInput(String s) {
		String[] str = s.split("\n");
		for (String st : str) {
			if (st.length() != str.length) {
				return false;
			}
			for (char c : st.toCharArray()) {
				if (c != '.' && c != '*') {
					return false;
				}
			}
		}
		return true;
	}*/
	
}