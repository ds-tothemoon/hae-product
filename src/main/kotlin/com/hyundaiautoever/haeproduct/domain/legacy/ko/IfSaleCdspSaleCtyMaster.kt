package com.hyundaiautoever.haeproduct.domain.legacy.ko

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Comment

@Entity
@Comment("판매상품마스터")
@Table(name = "if_sale_cdsp_sale_cty_m")
data class IfSaleCdspSaleCtyMaster(
    @Id
    @Column(name = "SALE_CTY_NO")
    val saleCtyNo: String = "",

    @Column(name = "SALE_CTY_HAN_NM")
    val saleCtyHanNm: String = "",

    @Column(name = "SALE_CTY_EN_NM")
    val saleCtyEnNm: String = "",

    @Column(name = "CTY_SCN_CD")
    val ctyScnCd: String = "",

    @Column(name = "PCE_XCT_CNTT_CD")
    val pceXctCnttCd: String = "",

    @Column(name = "PCE_XCT_WHOT_CD")
    val pceXctWhotCd: String = "",

    @Column(name = "PCE_XCT_RQ_CD")
    val pceXctRqCd: String = "",

    @Column(name = "PCE_XCT_ASG_CD")
    val pceXctAsgCd: String = "",

    @Column(name = "PCE_XCT_YN")
    val pceXctYn: String = "",

    @Column(name = "APL_STRT_YMD")
    val aplStrtYmd: String = "",

    @Column(name = "APL_FNH_YMD")
    val aplFnhYmd: String = "",

    @Column(name = "BASC_PCE_AMT")
    val bascPceAmt: Int? = null,

    @Column(name = "CRFW_YN")
    val crfwYn: String = "",

    @Column(name = "SALE_MDL_CD")
    val saleMdlCd: String = "",

    @Column(name = "CARN_CD")
    val carnCd: String = "",

    @Column(name = "SALE_VEHL_CD")
    val saleVehlCd: String = "",

    @Column(name = "SALE_CGRD_CD")
    val saleCgrdCd: String = "",

    @Column(name = "WHOT_VEHL_SCN_CD")
    val whotVehlScnCd: String = "",

    @Column(name = "USE_YN")
    val useYn: String = "",

    @Column(name = "ORD_CAR_YN")
    val ordCarYn: String = "",

    @Column(name = "CSPT_APL_YN")
    val csptAplYn: String = "",

    @Column(name = "TH1_OORD_CNEE_CD")
    val th1OordCneeCd: String = "",

    @Column(name = "TH2_OORD_CNEE_CD")
    val th2OordCneeCd: String = "",

    @Column(name = "CCDP1_YN")
    val ccdp1Yn: String = "",

    @Column(name = "RQSP_SPC_PSBL_YN")
    val rqspSpcPsblYn: String = "",

    @Column(name = "CTFN_SUBJ_YN")
    val ctfmSubjYn: String = "",

    @Column(name = "TH1_LN_SCN_CD")
    val th1LnScnCd: String = "",

    @Column(name = "TH2_LN_SCN_CD")
    val th2LnScnCd: String = "",

    @Column(name = "TAXN_SCN_CD")
    val taxnScnCd: String = "",

    @Column(name = "VEHL_REPN_CD")
    val vehlRepnCd: String = "",

    @Column(name = "PSVC1_CD")
    val psvc1Cd: String = "",

    @Column(name = "HDCP_SCN_CD")
    val hdcpScnCd: String = "",

    @Column(name = "CTY_USF_CD")
    val ctyUsfCd: String = "",

    @Column(name = "PACDS1_CD")
    val pacds1Cd: String = "",

    @Column(name = "SALE_USF_CD")
    val saleUsfCd: String = "",

    @Column(name = "SALE_TH1_BODY_CD")
    val saleTh1BodyCd: String = "",

    @Column(name = "SALE_TH2_BODY_CD")
    val saleTh2BodyCd: String = "",

    @Column(name = "SALE_ENG_CD")
    val saleEngCd: String = "",

    @Column(name = "SALE_TRIM_CD")
    val saleTrimCd: String = "",

    @Column(name = "SALE_TM_CD")
    var saleTmCd: String = "",

    @Column(name = "SALE_VER_CD")
    var saleVerCd: String = "",

    @Column(name = "SALE_SCLAS_CD")
    var saleSclasCd: String = "",

    @Column(name = "ORD_CD")
    var ordCd: String = "",

    @Column(name = "MTM_YN")
    var mtmYn: String = "",

    @Column(name = "TXFR_YN")
    var txfrYn: String = "",

    @Column(name = "FMT_CSET_YN")
    var fmtCsetYn: String = "",

    @Column(name = "OORD_YN")
    var oordYn: String = "",

    @Column(name = "SPMT")
    var spmt: Int? = null,

    @Column(name = "PCRM_CTY_PCE")
    var pcrmCtyPce: Int? = null,

    @Column(name = "TMP_CTY_PCE")
    var tmpCtyPce: Int? = null,

    @Column(name = "TMP_PCRM_CTY_PCE")
    var tmpPcrmCtyPce: Int? = null,

    @Column(name = "AS_PCE")
    var asPce: Int? = null,

    @Column(name = "CRM_CARN_CD")
    var crmCarnCd: String = "",

    @Column(name = "APL_YN")
    var aplYn: String = "",

    @Column(name = "HNAM_OORD_YN")
    var hnamOordYn: String = "",

    @Column(name = "CNSG_EXP_SUBJ_YN")
    var cnsgExpSubjYn: String = "",

    @Column(name = "GOAL_SALE_CRT")
    var goalSaleCrt: Int? = null,

    @Column(name = "PLN_CRT")
    var plnCrt: Int? = null,

    @Column(name = "CHAG_YN")
    var chagYn: String = "",

    @Column(name = "ANX_CTY_SCN_CD")
    var anxCtyScnCd: String = "",

    @Column(name = "ANX_CTY_CPND_SBC")
    var anxCtyCpndSbc: String = "",

    @Column(name = "SALE_CAR_CTY_NO")
    var saleCarCtyNo: String = "",

    @Column(name = "ORD_CSMR_NO")
    var ordCsmrNo: String = "",

    @Column(name = "ORD_CAR_CSMR_NO")
    var ordCarCsmrNo: String = "",

    @Column(name = "ORD_PRDN_CAR_NO")
    var ordPrdnCarNo: String = "",

    @Column(name = "ORD_CNTT_NO")
    var ordCnttNo: String = "",

    @Column(name = "ORD_CAR_CSMR_NM")
    var ordCarCsmrNm: String = "",

    @Column(name = "C_CD")
    var cCd: String = "",
)