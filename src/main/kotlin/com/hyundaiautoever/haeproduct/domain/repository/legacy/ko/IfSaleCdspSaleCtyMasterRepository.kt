package com.hyundaiautoever.haeproduct.domain.repository.legacy.ko

import com.hyundaiautoever.haeproduct.domain.legacy.ko.IfSaleCdspSaleCtyMaster

interface IfSaleCdspSaleCtyMasterRepository {
    fun findBySaleCtyNo(saleCtyNo: String): IfSaleCdspSaleCtyMaster?
}
