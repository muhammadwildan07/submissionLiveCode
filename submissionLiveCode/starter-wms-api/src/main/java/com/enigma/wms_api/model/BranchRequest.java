package com.enigma.wms_api.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;



@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class BranchRequest {
    private String branchId;

    @NotBlank(message = "Customer name is required")
    private String address;

    @NotBlank(message = " is required")
    private String brachCode;

    @NotBlank(message = "branch is required")
     private String branchName;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber ;

}
