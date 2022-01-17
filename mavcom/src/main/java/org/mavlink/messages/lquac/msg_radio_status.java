/**
 * Generated class : msg_radio_status
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
 * Class msg_radio_status Status generated by radio and injected into MAVLink
 * stream.
 **/
public class msg_radio_status extends MAVLinkMessage {
	public static final int MAVLINK_MSG_ID_RADIO_STATUS = 109;
	private static final long serialVersionUID = MAVLINK_MSG_ID_RADIO_STATUS;

	public msg_radio_status() {
		this(1, 1);
	}

	public msg_radio_status(int sysId, int componentId) {
		messageType = MAVLINK_MSG_ID_RADIO_STATUS;
		this.sysId = sysId;
		this.componentId = componentId;
		payload_length = 9;
	}

	/**
	 * Count of radio packet receive errors (since boot).
	 */
	public int rxerrors;
	/**
	 * Count of error corrected radio packets (since boot).
	 */
	public int fixed;
	/**
	 * Local (message sender) recieved signal strength indication in
	 * device-dependent units/scale. Values: [0-254], UINT8_MAX: invalid/unknown.
	 */
	public int rssi;
	/**
	 * Remote (message receiver) signal strength indication in device-dependent
	 * units/scale. Values: [0-254], UINT8_MAX: invalid/unknown.
	 */
	public int remrssi;
	/**
	 * Remaining free transmitter buffer space.
	 */
	public int txbuf;
	/**
	 * Local background noise level. These are device dependent RSSI values (scale
	 * as approx 2x dB on SiK radios). Values: [0-254], UINT8_MAX: invalid/unknown.
	 */
	public int noise;
	/**
	 * Remote background noise level. These are device dependent RSSI values (scale
	 * as approx 2x dB on SiK radios). Values: [0-254], UINT8_MAX: invalid/unknown.
	 */
	public int remnoise;

	/**
	 * Decode message with raw data
	 */
	public void decode(LittleEndianDataInputStream dis) throws IOException {
		rxerrors = (int) dis.readUnsignedShort() & 0x00FFFF;
		fixed = (int) dis.readUnsignedShort() & 0x00FFFF;
		rssi = (int) dis.readUnsignedByte() & 0x00FF;
		remrssi = (int) dis.readUnsignedByte() & 0x00FF;
		txbuf = (int) dis.readUnsignedByte() & 0x00FF;
		noise = (int) dis.readUnsignedByte() & 0x00FF;
		remnoise = (int) dis.readUnsignedByte() & 0x00FF;
	}

	/**
	 * Encode message with raw data and other informations
	 */
	public byte[] encode() throws IOException {
		byte[] buffer = new byte[12 + 9];
		LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
		dos.writeByte((byte) 0xFD);
		dos.writeByte(payload_length & 0x00FF);
		dos.writeByte(incompat & 0x00FF);
		dos.writeByte(compat & 0x00FF);
		dos.writeByte(packet & 0x00FF);
		dos.writeByte(sysId & 0x00FF);
		dos.writeByte(componentId & 0x00FF);
		dos.writeByte(messageType & 0x00FF);
		dos.writeByte((messageType >> 8) & 0x00FF);
		dos.writeByte((messageType >> 16) & 0x00FF);
		dos.writeShort(rxerrors & 0x00FFFF);
		dos.writeShort(fixed & 0x00FFFF);
		dos.writeByte(rssi & 0x00FF);
		dos.writeByte(remrssi & 0x00FF);
		dos.writeByte(txbuf & 0x00FF);
		dos.writeByte(noise & 0x00FF);
		dos.writeByte(remnoise & 0x00FF);
		dos.flush();
		byte[] tmp = dos.toByteArray();
		for (int b = 0; b < tmp.length; b++)
			buffer[b] = tmp[b];
		int crc = MAVLinkCRC.crc_calculate_encode(buffer, 9);
		crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
		byte crcl = (byte) (crc & 0x00FF);
		byte crch = (byte) ((crc >> 8) & 0x00FF);
		buffer[19] = crcl;
		buffer[20] = crch;
		dos.close();
		return buffer;
	}

	public String toString() {
		return "MAVLINK_MSG_ID_RADIO_STATUS : " + "  rxerrors=" + rxerrors + "  fixed=" + fixed + "  rssi=" + rssi
				+ "  remrssi=" + remrssi + "  txbuf=" + txbuf + "  noise=" + noise + "  remnoise=" + remnoise;
	}

}
