package com.searchengine.kz.dto;

import java.util.List;

public record Facet(String name,
                    List<FacetItem> items) {
}

