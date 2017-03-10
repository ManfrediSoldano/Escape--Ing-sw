package it.polimi.ingsw.cg_10.controller.socket;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Manfredi
 *
 */
public class SocketCommunicator implements Communicator {

	Socket socket;
	Scanner in;
	PrintWriter out;
	
	public SocketCommunicator(Socket s) {
		socket=s;
        try {
            in = new Scanner(socket.getInputStream());
 
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            throw new AssertionError("some weird configuration problem occured or pebkac and you haven't opened the socket yet", ex);
        }
	}

	@Override
	public void send(String stringa){
		stringa=stringa+"\n";
		out.println(stringa);
		out.flush(); 
	}



    @Override
	public String receive() {
		try {
			String s = "";
			String whil = "";
			boolean i = true;
			
			whil = in.nextLine();
			
			s += whil;
			while (i) {
				whil = in.nextLine();
				
				if (!whil.equals("")) {
					s = s + "\n" + whil;
				} else {
					i = false;
				}


			}
			return s;
		} catch (Exception exc) {
			return null;
		}
	}

    @Override
	public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("something wrong happened while closing a socket, who cares? I don't need it anymore: " + e.getMessage());
        } finally {
        		socket = null;
        }
    }

	
	
	
	
}

