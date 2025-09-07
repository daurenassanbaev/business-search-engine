package com.searchengine.kz.controller;

import com.searchengine.kz.dto.SearchRequestParameters;
import com.searchengine.kz.dto.SearchResponse;
import com.searchengine.kz.dto.SuggestionRequestParameters;
import com.searchengine.kz.service.SearchService;
import com.searchengine.kz.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BusinessSearchController {

    private final SuggestionService suggestionService;
    private final SearchService searchService;

    @GetMapping("/api/suggestions")
    public List<String> suggest(SuggestionRequestParameters parameters){
        return this.suggestionService.fetchSuggestions(parameters);
    }

    @GetMapping("/api/search")
    public SearchResponse search(SearchRequestParameters parameters){
        return this.searchService.search(parameters);
    }



}
