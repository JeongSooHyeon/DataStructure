public class FindPath {
	final static int LEFT = 1000;
	final static int RIGHT = 100;
	final static int UP = 10;
	final static int DOWN = 1;
	public static void main(String[] args) {
		/*
		 * 0000 = no path 1000 = can go left 100 = can go right 10 = can go up 1 = can
		 * go down 문제를 쉽게하기 위해, 1개의 cell 에서는 한 방향으로만 이동이 가능
		 */

		int[][] map1 = { { 0, 100, 0 }, { 100, 10, 0 }, { 10, 0, 0 } };
		int[][] map2 = { { 0, 1000, 0 }, { 100, 10, 0 }, { 10, 0, 0 } };
		int nROW = 3;
		int nCOL = 3;

		int startY = 2, startX = 0;
		int finishY = 0, finishX = 2;

		if (findPath(map1, nROW, nCOL) == 1)
			System.out.println("map1 : Found a path");
		else
			System.out.println("map1 : There is no path!");

		if (findPath(map2, nROW, nCOL) == 1)
			System.out.println("map2 : Found a path!");
		else
			System.out.println("map2 : Thehre is no path!");
	}

	public static int findPath(int[][] map, int row, int col) {
		if(row == 0 && col == map[0].length-1) // 도착지점 검사
			return 1;
				
		if(row == map.length && col == map[0].length) 
			{--row; col = 0;}	
		
		if(row < 0 || col < 0)
			return 0;
		
		int value = map[row][col];
		
		switch(value) {
		case 0:
			if(!(row==0 && col==map[0].length-1))
				return 0;
			break;
		case LEFT:
			col--;
			break;
		case RIGHT:
			col++;
			break;
		case UP:
			row--;
			break;
		case DOWN:
			row++;
			break;
		}	
		
		return findPath(map, row, col);
	}
}
