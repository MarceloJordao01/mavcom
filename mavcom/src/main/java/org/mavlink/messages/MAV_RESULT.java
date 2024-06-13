/**
 * Generated class : MAV_RESULT
 * DO NOT MODIFY!
 **/
package org.mavlink.messages;
/**
 * Interface MAV_RESULT
 * Result from a MAVLink command (MAV_CMD)
 **/
public interface MAV_RESULT {
    /**
     * Command is valid (is supported and has valid parameters), and was executed.
     */
    public final static int MAV_RESULT_ACCEPTED = 0;
    /**
     * Command is valid, but cannot be executed at this time. This is used to indicate a problem that should be fixed just by waiting (e.g. a state machine is busy, can't arm because have not got GPS lock, etc.). Retrying later should work.
     */
    public final static int MAV_RESULT_TEMPORARILY_REJECTED = 1;
    /**
     * Command is invalid (is supported but has invalid parameters). Retrying same command and parameters will not work.
     */
    public final static int MAV_RESULT_DENIED = 2;
    /**
     * Command is not supported (unknown).
     */
    public final static int MAV_RESULT_UNSUPPORTED = 3;
    /**
     * Command is valid, but execution has failed. This is used to indicate any non-temporary or unexpected problem, i.e. any problem that must be fixed before the command can succeed/be retried. For example, attempting to write a file when out of memory, attempting to arm when sensors are not calibrated, etc.
     */
    public final static int MAV_RESULT_FAILED = 4;
    /**
     * Command is valid and is being executed. This will be followed by further progress updates, i.e. the component may send further COMMAND_ACK messages with result MAV_RESULT_IN_PROGRESS (at a rate decided by the implementation), and must terminate by sending a COMMAND_ACK message with final result of the operation. The COMMAND_ACK.progress field can be used to indicate the progress of the operation.
     */
    public final static int MAV_RESULT_IN_PROGRESS = 5;
    /**
     * Command has been cancelled (as a result of receiving a COMMAND_CANCEL message).
     */
    public final static int MAV_RESULT_CANCELLED = 6;
    /**
     * Command is only accepted when sent as a COMMAND_LONG.
     */
    public final static int MAV_RESULT_COMMAND_LONG_ONLY = 7;
    /**
     * Command is only accepted when sent as a COMMAND_INT.
     */
    public final static int MAV_RESULT_COMMAND_INT_ONLY = 8;
    /**
     * Command is invalid because a frame is required and the specified frame is not supported.
     */
    public final static int MAV_RESULT_COMMAND_UNSUPPORTED_MAV_FRAME = 9;
}
