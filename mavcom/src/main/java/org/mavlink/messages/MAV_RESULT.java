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
     * Command is valid and is being executed. This will be followed by further progress updates, i.e. the component may send further COMMAND_ACK messages with result MAV_RESULT_IN_PROGRESS (at a rate decided by the implementation), and must terminate by sending a COMMAND_ACK message with final result of the operation. The COMMAND_ACK.progress field can be used to indicate the progress of the operation. There is no need for the sender to retry the command, but if done during execution, the component will return MAV_RESULT_IN_PROGRESS with an updated progress.
     */
    public final static int MAV_RESULT_IN_PROGRESS = 5;
}
