package com.hronline.vm.jobTitle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UpdateJobTitleVM implements Serializable {

    @NotBlank(message = "Id không được trống")
    @Size(max = 100, message = "Id không quá 100 ký tự")
    private String id;

    @NotBlank(message = "Tên chức vụ không được trống")
    @Size(max = 100, message = "Tên chức vụ không quá 100 ký tự")
    private String name;
}
