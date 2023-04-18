package com.hyundaiautoever.haeproduct.domain.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspCpndRel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IfSaleCdspCpndRelRepository {
    fun findAll(pageable: Pageable): Page<IfSaleCdspCpndRel>
}