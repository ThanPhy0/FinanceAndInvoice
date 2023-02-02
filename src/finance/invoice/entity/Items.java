package finance.invoice.entity;

import java.time.LocalDate;

public class Items {

	public enum Type {
		InList, OutList
	};

	public enum Kyat {
		burma, cmee, cp, rate, total
	};

	private int id;
	private LocalDate date;
	private String Name;
	private int burma;
	private int cmee;
	private int cp;
	private int rate;
	private int total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getBurma() {
		return burma;
	}

	public void setBurma(int burma) {
		this.burma = burma;
	}

	public int getCmee() {
		return cmee;
	}

	public void setCmee(int cmee) {
		this.cmee = cmee;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
