package com.wuming.web.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author manji
 * Created on 2025/3/1 10:36
 */
@Data
public class ResultDTO<T> implements Serializable {

    private T data;
    private Boolean success;
    private String errorCode = "NONE";
    private String errorMessage;
    private Boolean reTry = false;

}
