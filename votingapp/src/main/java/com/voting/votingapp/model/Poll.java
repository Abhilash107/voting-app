package com.voting.votingapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
@Entity
@Data
@NoArgsConstructor

@Schema(name = "Poll Request", description = "Poll object")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    @ElementCollection
    private List<OptionVote> options = new ArrayList<>();

//    @ElementCollection
//    private List<Long> votes = new ArrayList<>();
}
