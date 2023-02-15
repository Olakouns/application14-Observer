package com.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;

import com.model.ConvertModel;
import com.model.observer.*;

public class ConvertView extends  Observer  {

	/**
	 * Create subject 
	 */
	private JLabel cfaValue;
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel contentPane;
	private JTextField amountField;
	@SuppressWarnings("rawtypes")
	private JComboBox currenciesList;
	String[] currencies = { "Naira", "Dollar", "Pounds", "Euros", "Francs Guinéen" };

	

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ConvertView(ConvertModel subject) {
		this.subject = subject; 
		this.subject.attach(this);
		
		setTitle("TO CFA Currency Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);

		JPanel inputPanel = new JPanel();
		amountField = (new JTextField(10));
		inputPanel.add(new JLabel("Amount:"));
		inputPanel.add(amountField);
		inputPanel.add(new JLabel("From:"));

		currenciesList = new JComboBox(currencies);


		inputPanel.add(currenciesList);

		JPanel buttonPanel = new JPanel();


		getContentPane().add(inputPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		cfaValue = new JLabel("");
		buttonPanel.add(cfaValue);
		setVisible(false);
		setResizable(false);
	}

	public void start() {
		setVisible(true);
	}

	public void setcfaValue(String cfa) {
		cfaValue.setText(cfa);
	}


	public void addCaretListener(CaretListener caretListener) {
		amountField.addCaretListener(caretListener);
	}
	public void addItemListener(ItemListener itemListener) {
		currenciesList.addItemListener(itemListener);
	}

	public String getAmountFieldText(){
		return amountField.getText();
		
	}
	public int getcurrenciesListIndex() {
		return currenciesList.getSelectedIndex();
	}

	@Override
	public void update() {
		setcfaValue(Double.toString(subject.getResult()));
	}
}
