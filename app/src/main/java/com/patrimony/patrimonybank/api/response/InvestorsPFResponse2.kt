package com.patrimony.patrimonybank.api.response

import com.google.gson.annotations.SerializedName

data class InvestorsPFResponse2(


    @SerializedName("personalID")
    val personalID: Long?,

    @SerializedName("brandName")
    val brandName: String?,

    @SerializedName("civilName")
    val civilName: String?,

    @SerializedName("socialName")
    val socialName: String?,

    @SerializedName("dateTime")
    val dateTime: String?,

    @SerializedName("maritalStatusCode")
    val maritalStatusCode: String?,

    @SerializedName("maritalStatusAdditionalInfo")
    val maritalStatusAdditionalInfo: String?,

    @SerializedName("sex")
    val sex: String?,

    @SerializedName("companyCnpj")
    val companyCnpj: String?,

    @SerializedName("cpf")
    val cpf: String?,

    @SerializedName("hasBrazilianNationality")
    val hasBrazilianNationality: Boolean?,

    @SerializedName("otherNationalitiesInfo")
    val otherNationalitiesInfo: String?,

    @SerializedName("typeDocument")
    val typeDocument: String?,

    @SerializedName("typeAdditionalInfo")
    val typeAdditionalInfo: String?,

    @SerializedName("numberDocument")
    val numberDocument: String?,

    @SerializedName("checkDigit")
    val checkDigit: String?,

    @SerializedName("additionalInfo")
    val additionalInfo: String?,

    @SerializedName("expirationDate")
    val expirationDate: String?,

    @SerializedName("issueDate")
    val issueDate: String?,

    @SerializedName("country")
    val country: String?,

    @SerializedName("typeFiliation")
    val typeFiliation: String?,

    @SerializedName("civilNameFiliation")
    val civilNameFiliation: String?,

    @SerializedName("socialNameFiliation")
    val socialNameFiliation: String?,

    @SerializedName("address")
    val address: String?,

    @SerializedName("additionalInfoAdress")
    val additionalInfoAdress: String?,

    @SerializedName("districtName")
    val districtName: String?,

    @SerializedName("townName")
    val townName: String?,

    @SerializedName("ibgeTownCode")
    val ibgeTownCode: String?,

    @SerializedName("countrySubDivision")
    val countrySubDivision: String?,

    @SerializedName("postCode")
    val postCode: String?,

    @SerializedName("countryAdress")
    val countryAdress: String?,

    @SerializedName("countryCode")
    val countryCode: String?,

    @SerializedName("typePhone1")
    val typePhone1: String?,

    @SerializedName("additionalInfoPhone1")
    val additionalInfoPhone1: String?,

    @SerializedName("countryCallingCode1")
    val countryCallingCode1: String?,

    @SerializedName("areaCodePhone1")
    val areaCodePhone1: String?,

    @SerializedName("numberPhone1")
    val numberPhone1: String?,

    @SerializedName("phoneExtension1")
    val phoneExtension1: String?,

    @SerializedName("typePhone2")
    val typePhone2: String?,

    @SerializedName("additionalInfoPhone2")
    val additionalInfoPhone2: String?,

    @SerializedName("countryCallingCode2")
    val countryCallingCode2: String?,

    @SerializedName("areaCodePhone2")
    val areaCodePhone2: String?,

    @SerializedName("numberPhone2")
    val numberPhone2: String?,

    @SerializedName("phoneExtension2")
    val phoneExtension2: String?,

    @SerializedName("email")
    val email: String?

)
