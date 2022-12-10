package com.nepnep.querymaker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SqlEnum {
    SELECT("SELECT "), FROM(" FROM "), WHERE(" WHERE "), EQUALS(" = "), LIKE(" LIKE "), IN(" IN ");

    private final String queryStr;
}
