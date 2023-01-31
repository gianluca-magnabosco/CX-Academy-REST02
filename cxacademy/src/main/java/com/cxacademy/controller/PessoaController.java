package com.cxacademy.controller;

import com.cxacademy.model.PessoaModel;
import com.cxacademy.model.dto.PessoaDto;
import com.cxacademy.service.PessoaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final PessoaServiceImpl pessoaService;

    public PessoaController(PessoaServiceImpl pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaDto>> findAll() {

        List<PessoaDto> response = pessoaService.findAll();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable Long id) {

        PessoaDto response = pessoaService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }


    @PostMapping("/add")
    public ResponseEntity<PessoaDto> insert(@RequestBody PessoaModel pessoaModel) {

        PessoaDto response = pessoaService.insert(pessoaModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> update(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {

        PessoaDto response = pessoaService.update(id, pessoaModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = pessoaService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

}
