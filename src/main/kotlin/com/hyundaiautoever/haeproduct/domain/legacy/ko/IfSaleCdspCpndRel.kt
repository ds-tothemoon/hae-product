package com.hyundaiautoever.haeproduct.domain.legacy.ko

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.Comment
import java.io.Serializable
import java.time.LocalDateTime

@Embeddable
data class ColorCombinationRelation(
    @Column(name = "SALE_CAR_CTY_NO", nullable = false)
    val saleCarCtyNo: String = "",

    @Column(name = "XRCL_CD", nullable = false)
    val xrclCd: String = "",

    @Column(name = "IECL_CD", nullable = false)
    val ieclCd: String = "",

    @Column(name = "SALE_MDL_CD")
    val saleMdlCd: String? = null,

    @Column(name = "SCLAS_CD")
    val sclasCd: Char? = null,
) : Serializable

@Entity
@Comment("칼라조합관계정보")
@Table(name = "if_sale_cdsp_c_cpnd_rel_i")
data class IfSaleCdspCpndRel(

    @EmbeddedId
    val colorCombinationRelation: ColorCombinationRelation,

    @Column(name = "APL_YN")
    val aplYn: Char? = null,

    @Column(name = "RGST_DTM")
    val rgstDtm: LocalDateTime? = null,

    @Column(name = "RGN_EENO")
    val rgnEeno: String? = null,

    @Column(name = "FIN_MDFY_DTM")
    val finMdfyDtm: LocalDateTime? = null,

    @Column(name = "FIN_UPDR_EENO")
    val finUpdrEeno: String? = null
)
