/*
// CanteenRepository.java
package com.example.demo.repository;

import com.example.demo.entity.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CanteenRepository extends JpaRepository<Canteen, String> {
    List<Canteen> findByNameContainingIgnoreCase(String name);
    List<Canteen> findByLocationContainingIgnoreCase(String location);

    @Query("SELECT c FROM Canteen c WHERE " +
            "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:location IS NULL OR LOWER(c.location) LIKE LOWER(CONCAT('%', :location, '%')))")
    List<Canteen> findByNameAndLocation(@Param("name") String name, @Param("location") String location);

    @Query("SELECT c FROM Canteen c WHERE " +
            "(6371 * acos(cos(radians(:latitude)) * cos(radians(c.latitude)) * " +
            "cos(radians(c.longitude) - radians(:longitude)) + " +
            "sin(radians(:latitude)) * sin(radians(c.latitude)))) < :distance")
    List<Canteen> findNearbyCanteens(@Param("latitude") Double latitude,
                                     @Param("longitude") Double longitude,
                                     @Param("distance") Double distance);
}
*/