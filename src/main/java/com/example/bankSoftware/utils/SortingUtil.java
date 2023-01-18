package com.example.bankSoftware.utils;

import org.springframework.data.domain.Sort;


public class SortingUtil {

    public static Sort.Direction getSortDirection(Boolean sortAsc) {
        return Boolean.FALSE.equals(sortAsc) ? Sort.Direction.DESC : Sort.Direction.ASC;

    }
}