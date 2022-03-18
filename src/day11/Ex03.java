package day11;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) throws IOException {

        //FileInputStream in = null;
        //FileOutputStream out = null;

        try(FileInputStream in = new FileInputStream("source.txt");
        FileOutputStream out = new FileOutputStream("replica.txt")) {
            //in = new FileInputStream("source.txt");
           // out = new FileOutputStream("replica.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
//            if (in != null) {
//                in.close();
//            }
//            if (out != null) {
//                out.close();
//            }
        }
    }
}
//public abstract class InputStream implements Closeable {
//    public abstract int read() throws IOException;
//    public int read(byte[] b) throws IOException { ... }
//    int read(byte[] b, int off, int len) throws IOException { ... }
//}
//
//public abstract class OutputStream implements Closeable {
//    public abstract void write(int b) throws IOException;
//    public int write(byte[] b) throws IOException { ... }
//    public int write(byte[] b, int off, int len) throws IOException { ... }
//}
