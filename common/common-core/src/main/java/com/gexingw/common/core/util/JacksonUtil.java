package com.gexingw.common.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author GeXingW
 */
@SuppressWarnings("unused")
public class JacksonUtil {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    @NotNull
    public static String toJson(@NotNull Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public static <T> T toObject(@NotNull String json, @NotNull Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public static <T> T toObject(@NotNull String json, @NotNull Class<T> clazz, Class<?>... parameterClasses) {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructParametricType(clazz, parameterClasses));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
