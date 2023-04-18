package com.hyundaiautoever.haeproduct.infrastructure.jpa.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.QIfSaleCdspOptCpndCmpo
import com.hyundaiautoever.haeproduct.domain.legacy.ko.dto.OptionGroupingDto
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspOptCpndCmpoRepositoryCustom
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class IfSaleCdspOptCpndCmpoRepositoryCustomImpl(val jpaQueryFactory: JPAQueryFactory) :
    IfSaleCdspOptCpndCmpoRepositoryCustom {
    override fun findOptionCombination(saleMdlCd: String, optionList: List<String>): OptionGroupingDto? {
        val qOptCpndCmpo = QIfSaleCdspOptCpndCmpo.ifSaleCdspOptCpndCmpo

        val candidateOptionCombinations = jpaQueryFactory.select(
            Projections.constructor(
                OptionGroupingDto::class.java,
                qOptCpndCmpo.optCpndCtyNo,
                Expressions.stringTemplate("group_concat(${qOptCpndCmpo.optCtyNo})").`as`("optCtyNos")
            )
        )
            .from(qOptCpndCmpo)
            .groupBy(qOptCpndCmpo.optCpndCtyNo)
            .having(
                qOptCpndCmpo.count()
                    .eq(optionList.size.toLong())
            )
            .fetch()

        val optionSet = optionList.toSet()

        return candidateOptionCombinations.filter {
            val curOptionSet = it.optCtyNos.split(",").toSet()
            optionSet.containsAll(curOptionSet) && curOptionSet.containsAll(optionSet)
        }.firstOrNull()
    }
}
