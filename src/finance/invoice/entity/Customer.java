package finance.invoice.entity;

import java.time.LocalDate;

public class Customer {

	public enum Type {
		InList, OutList
	};

	public enum Kyat {
		burma, cmee, cp, rate, total
	};

	private int id;
	private LocalDate date;
	private String Name;
	private int rate;
	private int total;
	private int paid;

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
