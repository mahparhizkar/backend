package com.dss.backend.controller;

import com.dss.backend.services.LinkService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/linkApi")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/link/{id}")
    public long get(@PathVariable long id) {
        return linkService.getSchoolIdByStudentId(id);
    }
}
