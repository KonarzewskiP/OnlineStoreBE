package com.app.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
public class FinishPurchaseRequest {

    @NotNull
    private Map<Long, Integer> productIdProductCount;
    @NotEmpty
    private String name;
    private String surname;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    private String comment;

}
