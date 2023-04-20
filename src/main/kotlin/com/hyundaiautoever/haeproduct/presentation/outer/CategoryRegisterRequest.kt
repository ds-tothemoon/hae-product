package com.hyundaiautoever.haeproduct.presentation.outer

import com.hyundaiautoever.haeproduct.domain.entity.category.DisplayCategory
import com.hyundaiautoever.haeproduct.domain.entity.vo.DisplayCategoryType

data class CategoryRegisterRequest(
    val id: Long,
    val categoryName: String,
    val categoryType: DisplayCategoryType,
    val depth: Int,
    val priority: Int,
    val isActive: Boolean,
    val parentNo: Long?,
) {
    fun toEntity(): DisplayCategory = DisplayCategory(
        categoryName = categoryName,
        categoryType = categoryType,
        depth = depth,
        priority = priority,
        isActive = isActive
    )
}
