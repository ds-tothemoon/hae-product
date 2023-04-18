package com.hyundaiautoever.haeproduct.application.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCcar
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCpndRel
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspSaleCtyMaster
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspCcarRepository
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspCpndRelRepository
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspOptCpndCmpoRepositoryCustom
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspSaleCtyMasterRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LegacyKoSearchService(
    private val ifSaleCdspCpndRelRepository: IfSaleCdspCpndRelRepository,
    private val ifSaleCdspCcarRepository: IfSaleCdspCcarRepository,
    private val ifSaleCdspOptCpndCmpoRepositoryCustom: IfSaleCdspOptCpndCmpoRepositoryCustom,
    private val ifSaleCdspSaleCtyMasterRepository: IfSaleCdspSaleCtyMasterRepository
) {
    fun searchLegacyColorCombinationRelation(pageable: Pageable): Page<IfSaleCdspCpndRel> {
        return ifSaleCdspCpndRelRepository.findAll(pageable)
    }

    fun searchLegacyCarNameAndCarPropertyRelation(pageable: Pageable): Page<IfSaleCdspCcar> {
        return ifSaleCdspCcarRepository.findAll(pageable)
    }

    fun getOptionProduct(saleMdlCd: String, optionList: List<String>): IfSaleCdspSaleCtyMaster? {
        val optionCombination = ifSaleCdspOptCpndCmpoRepositoryCustom.findOptionCombination(saleMdlCd, optionList)
        return optionCombination?.let { ifSaleCdspSaleCtyMasterRepository.findBySaleCtyNo(it.optCpndCtyNo) }
    }
}
