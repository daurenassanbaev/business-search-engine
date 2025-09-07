package com.searchengine.kz.dto;

public record Pagination(int page,
                         int size,
                         long totalElements,
                         int totalPages) {
}
