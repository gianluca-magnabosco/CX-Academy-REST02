package com.cxacademy.service;

import com.cxacademy.handler.exceptions.ParametroInvalidoException;
import com.cxacademy.handler.exceptions.RecursoNaoEncontradoException;
import com.cxacademy.model.PessoaModel;
import com.cxacademy.model.dto.PessoaDto;
import com.cxacademy.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    private final ModelMapper modelMapper;


    public PessoaServiceImpl(PessoaRepository pessoaRepository, ModelMapper modelMapper) {
        this.pessoaRepository = pessoaRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PessoaDto> findAll() {

        List<PessoaModel> pessoaModels = pessoaRepository.findAll();

        return modelMapper.map(pessoaModels, new TypeToken<List<PessoaDto>>() {
        }.getType());
    }


    @Override
    public PessoaDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        PessoaModel pessoaModel = new PessoaModel();
        try {
            pessoaModel = pessoaRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(pessoaModel, PessoaDto.class);
    }


    @Override
    public PessoaDto insert(PessoaModel pessoaModel) {

        pessoaModel.setId(null);

        validarPessoa(pessoaModel);

        return new PessoaDto(pessoaRepository.save(pessoaModel));
    }


    @Override
    public PessoaDto update(Long id, PessoaModel pessoaModel) {

        if (pessoaModel == null) {
            throw new ParametroInvalidoException("A Pessoa Model deve ser informada!");
        }

        findById(id);

        pessoaModel.setId(id);

        validarPessoa(pessoaModel);

        return new PessoaDto(pessoaRepository.save(pessoaModel));
    }


    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            pessoaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

    }


    private void validarPessoa(PessoaModel pessoaModel) {

        if (pessoaModel.getNome() == null) {
            throw new ParametroInvalidoException("O nome da pessoa deve ser informado!");
        }

        if (pessoaModel.getCpf() == null) {
            throw new ParametroInvalidoException("O cpf da pessoa deve ser informado!");
        }

        if (pessoaModel.getRg() == null) {
            throw new ParametroInvalidoException("O rg da pessoa deve ser informado!");
        }

        if (pessoaModel.getDataNasc() == null) {
            throw new ParametroInvalidoException("A data de nascimento da pessoa deve ser informado!");
        }

        if (pessoaModel.getEstadoCivil() == null) {
            throw new ParametroInvalidoException("O estado civil da pessoa deve ser informado!");
        }

        if (pessoaModel.getTelefone() == null) {
            throw new ParametroInvalidoException("O telefone da pessoa deve ser informado!");
        }

        if (pessoaModel.getEmail() == null) {
            throw new ParametroInvalidoException("O e-mail da pessoa deve ser informado!");
        }
    }

}
