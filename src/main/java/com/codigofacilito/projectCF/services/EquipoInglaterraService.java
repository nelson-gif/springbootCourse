package com.codigofacilito.projectCF.services;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.codigofacilito.projectCF.models.Equipo;
import com.codigofacilito.projectCF.models.Jugador;

@Service
@Primary
public class EquipoInglaterraService implements IService{

	@Override
	public List<Equipo> getTodos() {
		Equipo manchesterUnited = new Equipo();
		manchesterUnited.setNombre("mancherterUnited");
		manchesterUnited.addJugador(new Jugador("GARNACHO", 49));
		
		Equipo manchesterCity = new Equipo();
		manchesterCity.setNombre("manchesterCity");
		manchesterCity.addJugador(new Jugador("J ALVAREZ", 9));
		
		
		return List.of(manchesterUnited, manchesterCity);
	}

}
