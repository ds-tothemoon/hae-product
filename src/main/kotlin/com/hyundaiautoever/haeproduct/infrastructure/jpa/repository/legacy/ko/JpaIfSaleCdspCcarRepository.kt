package com.hyundaiautoever.haeproduct.infrastructure.jpa.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.CarNameAndCarPropertyRelation
import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCcar
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspCcarRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaIfSaleCdspCcarRepository :
    JpaRepository<IfSaleCdspCcar, CarNameAndCarPropertyRelation>,
    IfSaleCdspCcarRepository {
    override fun findAll(pageable: Pageable): Page<IfSaleCdspCcar>
}