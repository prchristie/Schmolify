package com.example.schmolify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.MalformedURLException;
import java.net.URL;

record CreateSchmolRequest(String url) {
}

record CreateSchmolResponse(String id) {
}


record GetSchmolResponse(String url) {
}

@RestController
@RequestMapping("/api/v1/schmol")
public class SchmolController {

    @Autowired
    private SchmolService schmolService;

    @PostMapping("")
    public ResponseEntity<CreateSchmolResponse> createSchmol(@RequestBody CreateSchmolRequest req) {
        Schmol schmol = null;
        try {
            schmol = schmolService.createSchmol(new URL(req.url()));
        } catch (MalformedURLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid URL");
        }

        return ResponseEntity.ok(new CreateSchmolResponse(schmol.getId().getValue()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSchmolResponse> getSchmol(@PathVariable("id") String id) {
        var schmol = schmolService.getSchmol(SchmolId.create(id));

        return new ResponseEntity<>(new GetSchmolResponse(schmol.getUrl().toString()), HttpStatus.OK);
    }
}
