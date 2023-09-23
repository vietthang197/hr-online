package com.hronline.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
public class JobLocationDto implements Serializable {
    private String id;
    private String name;
}
