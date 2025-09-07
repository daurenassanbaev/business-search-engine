package com.searchengine.kz.service;

import com.searchengine.kz.dto.SuggestionRequestParameters;
import com.searchengine.kz.util.Constants;
import com.searchengine.kz.util.NativeQueryBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.suggest.response.Suggest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuggestionService {

    private final ElasticsearchOperations elasticsearchOperations;

    public List<String> fetchSuggestions(SuggestionRequestParameters parameters) {
        log.info("Suggestion request: {}", parameters);
        var query = NativeQueryBuilder.toSuggestQuery(parameters);
        var searchHits = this.elasticsearchOperations.search(query, Object.class, Constants.Index.SUGGESTION);
        return Optional.ofNullable(searchHits.getSuggest())
                .map(s -> s.getSuggestion(Constants.Suggestion.SUGGEST_NAME))
                .stream()
                .map(Suggest.Suggestion::getEntries)
                .flatMap(Collection::stream)
                .map(Suggest.Suggestion.Entry::getOptions)
                .flatMap(Collection::stream)
                .map(Suggest.Suggestion.Entry.Option::getText)
                .toList();
    }
}
