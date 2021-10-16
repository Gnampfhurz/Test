package a1sew2021;
import java.util.ArrayList;


public class Test {
	
	public static void main(String[] args) {
		Minesweeper mine = new Minesweeper();
		mine.setMinefield(".\n.\n");
		System.out.println(mine.field.isField());
		System.out.println(mine.field.field.toString());
		//System.out.println(mine.getHintAt(1, 1));
		//System.out.println(mine.getNumberOfBombs());
		//System.out.println(mine.clickOn(0, 1));
		//System.out.println(mine.clickOn(0, 0));
		//System.out.println(mine.field.field.toString());
		//System.out.println(mine.field.isField());
		//System.out.println(mine.isVisible(0, 0));
	}
}
