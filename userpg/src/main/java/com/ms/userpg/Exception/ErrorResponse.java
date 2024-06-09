package com.ms.userpg.Exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private int statusCode;
    private String Message;
    private long timestamp;

}
