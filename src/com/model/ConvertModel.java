package com.model;

import java.util.ArrayList;

import com.model.observer.*;

public class ConvertModel {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private double amount;
    private String currency ;
    private double result;
    private Double[] currenciesRate = { 1.31, 602.07, 744.12, 655.29, 0.071 };
	

    
    
    public void setAmount(double amount) {
        this.amount = amount;

    }

    public double getAmount() {
        return amount;
    }

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getResult() {
		return result;
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers(){
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
	public void convert(double amount, int idCurrency) {
		result = amount * currenciesRate[idCurrency];
    	notifyAllObservers();

	}

}
