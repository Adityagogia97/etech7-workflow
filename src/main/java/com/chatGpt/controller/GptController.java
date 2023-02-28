package com.chatGpt.controller;

import java.util.UUID;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatGpt.dto.ResponseModel;
import com.chatGpt.service.ChatgptService;
import com.chatGpt.service.SlackService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
public class GptController {

    @Autowired
    private ChatgptService chatgptService;
    
    @Autowired
    private SlackService appService;

    @GetMapping("/send")
    public ResponseModel send(HttpServletRequest request, @RequestParam String message) {
        String requestId = UUID.randomUUID().toString();
        log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), message);
        if (!StringUtils.hasText(message)) {
            return ResponseModel.fail("message can not be blank");
        }
        try {
            String responseMessage = chatgptService.sendMessage(message);
            appService.sendMessageToSlack(responseMessage);
            log.info("Response--> requestId {}, ip {}, response : {}", requestId, request.getRemoteHost(), responseMessage);
            return ResponseModel.success(responseMessage);
        } catch (Exception e) {
            log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(),e);
            return new ResponseModel(500, "error", e.getMessage());
        }
    }
    
    @PostMapping("/send/{message}")
    public ResponseEntity<String> sendSimpleMessageToSlack (
            @PathVariable(name = "message") String message) {
        appService.sendMessageToSlack(message);
        return ResponseEntity.ok(message);
    }

}
