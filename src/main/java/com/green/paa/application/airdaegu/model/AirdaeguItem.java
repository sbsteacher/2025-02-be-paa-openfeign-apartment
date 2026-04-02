package com.green.paa.application.airdaegu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Data
public class AirdaeguItem {
    @JacksonXmlProperty(localName = "DD_AV_VL")
    private String value;          // 일평균 값 (11, 15 등)

    @JacksonXmlProperty(localName = "MEA_ITM")
    private String itemCode;       // 항목 코드 (PM10 등)

    @JacksonXmlProperty(localName = "YYYY_MM_DD")
    private String measureDate;    // 측정 날짜 (20260101)

    @JacksonXmlProperty(localName = "UNT")
    private String unit;           // 단위 (㎍/㎥)

    @JacksonXmlProperty(localName = "MEAOFC_NM")
    private String stationName;    // 측정소명 (수창동)
}
