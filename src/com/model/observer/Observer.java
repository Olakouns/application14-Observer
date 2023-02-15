package com.model.observer;

import javax.swing.JFrame;

import com.model.ConvertModel;

@SuppressWarnings("serial")
public abstract class Observer extends JFrame {
	protected ConvertModel subject;
	public abstract void update();
}
