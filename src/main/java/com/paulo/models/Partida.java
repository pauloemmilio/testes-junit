package com.paulo.models;

public class Partida {

	private Time time1;
	private Time time2;
	private Integer golsTime1;
	private Integer golsTime2;
	
	public Partida() {}

	public Partida(Time time1, Time time2, Integer golsTime1, Integer golsTime2) {
		this.time1 = time1;
		this.time2 = time2;
		this.golsTime1 = golsTime1;
		this.golsTime2 = golsTime2;
	}

	public Time getTime1() {
		return time1;
	}

	public void setTime1(Time time1) {
		this.time1 = time1;
	}

	public Time getTime2() {
		return time2;
	}

	public void setTime2(Time time2) {
		this.time2 = time2;
	}

	public Integer getGolsTime1() {
		return golsTime1;
	}

	public void setGolsTime1(Integer golsTime1) {
		this.golsTime1 = golsTime1;
	}

	public Integer getGolsTime2() {
		return golsTime2;
	}

	public void setGolsTime2(Integer golsTime2) {
		this.golsTime2 = golsTime2;
	}
	
}
