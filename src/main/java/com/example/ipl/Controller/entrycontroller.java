package com.example.ipl.Controller;


import com.example.ipl.Model.Batsman;
import com.example.ipl.Model.Bowler;
import com.example.ipl.Model.Player;
import com.example.ipl.Model.Team;
import com.example.ipl.Service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add")
public class entrycontroller {


    @Autowired
    private EntryService entryService;
    @PostMapping("/batsman")
    public String addBatsman(@RequestBody Batsman batsman){
        return entryService.addBatsman(batsman);
    }

    @PostMapping("/bowler")
    public String addBowler(@RequestBody Bowler bowler){
        return entryService.addBowler(bowler);
    }

    @PostMapping("/team")
    public String addTeam(@RequestBody Team team){
        return entryService.addTeam(team);
    }
}
