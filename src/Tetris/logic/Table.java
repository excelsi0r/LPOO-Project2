package Tetris.logic;

public class Table {
	
	private char table[][] = {
			{'@','@','@','@','@','@','@','@','@','@','@','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','@'},
			{'@','@','@','@','@','@','@','@','@','@','@','@'},};
	
	
	public Table(){}

	/**
	 * @param table
	 */
	public Table(char[][] table) {
		super();
		this.table = table;
	}
	
	public Table(Table table) {
		this.table = getTable();
	}
	
	/**
	 * @return the table
	 */
	public char[][] getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(char[][] table) {
		this.table = table;
	}

	/**
	 * @Override toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < table.length; y++) {
			for (int x = 0; x < table[0].length; x++) {
				sb.append(table[y][x] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * @Override clone()
	 */
	public Table clone(){
		return new Table(this);
	}

}
