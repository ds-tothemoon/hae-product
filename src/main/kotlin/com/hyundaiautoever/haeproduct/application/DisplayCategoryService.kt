package com.hyundaiautoever.haeproduct.application

import com.hyundaiautoever.haeproduct.domain.dto.DisplayCategoryDto
import com.hyundaiautoever.haeproduct.domain.entity.category.*
import com.hyundaiautoever.haeproduct.domain.entity.vo.DisplayCategoryType
import com.hyundaiautoever.haeproduct.domain.repository.DisplayCategoryRepository
import com.hyundaiautoever.haeproduct.domain.repository.DisplayCategoryRepositoryCustom
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DisplayCategoryService(
    private val displayCategoryRepository: DisplayCategoryRepository,
    private val displayCategoryRepositoryCustom: DisplayCategoryRepositoryCustom
) {

    fun getCategory(categoryType: DisplayCategoryType): List<DisplayCategoryDto> {
        val categories = displayCategoryRepositoryCustom
            .findAll(categoryType)
            .map(DisplayCategoryDto::toDto)
        return DisplayCategory.toTree(categories)
    }

    @Transactional
    fun registerCategory(category: DisplayCategory, parentNo: Long?): Long {
        val parent = parentNo?.run {
            displayCategoryRepository.getReferenceById(parentNo)
        }
        category.applyParent(parent)
        return displayCategoryRepository.save(category).id
    }
}
