package com.enigma.wms_api.entity;//package com.enigma.wms_api.entity;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.GenericGenerator;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder(toBuilder = true)
//@Entity
//@Table(name = "m_bill", schema = "wms_db", catalog = "")
//public class MBillEntity {
//    @Id
//    @GeneratedValue(generator = "uuid-hibernate-generator")
//    @GenericGenerator(name = "uuid-hibernate-generator",
//            strategy = "org.hibernate.id.UUIDGenerator")
//
//    @Column(name = "bill_id", nullable = false, length = 100)
//    private String billId;
//
//    @Column(name = "receipt_number", nullable = true, length = 100)
//    private String receiptNumber;
//
//    @Column(name = "trans_date", nullable = true)
//    private Timestamp transDate;
//
//    @Column(name = "transaction_type", nullable = true, length = 100)
//    private String transactionType;
//
//    @Column(name = "bill_detail_id", nullable = true, length = 100)
//    private String billDetailId;
//
//
//
//
//
//
//
//
//
//    @OneToMany(mappedBy = "bill")
//    @JsonManagedReference
//    private List<MProductEntity> mProductsByBranchId;
//
////    @OneToMany(mappedBy = )
////    @JoinColumn(name = "bill_detail_id")
////    private List<TransactionEntity> transaction;
//}

import com.enigma.wms_api.entity.TransactionEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "bill_detail")
public class MBillEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "bill_detail_id", nullable = false, length = 100)
    private String billDetailId;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transaction;

    @Column(name = "product_price_id", nullable = false, length = 100)
    private String productPriceId;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
