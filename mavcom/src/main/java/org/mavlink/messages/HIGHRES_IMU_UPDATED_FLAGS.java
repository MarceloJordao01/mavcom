/**
 * Generated class : HIGHRES_IMU_UPDATED_FLAGS
 * DO NOT MODIFY!
 **/
package org.mavlink.messages;

/**
 * Interface HIGHRES_IMU_UPDATED_FLAGS Flags in the HIGHRES_IMU message indicate
 * which fields have updated since the last message
 **/
public interface HIGHRES_IMU_UPDATED_FLAGS {
	/**
	 * None of the fields in HIGHRES_IMU have been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_NONE = 0;
	/**
	 * The value in the xacc field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_XACC = 1;
	/**
	 * The value in the yacc field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_YACC = 2;
	/**
	 * The value in the zacc field has been updated since
	 */
	public final static int HIGHRES_IMU_UPDATED_ZACC = 4;
	/**
	 * The value in the xgyro field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_XGYRO = 8;
	/**
	 * The value in the ygyro field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_YGYRO = 16;
	/**
	 * The value in the zgyro field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_ZGYRO = 32;
	/**
	 * The value in the xmag field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_XMAG = 64;
	/**
	 * The value in the ymag field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_YMAG = 128;
	/**
	 * The value in the zmag field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_ZMAG = 256;
	/**
	 * The value in the abs_pressure field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_ABS_PRESSURE = 512;
	/**
	 * The value in the diff_pressure field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_DIFF_PRESSURE = 1024;
	/**
	 * The value in the pressure_alt field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_PRESSURE_ALT = 2048;
	/**
	 * The value in the temperature field has been updated
	 */
	public final static int HIGHRES_IMU_UPDATED_TEMPERATURE = 4096;
	/**
	 * All fields in HIGHRES_IMU have been updated.
	 */
	public final static int HIGHRES_IMU_UPDATED_ALL = 65535;
}
