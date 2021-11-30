package com.comino.mavcom.mavlink;

import org.mavlink.messages.lquac.msg_command_long;

import com.comino.mavcom.control.IMAVCmdAcknowledge;

public class MAVAcknowledge {
	
	final public IMAVCmdAcknowledge  callback;
	final public msg_command_long    msg;
	
	private int                      retries = 0;
	
	public MAVAcknowledge(IMAVCmdAcknowledge callback, msg_command_long msg, int retries) {
		super();
		this.callback = callback;
		this.msg      = msg;
		this.retries  = retries;
	}

	public int getAndDecreaseRetries() {
		return retries--;
	}
	
}