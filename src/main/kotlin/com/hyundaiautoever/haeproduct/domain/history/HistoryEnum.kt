package com.hyundaiautoever.haeproduct.domain.history

import com.hyundaiautoever.haeproduct.domain.Product
import kotlin.reflect.KClass

enum class HistoryEnum(
    val sourceClazz: KClass<out Historyable>,
    val historyClazz: KClass<out HistoryBase>
) {
    PRODUCT_HISTORY(Product::class, ProductHistory::class);

    companion object {
        @JvmStatic
        private val historyEnumMap = initHistoryEnumMap()

        @JvmStatic
        private fun initHistoryEnumMap(): Map<KClass<out Historyable>, HistoryEnum> {
            val historyEnumMap = mutableMapOf<KClass<out Historyable>, HistoryEnum>()
            HistoryEnum.values().forEach {
                historyEnumMap[it.sourceClazz] = it
            }
            return historyEnumMap
        }

        fun getHistoryType(classType: KClass<out Historyable>): HistoryEnum? {
            return historyEnumMap[classType]
        }
    }

    fun createNewHistory(vararg args: Any?): HistoryBase {
        return historyClazz.constructors.first().call(*args)
    }
}
