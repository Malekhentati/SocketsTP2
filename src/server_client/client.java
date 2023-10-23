package server_client;
	import java.io.*;
	import java.net.*;
	import java.util.Scanner;
	
public class client {
	 public static void main(String[] args) {
	        try {
	            // Définir l'adresse IP du serveur
	            InetAddress serverAddress = InetAddress.getByName("192.168.1.6");
	            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, 1234);
	            // Créer une socket pour se connecter au serveur
	            Socket clientSocket = new Socket();
	    		System.out.println("je suis un client pas encore connecté");
	            // Se connecter au serveur
	            clientSocket.connect(serverSocketAddress);
	    		System.out.println("je suis un client connecté");
	            // Set up output stream to send an Operation object to the server
	    		System.out.println("Génération de l'objet InputStream et ObjectInputStream de la socket");
	            OutputStream output = clientSocket.getOutputStream();
	            ObjectOutputStream os = new ObjectOutputStream(output);
	            // Create an Operation object (40 * 20)
	            operation op = new operation(40, 20, '*');     
	            // Send the Operation object to the server
	            os.writeObject(op);
	            // Set up input stream to receive a modified Operation object from the server
	            InputStream input = clientSocket.getInputStream();
	            ObjectInputStream is = new ObjectInputStream(input);
	            // Receive and read the modified Operation object
	            op = (operation) is.readObject();
	            // Print the result
	            System.out.println("Result received from the server: " + op.getRes());
	        } catch (Exception e) {
	            System.out.println("Client: An error occurred - " + e.getMessage());
	            throw new RuntimeException(e);
	        }}}


