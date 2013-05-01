package org.wahlque.transport.payload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.wahlque.transport.Payload;
import org.wahlque.transport.Transport;

public class Error implements Payload<String>
{
	
	public static final char discriminator = '-';
    private String value;

	public char discriminator()
	{
		return discriminator;
	}

    public String data()
    {
    	return value;
    }

	public void read(InputStream is) throws IOException
	{
		value = Transport.readString(is);
	}

	public void write(OutputStream os) throws IOException
	{
		Transport.writeDiscriminator(os, discriminator);
		Transport.writeString(os, value);
	}

}
