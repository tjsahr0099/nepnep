package com.nepnep.querymaker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum SqlEnum {
    SELECT("SELECT "), FROM(" FROM "), WHERE(" WHERE "), EQUALS(" = "), LIKE(" LIKE "), IN(" IN "),
    COLUMN("column"), TABLE("table"), CONDITION("condition"), VALUE("value");

    private final String queryStr;
}
