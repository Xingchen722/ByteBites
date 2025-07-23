/*
// DishReviewRepository.java
package com.example.demo.repository;

import com.example.demo.entity.DishReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DishReviewRepository extends JpaRepository<DishReview, Long> {
    List<DishReview> findByCanteenIdOrderByCreatedAtDesc(String canteenId);
    List<DishReview> findByCanteenIdAndDishNameOrderByCreatedAtDesc(String canteenId, String dishName);
    List<DishReview> findByUsernameOrderByCreatedAtDesc(String username);

    @Query("SELECT AVG(dr.rating) FROM DishReview dr WHERE dr.canteenId = :canteenId AND dr.dishName = :dishName")
    Double findAverageRatingByCanteenIdAndDishName(@Param("canteenId") String canteenId, @Param("dishName") String dishName);

    @Query("SELECT DISTINCT dr.dishName FROM DishReview dr WHERE dr.canteenId = :canteenId ORDER BY dr.dishName")
    List<String> findDistinctDishNamesByCanteenId(@Param("canteenId") String canteenId);
}
*/