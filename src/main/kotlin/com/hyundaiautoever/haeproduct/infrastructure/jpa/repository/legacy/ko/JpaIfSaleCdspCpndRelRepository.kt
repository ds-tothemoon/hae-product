package com.hyundaiautoever.haeproduct.infrastructure.jpa.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.ColorCombinationRelation
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCpndRel
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspCpndRelRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaIfSaleCdspCpndRelRepository :
    JpaRepository<IfSaleCdspCpndRel, ColorCombinationRelation>,
    IfSaleCdspCpndRelRepository {

    override fun findAll(pageable: Pageable): Page<IfSaleCdspCpndRel>
}