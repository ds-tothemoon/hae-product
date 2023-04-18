package com.hyundaiautoever.haeproduct.domain.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.dto.OptionGroupingDto

interface IfSaleCdspOptCpndCmpoRepositoryCustom {

    fun findOptionCombination(saleMdlCd: String, optionList: List<String>): OptionGroupingDto?
}
