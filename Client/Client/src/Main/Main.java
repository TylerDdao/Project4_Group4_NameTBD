//package Main;
//
//import java.io.*;
//import java.net.*;
//
//public class Main {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String serverAddress = "localhost"; // Server IP or hostname
//        int port = 27000;
//
//        try (Socket socket = new Socket(serverAddress, port)) {
//            // Create output stream to send data
//            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//            // Create input stream to receive data
//            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//            output.println("Hello Server 2!"); // Send message
//            String response = input.readLine(); // Read response
//
//            System.out.println("Server response: " + response);
//            System.out.println("Socket closed");
//            socket.close();
//            return;
//
//        } catch (IOException ex) {
//        	System.out.println("Client Error: " + ex.getMessage());
//        }
//	}
//
//}
