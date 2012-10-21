package com.ensimag.api.bank;

import java.io.Serializable;

import com.ensimag.api.message.IMessage;

public interface IBankMessage extends IMessage<Serializable, com.ensimag.api.bank.IBankNode> {
	@Override
	IBankAction getAction();

	@Override
	IBankMessage clone();
}
