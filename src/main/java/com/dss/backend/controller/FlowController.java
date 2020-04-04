package com.dss.backend.controller;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.variable.api.history.HistoricVariableInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class FlowController {

    private RuntimeService runtimeService;
    private HistoryService historyService;

    public FlowController(final RuntimeService runtimeService, final HistoryService historyService) {
        this.runtimeService = runtimeService;
        this.historyService = historyService;
    }

    @PostMapping("/{melicode}/findSchoolByMelicode")
    public ResponseEntity<String> saySomething(@PathVariable("melicode") String melicode) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("melicode", melicode);
        final ProcessInstance process = runtimeService.startProcessInstanceByKey("findSchoolByMelicode", variables);
        final HistoricVariableInstance hvi = historyService.createHistoricVariableInstanceQuery()
                .processInstanceId(process.getId())
                .variableName("result").singleResult();
        String message = (String) hvi.getValue();
        return ResponseEntity.ok(message);
    }
}