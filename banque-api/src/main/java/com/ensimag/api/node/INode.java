package com.ensimag.api.node;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.ensimag.api.message.IAck;
import com.ensimag.api.message.IMessage;
import com.ensimag.api.message.IResult;

/**
 * Node of the network
 * 
 * @author guillaume
 * 
 */
public interface INode extends Serializable, Remote {

	/**
	 * @return the id of the node
	 * @throws RemoteException
	 */
	long getId() throws RemoteException;

	/**
	 * Execute the message action on the node if the node is the target,
	 * propagate the message to its neighboors otherwise
	 * 
	 * @param message
	 *            the message to handle
	 * @throws RemoteException
	 */
	void onMessage(IMessage<? extends Serializable> message) throws RemoteException;

	/**
	 * Handles the ack of a given message
	 * 
	 * @param ack
	 *            the ack
	 * @throws RemoteException
	 */
	void onAck(IAck ack) throws RemoteException;

	/**
	 * Add a node as a known neighboor
	 * 
	 * @param neighboor
	 *            the neighboor to add
	 * @throws RemoteException
	 */
	void addNeighboor(INode neighboor) throws RemoteException;

	/**
	 * Remove a neighboor from the node
	 * 
	 * @param neighboor
	 *            the neighboor to remove
	 * @throws RemoteException
	 */
	void removeNeighboor(INode neighboor) throws RemoteException;

	/**
	 * Get the result for the given message
	 * 
	 * @param messageId
	 *            the message id for which a result is waited
	 * @return the result of the sent message
	 */
	List<IResult<? extends Serializable>> getResultForMessage(long messageId) throws RemoteException;

}
