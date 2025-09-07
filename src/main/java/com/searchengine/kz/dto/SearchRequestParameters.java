package com.searchengine.kz.dto;

import com.searchengine.kz.exceptions.BadRequestException;
import org.springframework.util.StringUtils;

import java.util.Objects;

public record SearchRequestParameters(String query,
                                      String distance,
                                      Double latitude,
                                      Double longitude,
                                      Double rating,
                                      String state,
                                      String offerings,
                                      Integer page,
                                      Integer size){

    public SearchRequestParameters {
        if(!StringUtils.hasText(query)){
            throw new BadRequestException("query can not be empty");
        }
        page = Objects.requireNonNullElse(page, 0);
        size = Objects.requireNonNullElse(size, 10);
    }

}
