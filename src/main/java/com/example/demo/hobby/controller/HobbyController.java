package com.example.demo.hobby.controller;

import com.example.demo.hobby.domain.request.HobbyRequest;
import com.example.demo.hobby.domain.response.HobbyResponse;
import com.example.demo.hobby.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hobby")
@RequiredArgsConstructor
public class HobbyController {

    private final HobbyService hobbyService;

    @GetMapping
    public List<HobbyResponse> searchHobby(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page){
        return hobbyService.searchHobby(name, page);
    }

    @GetMapping("/{id}")
    public HobbyResponse findById(@PathVariable("id") Long id){
        return HobbyResponse.from(hobbyService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody HobbyRequest hobbyRequest){
        hobbyService.save(hobbyRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        hobbyService.delete(id);
    }

}
