package finance.invoice.entity;

import java.time.LocalDate;

public class TableConstructor {
	private int id;
	private LocalDate i_date;
	private String i_name;
	private float burma;
	private float cmee;
	private float cp;

	private float multBurma;
	private float multCmee;
	private float multCp;

	private int total;
	private int paid;

	public TableConstructor(int id, LocalDate i_date, String i_name, float burma, float cmee, float cp, float multBurma,
			float multCmee, float multCp, int total, int paid) {
		super();
		this.id = id;
		this.i_date = i_date;
		this.i_name = i_name;
		this.burma = burma;
		this.cmee = cmee;
		this.cp = cp;
		this.multBurma = multBurma;
		this.multCmee = multCmee;
		this.multCp = multCp;
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

	public float getBurma() {
		return burma;
	}

	public void setBurma(float burma) {
		this.burma = burma;
	}

	public float getCmee() {
		return cmee;
	}

	public void setCmee(float cmee) {
		this.cmee = cmee;
	}

	public float getCp() {
		return cp;
	}

	public void setCp(float cp) {
		this.cp = cp;
	}

	public float getMultBurma() {
		return multBurma;
	}

	public void setMultBurma(float multBurma) {
		this.multBurma = multBurma;
	}

	public float getMultCmee() {
		return multCmee;
	}

	public void setMultCmee(float multCmee) {
		this.multCmee = multCmee;
	}

	public float getMultCp() {
		return multCp;
	}

	public void setMultCp(float multCp) {
		this.multCp = multCp;
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
