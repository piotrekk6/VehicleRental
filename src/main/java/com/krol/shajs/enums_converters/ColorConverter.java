package com.krol.shajs.enums_converters;

import com.google.common.collect.*;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

import static com.krol.shajs.enums_converters.Color.*;


@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, String> {

    private ImmutableMap<Color, String> colorToStringMap =  new ImmutableMap.Builder<Color, String>()                                                                      .put(RED, "red")
                                                                       .put(BLUE, "blue")
                                                                       .put(GREEN, "green")
                                                                       .put(BLACK, "black")
                                                                       .put(BROWN, "brown")
                                                                       .put(ORANGE, "orange")
                                                                       .put(PURPLE, "purple")
                                                                       .put(YELLOW, "yellow")
                                                                       .build();

    private Map<String, Color> stringToColorMap = HashBiMap.create(colorToStringMap).inverse();

    @Override
    public String convertToDatabaseColumn(Color color) {
        return colorToStringMap.get(color);
    }

    @Override
    public Color convertToEntityAttribute(String s) {
            return stringToColorMap.get(s);
    }
}
