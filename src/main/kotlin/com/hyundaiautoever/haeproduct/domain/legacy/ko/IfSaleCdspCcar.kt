package com.hyundaiautoever.haeproduct.domain.legacy.ko

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import java.io.Serializable
import java.time.LocalDateTime

@Embeddable
data class CarNameAndCarPropertyRelation(
    @Column(name = "CARN_CD", length = 2, nullable = false)
    val carNameCode: String = "",

    @Column(name = "CAR_ATTR_TYPE_SCN_CD", length = 2, nullable = false)
    val carAttributeTypeSceneCode: String = "",

    @Column(name = "CARN_CAR_ATTR_CD", length = 1, nullable = false)
    val carNameAttributeCode: String = "",

    @Column(name = "STRT_YMD", length = 8)
    val startYmd: String = "",

    @Column(name = "FNH_YMD", length = 8)
    val finishYmd: String = "",

    @Column(name = "CARN_CAR_ATTR_NM", length = 100)
    val carNameAttributeNm: String = "",

    @Column(name = "IQ_SORT_NO", length = 15)
    val inquirySortNo: String = "",

    @Column(name = "CAR_ATTR_G_CD", length = 2)
    val carAttributeGroupCode: String = "",

    @Column(name = "CARN_IDX_CD", length = 20)
    val carNameIndexCode: String = "",
) : Serializable

@Entity
@Comment("차명차량속성관계정보")
@Table(name = "if_sale_cdsp_ccar_i")
data class IfSaleCdspCcar(

    @EmbeddedId
    val carNameAndCarPropertyRelation: CarNameAndCarPropertyRelation,

    @Column(name = "RGST_DTM")
    val registrationDate: LocalDateTime,

    @Column(name = "RGN_EENO", length = 7)
    val regionEmployeeNo: String = "",

    @Column(name = "FIN_MDFY_DTM")
    val finalModifiedDate: LocalDateTime,

    @Column(name = "FIN_UPDR_EENO", length = 7)
    val finalUpdaterEmployeeNo: String = "",
)