package com.example.ipl.DTO;

import com.example.ipl.Enum.Toss;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TossDTO {
    private String teamName;
    private Toss toss;
}
