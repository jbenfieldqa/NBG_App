package com.qac.nbg_app.controllers;

import java.io.Serializable;

import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.util.InitialData;

@Named("stock")

public class StockController<Stock> implements Serializable{
	@Inject
	private DataModel<Stock> stocklist = null;

}
