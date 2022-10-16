package com.example.adtpoapi;

import java.io.Serializable;

public class FiltroVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7320185704350188783L;
	private String categoria;

	public FiltroVO(String categoria) {
		this.categoria = categoria;
	}
	
	public FiltroVO() {}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
