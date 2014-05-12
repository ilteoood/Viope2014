package group5.viope2014;

public class Enemy extends MobileElement {

  public Enemy()
  {
      /// Enemy class constructor. Not really needed but needs to be here because other classes extend it..
  }

// Created class for each enemy since we can't use behaviour as a parameter for Enemy constructor. Original implementation can be found below..

    public class Blinky extends Enemy{

        public Blinky (int x, int y, Behaviour b, char name)
        {
            this.bev = b;
            this.name = name;
        }

    }

    public class Clyde extends Enemy {


        public Clyde(int x, int y, Behaviour b, char name) {
            this.bev = b;
            this.name = name;
        }
    }

    public class Inky extends Enemy {
        public Inky (int x, int y, Behaviour b, char name)
        {
            this.bev = b;
            this.name = name;
        }
    }
    public class Pinky extends Enemy{
        public Pinky (int x, int y, Behaviour b, char name)
        {

            this.bev = b;
            this.name = name;
        }
    }
}

/*
Original Enemy-class implementation:

public class Enemy extends MobileElement {

  public Enemy(char name, Behaviour b)
  {
  this.name = name;
  this.bev = b;

  }

 */