package com.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.model.*;
import com.vue.*;

public class ConvertController {
	
	private ConvertModel model;
    private ConvertView view;
    
    public ConvertController(ConvertModel model, ConvertView view) {
        this.model = model;
        this.view = view;
        addCaretListener();
        addItemListener();
    }

    public void run() {
    	view.start();
    }
    public void addCaretListener() {
    	view.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				update();
			}
    	});
    }
    public void addItemListener() {
    	view.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				update();
				
			}
		});
    	
    };
    
    public void update() {
    	try {
    		double amount = Double.parseDouble(view.getAmountFieldText());
    		int idCurrency = view.getcurrenciesListIndex();
    		model.convert(amount,idCurrency);
		} catch (Exception error) {
			
		}
    }

}
