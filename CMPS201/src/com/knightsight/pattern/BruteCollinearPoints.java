package com.knightsight.pattern;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


public class BruteCollinearPoints {
	   public LineSegment[] segments;
	   ArrayList<LineSegment> list=new ArrayList<LineSegment>();
	   public BruteCollinearPoints(Point[] points){
		   checkPoints(points);
		   Arrays.sort(points);
		   for(int p=0;p<points.length-3;p++){
			   for(int q=p+1;q<points.length-2;q++){
				   for(int r=q+1;r<points.length-1;r++){
					   for(int s=r+1;s<points.length;s++){
						   if(points[p].slopeTo(points[q])==points[p].slopeTo(points[r])&&
								   points[p].slopeTo(points[q])==points[p].slopeTo(points[s]))
							   list.add(new LineSegment(points[p], points[s]));
					   }
				   }
			   }
		   }
		   // finds all line segments containing 4 points
	   }
	   public int numberOfSegments(){
		  return list.size();
		// the number of line segments
	   }
	   public LineSegment[] segments(){
		  return list.toArray(new LineSegment[list.size()]);
		  // the line segments
	   }
	   public void checkPoints(Point []points){
		   for(int i=0;i<points.length-1;i++){
			   if(points[i]==null)
				   throw new NullPointerException();
			   for(int j=i+1;j<points.length;j++){
				   if(points[i].compareTo(points[j])==0)
					   throw new IllegalArgumentException("Contains Duplicate");
			   }
		   }
		   
	   }
	   
	   public static void main(String[] args) {

		    // read the n points from a file
		    In in = new In(args[0]);
		    int n = in.readInt();
		    Point[] points = new Point[n];
		    for (int i = 0; i < n; i++) {
		        int x = in.readInt();
		        int y = in.readInt();
		        points[i] = new Point(x, y);
		    }

		    // draw the points
		    StdDraw.enableDoubleBuffering();
		    StdDraw.setXscale(0, 32768);
		    StdDraw.setYscale(0, 32768);
		    for (Point p : points) {
		        p.draw();
		    }
		    StdDraw.show();

		    // print and draw the line segments
		    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		    for (LineSegment segment : collinear.segments()) {
		        StdOut.println(segment);
		        segment.draw();
		    }
		    StdDraw.show();
		}
}