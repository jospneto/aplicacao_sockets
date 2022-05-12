import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

import javax.swing.JOptionPane;

public class UDPClient {
	public static void main(String[] args) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			
			byte[] sendData = new byte[1024];
			InetAddress ipAddress = InetAddress.getByName("BRADDOCK");
			int port = 5000;
			
			while(true) {
				String sentence = JOptionPane.showInputDialog("Digite algo: ");
				
				if(sentence.equalsIgnoreCase("sair")) {
					break;
				}
				
				String nameUser = "(Neto) "+sentence;
				
				sendData = nameUser.getBytes();
				
				DatagramPacket sendPacket = new DatagramPacket(sendData, nameUser.length(), ipAddress, port);
				
				clientSocket.send(sendPacket);
			}
			clientSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
