package com.transaction.entity;

import com.transaction.commons.Observable;
import com.transaction.commons.Observer;

public class Reciever implements Observer {

	private String name;
	private String contact;
	private String email;
	private BankAccount bank;

	public Reciever(BankAccount bank, String name, String contact, String email) {
		this.bank = bank;
		this.name = name;
		this.contact = contact;
		this.email = email;

	}

	public BankAccount getBank() {
		return bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void getNotify(Transaction transaction) {
		this.bank.getTransactionList().add(transaction);
		System.out.println(transaction);
	}

	@Override
	public void addObservable(Observable subject) {
		subject.registerObserver(this);
	}

	@Override
	public long getAccount() {
		return this.bank.getAccountNumber();
	}

}
