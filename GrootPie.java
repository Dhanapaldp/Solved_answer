package Practice;

public class GrootPie {
	static void grootPie(int arr[],int result)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==result)
			{
				 System.out.println("The pie to get desired sweetness");
				System.out.println("["+i+"]");
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
			  if(arr[i]+arr[j]==result)
			  {
				  System.out.println("The two pies to get desired sweetness");
				  System.out.println("["+i+" "+j+"]");
			  }
			}
		}
		for(int i=0;i<arr.length-2;i++)
		{
			for(int j=i+1;j<arr.length-1;j++)
			{
				for(int k=j+1;k<arr.length;k++)
				{
			       if(arr[i]+arr[j]+arr[k]==result)
			       {
			    	   System.out.println("The three pies to get desired sweetness");
				      System.out.println("["+i+" "+j+" "+k+"]");
			       }
				}
			}
		}
				
	}

	public static void main(String[] args) {
		int arr[]= {8,4,3,1,2,6,5,1};
		int desiredSweetness=6;
		grootPie(arr,desiredSweetness);

	}

}
