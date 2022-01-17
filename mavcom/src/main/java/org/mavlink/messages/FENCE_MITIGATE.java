/**
 * Generated class : FENCE_MITIGATE
 * DO NOT MODIFY!
 **/
package org.mavlink.messages;

/**
 * Interface FENCE_MITIGATE Actions being taken to mitigate/prevent fence breach
 **/
public interface FENCE_MITIGATE {
	/**
	 * Unknown
	 */
	public final static int FENCE_MITIGATE_UNKNOWN = 0;
	/**
	 * No actions being taken
	 */
	public final static int FENCE_MITIGATE_NONE = 1;
	/**
	 * Velocity limiting active to prevent breach
	 */
	public final static int FENCE_MITIGATE_VEL_LIMIT = 2;
}
