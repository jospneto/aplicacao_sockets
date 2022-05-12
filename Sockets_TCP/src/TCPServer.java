import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("+------------------------+");
		System.out.println("Servidor TCP foi iniciado!");
		System.out.println("+------------------------+");
		
		int port = 5000;
		
		ServerSocket socketServidor = new ServerSocket(port);
		//O cliente recebe o objeto servidor e o servidor aceita a requisição do cliente.
		Socket socketClient = socketServidor.accept();//Com objeto accept vai criar uma forma de receber e enviar os dados. Necessário criar objetos para entrada e saida.
		
		PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);//Captura a saída do socket e retorna ao objeto.
		BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));//Captura os dados que entram no socket.
		
		String entrada;
		
		while((entrada = in.readLine()) != null) {
			System.out.println("Recebido do cliente: " + entrada);
			out.println(entrada.toUpperCase());
			
			if(entrada.equalsIgnoreCase("sair")) {
				break;
			}
		}
		out.close();
		in.close();
		socketClient.close();
		socketServidor.close();
		
		System.out.println("\nO cliente digitou SAIR...");
		System.out.println("\n_________________________");
		System.out.println("\nConexão encerrada...");
	}

}
