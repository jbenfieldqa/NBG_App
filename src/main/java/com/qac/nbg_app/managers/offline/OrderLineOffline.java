package com.qac.nbg_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.OrderLine;
import com.qac.nbg_app.managers.OrderLineManager;
import com.qac.nbg_app.util.InitialData;

@Stateless
@Default
public class OrderLineOffline implements OrderLineManager{
	
	@Inject
	private InitialData initialData;

	@Override
	public List<OrderLine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistOrderLine(OrderLine o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistOrderLines(ArrayList<OrderLine> os) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderLine findByCustomerOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderLine findByProductId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderLine> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderLine(OrderLine o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderLine(OrderLine o) {
		// TODO Auto-generated method stub
		
	}

}
