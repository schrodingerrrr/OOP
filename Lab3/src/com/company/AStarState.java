package com.company;
import java.util.HashMap;
public class AStarState {

    private Map2D map;
    HashMap<Location,Waypoint>OpenWp=new HashMap<>();
    HashMap<Location,Waypoint>CloseWp=new HashMap<>();

    public AStarState (Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint()
    {
        if (OpenWp.size()==0)
            return null;
        else
            {
            Waypoint point=null;
            float totalCost=100000;
            for (Location key: OpenWp.keySet())
            {
                Waypoint point_cur=OpenWp.get(key);
                System.out.println("value="+point_cur);
                if (point_cur.getTotalCost()<totalCost)
                {
                    totalCost=point_cur.getTotalCost();
                    point = point_cur;
                }
            }
            return point;
        }
    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        if ((!OpenWp.containsKey(newWP.loc)))
            OpenWp.put(newWP.loc,newWP);
        else
        {
            Waypoint point = OpenWp.get(newWP.loc);
            if(point.getPreviousCost() > newWP.getPreviousCost())
            {
                OpenWp.put(newWP.loc,newWP);
                return true;
            }
        }
        return false;
    }

    public int numOpenWaypoints()
    {
        return OpenWp.size();
    }

    public void closeWaypoint(Location loc)
    {
        Waypoint point = OpenWp.get(loc);
        OpenWp.remove(loc);
        CloseWp.put(loc,point);
    }

    public boolean isLocationClosed(Location loc)
    {
        if (CloseWp.containsKey(loc))
            return true;
            else
            return false;
    }
}
