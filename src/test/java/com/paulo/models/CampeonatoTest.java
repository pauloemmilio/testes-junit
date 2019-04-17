package com.paulo.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.paulo.exceptions.PartidaInvalidaException;
import com.paulo.exceptions.ResultadoInvalidoException;
import com.paulo.exceptions.TimeNaoEncontradoException;

public class CampeonatoTest {

	List<Time> times = new ArrayList<Time>();
	List<Partida> partidas = new ArrayList<Partida>();
	Campeonato campeonato;
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Cria uma lista de times que serão utilizados nos testes
	 */
	@Before
	public void setUp() {
		Time time1 = new Time(1, "São Paulo");
		Time time2 = new Time(2, "Corinthians");
		Time time3 = new Time(3, "Santos");
		Time time4 = new Time(4, "Palmeiras");
		times.add(time1);
		times.add(time2);
		times.add(time3);
		times.add(time4);
		campeonato = new Campeonato(times, partidas);
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Remove todos os times e partidas que foram utilizados em um teste
	 */
	@After
	public void tearDown() {
		times.removeAll(times);
		partidas.removeAll(partidas);
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Verifica se a funcionalidade de buscar um time por id está retornando o time correto
	 */
	@Test
	public void deveRetornarTime() {
		/* EXECUÇÃO */
		Time time = campeonato.getTimeById(1);
		/* VERIFICAÇÃO */
		assertEquals(time, campeonato.getTimes().get(0));
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Verifica se a funcionalidade de buscar time por id lança uma exceção quando o time não é encontrado
	 */
	@Test
	public void deveLancarExcecaoSeNaoEncontrarTime() {
		try {
			/* EXECUÇÃO */
			campeonato.getTimeById(0);
			fail();
		} catch (TimeNaoEncontradoException e) {
			/* VERIFICAÇÃO */
			assertEquals(TimeNaoEncontradoException.MSG_PADRAO, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Verifica se uma partida válida será salva corretamente
	 */
	@Test
	public void deveAceitarPartida() {		
		/* MONTAGEM DO CENÁRIO */
		Time time1 = campeonato.getTimeById(1);
		Time time2 = campeonato.getTimeById(2);
		Partida partida = new Partida(time1, time2, 1, 1);
		/* EXECUÇÃO */
		campeonato.salvarPartida(partida);
		/* VERIFICAÇÃO */
		assertEquals(partida, campeonato.getPartidas().get(0));
		assertEquals(1, campeonato.getPartidas().size());
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Verifica se a funcionalidade de salvar uma partida lança uma exceção caso um dos times seja nulo
	 */
	@Test
	public void deveLancarExcecaoSeTimeForNulo() {
		/* MONTAGEM DO CENÁRIO */
		Time time1 = campeonato.getTimeById(1);
		Partida partida = new Partida(time1, null, 1, 1);
		try {
			/* EXECUÇÃO */
			campeonato.salvarPartida(partida);
			fail();
		} catch (TimeNaoEncontradoException e) {
			/* VERIFICAÇÃO */
			assertEquals(TimeNaoEncontradoException.MSG_PADRAO, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Verifica se a funcionalidade de salvar uma partida lança uma exceção se os times forem iguais
	 */
	@Test
	public void deveLancarExcecaoSeTimeIgual() {
		/* MONTAGEM DO CENÁRIO */
		Time time1 = campeonato.getTimeById(1);
		Time time2 = campeonato.getTimeById(1);
		Partida partida = new Partida(time1, time2, 1, 1);
		try {
			/* EXECUÇÃO */
			campeonato.salvarPartida(partida);
			fail();
		} catch (PartidaInvalidaException e) {
			/* VERIFICAÇÃO */
			assertEquals(PartidaInvalidaException.MSG_PADRAO, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Verifica se a funcionalidade de salvar uma partida lança uma exceção caso um dos gols de um time seja nulo
	 */
	@Test
	public void deveLancarExcecaoSeResultadoForNulo() {
		/* MONTAGEM DO CENÁRIO */
		Time time1 = campeonato.getTimes().get(0);
		Time time2 = campeonato.getTimes().get(1);			
		Partida partida = new Partida(time1, time2, 1, null);
		try {
			/* EXECUÇÃO */
			campeonato.salvarPartida(partida);
		} catch (ResultadoInvalidoException e) {
			/* VERIFICAÇÃO */
			assertEquals(ResultadoInvalidoException.MSG_PADRAO, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @author Paulo Emílio
	 * 
	 * Verifica se a funcionalidade de salvar time lança exceção se um dos times possuir valor negativo de gols
	 */
	@Test
	public void deveLancarExcecaoSeResultadoForInvalido() {
		/* MONTAGEM DO CENÁRIO*/
		Time time1 = campeonato.getTimes().get(0);
		Time time2 = campeonato.getTimes().get(1);			
		Partida partida = new Partida(time1, time2, -1, 1);
		try {
			/* EXECUÇÃO */
			campeonato.salvarPartida(partida);
		} catch (ResultadoInvalidoException e) {
			/* VERIFICAÇÃO */
			assertEquals(ResultadoInvalidoException.MSG_PADRAO, e.getMessage());
		}
	}
}
