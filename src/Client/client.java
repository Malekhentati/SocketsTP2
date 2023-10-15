package Client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
	        int serverPort = 1234;
	        int op1, op2;
	        String operator;

	        System.out.println("Je suis un client pas encore connecté");
	        Socket s = new Socket("localhost", serverPort);
	        System.out.println("Je suis un client connecté");

	        try (Scanner scanner = new Scanner(System.in)) {
	            System.out.print("Entrez le premier opérande : ");
	            op1 = scanner.nextInt();
	            System.out.print("Entrez le deuxième opérande : ");
	            op2 = scanner.nextInt();
	            scanner.nextLine(); // Pour consommer la nouvelle ligne restante
	            System.out.print("Entrez l'opérateur (+, -, *, /) : ");
	            operator = scanner.nextLine();

	            // Génération de l'objet InputStream et OutputStream de la socket
	            InputStream is = s.getInputStream();
	            OutputStream os = s.getOutputStream();
	            PrintWriter pw = new PrintWriter(os, true);

	            // Envoi de l'opération au serveur
	            pw.println(op1);
	            pw.println(op2);
	            pw.println(operator);

	            // Attendre la réponse du serveur
	            InputStreamReader isr = new InputStreamReader(is);
	            BufferedReader br = new BufferedReader(isr);
	            int result = Integer.parseInt(br.readLine());
	            System.out.println("Résultat de l'opération : " + result);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            s.close();
	        }
	    }
	}


