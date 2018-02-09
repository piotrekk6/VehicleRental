package com.krol.shajs.Enum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color color) {
        switch (color)
        {
            case RED: return "red";
            case BLUE: return "blue";
            case GREEN: return "green";
            case BLACK: return "black";
            case BROWN: return "brown";
            case ORANGE: return "orange";
            case PURPLE: return "purple";
            case YELLOW: return "yellow";
            default: return  null;
        }
    }

    @Override
    public Color convertToEntityAttribute(String s) {
        switch (s)
        {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            case "black": return Color.BLACK;
            case "brown": return Color.BROWN;
            case "orange": return Color.ORANGE;
            case "purple": return Color.PURPLE;
            case "yellow": return Color.YELLOW;
            default: return  null;
        }
    }
}
