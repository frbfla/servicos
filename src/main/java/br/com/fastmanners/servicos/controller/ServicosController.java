package br.com.fastmanners.servicos.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fastmanners.servicos.enumeration.TipoSociedade;
import br.com.fastmanners.servicos.model.Evento;
import br.com.fastmanners.servicos.service.EventoService;

@Controller
public class ServicosController {
	
	@Autowired
	private EventoService eventoService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("cadastrarEvento")
	public String cadastrarEvento(Model model) {
		model.addAttribute("sociedades", TipoSociedade.values());
		
		return "cadastrarEvento";
	}
	
	@RequestMapping(value = "salvarEvento", method = RequestMethod.POST )
	public String salvarEvento(@RequestParam("descricao") String descricao, 
			@RequestParam("dataEvento") String dataEvento, @RequestParam("tipoSociedade") Integer tipoSociedade, Model model){
		
		Evento evento = new Evento();
		evento.setDescricao(descricao);
		evento.setTipoSociedade(TipoSociedade.getTipoPorId(Integer.valueOf(tipoSociedade)));
		//evento.setDataEvento();
		evento.setDataPublicacao(new Date());
		
		try{
			this.eventoService.salvar(evento);
				
			model.addAttribute("sucesso", "Evento inserido com sucesso");
		} catch(Exception e){
			model.addAttribute("erro", "Alguma coisa está errada...verifique os dados no formulário");
		}
		return "cadastrarEvento";
	}
}
