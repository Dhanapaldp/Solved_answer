package Exception;

import java.util.ArrayList;
import java.util.Scanner;

class NotMatchingException extends Exception
{
	public NotMatchingException()
	{
		System.out.println("Exception Occurs");
	}
}
abstract class Server
{
	public int uid=54321;
	public int upw=12345;
	public int id;
	public int pw;
	public double amount;
	static double bankBalance=200000;
	Scanner s=new Scanner(System.in);
	void input()
	{
		System.out.println("Enter the UserID");
		id=s.nextInt();
		System.out.println("Enter the PassWord");
		pw=s.nextInt();
	}
	abstract void verify() throws Exception;
	
}
class Deposit extends Server
{
	void verify() throws Exception, NotMatchingException
	{
		if(uid==id && upw==pw)
		{
			System.out.println("Enter the amount to be deposited");
			amount=s.nextDouble();
			System.out.println("Place the amount in our Drawyer");
			System.out.println("Loading........");
			Thread.sleep(4000);
			System.out.println("Your amount has been Deposited successfully ");
			Balance.afterDeposit(amount);
			System.out.println("Thank you");
			System.out.println("Your bank Balance is");
			System.out.println(bankBalance);
		}
		else
		{
			NotMatchingException ne=new NotMatchingException();
			throw ne;
		}
	}
}
class Withdrawl extends Server
{
	void verify() throws InterruptedException, NotMatchingException
	{
		if(uid==id && upw==pw)
		{
			System.out.println("Enter the amount to be Withdraw");
			amount=s.nextDouble();
			System.out.println("Loading........");
			Thread.sleep(4000);
			System.out.println("Your amount is Withdrawyed successfully ");
			Thread.sleep(2000);
			Balance.afterWithdraw(amount);
			System.out.println("Thank you");
			System.out.println("Your bank Balance is");
			System.out.println(bankBalance);
		}
		else
		{
			NotMatchingException ne=new NotMatchingException();
			throw ne;
		}
	}
}
class Balance extends Server
{
	
	static void afterWithdraw(double amount)
	{
		bankBalance=bankBalance-amount;
	}
	static void afterDeposit(double amount)
	{
		bankBalance=bankBalance+amount;
	}
	void verify() throws NotMatchingException
	{
		if(uid==id && upw==pw)
		{
			System.out.println("Your Bank Balance fetched Successfully");
			System.out.println(bankBalance);
		}
		else
		{
			NotMatchingException ne=new NotMatchingException();
			throw ne;
		}
	}
	
}
class Accessing 
{
	void permit(Server s) throws Exception
	{
		try
		{
			s.input();

			s.verify();
		}
		catch(InterruptedException | NotMatchingException nme)
		{
			System.out.println("Hey ,Invalid PassWord or UserID checkit out");
			try 
			{
				s.input();
				s.verify();
			} 
			catch (NotMatchingException e)
			{
				System.out.println("Again Invalid PassWord or UserID checkit out ");
				try 
				{
					s.input();
					s.verify();
				} 
				catch (NotMatchingException ae) 
				{
					System.out.println("Not anymore to access.Your Account is blocked for 24hours");
				}
				
			}
			finally
			{
				System.out.println("Contact your nearest branch for more covenience");
			}
		}
	}


	
}
public class Atm {

	public static void main(String[] args) throws Exception {
		Scanner s =new Scanner(System.in);
		System.out.println(".........................ATM Machine..................... ");
		System.out.println();
		System.out.println("1. Withdrawl");
		System.out.println("2. Deposit");
		System.out.println("3. Bank Balance");
		int choice=s.nextInt();
		if(choice==1)
		{
			Withdrawl w=new Withdrawl();
			Accessing ac =new Accessing();
			ac.permit(w);
		}
		else if(choice==2)
		{
			Deposit d =new Deposit();
			Accessing ac1 =new Accessing();
			ac1.permit(d);
		}
		else if(choice==3)
		{
			Balance b =new Balance();
			Accessing ac2 =new Accessing();
			ac2.permit(b);
		}
			
		
	}

}
