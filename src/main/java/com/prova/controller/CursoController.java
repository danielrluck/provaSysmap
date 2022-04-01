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

import com.prova.dto.CursoDTO;
import com.prova.dto.CursoDisciplinaDTO;
import com.prova.model.Curso;
import com.prova.model.Disciplina;
import com.prova.model.Log;
import com.prova.repository.CursoRepository;
import com.prova.repository.DisciplinaRepository;
import com.prova.repository.LogRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private LogRepository logRepository;
	

    @Autowired
    private ModelMapper modelMapperCurso;
    
    @Bean
    public ModelMapper modelMapperCurso() {
        return new ModelMapper();
    }
	
	@GetMapping()
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Curso cadastrar(@RequestBody CursoDTO curso) {
		boolean isInsercao = (curso.getCodigo() == 0 );
		Curso c;
		if (isInsercao) {
			c = modelMapperCurso.map(curso, Curso.class);
			c = cursoRepository.save(c);
		} else {
			c = cursoRepository.getById(curso.getCodigo());
			c.setDescricao(curso.getDescricao());
		}
		
		Log l = new Log(isInsercao,curso.getUsuario());
		logRepository.save(l);
		c.getLogs().add(l);
		return cursoRepository.save(c);
	}
	
	@PostMapping("/disciplinas")
	@ResponseStatus(HttpStatus.CREATED)
	public Curso relacionarDisciplinaCurso(@RequestBody CursoDisciplinaDTO cursoDisciplina)  {
		Curso c = null;
		if ((cursoDisciplina.getCodigoCurso() != 0) && (cursoDisciplina.getCodigoDisciplina() != 0)) {
			c =  cursoRepository.getById(cursoDisciplina.getCodigoCurso());
			Disciplina d = disciplinaRepository.getById(cursoDisciplina.getCodigoDisciplina());
			if (c.getDisciplinas().indexOf(d) == -1) {
				c.getDisciplinas().add(d);
				
				Log l = new Log(false,cursoDisciplina.getUsuario());
				logRepository.save(l);
				c.getLogs().add(l);
				cursoRepository.save(c);
			}
		}
		return c;
	}
}
