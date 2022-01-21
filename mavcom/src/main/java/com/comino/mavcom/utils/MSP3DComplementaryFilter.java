package com.comino.mavcom.utils;

import georegression.struct.point.Vector3D_F64;

public class MSP3DComplementaryFilter {

	private double factor = 1;
	private Vector3D_F64 filtered;
	private int count;

	public MSP3DComplementaryFilter(double factor) {
		this(factor, new Vector3D_F64());
	}

	public MSP3DComplementaryFilter(double factor, Vector3D_F64 filtered) {
		this.factor = factor;
		this.filtered = filtered;
	}

	public void add(Vector3D_F64 value) {
		if (filtered.x != 0)
			filtered.x = filtered.x * (1 - factor) + value.x * factor;
		else
			filtered.x = value.x;

		if (filtered.y != 0)
			filtered.y = filtered.y * (1 - factor) + value.y * factor;
		else
			filtered.y = value.y;

		if (filtered.z != 0)
			filtered.z = filtered.z * (1 - factor) + value.z * factor;
		else
			filtered.z = value.z;

		count++;
	}

	public void add(Vector3D_F64 value1, Vector3D_F64 value2) {
		filtered.x = value2.x * (1 - factor) + value1.x * factor;
		filtered.y = value2.y * (1 - factor) + value1.y * factor;
		filtered.z = value2.z * (1 - factor) + value1.z * factor;
		count++;
	}

	public Vector3D_F64 get() {
		return filtered;
	}

	public double getNorm() {
		return filtered.norm();
	}

	public int getCount() {
		return count;
	}

	public void reset() {
		filtered.setTo(0, 0, 0);
		count = 0;
	}

}