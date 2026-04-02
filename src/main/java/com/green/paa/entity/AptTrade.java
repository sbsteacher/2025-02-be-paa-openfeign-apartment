package com.green.paa.entity;

import com.green.paa.application.model.AptItem;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "apt_trade", uniqueConstraints = {
        @UniqueConstraint(
                name = "uq_apt_trade_identity",
                columnNames = {"jibun", "sgg_cd", "deal_amount", "deal_date", "floor", "apt_dong"}
        )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AptTrade {

    public AptTrade(AptItem item) {
        this.aptDong = item.getAptDong();
        this.aptNm = item.getAptNm();
        this.buildYear = item.getBuildYear();
        this.buyerGbn = item.getBuyerGbn();
        this.cdealDay = item.getCdealDay();
        this.cdealType = item.getCdealType();
        this.dealAmount = Long.parseLong(item.getDealAmount().replaceAll(",", "").trim());
        this.dealDate = LocalDate.of(
                Integer.parseInt(item.getDealYear()),
                Integer.parseInt(item.getDealMonth()),
                Integer.parseInt(item.getDealDay())
        );
        this.dealingGbn = item.getDealingGbn();
        this.estateAgentSggNm = item.getEstateAgentSggNm();
        this.excluUseAr = new BigDecimal(item.getExcluUseAr());
        this.floor = (item.getFloor() != null && !item.getFloor().trim().isEmpty()) ? Integer.parseInt(item.getFloor().trim()) : null;
        this.jibun = item.getJibun();
        this.landLeaseholdGbn = item.getLandLeaseholdGbn();
        this.rgstDate = item.getRgstDate();
        this.roadNm = item.getRoadNm();
        this.sggCd = item.getSggCd();
        this.slerGbn = item.getSlerGbn();
        this.umdNm = item.getUmdNm();
    }

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apt_dong", length = 50, nullable = false)
    private String aptDong;

    @Column(name = "apt_nm", length = 100, nullable = false)
    private String aptNm;

    @Column(name = "build_year", length = 4)
    private String buildYear;

    @Column(name = "buyer_gbn", length = 20)
    private String buyerGbn;

    @Column(name = "cdeal_day", length = 20)
    private String cdealDay;

    @Column(name = "cdeal_type", length = 20)
    private String cdealType;

    @Column(name = "deal_amount", nullable = false)
    private Long dealAmount; // 만원 단위 (쉼표 제거 후 저장)

    @Column(name = "deal_date", nullable = false)
    private LocalDate dealDate; // 년, 월, 일을 합친 날짜

    @Column(name = "dealing_gbn", length = 50)
    private String dealingGbn;

    @Column(name = "estate_agent_sgg_nm", length = 255)
    private String estateAgentSggNm;

    @Column(name = "exclu_use_ar", precision = 10, scale = 4, nullable = false)
    private BigDecimal excluUseAr;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "jibun", length = 20, nullable = false)
    private String jibun;

    @Column(name = "land_leasehold_gbn", length = 1)
    private String landLeaseholdGbn;

    @Column(name = "rgst_date", length = 20)
    private String rgstDate;

    @Column(name = "road_nm", length = 100)
    private String roadNm;

    @Column(name = "sgg_cd", length = 10, nullable = false)
    private String sggCd;

    @Column(name = "sler_gbn", length = 20)
    private String slerGbn;

    @Column(name = "umd_nm", length = 50)
    private String umdNm;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}
