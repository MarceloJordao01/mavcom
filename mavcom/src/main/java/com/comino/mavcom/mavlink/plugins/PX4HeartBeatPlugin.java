package com.comino.mavcom.mavlink.plugins;

import org.mavlink.messages.MAV_MODE_FLAG;
import org.mavlink.messages.MAV_MODE_FLAG_DECODE_POSITION;
import org.mavlink.messages.lquac.msg_heartbeat;

import com.comino.mavcom.mavlink.MAV_CUST_MODE;
import com.comino.mavcom.model.segment.Status;

public class PX4HeartBeatPlugin extends MAVLinkPluginBase {

	public PX4HeartBeatPlugin() {
		super(msg_heartbeat.class);
	}

	@Override
	public void received(Object o) {
		msg_heartbeat hb = (msg_heartbeat) o;

		if (hb.autopilot == 0) {
			// drop invalid packages
			return;
		}

		model.sys.px4_status = hb.system_status;
		// model.sys.nav_state = Status.NAVIGATION_STATE_MANUAL;

		model.sys.setStatus(Status.MSP_ARMED,
				(hb.base_mode & MAV_MODE_FLAG_DECODE_POSITION.MAV_MODE_FLAG_DECODE_POSITION_SAFETY) > 0);

		model.sys.setStatus(Status.MSP_ARMED, (hb.base_mode & MAV_MODE_FLAG.MAV_MODE_FLAG_SAFETY_ARMED) != 0);

		if (model.sys.isStatus(Status.MSP_ARMED)) {

			// synchronized( this) {

			if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_AUTO,
					MAV_CUST_MODE.PX4_CUSTOM_SUB_MODE_AUTO_RTL))
				model.sys.nav_state = Status.NAVIGATION_STATE_AUTO_RTL;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_AUTO,
					MAV_CUST_MODE.PX4_CUSTOM_SUB_MODE_AUTO_LAND))
				model.sys.nav_state = Status.NAVIGATION_STATE_AUTO_LAND;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_AUTO,
					MAV_CUST_MODE.PX4_CUSTOM_SUB_MODE_AUTO_TAKEOFF))
				model.sys.nav_state = Status.NAVIGATION_STATE_AUTO_TAKEOFF;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_AUTO,
					MAV_CUST_MODE.PX4_CUSTOM_SUB_MODE_AUTO_LOITER))
				model.sys.nav_state = Status.NAVIGATION_STATE_AUTO_LOITER;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_AUTO,
					MAV_CUST_MODE.PX4_CUSTOM_SUB_MODE_AUTO_MISSION))
				model.sys.nav_state = Status.NAVIGATION_STATE_AUTO_MISSION;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_OFFBOARD))
				model.sys.nav_state = Status.NAVIGATION_STATE_OFFBOARD;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_POSCTL))
				model.sys.nav_state = Status.NAVIGATION_STATE_POSCTL;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_ALTCTL))
				model.sys.nav_state = Status.NAVIGATION_STATE_ALTCTL;

			else if (MAV_CUST_MODE.is(hb.custom_mode, MAV_CUST_MODE.PX4_CUSTOM_MAIN_MODE_STABILIZED))
				model.sys.nav_state = Status.NAVIGATION_STATE_STAB;
			else
				model.sys.nav_state = Status.NAVIGATION_STATE_MANUAL;
			// }

		} else

			model.sys.nav_state = Status.NAVIGATION_STATE_MANUAL;

		model.sys.setStatus(Status.MSP_CONNECTED, true);

	}
}
