package com.example.demo.join;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/connect")
public class ConnectController {

    private final ConnectService connectService;

    @PostMapping
    public void connectMemberHobby(@RequestBody ConnectRequest connectRequest){
        connectService.connectMemberHobby(connectRequest);
    }
}
