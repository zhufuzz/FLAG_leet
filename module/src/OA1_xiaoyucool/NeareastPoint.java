package OA1_xiaoyucool;
import java.util.*;

public class NeareastPoint{

	static class Point{
		double x;
		double y;
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		public Point(){
		}
	}

	public static Point[] getClosetK(Point[] points,int k){

		if(points == null || points.length <k || k <= 0){
			return new Point[0];
		}
		Point[] res= new Point[k];
		Comparator<Point> comp = new Comparator<Point>(){
			@Override
			public int compare(Point cp1, Point cp2){
			
			double result = (cp1.x * cp1.x + cp1.y * cp1.y) - (cp2.x * cp2.x + cp2.y * cp2.y);
			if(result > 0){
				return -1;
			} else if(result < 0){
				return 1;
			} else{
				return 0;
			}
			}
		};
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k,comp);
		for(int i = 0;i<points.length;i++){
			if(pq.size() <k){
				pq.offer(points[i]);
			}else{
				Point peekPoint = pq.peek();
				if(comp.compare(peekPoint,points[i]) <0){
					pq.poll();
					pq.offer(points[i]);
				}
			}
			//pq.offer(points[i]);
		}
		for(int i = k-1;i>=0;i--){
			res[i] = pq.poll();
		}
		return res;
	}

	public static void main(String[] args){
		Random rand = new Random();
		int size = rand.nextInt(20);
		while(size <3){
			size = rand.nextInt(20);
		}
		Point[] points = new Point[size];
		for(int i = 0;i<points.length;i++){
			points[i] = new Point();
			points[i].x = rand.nextInt(100)*rand.nextDouble();
			points[i].y = rand.nextInt(100)*rand.nextDouble();

		}
		Point[] res = getClosetK(points,3);
		System.out.println("Total points is " + points.length);
		for(int i = 0;i<points.length;i++){
			System.out.println("Number " + i+ " point is "+ points[i].x + "," +points[i].y);
		}
		System.out.println();
		System.out.println();
		System.out.println("First K points is " + res.length);
		for(int i = 0;i<res.length;i++){
			System.out.println("Number " + i+ " closet point is "+ res[i].x + ","+ res[i].y);
		}
	}
		

}