package group5.viope2014;

public class ChaseBehaviour implements ArtificialIntelligence{
	
	public int intMove(int x, int y){
		int dir=4;
		if(x > Maze.pcX){
			dir = choseDirection.Move_Up;
		}
		else if(x < Maze.pcX){
			dir = choseDirection.Move_Down;
		}
		else if(y > Maze.pcY){
			dir = choseDirection.Move_Left;
		}
		else if(y < Maze.pcY){
			dir = choseDirection.Move_Right;
		}
		return dir;
	}
}
