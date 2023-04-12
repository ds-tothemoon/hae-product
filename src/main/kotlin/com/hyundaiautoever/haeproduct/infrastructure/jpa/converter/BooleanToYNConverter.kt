package com.hyundaiautoever.haeproduct.infrastructure.jpa.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class BooleanToYNConverter : AttributeConverter<Boolean, String> {

    override fun convertToDatabaseColumn(attribute: Boolean?): String {
        return if (attribute == true) "Y" else "N"
    }

    override fun convertToEntityAttribute(dbData: String?): Boolean {
        return dbData?.equals("Y", ignoreCase = true) ?: false
    }
}