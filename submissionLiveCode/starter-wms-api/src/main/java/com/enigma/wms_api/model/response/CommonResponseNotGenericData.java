package com.enigma.wms_api.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommonResponseNotGenericData<T> {
    private String errors;
    private String data;
    private PagingResponse paging;

}
