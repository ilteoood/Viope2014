package group5.viope2014;

/**
 * Created by Anne on 04/04/14.
 */
public abstract class BlinkyBehaviour extends Behaviour {

    turnLeft()
    do {
        if (cellAhead == Wall) { turnLeft() }
        else { moveAhead() }
    } while (isAlive and gameOngoing)


}
