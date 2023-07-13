package com.example.demo.hobby.service;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.hobby.domain.request.HobbyRequest;
import com.example.demo.hobby.domain.response.HobbyResponse;
import com.example.demo.hobby.repository.HobbyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HobbyService {
    private final HobbyRepository hobbyRepository;
    public List<HobbyResponse> searchHobby(String name){
        List<Hobby> hobbies;
        hobbies = name==null ?  hobbyRepository.findAll() : hobbyRepository.findByLikeName(name);
        return hobbies
                .stream()
                .map(HobbyResponse::from)
                .collect(Collectors.toList());
    }

    public void save(HobbyRequest hobbyRequest){
        hobbyRepository.save(hobbyRequest.toEntity());
    }

    public Hobby findById(Long id){
        return hobbyRepository.findById(id);
    }

    public void delete(Long id){
        Hobby hobby = findById(id);
        hobbyRepository.delete(hobby);
    }

}
