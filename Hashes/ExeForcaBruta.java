package Hashes;

import java.io.*;

public class ExeForcaBruta {
    static long t0 = System.currentTimeMillis();
    public static void main(String[] args) throws IOException {

        ExeForcaBruta exeForcaBruta = new ExeForcaBruta();
        BruteForce fb = new BruteForce();
        BufferedReader br = new BufferedReader(new FileReader("passwords.txt"));
        StringBuilder sb = new StringBuilder(); String line = br.readLine();

        while (line != null) {
            String s = line;
            line = br.readLine();
            fb.forcaBruta(s);
        }
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0 + "ms");
    }

}
