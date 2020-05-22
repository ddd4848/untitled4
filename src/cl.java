import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;
import java.util.Scanner;
import java.net.InetAddress;



public class cl{

    public static void main(String args[]){
        Scanner ino = new Scanner(System.in);
        System.out.println("enter name");
        String name = ino.nextLine();
        try{

            DatagramSocket dsock = new DatagramSocket();
            DatagramSocket dsock2 = new DatagramSocket();
            byte[] arr = new byte[1024];

            DatagramPacket dpack_send ,dpack_recv ;

            Scanner inp = new Scanner(System.in);

            while(true){

                clearBytes(arr);            // to remove data from previous operation from 
                System.out.print(name + " : ");
                arr = (inp.nextLine()).getBytes();
                dpack_send =  new DatagramPacket( arr , arr.length ,  InetAddress.getByName("127.0.0.1") , 8080 );
                byte [] ogg =name.getBytes();
                DatagramPacket    namme =  new DatagramPacket( ogg , ogg.length ,  InetAddress.getByName("127.0.0.1") , 8090 );
                dsock.send(dpack_send);
                dsock2.send(namme);
                clearBytes(arr);            // to remove data from previous operation from 
                dpack_recv = new DatagramPacket( arr , arr.length );
                dsock.receive(dpack_recv);
                System.out.println("Server : " + new String(arr) );

            }

        }catch(IOException e){
            System.out.println("Error : " + e );
        }

    }

    public static void clearBytes(byte[] arr){
        for( int i = 0 ; i < arr.length ; i ++ )
            arr[i] = '\0' ;
    }

}