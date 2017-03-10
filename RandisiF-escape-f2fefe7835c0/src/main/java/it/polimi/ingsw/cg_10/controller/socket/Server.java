package it.polimi.ingsw.cg_10.controller.socket;


import it.polimi.ingsw.cg_10.controller.server.ServerComunication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Manfredi
 *
 */
public class Server extends Thread {
	
	private int port;
	private ServerSocket serverSocket; 
	private ServerComunication sc;
	public Server(int port, ServerComunication sc) {
		this.port = port; 
		this.sc = sc;
	}
	@Override
	public void run() {
		try {
            serverSocket = new ServerSocket(port);
           
            while (isStopped()) {
                Socket socket = serverSocket.accept();
                new ClientHandler(new SocketCommunicator(socket),sc).start();  
            }
            serverSocket.close();
        } catch (IOException ex) {
            throw new AssertionError("Weird errors with I/O occured, please verify environment config", ex);
        }
	}
		

	private boolean isStopped() {
		return true;
	}
	

}
