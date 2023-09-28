package com.enigma.wms_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "m_product", schema = "wms_db", catalog = "")
public class MProductEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator",
            strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name = "product_id", nullable = false, length = 100)
    private String productId;

    @Column(name = "product_price_id", nullable = true, length = 100)
    private String productPriceId;

    @Column(name = "product_code", nullable = true, length = 100)
    private String productCode;

    @Column(name = "product_name", nullable = true, length = 100)
    private String productName;

    @Column(name = "price", nullable = true)
    private Long price;

    @Column(name = "branch_id", nullable = true, length = 100)
    private String branchId;
    @OneToMany(mappedBy = "product")

    @JsonManagedReference
    private List<MBranchEntity> mBranch;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
    private MBillEntity bill;


}