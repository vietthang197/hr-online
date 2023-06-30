package com.hronline.exception;

/**
 * @author thanglv on 4/10/2022
 * @project recruiter-api
 */
public class SearchEngineException extends RuntimeException {
    public SearchEngineException(String msg) {
        super(msg);
    }
}
