package org.wahlque.net.connection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.wahlque.net.command.Command;
import org.wahlque.net.reply.Reply;

/**
 * Implements the Redis Universal Protocol, send/receive a command or a reply
 */
public class ServerConnection {

    private final BufferedInputStream is;
    private final OutputStream os;

    /**
     * Create a new connection from a socket connection.
     */
    public ServerConnection(Socket socket) throws IOException {
        this.is = new BufferedInputStream(socket.getInputStream());
        this.os = new BufferedOutputStream(socket.getOutputStream());
    }

    /**
     * Wait for a reply on the input stream.
     */
    public Command receive() throws IOException {
        synchronized (this.is) {
            return null;
        }
    }

    /**
     * Send a command over the wire, do not wait for a reponse.
     */
    public void send(Reply<?> reply) throws IOException {
        synchronized (this.os) {
            reply.write(os);
        }
        this.os.flush();
    }

    /**
     * Close the input and output streams. Will also disconnect the socket.
     */
    public void close() throws IOException {
        this.is.close();
        this.os.close();
    }
}