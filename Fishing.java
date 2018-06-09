import java.util.Scanner;
public class Fishing {
	public void solve()
	{
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int tc=1;tc<=test;tc++)
		{
			int gsum=Integer.MAX_VALUE;
			int n=sc.nextInt();
			int entrance[]=new int[3];
			int fm[]=new int[3];
			int order[]=new int[3];
			int leftright[]=new int[3];
			for(int i=0;i<3;i++)
			{
				entrance[i]=sc.nextInt()-1;
				fm[i]=sc.nextInt();
				//System.out.println(entrance[i]);
			}
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(i==j)
						continue;
					for(int k=0;k<3;k++)
					{
						if(i==k||j==k)
							continue;
						order[0]=i;
						order[1]=j;
						order[2]=k;
						//System.out.println("Order assigned "+i+" "+j+" "+k);
						for(int p=0;p<2;p++)
						{
							for(int q=0;q<2;q++)
							{
								for(int r=0;r<2;r++)
								{
									leftright[0]=p;
									leftright[1]=q;
									leftright[2]=r;
									//System.out.println("Left Right "+p+" "+q+" "+r);
									int sum=find(n,entrance,fm,order,leftright);
									if(sum<gsum)
										gsum=sum;
								}
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+gsum);
		}
	}
	public int find(int n,int[] entrance,int[] fm,int[] order,int[] leftright)
	{
		int sum=0;
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++)
			visited[i]=false;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(order[j]==i)
				{
					//System.out.println("Order[j] "+order[j]+" i "+i);
					if(leftright[j]==0)
					{
						sum=sum+calculateLeftFirst(n,entrance[j],fm[j],visited);
					}
					else
					{
						sum=sum+calculateRightFirst(n,entrance[j],fm[j],visited);
					}
				}
			}
		}
		return sum;
	}
	public int calculateLeftFirst(int n,int entrance,int fm,boolean[] visited)
	{
		int sum=0;
		if(visited[entrance]==false)
		{
			visited[entrance]=true;
			fm--;
			sum++;
		}
		for(int i=0;i<n;i++)
		{
			if(fm==0)
			{
				break;
			}
			int add=entrance+i;
			int sub=entrance-i;
			if(sub>=0&&visited[sub]==false)
			{
				visited[sub]=true;
				fm--;
				sum=sum+i+1;
			}
			if(add<n&&visited[add]==false)
			{
				visited[add]=true;
				fm--;
				sum=sum+i+1;
			}
		}
		return sum;
	}
	public int calculateRightFirst(int n,int entrance,int fm,boolean[] visited)
	{
		int sum=0;
		if(visited[entrance]==false)
		{
			visited[entrance]=true;
			fm--;
			sum++;
		}
		for(int i=0;i<n;i++)
		{
			if(fm==0)
			{
				break;
			}
			int add=entrance+i;
			int sub=entrance-i;
			if(add<n&&visited[add]==false)
			{
				visited[add]=true;
				fm--;
				sum=sum+i+1;
			}
			if(sub>=0&&visited[sub]==false)
			{
				visited[sub]=true;
				fm--;
				sum=sum+i+1;
			}
		}
		return sum;
	}
	public static void main(String[] args) 
	{
		Fishing fs=new Fishing();
		fs.solve();
	}
}