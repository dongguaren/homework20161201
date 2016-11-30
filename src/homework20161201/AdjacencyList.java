package homework20161201;

import java.util.*;

public class AdjacencyList {
	
	static List<List<Node>> list = new LinkedList<List<Node>>();
	static int Path[][];
	
	public static int getXYValue( int x,int y )
	{
		List<Node> t=list.get(x);
		
		for( int i=0;i<t.size();i++ )
		{
			if( t.get(i).point == y )
			{
				return t.get(i).value;
			}
		}
		return Integer.MAX_VALUE/2-2;
	}
	
	public static void setXYValue( int x,int y,int v )
	{
		list.get(x).get(y).value=v;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int NumOfPoint;
		Scanner read=new Scanner(System.in);
		NumOfPoint=read.nextInt();
		
		for( int i=1;i<=NumOfPoint;i++ )
		{
			int NumOfLinkedPoint=read.nextInt();
			List<Node> OnePoint=new LinkedList <Node>();
			for( int j=1;j<=NumOfLinkedPoint;j++ )
			{
				int point=read.nextInt();
				int value=read.nextInt();
				OnePoint.add(new Node(point,value));
			}
			list.add(OnePoint);
		}
		
		Path=new int [list.size()][list.size()];
		for( int i=0;i<list.size();i++ )
		{
			for( int j=0;j<list.size();j++ )
			{
				Path[i][j]=j;
			}
		}
		
		for( int k=0;k<list.size();k++ )
		{
			for( int i=0;i<list.size();i++ )
			{
				for( int j=0;j<list.size();j++ )
				{
					if( getXYValue(i,j) > getXYValue(i,k)+getXYValue(k,j) )
					{
						setXYValue(i,j,getXYValue(i,k)+getXYValue(k,j));
						Path[i][j]=Path[i][k];
					}
				}
			}
		}
		
		for( int i=0;i<list.size();i++ )
		{
			for( int j=0;j<list.size();j++ )
			{
				if( getXYValue(i,j) > Integer.MAX_VALUE/2-2000)
				{
					System.out.printf("从%d到%d无最短路径\n",i,j);
					continue;
				}
				System.out.printf("从%d到%d的最短路径长度是:%d    ",i,j,getXYValue(i,j));
				System.out.printf("通过：");
				
				int k=Path[i][j];
				System.out.printf("%d",i);
				
				while( k!=j )
				{
					System.out.printf("->%d",k);
					k=Path[k][j];
				}
				System.out.printf("->%d\n",j);
			
			
			}
		}
		
		
	}

}
