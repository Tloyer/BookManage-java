package book.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import book.service.AIManageService;


@Service    
public class AIManageServiceImpl implements AIManageService{

        private final String API_URL = "https://open.bigmodel.cn/api/paas/v4/chat/completions"; // GLM API的地址
        private final String API_KEY = ""; // 替换为API Key

        @Override
        public String getChatResponse(String userInput) {
            RestTemplate restTemplate = new RestTemplate();

            // 构建请求头
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + API_KEY);
            headers.set("Content-Type", "application/json");
            
            // 构建请求体
            String requestBody = "{"
                    + "\"model\": \"glm-4-plus\","
                    + "\"messages\": ["
                    + "{\"role\": \"user\", \"content\": \"" + userInput + "\"}"
                    + "]"
                    + "}";
            
            // 发送请求
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);

            // 获取返回的结果
            System.out.println(response.getBody());
            return response.getBody();
        }
}
