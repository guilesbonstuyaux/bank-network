package com.ensimag.api.bank;

import java.io.Serializable;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.ensimag.api.message.IResult;

/**
 * Interface that defines a Bank
 * 
 * @author guillaume
 * 
 */
public interface IBank {

	/**
	 * Get the result for the given message id
	 * 
	 * @param messageId
	 *            the message id to get the message for
	 * @return all the result for the message
	 */
	public List<IResult<? extends Serializable>> getResultForMessage(final long messageId);

	/**
	 * Deliver a result to a bank
	 * 
	 * @param result
	 *            the result to deliver
	 * @return <code>true</code> if the result is delivered, <code>false</code>
	 *         otherwise
	 */
	Boolean deliverResult(IResult<Serializable> result);

	/**
	 * @return bank id
	 */
	long getBankId();

	/**
	 * @return the list of all accounts in the bank
	 */
	List<IAccount> getAccounts();

	/**
	 * @param number
	 *            the number of the account to get
	 * @return the account corresponding to the number
	 * @throws AccountNotFoundException
	 *             if the account is not found
	 */
	IAccount getAccount(long number) throws AccountNotFoundException;

	/**
	 * Open an account for the given user
	 * 
	 * @param user
	 *            the user
	 * @return the created account
	 */
	IAccount openAccount(IUser user);

	/**
	 * Close the account corresponding to the number
	 * 
	 * @param number
	 *            the account number
	 * @return <code>true</code> if the account has been deleted,
	 *         <code>false</code> otherwise
	 * @throws AccountNotFoundException
	 *             if the account is not found
	 */
	boolean closeAccount(long number) throws AccountNotFoundException;

}
