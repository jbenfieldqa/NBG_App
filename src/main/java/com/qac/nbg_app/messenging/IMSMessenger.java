package com.qac.nbg_app.messenging;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.qac.nbg_app.messenging.messages.PlacedOrder;

public class IMSMessenger {

	public void sendPlacedOrder(PlacedOrder placedOrder) {
		Context context = null;
		Connection connection = null;
		try {
			//Setting up the message destination
			context = new InitialContext();
			
			TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
			Topic queue = (Topic) context.lookup("NBG-App_placedOrders");
			connection = ((QueueConnectionFactory) connectionFactory).createQueueConnection();
			TopicSession session = (TopicSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = ((QueueSession) session).createSender((Queue) queue);
		
			//making the message
			ObjectMessage message = session.createObjectMessage(placedOrder); 
			
			//Send the message
			connection.start();
			sender.send(message);
			connection.stop();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				context.close();
				connection.close();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		
	}
}