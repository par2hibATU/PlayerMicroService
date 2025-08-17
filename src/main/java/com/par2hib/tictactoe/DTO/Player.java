package com.par2hib.tictactoe.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    String uniqueId;
    String name;
    String age;
    String password;
}
