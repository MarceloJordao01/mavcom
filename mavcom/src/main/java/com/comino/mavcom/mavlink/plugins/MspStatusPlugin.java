package com.comino.mavcom.mavlink.plugins;

import org.mavlink.messages.lquac.msg_msp_status;

import com.comino.mavcom.model.segment.Status;

public class MspStatusPlugin extends MAVLinkPluginBase {

	public MspStatusPlugin() {
		super(msg_msp_status.class);
	}

	@Override
	public void received(Object o) {

		msg_msp_status status = (msg_msp_status) o;
		model.sys.status = (int)status.status;
		model.sys.load_m = status.load;
		model.sys.autopilot = (long)status.autopilot_mode;
		model.sys.setSensor(Status.MSP_MSP_AVAILABILITY, true);
		model.sys.setStatus(Status.MSP_ACTIVE, true);
		model.sys.wifi_quality = status.wifi_quality/100f;
		model.sys.msp_temp = (byte)status.cpu_temp;
		model.sys.build = status.getVersion();
		model.sys.t_takeoff_ms = status.takeoff_ms;

		model.sys.setStatus(Status.MSP_CONNECTED, true);
	}
}
