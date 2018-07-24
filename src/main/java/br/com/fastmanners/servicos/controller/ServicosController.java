package br.com.fastmanners.servicos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		model.addAttribute("eventos", this.eventoService.obterTodos());
		
		return "cadastrarEvento";
	}
	
	@RequestMapping(value = "salvarEvento", method = RequestMethod.POST )
	public String salvarEvento(@RequestParam("descricao") String descricao, 
			@RequestParam("dataEvento") String dataEvento, @RequestParam("tipoSociedade") String tipoSociedade, 
			@RequestParam("fotoEvento") MultipartFile fotoEvento, HttpServletRequest request, Model model){
		
		try{
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date data = formato.parse(dataEvento);
			
			Evento evento = new Evento();
			evento.setDescricao(descricao);
			evento.setTipoSociedade(TipoSociedade.getTipoPorId(Integer.valueOf(tipoSociedade)));
			evento.setDataEvento(data);
			evento.setDataPublicacao(new Date());
			evento.setImagemEvento(fotoEvento.getBytes());
			
			this.eventoService.salvar(evento);
			
			model.addAttribute("eventos", this.eventoService.obterTodos());
			model.addAttribute("sucesso", "Evento inserido com sucesso");
			
		} catch(Exception e){
			model.addAttribute("erro", "Alguma coisa está errada...verifique os dados no formulário");
		}
		return "cadastrarEvento";
	}
	
	@RequestMapping("/visualizarFotoEvento/{id}")
	public ResponseEntity<byte[]> visualizarEvento(@PathVariable("id") Long id) {
		Evento evento = this.eventoService.obterEventoPorId(Long.valueOf(id));
		
		HttpHeaders headers = new HttpHeaders();

	    headers.setContentType(MediaType.parseMediaType("image/jpeg"));
	    String filename = "img" + id + ".jpg";

	    headers.add("content-disposition", "inline;filename=" + filename);
	  
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(evento.getImagemEvento(), headers, HttpStatus.OK);
	    return response;
	}
}
