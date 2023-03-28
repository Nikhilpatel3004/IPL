package com.example.ipl.Controller;

import com.example.ipl.DTO.ElectDTO;
import com.example.ipl.DTO.TossDTO;
import com.example.ipl.Service.TossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toss")
public class TossController {

    @Autowired
    private TossService tossService;

    @PostMapping("/begin")
    public String TossBegin(@RequestBody TossDTO tossDTO){
        return tossService.flipCoin(tossDTO);
    }


    @PostMapping("/elect")
    public String electBatOrBall(@RequestBody ElectDTO electDTO){
       return tossService.electBatOrBall(electDTO);
    }

}
