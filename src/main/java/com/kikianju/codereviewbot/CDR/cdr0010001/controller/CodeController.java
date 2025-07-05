package com.kikianju.codereviewbot.CDR.cdr0010001.controller;

import com.kikianju.codereviewbot.CDR.cdr0010001.dto.CDR0010001_Input;
import com.kikianju.codereviewbot.CDR.cdr0010001.dto.CDR0010001_Output;
import com.kikianju.codereviewbot.CDR.cdr0010001.service.codeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cdr0010001")
@RequiredArgsConstructor
public class CodeController {

    private final codeService service;

    @PostMapping("/analyze")
    public CDR0010001_Output analyze(@RequestBody CDR0010001_Input input) {
        CDR0010001_Output result = new CDR0010001_Output();

        result.setId("jhan1012");
        return result;
    }
}
