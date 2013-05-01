package org.wahlque.transport.payload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.wahlque.transport.Payload;
import org.wahlque.transport.Transport;

public class Multiple implements Payload<Payload<?>[]> {

    public static final char discriminator = '*';
    private Payload<?>[] value;

    public char discriminator() {
        return discriminator;
    }

    public Payload<?>[] data() {
        return value;
    }

    public void read(InputStream is) throws IOException {
        value = Transport.readPayloads(is);
    }

    public void write(OutputStream os) throws IOException {
        Transport.writeDiscriminator(os, discriminator);
        Transport.writePayloads(os, value);
    }

}
