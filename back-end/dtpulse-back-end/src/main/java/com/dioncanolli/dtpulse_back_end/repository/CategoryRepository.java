package com.dioncanolli.dtpulse_back_end.repository;

import com.dioncanolli.dtpulse_back_end.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByCategoryName(String categoryName);
}
