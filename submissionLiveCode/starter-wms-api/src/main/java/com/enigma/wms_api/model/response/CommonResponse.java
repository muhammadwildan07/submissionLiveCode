package com.enigma.wms_api.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse<T> {
    private String errors;
    private T data;
    private PagingResponse paging;

}
