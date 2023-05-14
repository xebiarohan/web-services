package com.rohan.springboot.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        return getMappingJacksonValue(mapping, new HashSet<>(Arrays.asList("field1", "field3")));
    }


    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringLint() {
        List<SomeBean> beanList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
        MappingJacksonValue mapping = new MappingJacksonValue(beanList);
        return getMappingJacksonValue(mapping, new HashSet<>(Arrays.asList("field2", "field3")));
    }

    private static MappingJacksonValue getMappingJacksonValue(MappingJacksonValue mapping, Set<String> fields) {

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);

        mapping.setFilters(filters);
        return mapping;
    }
}
