package net.sf.briar.protocol.writers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.briar.api.protocol.Types;
import net.sf.briar.api.protocol.writers.TransportWriter;
import net.sf.briar.api.serial.Writer;
import net.sf.briar.api.serial.WriterFactory;

class TransportWriterImpl implements TransportWriter {

	private final OutputStream out;
	private final Writer w;

	TransportWriterImpl(OutputStream out, WriterFactory writerFactory) {
		this.out = out;
		w = writerFactory.createWriter(out);
	}

	public void writeTransports(Map<Integer, Map<String, String>> transports,
			long timestamp) throws IOException {
		w.writeUserDefinedId(Types.TRANSPORT_UPDATE);
		w.writeListStart();
		for(Entry<Integer, Map<String, String>> e : transports.entrySet()) {
			w.writeUserDefinedId(Types.TRANSPORT_PROPERTIES);
			w.writeInt32(e.getKey());
			w.writeMap(e.getValue());
		}
		w.writeListEnd();
		w.writeInt64(timestamp);
		out.flush();
	}
}
