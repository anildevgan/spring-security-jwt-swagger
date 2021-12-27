package com.devgan.jwtdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String job;
    @Positive
    @Min(value = 0)
    private double salary;

}
