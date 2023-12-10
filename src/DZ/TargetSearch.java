package DZ;
import java.util.*;

public class TargetSearch {
static char[][] grid;
static int rows , cols;
static void makeGrid(int Rows, int Column)
{
	rows=Rows;
	cols=Column;
	grid= new char[rows][cols];
	for(int i = 0;i< rows ; i++)
	{
		for (int j=0 ; j< cols ; j++)
		{
			grid[i][j] = '-';
		}
	}
}

static void droneSet(int[] droneX , int[] droneY)
{
	for(int i=0 ; i< droneX.length ; i++)
	{
		grid[droneX[i]][droneY[i]]= 'D';
	}
}
static void gridPrint()
{
	for(int i = 0;i< rows ; i++)
	{
		for (int j=0 ; j< cols ; j++)
		{
			System.out.println(grid[i][j] + "  ");
		}
		System.out.println();
	}
	System.out.println();
}
static void targetFind(int targetX , int targetY, int [] droneX , int[] droneY , int nearestDrone)
{
	droneSet(droneX ,droneY);
	int currX=droneX[nearestDrone];
	int currY=droneY[nearestDrone];
	System.out.println("drone position of nearest drone ("+ currX + " , "+ currY + " SEARCHING THE TARGET");
	while(currX !=targetX || currY != targetY) 
	{
		if(currX < targetX)
		{
			currX++;
		}
		else if(currX > targetX)
			{currX--;}
		
		if(currY < targetY)
		{
			currY++;
		}
		else if(currY > targetY)
			{currY--;}
			
		System.out.println("Current position : (" + currX + " ," + currY + ")");
		gridPrint();
	}
	if(currX==targetX && currY == targetY)
	{
		System.out.println("Target found at position (" + targetX + "," + targetY + ") by drone at ("
				+droneX[nearestDrone] + " ," + droneY[nearestDrone]+ ")..");
		return ;
	}
		}
 static int calculateDistance(int x1 , int y1 , int x2 ,int y2) {
	 return Math.abs(x1-x2)+ Math.abs(y1-y2);
 }
 
 static int findNearest(int targetX , int targetY ,int[] droneX ,int droneY[])
 {
	 int minD = Integer.MAX_VALUE;
	 int nearestD=-1;
	 for(int i=0 ; i<droneX.length ; i++)
	 {
		 int distance = calculateDistance(droneX[i] , droneY[i], targetX , targetY);
		 if(distance < minD)
		 {
			 minD = distance;
			 nearestD=i;
			 }
	 }
	 return nearestD;
 }
 public static void main(String args[])
 {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("enter the no. of rows");
	 int numR= sc.nextInt();
	 System.out.println("enter the no. of cols");
	 int numC= sc.nextInt();
	 makeGrid(numR , numC);
	 int[] droneX = new int[4];
	 int[] droneY = new int[4];
	 System.out.println("enter the position for 4 drones (format x1 y1 x2 y2 x3 y3 x4 y4)");
	 for(int i=0; i<4;i++)
	 {
		 droneX[i]=sc.nextInt();
		 droneY[i]=sc.nextInt();
	 }
		 System.out.println("enter the target point (format : x y)");
		 int targetX=sc.nextInt();
		 int targetY=sc.nextInt();
		 int nearestDrone = findNearest(targetX ,targetY, droneX ,droneY);
		 System.out.println("nearest drone is ="+ nearestDrone);
		 targetFind(targetX ,targetY, droneX ,droneY , nearestDrone);
		 sc.close();
		 
		 
	 }
	 
	 
	 
 }



