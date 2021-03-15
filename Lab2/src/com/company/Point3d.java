package com.company;

public class Point3d extends Point2d {
    private double zCoord;
    public Point3d (double x, double y, double z)
    {
        zCoord = z;
        xCoord = x;
        yCoord = y;
    }
    public Point3d () {

        this(0,0,0);
    }
    public double getZ () {
        return zCoord;
    }

    private void setZ ( double val) {
        zCoord = val;
    }

    public boolean comparePoint3d(double x,double y, double z)
    {
        if ((this.zCoord ==z)&& (this.xCoord ==x) && (this.yCoord ==y))
        {
            return true;
        }
        else return false;
    }
    public double distanceTo(double x, double y, double z)
    {
        double len = Math.sqrt(Math.pow((this.xCoord-x),2) + Math.pow ((this.yCoord-y),2)+ Math.pow ((this.zCoord-z),2));
        double result = Math.ceil(len*100)/100;
        return result;
    }
}
