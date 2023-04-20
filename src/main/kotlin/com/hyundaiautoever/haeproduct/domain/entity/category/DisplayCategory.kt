package com.hyundaiautoever.haeproduct.domain.entity.category

import com.hyundaiautoever.haeproduct.domain.dto.DisplayCategoryDto
import com.hyundaiautoever.haeproduct.domain.entity.vo.AuditLog
import com.hyundaiautoever.haeproduct.domain.entity.vo.DisplayCategoryType
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class)
@Entity
class DisplayCategory(
    categoryName: String,
    categoryType: DisplayCategoryType,
    depth: Int,
    priority: Int,
    isActive: Boolean
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var categoryName: String = categoryName
        private set

    @Enumerated(EnumType.STRING)
    var categoryType: DisplayCategoryType? = categoryType

    var depth: Int = depth
        private set

    var priority: Int = priority
        private set

    var isActive: Boolean = isActive
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    var parent: DisplayCategory? = null
        private set

    @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL])
    var children: List<DisplayCategory> = listOf() // 자식 연관
        private set

    @Embedded
    var auditLog: AuditLog = AuditLog()
        private set

    fun applyParent(parent: DisplayCategory?) {
        this.parent = parent
    }

    companion object {
        fun toTree(categories: Collection<DisplayCategoryDto>): List<DisplayCategoryDto> {
            val maxDepth = categories.maxOf(DisplayCategoryDto::depth)
            if (categories.isEmpty() || maxDepth < 1) {
                return emptyList()
            }

            val categoryMap = categories.groupBy(DisplayCategoryDto::depth)
            val categoryMapByParent = categories.groupBy(DisplayCategoryDto::parentNo)

            for (depth in (maxDepth - 1) downTo 1) {
                categoryMap[depth]?.forEach { subCategory ->
                    categoryMapByParent[subCategory.id]?.apply {
                        subCategory.children = this
                    }
                }
            }

            return categoryMap[1] ?: emptyList()
        }
    }
}
