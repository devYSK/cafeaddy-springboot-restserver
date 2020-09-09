package xyz.cafeaddy.rest.lcs.utils;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class PointUtil {

    private static final WKTReader wktReader = new WKTReader();

    public static Point makePointFromCoords(Double latitude, Double longitude) {
        String pointWKT = String.format("POINT(%s %s)", latitude, longitude);

        Geometry geometry = null;

        // WKTReader를 통해 WKT를 실제 타입으로 변환.
        try {
            geometry = wktReader.read(pointWKT);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return (Point)geometry;
    }

//        public static Point makePointFromCoords(Double  longitude, Double latitude) {
//        GeometryFactory gf = new GeometryFactory();
//
//        return gf.createPoint(new Coordinate(longitude, latitude));
//    }

}
