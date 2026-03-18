package com.voting.votingapp.controllers;

import com.voting.votingapp.model.Poll;
import com.voting.votingapp.request.Vote;
import com.voting.votingapp.services.PollService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
@Tag(name = "Poll APIs", description = "Operations related to voting polls")

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class PollController {
    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @Operation(summary = "Create a new poll")
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @Operation(summary = "Get all polls")
    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @Operation(summary = "Get poll by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id) {
        return pollService.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Vote on a poll")
    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote) {
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}
