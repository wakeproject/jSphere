package org.wahlque.transport.payload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.wahlque.transport.Payload;
import org.wahlque.transport.Transport;

public class Number implements Payload<Long>
{
	
	public static final char discriminator = ':';
    private long value;

	public char discriminator()
	{
		return discriminator;
	}

    public Long data()
    {
    	return value;
    }

	public void read(InputStream is)
			throws IOException
    {
        value = Transport.readNumber(is);
    }

	public void write(OutputStream os)
			throws IOException
	{
		Transport.writeDiscriminator(os, discriminator);
		Transport.writeNumber(os, value);
	}

}
