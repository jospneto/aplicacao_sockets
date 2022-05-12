import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) {
		try {
			System.out.println("+------------------------------+");
			System.out.println(":: Servidor em funcionamento! ::");
			System.out.println("+------------------------------+");
			DatagramSocket serverSocket = new DatagramSocket(5000);
			
			while(true) {
				byte[] receivedData = new byte[1024];
				DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
				serverSocket.receive(receivedPacket);
				
				String sentence = new String(receivedPacket.getData());
				if(sentence.substring(0,4).equalsIgnoreCase("sair")) {
					break;
				}
				InetAddress ipAddress = receivedPacket.getAddress();
				
				System.out.println("Recebido de "+ipAddress.getHostAddress()+": "+sentence.trim());
			}
			
			serverSocket.close();
			System.out.println("+--------------------------+");
			System.out.println("::   Servidor finalizado! ::");
			System.out.println("+--------------------------+");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
