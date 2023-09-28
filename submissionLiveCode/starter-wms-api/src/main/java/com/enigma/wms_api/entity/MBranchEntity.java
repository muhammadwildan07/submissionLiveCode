package com.enigma.wms_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "m_branch", schema = "wms_db", catalog = "")
public class MBranchEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "branch_id")
    private String branchId;
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Column(name = "branch_code", nullable = false, length = 255)
    private String branchCode;

    @Column(name = "branch_name", nullable = false, length = 255)
    private String branchName;

    @Column(name = "phone_number", nullable = false, length = 255)
    private String phoneNumber;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id")
    private MProductEntity product;
}