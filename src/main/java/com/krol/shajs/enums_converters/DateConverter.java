package com.krol.shajs.enums_converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Converter
public class DateConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return Optional.ofNullable(localDate).map(Date::valueOf).orElse(null);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);
    }
}