package Server;
import java.io.*;
import java.net.*;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int serverPort = 1234;
        int op1, op2;
        String operator;

        try {
            // La première étape :
            ServerSocket ss = new ServerSocket(serverPort);
            System.out.println("Je suis en attente de la connexion d'un client");
            // La deuxième étape :
            Socket s = ss.accept();
            System.out.println("Un client est connecté");

            // 3ème étape : lire une opération envoyée par un client
            // Flux de communication
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            // Flux de traitement
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            op1 = Integer.parseInt(br.readLine());
            op2 = Integer.parseInt(br.readLine());
            operator = br.readLine();

            int result = calculate(op1, op2, operator);

            // Envoyer le résultat au client
            pw.println(result);

            // La dernière étape : fermer la socket
            System.out.println("Déconnexion du client");
            s.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calculate(int op1, int op2, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                if (op2 != 0) {
                    result = op1 / op2;
                }
                break;
        }
        return result;
    }
	}


