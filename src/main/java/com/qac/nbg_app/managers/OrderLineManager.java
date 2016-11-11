package com.qac.nbg_app.managers;

import java.util.ArrayList;
import java.util.List;

import com.qac.nbg_app.entities.OrderLine;

public interface OrderLineManager {
	public List<OrderLine> findAll();
	
	void persistOrderLine(OrderLine o);
	
	void persistOrderLines(ArrayList<OrderLine> os);

	OrderLine findByCustomerOrderId(int orderId);
	
	OrderLine findByProductId(int orderId);

	ArrayList<OrderLine> getEntities();

	void updateOrderLine(OrderLine o);

	void removeOrderLine(OrderLine o);

}
