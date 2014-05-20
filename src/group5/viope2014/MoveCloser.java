package group5.viope2014;

public class MoveCloser implements ArtificialIntelligence{
	
	public int intMove(int x, int y){
		int xD = Maze.eX - Maze.pcX;
		int yD = Maze.eY - Maze.pcY;
		int dir=-1;
		if(xD > 0){
			dir = choseDirection.Move_Left;
		}
		else if(xD < 0){
			dir = choseDirection.Move_Right;
		}
		else if(yD > 0){
			dir = choseDirection.Move_Up;
		}
		else if(yD < 0){
			dir = choseDirection.Move_Down;
		}
		return dir;
	}
}
