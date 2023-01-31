package com.cxacademy.service;

import com.cxacademy.model.PessoaModel;
import com.cxacademy.model.dto.PessoaDto;

import java.util.List;

public interface PessoaService {

    List<PessoaDto> findAll();

    PessoaDto findById(Long id);

    PessoaDto insert(PessoaModel pessoaModel);

    PessoaDto update(Long id, PessoaModel pessoaModel);

    boolean delete(Long id);
}
