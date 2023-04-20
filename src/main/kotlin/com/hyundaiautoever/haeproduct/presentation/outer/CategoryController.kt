package com.hyundaiautoever.haeproduct.presentation.outer

import com.hyundaiautoever.haeproduct.application.DisplayCategoryService
import com.hyundaiautoever.haeproduct.domain.dto.DisplayCategoryDto
import com.hyundaiautoever.haeproduct.domain.entity.vo.DisplayCategoryType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("category")
class CategoryController(
    private val displayCategoryService: DisplayCategoryService
) {
    @GetMapping
    fun getCategories(): List<DisplayCategoryDto> {
        return displayCategoryService.getCategory(DisplayCategoryType.NORMAL)
    }

    @PostMapping("register")
    fun registerCategory(
        @RequestBody request: CategoryRegisterRequest
    ) {
        val category = request.toEntity()
        displayCategoryService.registerCategory(category, request.parentNo)
    }
}
