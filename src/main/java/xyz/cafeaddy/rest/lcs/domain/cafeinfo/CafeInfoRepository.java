package xyz.cafeaddy.rest.lcs.domain.cafeinfo;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeInfoRepository extends JpaRepository<CafeInfo, Long> {


    /**
     *
     * @param neLongitude 북동쪽 경도 (northEast longitude)
     * @param neLatitude 북동쪽 위도 (northEast latitude)
     * @param swLongitude 남서쪽 경도 (southWest longitude)
     * @param swLatitude 남서쪽 위도 (southWest latitude)
     * @return
     */

    @Query(value = "SELECT * FROM cafe_info AS c\n" +
            "WHERE MBRCONTAINS" +
            "(ST_LINESTRINGFROMTEXT(CONCAT('LINESTRING(', :neLongitude, ' ', :neLatitude, ',', :swLongitude, ' ', :swLatitude, ')')), c.location);\n"
            , nativeQuery= true)
    public List<CafeInfo> findByMBRContains(@Param("x1") Double neLongitude, @Param("y1") Double neLatitude,
                                            @Param("x2") Double swLongitude, @Param("y2") Double swLatitude);


}

// 특정 좌표만 찾아내는것
//SELECT * FROM cafe_info AS c
//        WHERE MBRCONTAINS(ST_GEOMFROMTEXT('Point(127.04227240 37.65877490)'), c.location);

// "WHERE MBRContains(ST_GeomFromText(ST_LINESTRINGFROMTEXT(LINESTRING(:x1, :y1, :x2, :y2 ))), c.location )"