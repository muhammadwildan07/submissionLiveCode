package com.enigma.wms_api.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BranchResponse {
    private String branchId;
    private String branchCode;
    private String branch_Name;
    private String address;
    private String phoneNumber;
//    private String email;
//    private String mobilePhone;
//    private Integer address;
}