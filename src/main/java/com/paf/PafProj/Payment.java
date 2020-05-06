package com.paf.PafProj;

public class Payment {

	private String P_ID;
	private int Paient_id;
	private double P_amount;
	private String P_method;
	private String P_Description;

	// Getters and Setters
	// Payment ID
	public String getP_ID() {
		return P_ID;
	}

	public void setP_ID(String p_ID) {
		P_ID = p_ID;
	}

	
	// Patient ID
	public int getPaient_id() {
		return Paient_id;
	}

	public void setPaient_id(int paient_id) {
		Paient_id = paient_id;
	}

	
	// Amount
	public double getP_amount() {
		return P_amount;
	}

	public void setP_amount(double p_amount) {
		P_amount = p_amount;
	}

	
	// Payment Method
	public String getP_method() {
		return P_method;
	}

	public void setP_method(String p_method) {
		P_method = p_method;
	}

	
	// Description
	public String getP_Description() {
		return P_Description;
	}

	public void setP_Description(String p_Description) {
		P_Description = p_Description;
	}

}
