package com.hronline.util;

import java.util.List;

public interface HrConstant {
    String ATTRIBUTE_SUCCCES_MESSAGE = "successMsg";
    String ATTRIBUTE_ERROR_LIST = "errorList";
    String STR_N = "N";
    String STR_Y = "Y";
    String JD_CODE = "0001";
    String RESUME_CODE = "0002";

    List<String> currencyList = List.of("VND", "USD", "EUR", "JPY", "KRW");
    List<String> jobTypeList = List.of("inoffice", "onsite");

    interface JOB_STATUS {
        String HIRING = "HIRING"; // DANG TIM KIEM
        String CANCELED = "CANCELD"; // BI HUY BO
    }
}
