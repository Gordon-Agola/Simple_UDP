package simple_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {
	
	
	public Receiver() throws Exception {
		DatagramSocket socket = new DatagramSocket(2020);
		System.out.println("Receiver is running");
		while(true) {
		
			byte[] buffer = new byte[1500];// Maximum transmission Unit
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

			socket.receive(packet); // Retrieving sender's message
			String message = new String(buffer).trim();
			System.out.println("Received: " + message);

			InetAddress senders_address = packet.getAddress();
			int senders_port = packet.getPort();

			// System.out.println("Enter your message: ");
			message = "Ok";
			buffer = message.getBytes();
			packet = new DatagramPacket(buffer, buffer.length, senders_address, senders_port);
			socket.send(packet);

			System.out.println("Sent: " + message);
		}
	}
	
public static void main(String[] args) {
	try {
		new Receiver();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
