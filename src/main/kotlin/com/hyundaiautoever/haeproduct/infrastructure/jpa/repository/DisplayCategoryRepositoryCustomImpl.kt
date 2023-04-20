package com.hyundaiautoever.haeproduct.infrastructure.jpa.repository

import com.hyundaiautoever.haeproduct.domain.entity.category.DisplayCategory
import com.hyundaiautoever.haeproduct.domain.repository.DisplayCategoryRepositoryCustom
import com.hyundaiautoever.haeproduct.domain.entity.category.QDisplayCategory
import com.hyundaiautoever.haeproduct.domain.entity.vo.DisplayCategoryType
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class DisplayCategoryRepositoryCustomImpl(val jpaQueryFactory: JPAQueryFactory) : DisplayCategoryRepositoryCustom {
    override fun findAll(displayCategoryType: DisplayCategoryType): List<DisplayCategory> {
        val qDisplayCategory = QDisplayCategory.displayCategory
        return jpaQueryFactory.selectFrom(qDisplayCategory)
            .where(
                qDisplayCategory.isActive.isTrue,
                qDisplayCategory.categoryType.eq(displayCategoryType)
            )
            .orderBy(
                qDisplayCategory.priority.asc()
            )
            .fetch()
    }
}
