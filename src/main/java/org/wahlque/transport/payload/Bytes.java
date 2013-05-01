package org.wahlque.transport.payload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.wahlque.transport.Payload;
import org.wahlque.transport.Transport;

public class Bytes implements Payload<byte[]> {
	
	public static final char discriminator = '$';
    private byte[] value;

	public char discriminator() {
		return discriminator;
	}

	public byte[] data() {
		return value;
	}

	public void read(InputStream is) throws IOException {
		value = Transport.readBytes(is);
	}

	public void write(OutputStream os)
			throws IOException
	{
		Transport.writeDiscriminator(os, discriminator);
		Transport.writeBytes(os, value);
	}

}

