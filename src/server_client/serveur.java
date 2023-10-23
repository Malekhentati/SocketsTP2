package server_client;
	import java.io.*;
	import java.net.*;

	
public class serveur {
	
	 public static void main(String[] args) throws IOException {
	        try (ServerSocket ss = new ServerSocket(1234)) {
	    		System.out.println("je suis en attente de la connexion d'un client");
	            // Attendre qu'un client se connecte et accepter la connexion.
	    		
	            Socket clientSocket = ss.accept();
	    		System.out.println("un client est connecté");

	            // Set up input stream to receive object
	    		System.out.println("Génération de l'objet InputStream et ObjectInputStream de la socket");

	            InputStream input = clientSocket.getInputStream();
	            ObjectInputStream oi = new ObjectInputStream(input);

	            // Read the received object (Operation)
	            operation op = (operation) oi.readObject();

	            // Extract necessary data from the Operation object
	            int nb1 = op.getNb1();
	            int nb2 = op.getNb2();
	            char ops = op.getOp();

	            int res = 0;

	            // Perform the requested operation
	            switch (ops) {
	                case '+':
	                    res = nb1 + nb2;
	                    break;
	                case '-':
	                    res = nb1 - nb2;
	                    break;
	                case '*':
	                    res = nb1 * nb2;
	                    break;
	                case '/':
	                    res = nb1 / nb2;
	                    break;
	            }

	            // Store the result in the Operation object
	            op.setRes(res);

	            // Set up output stream to send the modified Operation object
	            OutputStream output = clientSocket.getOutputStream();
	            ObjectOutputStream oo = new ObjectOutputStream(output);

	            // Send the modified Operation object back to the client
	            oo.writeObject(op);

	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	            throw new RuntimeException(e);
	        }}}
	    
