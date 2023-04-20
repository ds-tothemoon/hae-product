package com.hyundaiautoever.haeproduct.domain.history

import com.hyundaiautoever.haeproduct.domain.entity.product.Product
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

enum class HistoryEnum(
    val sourceClazz: KClass<out Historyable>,
    val historyClazz: KClass<out HistoryBase>
) {
    PRODUCT_HISTORY(Product::class, ProductHistory::class);

    companion object {
        @JvmStatic
        private val historyEnumMap: Map<KClass<out Historyable>, HistoryEnum> = values().associateBy { it.sourceClazz }

        fun getHistoryType(classType: KClass<out Historyable>): HistoryEnum? {
            return historyEnumMap[classType]
        }
    }

    fun createNewHistory(vararg args: Any?): HistoryBase {
        return historyClazz.primaryConstructor!!.call(*args)
    }
}
