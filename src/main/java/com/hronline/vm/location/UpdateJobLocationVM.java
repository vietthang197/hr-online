package com.hronline.vm.location;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UpdateJobLocationVM implements Serializable {

    @NotBlank(message = "Id không được trống")
    @Size(max = 100, message = "Id không quá 100 ký tự")
    private String id;

    @NotBlank(message = "Địa chỉ làm việc không được trống")
    @Size(max = 100, message = "Địa chỉ làm việc không quá 100 ký tự")
    private String name;
}
