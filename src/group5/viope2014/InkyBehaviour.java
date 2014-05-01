package group5.viope2014;

/**
 * Created by Anne on 04/04/14.
 */
public abstract class InkyBehaviour extends Behaviour {

    turnUp()
    do {
        if (cellAhead == Wall) { turnLeft(), turnLeft() }
        else { moveAhead() }
    } while (isAlive and gameOngoing)

}
