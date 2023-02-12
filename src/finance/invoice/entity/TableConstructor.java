package finance.invoice.entity;

import java.time.LocalDate;

public class TableConstructor {
	private int id;
	private LocalDate i_date;
	private String i_name;
	private int burma;
	private int cmee;
	private int cp;
	private int rate;
	private int total;
	private int paid;

	public TableConstructor(int id, LocalDate i_date, String i_name, int burma, int cmee, int cp, int rate, int total,
			int paid) {
		super();
		this.id = id;
		this.i_date = i_date;
		this.i_name = i_name;
		this.burma = burma;
		this.cmee = cmee;
		this.cp = cp;
		this.rate = rate;
		this.total = total;
		this.paid = paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getI_date() {
		return i_date;
	}

	public void setI_date(LocalDate i_date) {
		this.i_date = i_date;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
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

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

}
