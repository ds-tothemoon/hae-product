package com.hyundaiautoever.haeproduct.presentation.outer

import com.hyundaiautoever.haeproduct.application.legacy.ko.LegacyKoSearchService
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCcar
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCpndRel
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspSaleCtyMaster
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("legacy")
class LegacyController(
    private val legacyKoSearchService: LegacyKoSearchService
) {
    @GetMapping("color-combination")
    fun searchLegacyColorCombinationRelation(pageable: Pageable): Page<IfSaleCdspCpndRel> {
        return legacyKoSearchService.searchLegacyColorCombinationRelation(pageable)
    }

    @GetMapping("car-name-and-car-property-relation")
    fun searchLegacyCarNameAndCarPropertyRelation(pageable: Pageable): Page<IfSaleCdspCcar> {
        return legacyKoSearchService.searchLegacyCarNameAndCarPropertyRelation(pageable)
    }

    @GetMapping("option/{saleMdlCd}")
    fun getOptionProduct(
        @PathVariable saleMdlCd: String,
        @RequestParam optionList: List<String>
    ): IfSaleCdspSaleCtyMaster? {
        return legacyKoSearchService.getOptionProduct(saleMdlCd, optionList)
    }
}
