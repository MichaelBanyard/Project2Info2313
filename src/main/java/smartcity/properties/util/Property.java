package smartcity.properties.util;

import com.gluonhq.maps.MapPoint;

public interface Property {
    double calculatePropertyValue();
    MapPoint getMapPoint();
    void setMapPoint(MapPoint mapPoint);
}