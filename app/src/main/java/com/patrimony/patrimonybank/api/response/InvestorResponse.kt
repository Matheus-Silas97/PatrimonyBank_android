package com.patrimony.patrimonybank.api.response

import com.google.gson.annotations.SerializedName

data class InvestorResponse(

    @SerializedName("personalID")
    val personalID: Long,

    @SerializedName("brandName")
    val brandName: String,

    @SerializedName("civilName")
    val civilName: String,

    @SerializedName("socialName")
    val socialName: String,

    @SerializedName("dateTime")
    val dateTime: String,

    @SerializedName("maritalStatusCode")
    val maritalStatusCode: String,

    @SerializedName("maritalStatusAdditionalInfo")
    val maritalStatusAdditionalInfo: String,

    @SerializedName("sex")
    val sex: String,

    @SerializedName("companyCnpj")
    val companyCnpj: List<CompanyCnpj>,

    @SerializedName("document")
    val document: Document,

    @SerializedName("otherDocuments")
    val otherDocuments: List<OtherDocuments>,

    @SerializedName("hasBrazilianNationality")
    val hasBrazilianNationality: Boolean,

    @SerializedName("nationality")
    val nationality: List<Nationality>,

    @SerializedName("filiation")
    val filiation: List<Filiation>,

    @SerializedName("contacts")
    val contacts: Contacts

) {

    data class CompanyCnpj(
        @SerializedName("cnpj")
        val cnpj: String
    )

    data class Document(

        @SerializedName("cpfNumber")
        val cpfNumber: String,

        @SerializedName("passportNumber")
        val passportNumber: String,

        @SerializedName("passportExpirationDate")
        val passportExpirationDate: String,

        @SerializedName("passportIssueDate")
        val passportIssueDate: String
    )

    data class OtherDocuments(

        @SerializedName("type")
        val type: String,

        @SerializedName("typeAdditionalInfo")
        val typeAdditionalInfo: String,

        @SerializedName("number")
        val number: String,

        @SerializedName("checkDigit")
        val checkDigit: String,

        @SerializedName("additionalInfo")
        val additionalInfo: String,

        @SerializedName("expirationDate")
        val expirationDate: String,

        @SerializedName("issueDate")
        val issueDate: String,

        @SerializedName("country")
        val country: String
    )

    data class Nationality(

        @SerializedName("id")
        val id: Long,

        @SerializedName("otherNationalitiesInfo")
        val otherNationalitiesInfo: String,

        @SerializedName("documents")
        val documents: List<OtherDocuments>
    )

    data class Filiation(

        @SerializedName("type")
        val type: String,

        @SerializedName("civilName")
        val civilName: String,

        @SerializedName("socialName")
        val socialName: String
    )

    data class Contacts(

        @SerializedName("id")
        val id: Long,

        @SerializedName("postalAdresses")
        val postalAdresses: List<PostalAdresses>,

        @SerializedName("phones")
        val phones: List<Phones>,

        @SerializedName("emails")
        val emails: List<Emails>
    )

    data class PostalAdresses(

        @SerializedName("isMain")
        val isMain: Boolean,

        @SerializedName("address")
        val address: String,

        @SerializedName("additionalInfo")
        val additionalInfo: String,

        @SerializedName("districtName")
        val districtName: String,

        @SerializedName("townName")
        val townName: String,

        @SerializedName("ibgeTownCode")
        val ibgeTownCode: String,

        @SerializedName("countrySubDivision")
        val countrySubDivision: String,

        @SerializedName("postCode")
        val postCode: String,

        @SerializedName("country")
        val country: String,

        @SerializedName("countryCode")
        val countryCode: String,

        @SerializedName("geographicCoordinates")
        val geographicCoordinates: GeographicCoordinates

    )

    data class GeographicCoordinates(

        @SerializedName("id")
        val id: Long,

        @SerializedName("latitude")
        val latitude: String,

        @SerializedName("longitude")
        val longitude: String
    )

    data class Phones(

        @SerializedName("isMain")
        val isMain: Boolean,

        @SerializedName("type")
        val type: String,

        @SerializedName("additionalInfo")
        val additionalInfo: String,

        @SerializedName("countryCallingCode")
        val countryCallingCode: String,

        @SerializedName("areaCode")
        val areaCode: String,

        @SerializedName("number")
        val number: String,

        @SerializedName("phoneExtension")
        val phoneExtension: String
    )

    data class Emails(

        @SerializedName("isMain")
        val isMain: Boolean,

        @SerializedName("email")
        val email: String

    )
}