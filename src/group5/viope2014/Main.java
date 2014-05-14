package group5.viope2014;

public class Main
{
/*    public static void main(String[] args)
    {
        int column,row,pillDuration,score,nLife;
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.print("Insert the path: ");
            BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));
            String s=br.readLine();
            if(s==null)
            {
                System.out.println("No initial configuration file");
                System.exit(-1);
            }
            String splitted[]=s.split("\\|");
            if(splitted.length!=5)
            {
                System.out.println("Wrong structure of the configuration file");
                System.exit(-1);
            }
            column = Integer.parseInt(splitted[0]);
            row = Integer.parseInt(splitted[1]);
            pillDuration = Integer.parseInt(splitted[2]);
            score = Integer.parseInt(splitted[3]);
            nLife = Integer.parseInt(splitted[4]);
            while((s=br.readLine())!=null)
            {

            }
        }
        catch(FileNotFoundException e)
        {System.out.println(e.getMessage());}
        catch (IOException e)
        {System.out.println(e.getMessage());}
    }
  */
    public static void main(String[] args) {
    	Maze field = new Maze("filename.txt");
    	field.reload();
    	field.printMaze();
    	System.exit(0);
    }

}
