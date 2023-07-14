package com.example.demo.hobby.service;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.hobby.domain.request.HobbyRequest;
import com.example.demo.hobby.domain.response.HobbyResponse;
import com.example.demo.hobby.repository.HobbyRepository;
import com.example.demo.utility.QueryUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HobbyService {

    private final HobbyRepository hobbyRepository;
    public List<HobbyResponse> searchHobby(String name, Integer page){

        final int PAGE_SIZE = 3;
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        List<Hobby> hobbies = hobbyRepository.findAllFetchByNameContaining("%"+name+"%", pageable);

        return hobbies
                .stream()
                .map(HobbyResponse::from)
                .collect(Collectors.toList());
    }

    public void save(HobbyRequest hobbyRequest){
        hobbyRepository.save(hobbyRequest.toEntity());
    }

    public Hobby findById(Long id){
        return hobbyRepository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        hobbyRepository.deleteById(id);
    }

}
