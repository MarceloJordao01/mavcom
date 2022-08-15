/**
 * Generated class : msg_msp_ekf2_reset
 * DO NOT MODIFY!
 **/
package org.mavlink.messages.lquac;
import org.mavlink.messages.MAVLinkMessage;
import org.mavlink.IMAVLinkCRC;
import org.mavlink.MAVLinkCRC;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mavlink.io.LittleEndianDataInputStream;
import org.mavlink.io.LittleEndianDataOutputStream;
/**
 * Class msg_msp_ekf2_reset
 * EKF2 reset
 **/
public class msg_msp_ekf2_reset extends MAVLinkMessage {
  public static final int MAVLINK_MSG_ID_MSP_EKF2_RESET = 186;
  private static final long serialVersionUID = MAVLINK_MSG_ID_MSP_EKF2_RESET;
  public msg_msp_ekf2_reset() {
    this(1,1);
}
  public msg_msp_ekf2_reset(int sysId, int componentId) {
    messageType = MAVLINK_MSG_ID_MSP_EKF2_RESET;
    this.sysId = sysId;
    this.componentId = componentId;
    payload_length = 22;
}

  /**
   * Timestamp
   */
  public long tms;
  /**
   * X Offset
   */
  public float offset_x;
  /**
   * Y Offset
   */
  public float offset_y;
  /**
   * Z Offset
   */
  public float offset_z;
  /**
   * ResetCounter
   */
  public int counter;
/**
 * Decode message with raw data
 */
public void decode(LittleEndianDataInputStream dis) throws IOException {
  tms = (long)dis.readLong();
  offset_x = (float)dis.readFloat();
  offset_y = (float)dis.readFloat();
  offset_z = (float)dis.readFloat();
  counter = (int)dis.readUnsignedShort()&0x00FFFF;
}
/**
 * Encode message with raw data and other informations
 */
public byte[] encode() throws IOException {
  byte[] buffer = new byte[12+22];
   LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
  dos.writeByte((byte)0xFD);
  dos.writeByte(payload_length & 0x00FF);
  dos.writeByte(incompat & 0x00FF);
  dos.writeByte(compat & 0x00FF);
  dos.writeByte(packet & 0x00FF);
  dos.writeByte(sysId & 0x00FF);
  dos.writeByte(componentId & 0x00FF);
  dos.writeByte(messageType & 0x00FF);
  dos.writeByte((messageType >> 8) & 0x00FF);
  dos.writeByte((messageType >> 16) & 0x00FF);
  dos.writeLong(tms);
  dos.writeFloat(offset_x);
  dos.writeFloat(offset_y);
  dos.writeFloat(offset_z);
  dos.writeShort(counter&0x00FFFF);
  dos.flush();
  byte[] tmp = dos.toByteArray();
  for (int b=0; b<tmp.length; b++) buffer[b]=tmp[b];
  int crc = MAVLinkCRC.crc_calculate_encode(buffer, 22);
  crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
  byte crcl = (byte) (crc & 0x00FF);
  byte crch = (byte) ((crc >> 8) & 0x00FF);
  buffer[32] = crcl;
  buffer[33] = crch;
  dos.close();
  return buffer;
}
public String toString() {
return "MAVLINK_MSG_ID_MSP_EKF2_RESET : " +   "  tms="+tms
+  "  offset_x="+format((float)offset_x)
+  "  offset_y="+format((float)offset_y)
+  "  offset_z="+format((float)offset_z)
+  "  counter="+counter
;}

}

