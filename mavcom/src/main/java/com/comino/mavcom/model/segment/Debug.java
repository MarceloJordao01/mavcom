/****************************************************************************
 *
 *   Copyright (c) 2017 Eike Mansfeld ecm@gmx.de. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 * 3. Neither the name of the copyright holder nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 ****************************************************************************/


package com.comino.mavcom.model.segment;

import com.comino.mavcom.model.segment.generic.Segment;

import georegression.struct.point.Vector3D_F64;
import georegression.struct.point.Vector4D_F64;

public class Debug extends Segment {

	private static final long serialVersionUID = -1026591471182262641L;

	// positioning actual


	public float	x=0;
	public float    y=0;
	public float    z=0;
	

	public Debug clone() {
		Debug t = new Debug();
		t.x		= x;
		t.y		= y;
		t.z		= z;

		return t;
	}

	public void set(Debug t) {
		x		= t.x;
		y		= t.y;
		z		= t.z;
	}
	
	public void set(Vector3D_F64 t) {
		x       = (float)t.x;
		y       = (float)t.y;
		z       = (float)t.z;
	}
	
	public void set(Vector4D_F64 t) {
		x       = (float)t.x;
		y       = (float)t.y;
		z       = (float)t.z;
	}

	public void clear() {
      x = 0; y = 0; z = 0;
	}

}
