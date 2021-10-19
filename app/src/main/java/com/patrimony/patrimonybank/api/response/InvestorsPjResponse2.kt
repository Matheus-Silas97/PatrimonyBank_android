package com.patrimony.patrimonybank.api.response

import com.google.gson.annotations.SerializedName

data class InvestorsPjResponse2(

    @SerializedName("ID")
    val ID: Long,

    @SerializedName("brandName")
    val brandName: String,

    @SerializedName("companyName")
    val companyName : String,

    @SerializedName("tradeName")
    val tradeName: String,

    @SerializedName("IncorporationDate")
    val IncorporationDate: String,

    @SerializedName("cnpjNumber")
    val cnpjNumber: String,

    @SerializedName("partieSocialName")
    val partieSocialName: String,

    @SerializedName("partieDocumentNumber")
    val partieDocumentNumber: String,

    @SerializedName("adress")
    val adress: String,

    @SerializedName("adressAdditionalInfo")
    val adressAdditionalInfo: String,

    @SerializedName("adressDistrictName")
    val adressDistrictName: String,

    @SerializedName("adressTownName")
    val adressTownName: String,

    @SerializedName("adressIbgeTownCode")
    val adressIbgeTownCode: String,

    @SerializedName("adressPostCode")
    val adressPostCode: String,

    @SerializedName("adressCountry")
    val adressCountry: String,

    @SerializedName("adressCountryCode")
    val adressCountryCode: String,

    @SerializedName("phonesType")
    val phonesType: String,

    @SerializedName("phonesAdditionalInfo")
    val phonesAdditionalInfo: String,

    @SerializedName("phonesCountryCallingCode")
    val phonesCountryCallingCode: String,

    @SerializedName("phonesAreaCode")
    val phonesAreaCode: String,

    @SerializedName("phonesNumber")
    val phonesNumber: String,

    @SerializedName("phonesExtension")
    val phonesExtension: String,

    @SerializedName("email")
    val email: String



)
