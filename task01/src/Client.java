import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public final class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        // using console to receive input from keyboard
        Console console = System.console();

        // opening a socket to connect to the server on port xxxx
        Socket socket = new Socket("localhost", 5000);

        try (OutputStream os = socket.getOutputStream()) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            try (InputStream is = socket.getInputStream()) {
                BufferedInputStream bis = new BufferedInputStream(is);
                DataInputStream dis = new DataInputStream(bis);

                // reading the string
                String keyInput = dis.readUTF(); 

                // calculate mean of numbers
                Double average = keyInput.mapToInt(val -> val).average().orElse(0.0);

                //calculate standard deviation of numbers
                 double powerSum1 = 0;
                 double powerSum2 = 0;
                 double stdev = 0;
                 
                 for i in range(0, keyInput.length) {
                     powerSum1 += total[i];
                     powerSum2 += Math.pow(total[i], 2);
                     stdev = Math.sqrt(i*powerSum2 - Math.pow(powerSum1, 2))/i;
                     System.out.println(total[i]); 
                 }
                 System.out.println(stdev); 

                 dos.writeUTF("CHANEL HUANG", average, stdev);
                dos.flush();
                   
                }

                bos.close();
                dos.close();
                socket.close();
            } catch (EOFException ex) {
                ex.printStackTrace();
                socket.close();
            }
        } catch (EOFException ex) {

            ex.printStackTrace();
            socket.close();
        }




    }

