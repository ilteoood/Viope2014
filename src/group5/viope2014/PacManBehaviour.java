package group5.viope2014;

/**
 * Created by Anne on 04/04/14.
 */
public abstract class PacManBehaviour extends Behaviour {

    turnRight()
    do {
        if (cellAhead == Wall) { turnLeft(); }
        else { moveAhead(); }
    } while (isAlive and gameOngoing)


    // something like if (x,y) is position of an enemy, add points and make enemy disappear? (here or in PacMan class)

}
