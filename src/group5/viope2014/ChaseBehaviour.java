package group5.viope2014;

public class ChaseBehaviour implements ArtificialIntelligence{
	
	public int intMove(int x, int y){
		int xD = x - Maze.pcX;
		int yD = y - Maze.pcY;
		int dir=-1;
		if(xD > 0){
			dir = choseDirection.Move_Up;
		}
		else if(xD < 0){
			dir = choseDirection.Move_Down;
		}
		else if(yD > 0){
			dir = choseDirection.Move_Right;
		}
		else if(yD < 0){
			dir = choseDirection.Move_Left;
		}
		return dir;
	}
}
