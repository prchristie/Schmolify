package com.example.schmolify.presentation;

import com.example.schmolify.application.SchmolService;
import com.example.schmolify.domain.Schmol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.MalformedURLException;
import java.util.List;

record SchmolDTO(String id, String url) {
}

record CreateSchmolRequest(String url) {
}

record CreateSchmolResponse(SchmolDTO schmol) {
}


record GetSchmolResponse(SchmolDTO schmol) {
}

@CrossOrigin
@RestController
@RequestMapping("/api/v1/schmol")
public class SchmolController {

    private final SchmolService schmolService;

    public SchmolController(SchmolService schmolService) {
        this.schmolService = schmolService;
    }

    @PostMapping("")
    public ResponseEntity<CreateSchmolResponse> createSchmol(@RequestBody CreateSchmolRequest req) {
        Schmol schmol;
        try {
            schmol = schmolService.createSchmol(req.url());
        } catch (MalformedURLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid URL");
        }

        return ResponseEntity.ok(new CreateSchmolResponse(schmolEntityToDTO(schmol)));
    }

    private SchmolDTO schmolEntityToDTO(Schmol s) {
        return new SchmolDTO(s.getId().value(), s.getUrl());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSchmolResponse> getSchmol(@PathVariable("id") String id) {
        var schmol = schmolService.getSchmol(id);

        if (schmol == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Schmol not found");
        }

        return new ResponseEntity<>(new GetSchmolResponse(schmolEntityToDTO(schmol)), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<SchmolDTO>> getAllSchmols() {
        List<Schmol> schmols = schmolService.getAllSchmols();
        List<SchmolDTO> schmolDTOs = schmols.stream().map(this::schmolEntityToDTO).toList();

        return new ResponseEntity<>(schmolDTOs, HttpStatus.OK);
    }
}
