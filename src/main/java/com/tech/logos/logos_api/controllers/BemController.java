package com.tech.logos.logos_api.controllers;

import com.tech.logos.logos_api.services.BemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bens")
@RequiredArgsConstructor
public class BemController {
    private final BemService bemService;
}
