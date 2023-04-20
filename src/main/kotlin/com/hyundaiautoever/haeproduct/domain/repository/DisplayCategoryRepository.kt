package com.hyundaiautoever.haeproduct.domain.repository

import com.hyundaiautoever.haeproduct.domain.entity.category.DisplayCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DisplayCategoryRepository : JpaRepository<DisplayCategory, Long>
