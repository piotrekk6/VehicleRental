package com.krol.shajs.enums_converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color color) {
        if (color == null) return null;
        else {
            switch (color) {
                case RED:
                    return "red";
                case BLUE:
                    return "blue";
                case GREEN:
                    return "green";
                case BLACK:
                    return "black";
                case BROWN:
                    return "brown";
                case ORANGE:
                    return "orange";
                case PURPLE:
                    return "purple";
                case YELLOW:
                    return "yellow";
                default:
                    throw new IllegalArgumentException("Unknown color " + color.toString());
            }
        }
    }

    @Override
    public Color convertToEntityAttribute(String s) {
        if (s == null) return null;
        else {
            switch (s) {
                case "red":
                    return Color.RED;
                case "blue":
                    return Color.BLUE;
                case "green":
                    return Color.GREEN;
                case "black":
                    return Color.BLACK;
                case "brown":
                    return Color.BROWN;
                case "orange":
                    return Color.ORANGE;
                case "purple":
                    return Color.PURPLE;
                case "yellow":
                    return Color.YELLOW;
                default:
                    throw new IllegalArgumentException("Unknown color " + s);
            }
        }
    }
}
