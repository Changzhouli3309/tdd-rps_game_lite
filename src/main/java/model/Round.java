package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Round {
    private String playerMove;
    private String aiMove;
    private String result;

}
