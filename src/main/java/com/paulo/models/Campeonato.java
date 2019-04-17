package com.paulo.models;

import java.util.List;

import com.paulo.exceptions.PartidaInvalidaException;
import com.paulo.exceptions.ResultadoInvalidoException;
import com.paulo.exceptions.TimeNaoEncontradoException;

public class Campeonato {
	
	List<Time> times;
	List<Partida> partidas;
	
	public Campeonato() {}
	
	public Campeonato(List<Time> times, List<Partida> partidas) {
		this.times = times;
		this.partidas = partidas;
	}

	public List<Time> getTimes() { return times; }

	public void setTimes(List<Time> times) { this.times = times; }

	public List<Partida> getPartidas() { return partidas; }

	public void setPartidas(List<Partida> partidas) { this.partidas = partidas; }
	
	public Time getTimeById(Integer id) throws TimeNaoEncontradoException {
		for(Time time: times) {
			if(time.getId() == id) return time;
		}
		throw new TimeNaoEncontradoException();
	}
	
	public void salvarPartida(Partida partida){
		List<Time> times = getTimes();
		Time time1 = partida.getTime1();
		Time time2 = partida.getTime2();
		Integer golsTime1 = partida.getGolsTime1();
		Integer golsTime2 = partida.getGolsTime2();
		if(time1 == null || time2 == null || !times.contains(time1) || !times.contains(time2)) {
			throw new TimeNaoEncontradoException();
		}
		else if(time1.equals(time2)) {
			throw new PartidaInvalidaException();
		}
		else if(golsTime1 == null || golsTime2 == null || golsTime1 < 0 || golsTime2 < 0) {
			throw new ResultadoInvalidoException();
		}
		else {
			getPartidas().add(partida);
		}
	}
}
