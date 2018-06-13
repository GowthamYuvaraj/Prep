import java.util.Scanner;
public class AutoFuelingRobot {
	int noc,arr[],maxi;
	boolean visited[];
	public void solve()
	{
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		for(int tc=1;tc<=testcase;tc++)
		{
			noc=sc.nextInt();
			arr=new int[noc+2];
			visited=new boolean[noc+2];
			arr[0]=3;visited[0]=true;
			for(int i=1;i<noc+1;i++)
			{
				arr[i]=sc.nextInt();
				visited[i]=false;
			}
			arr[noc+1]=4;
			visited[noc+1]=true;
			maxi=Integer.MAX_VALUE;
			func(0,0,2,0,0);
			System.out.println("#"+tc+" "+maxi);
		}
	}
	public void func(int dist_covered,int index,int gasoline,int petrol,int cars_filled)
	{
		if(dist_covered<maxi)
		{
			if(cars_filled==noc)
			{
				visited[index]=false;
				maxi=dist_covered;
				return;
			}
			for(int i=0;i<noc+2;i++)
			{
				if(!visited[i]){
				if(gasoline>0&&arr[i]==1)
				{
					visited[i]=true;
					func(dist_covered+absol(i,index),i,gasoline-1,petrol,cars_filled+1);
					visited[i]=false;
				}
				if(i==0&&index!=noc+1)
				{
					func(dist_covered+absol(i,index),i,2,0,cars_filled);
				}
				if(petrol>0&&arr[i]==2)
				{
					visited[i]=true;
					func(dist_covered+absol(i,index),i,gasoline,petrol-1,cars_filled+1);
					visited[i]=false;
				}
				if(i==noc+1)
				{
					func(dist_covered+absol(i,index),i,0,2,cars_filled);
				}}
			}
		}
	}
	public int absol(int a,int b)
	{
		return a>b?a-b:b-a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoFuelingRobot obj=new AutoFuelingRobot();
		obj.solve();
	}

}
