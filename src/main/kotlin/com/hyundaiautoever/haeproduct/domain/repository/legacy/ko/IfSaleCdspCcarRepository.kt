package com.hyundaiautoever.haeproduct.domain.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCcar
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IfSaleCdspCcarRepository {
    fun findAll(pageable: Pageable): Page<IfSaleCdspCcar>
}