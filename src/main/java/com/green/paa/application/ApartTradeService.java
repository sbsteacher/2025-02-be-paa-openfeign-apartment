package com.green.paa.application;

import com.green.paa.application.model.AptItem;
import com.green.paa.application.model.AptTradeGetReq;
import com.green.paa.application.model.AptTradeResponse;
import com.green.paa.configuration.constants.ConstAptTrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApartTradeService {
    private final AptTradeClient aptTradeClient;
    private final ConstAptTrade constAptTrade;

    public List<AptItem> getAptTradeList(AptTradeGetReq req) {
        AptTradeResponse response = aptTradeClient.getAptTrade(
                  constAptTrade.serviceKey
                , req.getLawdCd()
                , req.getDealYearMon()
                , req.getPageNo()
                , req.getNumOfRows()
        );
        return response.getBody().getItems();
    }

}
