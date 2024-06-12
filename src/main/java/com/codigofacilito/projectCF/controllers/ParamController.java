package com.codigofacilito.projectCF.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.codigofacilito.projectCF.models.Equipo;
import com.codigofacilito.projectCF.models.Jugador;
import com.codigofacilito.projectCF.services.IService;

@Controller
public class ParamController {
	
	@Autowired
	@Qualifier("equiposEspania")
	IService equipoService;

	
	@GetMapping("/parametros")
	public String parametros(@RequestParam(defaultValue = "Valor por default") String valor,
							 @RequestParam(defaultValue = "", name="valor_dos") String otroValor,  Model model) {
		
		model.addAttribute("parametro", valor);
		model.addAttribute("titulo", "parametros:");
		model.addAttribute("otroValor", otroValor);
		
		return "parametros"; 
	}
	
	// /equipos/{nombre_equipo}/{numero_jugador}
	// /equipos/Barcelona/9 => lewandoski(9)
	
	@GetMapping("/equipos/{nombre}/{numero}")
	public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model) {
		Optional<Equipo> equipoOptional = equipoService.getTodos().stream()
													.filter(equipo -> 
													nombre.toLowerCase()
													.equals(equipo.getNombre().toLowerCase()))
													.findFirst();
		if(equipoOptional.isPresent()) {
			Optional<Jugador> jugadorOptional = equipoOptional
					.get().getPlantilla().stream() 
					.filter(jugador -> numero == jugador.getNumero()).findFirst();
			
			if(jugadorOptional.isPresent()) {
				model.addAttribute("jugador", jugadorOptional.get());
			}
			
		}
		return "parametros";
	}
	
}
