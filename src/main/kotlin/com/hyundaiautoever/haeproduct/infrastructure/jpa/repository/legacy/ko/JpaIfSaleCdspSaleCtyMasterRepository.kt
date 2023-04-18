package com.hyundaiautoever.haeproduct.infrastructure.jpa.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspSaleCtyMaster
import com.hyundaiautoever.haeproduct.domain.repository.legacy.ko.IfSaleCdspSaleCtyMasterRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaIfSaleCdspSaleCtyMasterRepository :
    JpaRepository<IfSaleCdspSaleCtyMaster, String>,
    IfSaleCdspSaleCtyMasterRepository
