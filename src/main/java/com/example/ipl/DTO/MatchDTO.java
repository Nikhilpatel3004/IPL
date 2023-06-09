package com.example.ipl.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {

    private Integer overs;
    @NonNull
    private String electId;
}
