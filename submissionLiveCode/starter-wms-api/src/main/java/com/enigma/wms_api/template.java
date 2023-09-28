//package com.enigma.wms_api;
//
//public class template {@Getter
//@AllArgsConstructor
//public enum TransactionTypeEnum {
//    EAT_IN("EAT IN"),
//    ONLINE("ONLINE"),
//    TAKE_AWAY("TAKE AWAY");
//
//    private String name;
//
//    public static TransactionTypeEnum getType(String value) {
//        return Arrays.stream(values()).filter(transactionTypeEnum -> transactionTypeEnum.name.equalsIgnoreCase(value))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
//
//    }
//
//    public static TransactionTypeEnum getTypeNumber(String number) {
//        try {
//            return Arrays.stream(values()).filter(transactionTypeEnum -> transactionTypeEnum.ordinal() == Integer.parseInt(number) -1)
//                    .findFirst()
//                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
//        } catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Not Found Transaction Type");
//        }
//    }
//}
//}
