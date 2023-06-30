package com.hronline.util;

import com.hronline.obj.DataType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HrUtils {
    private static final Logger logger = LogManager.getLogger();

    public static Object getValueOfDataType(String value, DataType dataType, String format) {
        switch (dataType) {
            case BYTE:
                return Byte.valueOf(value);
            case SHORT:
                return Short.valueOf(value);
            case CHAR:
                return value == null ? null : value.charAt(0);
            case INTEGER:
                return Integer.valueOf(value);
            case FLOAT:
                return Float.valueOf(value);
            case LONG:
                return Long.valueOf(value);
            case DOUBLE:
                return Double.valueOf(value);
            case DATE:
                try {
                    return DateUtils.toDate(value, format);
                } catch (Exception e) {
                    logger.error("Lỗi parse datatype", e);
                    return null;
                }
            default:
                return value;
        }
    }
}
