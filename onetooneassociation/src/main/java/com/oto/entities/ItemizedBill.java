package com.oto.entities;

import java.io.Serializable;

import lombok.Data;
@Data
public class ItemizedBill implements Serializable {

	private static final long serialVersionUID = 1L;
	private int billNo;
	private long voiceCall;
	private long internationalVoiceCall;
	private long rommingVoice;
	private long message;
	private double previousDueAmount;
	private Bill bill;


}
