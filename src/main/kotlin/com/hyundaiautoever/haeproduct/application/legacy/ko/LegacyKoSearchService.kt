package com.hyundaiautoever.haeproduct.application.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCcar
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCpndRel
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspSaleCtyMaster
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspCcarRepository
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspCpndRelRepository
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspOptCpndCmpoRepositoryCustom
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspSaleCtyMasterRepository
import com.hyundaiautoever.haeproduct.logger
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
        val optionProduct = ifSaleCdspOptCpndCmpoRepositoryCustom.findOptionCombination(saleMdlCd, optionList)
        logger().info("$optionProduct")
        if (optionProduct == null) {
            return null
        }

        return ifSaleCdspSaleCtyMasterRepository.findBySaleCtyNo(optionProduct.optCpndCtyNo)
    }
}
