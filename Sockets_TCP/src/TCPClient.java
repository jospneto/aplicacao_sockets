import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 5000;
		Socket socket = new Socket("localhost", port);//Cria o objeto que se comunica  com o servidor
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);//Objeto de saída
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Objeto de entrada
		
		String entradaServidor = "";
		String entradaUsuario = JOptionPane.showInputDialog("Digite algo: ");
		
		while(!entradaUsuario.equalsIgnoreCase("sair")) {
			out.println(entradaUsuario);
			entradaServidor = in.readLine();
			entradaUsuario = JOptionPane.showInputDialog("Mensagem do Servidor: "+entradaServidor+"\nDigite algo: ");
		}
		out.close();
		in.close();
		socket.close();
	}
}
