package com.hyundaiautoever.haeproduct.domain.legacy.ko

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import java.io.Serializable
import java.time.LocalDateTime

data class OptionCombination(
    @Column(name = "OPT_CTY_NO", length = 20)
    val optCtyNo: String = "",

    @Column(name = "OPT_CPND_CTY_NO", length = 20)
    val optCpndCtyNo: String = "",
) : Serializable

@Entity
@Comment("옵션조합구성정보")
@Table(name = "if_sale_cdsp_opt_cpnd_cmpo_i")
@IdClass(OptionCombination::class)
data class IfSaleCdspOptCpndCmpo(

    @Id
    @Column(name = "OPT_CTY_NO", length = 20)
    val optCtyNo: String = "",

    @Id
    @Column(name = "OPT_CPND_CTY_NO", length = 20)
    val optCpndCtyNo: String = "",

    @Column(name = "RGST_DTM")
    val rgstDtm: LocalDateTime,

    @Column(name = "RGN_EENO", length = 7)
    val rgnEeno: String = "",

    @Column(name = "FIN_MDFY_DTM")
    val finMdfyDtm: LocalDateTime,

    @Column(name = "FIN_UPDR_EENO", length = 7)
    val finUpdrEeno: String = "",

    @Column(name = "BTO_YN", length = 1)
    val btoYn: Boolean
)
