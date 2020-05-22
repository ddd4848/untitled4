import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.*;
public class client {


    public static void main(String arg[]) throws Exception {
        BufferedReader informuser = new BufferedReader(new InputStreamReader(System.in))   ;
        DatagramSocket clientsocket = new DatagramSocket();
        InetAddress IPa = InetAddress.getByName("localhost")
                ;byte[] recivedt = new byte[1024];


        byte[] senddt =new byte[1024];
        while( true) {
            String setence = informuser.readLine();
            senddt = setence.getBytes();
            DatagramPacket sendpk = new DatagramPacket(senddt, senddt.length, IPa, 9876);
            clientsocket.send(sendpk);
            DatagramPacket recepk = new DatagramPacket(recivedt, recivedt.length);
            clientsocket.receive(recepk);
            String modi = new String(recepk.getData());

            System.out.println("    from sever " + modi);
            modi="";
            setence="";
          break;
        }
    }
}