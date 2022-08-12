package com.comino.mavcom.mavlink.plugins;



import org.mavlink.messages.lquac.msg_msp_ekf2_reset;


public class MspEKF2Reset extends MAVLinkPluginBase {

	public MspEKF2Reset() {
		super(msg_msp_ekf2_reset.class);
	}

	@Override
	public void received(Object o) {

		msg_msp_ekf2_reset reset = (msg_msp_ekf2_reset) o;
		model.state.l_rx = reset.offset_x;
		model.state.l_ry = reset.offset_y;
		model.state.l_rz = reset.offset_z;
	}

}