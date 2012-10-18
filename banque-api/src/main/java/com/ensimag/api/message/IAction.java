package com.ensimag.api.message;

import java.io.Serializable;

import com.ensimag.api.bank.IBank;

public interface IAction<ResultType extends Serializable> extends Serializable {

	ResultType execute(IBank bank) throws Exception;

}
