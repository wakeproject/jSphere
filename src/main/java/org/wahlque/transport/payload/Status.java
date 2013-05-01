package org.wahlque.transport.payload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.wahlque.transport.Payload;

public class Status implements Payload<String> {

    public static final char discriminator = '+';
    private String value;

    public char discriminator() {
        return discriminator;
    }

    public String data() {
        return value;
    }

    public void read(InputStream is) throws IOException {
    }

    public void write(OutputStream os) throws IOException {
    }

}
