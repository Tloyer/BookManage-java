package book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import book.utils.ResultBody;

import book.service.AIManageService;

@RestController
@RequestMapping("/ai")
public class AIManageController {
    private final AIManageService aimanageService;

    @Autowired
    public AIManageController(AIManageService aimanageService) {
        this.aimanageService = aimanageService;
    }

    @PostMapping("/getChatResponse")
    public ResultBody getChatResponse(@RequestBody ChatRequest request) {
        System.out.println(request.getUserInput());
        String answer = aimanageService.getChatResponse(request.getUserInput());
        return ResultBody.success("获取成功", answer);

    }

    public static class ChatRequest {
        private String userInput;
    
        // Getter and Setter
        public String getUserInput() {
            return userInput;
        }
    
        public void setUserInput(String userInput) {
            this.userInput = userInput;
        }
    }
    
}
