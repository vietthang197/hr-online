package com.hronline.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseObjPagination implements Serializable {
    @NotNull
    private Long draw;
    @NotNull
    private Integer start;
    @NotNull
    private Integer length;
}
