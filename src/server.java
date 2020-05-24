import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.*;
public class server {


    public static void main(String arg[]) throws Exception

    {
        DatagramSocket sevesoke = new DatagramSocket(9876)
;
        byte[] recivedt = new byte[1024];
       byte[] senddt =new byte[1024];
while (true) {

    DatagramPacket recivepk = new DatagramPacket(recivedt,recivedt.length);
    sevesoke.receive(recivepk);
    String setene= new String(recivepk.getData());
    InetAddress IPadress = recivepk.getAddress();
    int port = recivepk.getPort();
    System.out.println(" from client " + IPadress + " at port " + port +"  with data  " + setene);
String captital =setene.toUpperCase();
senddt= captital.getBytes();
        DatagramPacket sendpaket=new DatagramPacket(senddt,senddt.length,IPadress,port);
        sevesoke.send(sendpaket);
}



    }

}
