package com.prova.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prova.dto.DisciplinaDTO;
import com.prova.model.Disciplina;
import com.prova.model.Log;
import com.prova.repository.DisciplinaRepository;
import com.prova.repository.LogRepository;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private LogRepository logRepository;

    @Autowired
    private ModelMapper modelMapperDisciplina;
    
    @Bean
    public ModelMapper modelMapperDisciplina() {
        return new ModelMapper();
    }
	
	@GetMapping()
	public List<Disciplina> listar(){
		return disciplinaRepository.findAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Disciplina cadastrar(@RequestBody DisciplinaDTO disciplina) {
		
		boolean isInsercao = (disciplina.getCodigo() == 0 );
		Disciplina d;
		if (isInsercao) {
			d = modelMapperDisciplina.map(disciplina, Disciplina.class);
			d = disciplinaRepository.save(d);
		} else {
			d = disciplinaRepository.getById(disciplina.getCodigo());
			d.setDescricao(disciplina.getDescricao());
		}
		
		Log l = new Log(isInsercao,disciplina.getUsuario());
		logRepository.save(l);
		d.getLogs().add(l);
		return disciplinaRepository.save(d);
	}
}
