package com.company;

public class Location {
    public int xCoord;
    public int yCoord;

    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }
    public Location()
    {
        this(0, 0);
    }

   public int hashCode()
   {
       int result=17;
       result=37*result+xCoord;
       result=37*result+yCoord;
       return result;
   }
   public boolean equals (Object obj)
   {
       if (obj==this)
       {
           return true;
       }
       if (obj==null || obj.getClass()!=this.getClass())
       {
           return false;
       }
       Location loc = (Location)obj;
       return loc.xCoord==this.xCoord & loc.yCoord== this.yCoord;
   }
}