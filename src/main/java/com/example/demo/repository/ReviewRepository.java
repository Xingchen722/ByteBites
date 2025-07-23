/*
// ReviewRepository.java
package com.example.demo.repository;

import com.example.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCanteenIdOrderByCreatedAtDesc(String canteenId);
    List<Review> findByUsernameOrderByCreatedAtDesc(String username);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.canteenId = :canteenId")
    Double findAverageRatingByCanteenId(@Param("canteenId") String canteenId);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.canteenId = :canteenId")
    Long countByCanteenId(@Param("canteenId") String canteenId);
}
*/
