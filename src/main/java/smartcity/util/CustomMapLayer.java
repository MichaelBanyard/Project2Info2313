package smartcity.util;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public class CustomMapLayer extends MapLayer {

    private final ImageView marker;
    private final MapPoint mapPoint;

    public CustomMapLayer(MapPoint mapPoint, ImageView marker) {
        this.mapPoint = mapPoint;
        this.marker = marker;
    }

    @Override
    protected void layoutLayer() {
        getChildren().clear();
        Point2D point = getMapPoint(mapPoint.getLatitude(), mapPoint.getLongitude());
        marker.setTranslateX(point.getX() - marker.getFitWidth() / 2);
        marker.setTranslateY(point.getY() - marker.getFitHeight() / 1.05);
        getChildren().add(marker);
    }

    public void refresh() {
        markDirty();
    }
}
