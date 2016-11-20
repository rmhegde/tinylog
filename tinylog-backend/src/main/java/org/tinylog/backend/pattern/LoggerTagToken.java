/*
 * Copyright 2016 Martin Winandy
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.tinylog.backend.pattern;

import java.util.Collection;
import java.util.Collections;

import org.tinylog.backend.LogEntry;
import org.tinylog.backend.LogEntryValue;

/**
 * Token for outputting the tag of a logger.
 */
final class LoggerTagToken implements Token {

	private static final String DEFAULT_EMPTY_TAG = "";

	private final String empty;

	/** */
	LoggerTagToken() {
		this.empty = DEFAULT_EMPTY_TAG;
	}

	/**
	 * @param empty
	 *            Value for untagged log entries
	 */
	LoggerTagToken(final String empty) {
		this.empty = empty;
	}

	@Override
	public Collection<LogEntryValue> getRequiredLogEntryValues() {
		return Collections.singleton(LogEntryValue.TAG);
	}

	@Override
	public void render(final LogEntry logEntry, final StringBuilder builder) {
		String tag = logEntry.getTag();
		if (tag == null) {
			builder.append(empty);
		} else {
			builder.append(tag);
		}
	}

}