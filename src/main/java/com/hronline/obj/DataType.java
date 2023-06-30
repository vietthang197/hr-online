package com.hronline.obj;

public enum DataType {
    BYTE,
    SHORT,
    CHAR,
    INTEGER,
    FLOAT,
    LONG,
    DOUBLE,
    DATE,
    STRING;

    public static DataType getDataType(String dataType) {
        switch (dataType) {
            case "BYTE":
            case "byte":
                return BYTE;
            case "SHORT":
            case "short":
                return SHORT;
            case "CHAR":
            case "char":
                return CHAR;
            case "INTEGER":
            case "integer":
                return INTEGER;
            case "FLOAT":
            case "float":
                return FLOAT;
            case "LONG":
            case "long":
                return LONG;
            case "DOUBLE":
            case "double":
                return DOUBLE;
            case "DATE":
            case "date":
                return DATE;
            default:
                return STRING;
        }
    }
}
