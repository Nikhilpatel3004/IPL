package com.example.ipl.Controller;

import com.example.ipl.DTO.MatchDTO;
import com.example.ipl.DTO.MatchResultDTO;
import com.example.ipl.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {
     @Autowired
    private MatchService matchService;

     @PostMapping("/start")
    public MatchResultDTO matchStart(@RequestBody MatchDTO matchDTO){
         return matchService.matchStart(matchDTO);
     }
}
