package com.mascara.oyo_booking_backend.entities;

import com.mascara.oyo_booking_backend.entities.base.BasePesistence;
import com.mascara.oyo_booking_backend.enums.CommonStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "facility_categories")
public class FacilityCategories extends BasePesistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "faci_cate_name")
    private String faciCateName;

    @Column(name = "faci_cate_code", unique = true)
    private String faciCateCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityCategories")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Facility> facilitySet;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CommonStatusEnum status;
}
