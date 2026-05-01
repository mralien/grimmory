package org.booklore.app.convertor;

import org.apache.tika.utils.StringUtils;
import org.jspecify.annotations.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class StringToSortMapConvertor implements Converter<String, Map<String, Sort.Direction>> {
    private static final ObjectMapper om = new ObjectMapper();

    @Override
    public Map<String, Sort.Direction> convert(@Nullable String src) {
        if (StringUtils.isBlank(src)) {
            return Collections.emptyMap();
        }
        return om.readValue(src, new TypeReference<LinkedHashMap<String, Sort.Direction>>() {
        });
    }
}
