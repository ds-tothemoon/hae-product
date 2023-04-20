package com.hyundaiautoever.haeproduct.domain.dto

import com.hyundaiautoever.haeproduct.domain.entity.category.DisplayCategory
import com.hyundaiautoever.haeproduct.domain.entity.vo.DisplayCategoryType

data class DisplayCategoryDto(
    val id: Long,
    val categoryName: String,
    val categoryType: DisplayCategoryType,
    val depth: Int,
    val priority: Int,
    val parentNo: Long?,
    var children: List<DisplayCategoryDto> = emptyList()
) {
    companion object {
        fun toDto(displayCategory: DisplayCategory): DisplayCategoryDto = DisplayCategoryDto(
            id = displayCategory.id,
            categoryName = displayCategory.categoryName,
            categoryType = displayCategory.categoryType!!,
            depth = displayCategory.depth,
            priority = displayCategory.priority,
            parentNo = displayCategory.parent?.id,
        )
    }
}
