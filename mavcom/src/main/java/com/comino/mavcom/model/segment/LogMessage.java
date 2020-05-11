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

public class LogMessage extends Segment {

	private static final long serialVersionUID = 3345013931542810501L;

	private static final String[] severity_texts = { "Emergency","Alert","Critical","Error","Warning","Notice","Info","Debug" };

	public String    text = null;
	public int   severity = 0;

	public LogMessage() {
		this.tms = System.currentTimeMillis();
	}

	public LogMessage(String text, int severity) {
		this.text = text;
		this.severity = severity;
		this.tms = System.currentTimeMillis();
	}

	public LogMessage(String text, int severity, long tms) {
		this.text = text;
		this.severity = severity;
		this.tms = tms;
	}

	public LogMessage clone() {
		LogMessage m = new LogMessage(this.text,this.severity, this.tms);
		this.text = null;
		return m;
	}

	public void set(LogMessage m) {
		this.text = m.text;
		this.severity = m.severity;
		this.tms = m.tms;
	}

	public boolean isEqual(LogMessage m) {
		if(m.text==null)
			return false;
		return m.filter(this.text) || (m.tms - this.tms) > 500 ;
	}

	public boolean filter(String filter) {
		return this.text.contains(filter);
	}

	public void clear() {
		this.text = null;
		this.severity = 0;
	}

	public String getSeverityString() {
		return "["+severity_texts[severity]+"]";
	}

	public String toString() {
		return String.format("%-13s %s", getSeverityString(), text);
	}

}
