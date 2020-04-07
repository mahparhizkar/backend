package com.dss.backend.controller;

import com.dss.backend.model.School;
import com.dss.backend.services.SchoolService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/schoolApi")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/school")
    public List<School> get() {
        return schoolService.get();
    }

    @PostMapping("/school")
    public School save(@RequestBody School school) {
        schoolService.save(school);
        return school;
    }

    @GetMapping("/school/{id}")
    public School get(@PathVariable long id) {
        return schoolService.get(id);
    }

    @DeleteMapping("/school/{id}")
    public String delete(@PathVariable long id) {
        schoolService.delete(id);
        return "School removed with id "+id;
    }

    @PutMapping("/school")
    public School update(@RequestBody School school) {
        schoolService.save(school);
        return school;
    }
}
