package Practice;

import java.util.Scanner;

class Umpire
{
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	int prize=1500;
	void collectFromGuesser()
	{
		Guesser obj1=new Guesser();
		numFromGuesser=obj1.guessNum();
	
	}
	void collectFromPlayer()
	{
		Player play1=new Player();
		Player play2=new Player();
		Player play3=new Player();
		
                                                    
		numFromPlayer1=play1.guessNumPlayer();
		numFromPlayer2=play2.guessNumPlayer();
		numFromPlayer3=play3.guessNumPlayer();
	}
	void compare()
	{
		if(numFromGuesser==numFromPlayer1)
		{
			if(numFromPlayer1==numFromPlayer2 &&numFromPlayer1==numFromPlayer3 )
			{
				prize/=3;
				System.out.println("All Players won the game");
				System.out.println("Each player won the prize amount of rupees "+prize );
			}
			else if(numFromPlayer1==numFromPlayer2)
			{
				prize/=2;
				System.out.println("Player1 and player2 won the game");
				System.out.println("Each player won the prize amount of rupees "+prize );
			}
			else if(numFromPlayer1==numFromPlayer3)
			{
				prize/=2;
				System.out.println("Player1 and player3 won the game");
				System.out.println("Each player won the prize amount of rupees "+prize );
			}
			else
			{
			System.out.println("Player1 Won the game with the prize amount of rupees "+prize);
			}
		}
		else if(numFromGuesser==numFromPlayer2)
		{
			if(numFromPlayer2==numFromPlayer3)
			{
				prize/=2;
				System.out.println("Player2 and player3 won the game");
				System.out.println("Each player won the prize amount of rupees "+prize );
			}
			else
			{
			System.out.println("Player2 Won the game with the prize amount of rupees "+prize);
			}
		}
		else if(numFromGuesser==numFromPlayer3)
		{
			System.out.println("Player3 Won the game with the prize amount of rupees "+prize);
		}
		
		else
			System.out.println("No one won the game");
	}
}
class Guesser
{
	int guessNum;
	int guessNum()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Guesser, Guess the number within the range of 1 to 20 ");
		guessNum=s.nextInt();
		while(guessNum<0 || guessNum>20)
		{
			System.out.println("Again please guess the number between only within the range of 1to 20");
			guessNum=s.nextInt();
		}
		
		return guessNum;
	}
}
class Player
{
	int guessNum;
	int guessNumPlayer()
	{
	    Scanner scan =new Scanner(System.in);
	    System.out.println("Player guess the number within the range of 1 to 20 ");
	    guessNum=scan.nextInt();
	    while(guessNum<0 || guessNum>20)
	    {
	    	System.out.println("Again please guess the number between only within the range of 1to 20");
	    	guessNum=scan.nextInt();
	    }
	   
	    return guessNum;
	    
	}
}
public class GuesserGame 
{
    public static void main(String[] args)
    {
    	System.out.println("                           WELOCOME TO THE GUESSER GAME                 ");
    	System.out.println("                      RULES AND REGULATIONS OF GUESSER GAME                         ");
    	System.out.println("1. One Guesser and three players are allowed to play the game ");
    	System.out.println("2. Winners would have prized by 1500 rupees ");
    	System.out.println();
    	System.out.println();
    	Scanner scan =new Scanner(System.in);
        System.out.println("Enter the option");
        System.out.println("1.Play Game ");
        System.out.println("2.Exit ");
        int choice=scan.nextInt();
        while(choice==1)
        {
        if(choice==1)
        {
		Umpire obj=new Umpire();
		obj.collectFromGuesser();
		obj.collectFromPlayer();
		obj.compare();	
        }
        else
        	return;
        System.out.println();
        System.out.println("If yu want to Play again     click 1");
        System.out.println("If yu want to Exit the game  click 2");
        
        choice=scan.nextInt();
        }  
	}

}
