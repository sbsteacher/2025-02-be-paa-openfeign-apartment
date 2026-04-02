package com.green.paa.application.airdaegu;

import com.green.paa.application.airdaegu.model.AirdaeguItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airdaegu")
public class AirdaeguController {
    private final AirdaeguService airdaeguService;

    @GetMapping
    public List<AirdaeguItem> getAirdaeguList(@RequestParam String dataDt) {
        return airdaeguService.getAirdaeguList(dataDt);
    }
}
