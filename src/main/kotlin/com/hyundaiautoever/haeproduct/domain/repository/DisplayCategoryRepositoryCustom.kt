package com.hyundaiautoever.haeproduct.domain.repository

import com.hyundaiautoever.haeproduct.domain.entity.category.DisplayCategory
import com.hyundaiautoever.haeproduct.domain.entity.vo.DisplayCategoryType

interface DisplayCategoryRepositoryCustom {
    fun findAll(displayCategoryType: DisplayCategoryType): List<DisplayCategory>
}
