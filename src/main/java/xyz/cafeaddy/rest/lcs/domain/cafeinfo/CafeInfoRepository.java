package xyz.cafeaddy.rest.lcs.domain.cafeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeInfoRepository extends JpaRepository<CafeInfo, Long> {

}
