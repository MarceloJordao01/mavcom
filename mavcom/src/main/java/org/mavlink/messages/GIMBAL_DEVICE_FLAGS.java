/**
 * Generated class : GIMBAL_DEVICE_FLAGS
 * DO NOT MODIFY!
 **/
package org.mavlink.messages;

/**
 * Interface GIMBAL_DEVICE_FLAGS Flags for gimbal device (lower level)
 * operation.
 **/
public interface GIMBAL_DEVICE_FLAGS {
	/**
	 * Set to retracted safe position (no stabilization), takes presedence over all
	 * other flags.
	 */
	public final static int GIMBAL_DEVICE_FLAGS_RETRACT = 1;
	/**
	 * Set to neutral/default position, taking precedence over all other flags
	 * except RETRACT. Neutral is commonly forward-facing and horizontal
	 * (pitch=yaw=0) but may be any orientation.
	 */
	public final static int GIMBAL_DEVICE_FLAGS_NEUTRAL = 2;
	/**
	 * Lock roll angle to absolute angle relative to horizon (not relative to
	 * drone). This is generally the default with a stabilizing gimbal.
	 */
	public final static int GIMBAL_DEVICE_FLAGS_ROLL_LOCK = 4;
	/**
	 * Lock pitch angle to absolute angle relative to horizon (not relative to
	 * drone). This is generally the default.
	 */
	public final static int GIMBAL_DEVICE_FLAGS_PITCH_LOCK = 8;
	/**
	 * Lock yaw angle to absolute angle relative to North (not relative to drone).
	 * If this flag is set, the quaternion is in the Earth frame with the x-axis
	 * pointing North (yaw absolute). If this flag is not set, the quaternion frame
	 * is in the Earth frame rotated so that the x-axis is pointing forward (yaw
	 * relative to vehicle).
	 */
	public final static int GIMBAL_DEVICE_FLAGS_YAW_LOCK = 16;
}
