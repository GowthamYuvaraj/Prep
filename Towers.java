import java.util.Scanner;
public class Towers {
	int count=0,cost=0,maxi=Integer.MIN_VALUE,sum=0;
	public void solve()
	{
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int Tc=1;Tc<=tc;Tc++)
		{
			int r=sc.nextInt();
			int c=sc.nextInt();
			int arr[][]=new int[r*2][c];
			int row=0;
			for(int i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{
					if(j%2==0)
					{
						arr[row][j]=sc.nextInt();
					}
					else
					{
						arr[row+1][j]=sc.nextInt();
					}
				}
				row+=2;
			}
			for(int i=0;i<r*2;i++)
			{
				for(int j=0;j<c;j++)
				{
					if(arr[i][j]!=0)
					{
						checkNeighbours(i,j,arr,new int[6],r,c);
						findMax(i,j,arr,new boolean[r*2][c],0,0,r,c);
					}
				}
			}
			System.out.println("#"+Tc+" "+maxi*maxi);
		}
	}
	public void checkNeighbours(int i,int j,int[][] arr,int[] ar,int r,int c)
	{
		sum=arr[i][j];
		int index=0;
		if(isSafe(i-1,j-1,r,c))
		{
			ar[index++]=arr[i-1][j-1];
		}
		if(isSafe(i-1,j+1,r,c))
		{
			ar[index++]=arr[i-1][j+1];
		}
		if(isSafe(i+1,j-1,r,c))
		{
			ar[index++]=arr[i+1][j-1];
		}
		if(isSafe(i+1,j+1,r,c))
		{
			ar[index++]=arr[i+1][j+1];
		}
		if(isSafe(i-2,j,r,c))
		{
			ar[index++]=arr[i-2][j];
		}
		if(isSafe(i+2,j-1,r,c))
		{
			ar[index++]=arr[i+2][j];
		}
		for(int ii=0;ii<5;ii++)
		{
			for(int jj=ii+1;jj<6;jj++)
			{
				if(ar[ii]>ar[jj])
				{
					int temp=ar[ii];
					ar[ii]=ar[jj];
					ar[jj]=temp;
				}
			}
		}
		sum=sum+ar[3]+ar[4]+ar[5];
		if(sum>maxi)
			maxi=sum;
	}
	public boolean isSafe(int i,int j,int r,int c)
	{
		if(i>=0&&j>=0&&i<r*2&&j<c)
			return true;
		return false;
	}
	public void findMax(int i,int j,int[][] arr,boolean[][] visited,int count,int cost,int r,int c)
	{
		visited[i][j]=true;
		count++;
		cost+=arr[i][j];
		if(count==4)
		{
			if(cost>maxi)
				maxi=cost;
		}
		else
		{
			if(isSafe(i-1,j-1,r,c)&&!visited[i-1][j-1])
			{
				findMax(i-1,j-1,arr,visited,count,cost,r,c);
			}
			if(isSafe(i-1,j+1,r,c)&&!visited[i-1][j+1])
			{
				findMax(i-1,j+1,arr,visited,count,cost,r,c);
			}
			if(isSafe(i+1,j-1,r,c)&&!visited[i+1][j-1])
			{
				findMax(i+1,j-1,arr,visited,count,cost,r,c);
			}
			if(isSafe(i+1,j+1,r,c)&&!visited[i+1][j+1])
			{
				findMax(i+1,j+1,arr,visited,count,cost,r,c);
			}
			if(isSafe(i-2,j,r,c)&&!visited[i-2][j])
			{
				findMax(i-2,j,arr,visited,count,cost,r,c);
			}
			if(isSafe(i+2,j,r,c)&&!visited[i+2][j])
			{
				findMax(i+2,j,arr,visited,count,cost,r,c);
			}
		}
		visited[i][j]=false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Towers obj=new Towers();
		obj.solve();
	}
}