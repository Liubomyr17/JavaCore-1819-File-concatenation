package com.company;

/*
1819 file concatenation
Read 2 file names from the console.
At the beginning of the first file, write the contents of the second file so that the file merges.
Close streams.

Requirements:
1. The program should read the file names from the console twice.
2. For the first file, create a stream for reading and read its contents.
3. Then, for the first file, create a stream for writing. For the second - for reading.
4. The contents of the first and second file must be combined in the first file.
5. First, the contents of the second file should go, then the contents of the first.
6. Streams created for files should be closed.
 */

import java.io.*;

public class Solution {
    static final int BUF_SIZE = 1024; //Размер буффера для чтения
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        fileToMem (mem, fileName2);
        fileToMem (mem, fileName1);
        FileOutputStream f = new FileOutputStream(fileName1);
        mem.writeTo(f);
        f.close();
    }

    public static void fileToMem(ByteArrayOutputStream mem, String fileName) throws IOException {
        FileInputStream f = new FileInputStream(fileName);
        int readedByte = 0;
        while (f.available() > 0) {
            byte[] buf = new byte[Solution.BUF_SIZE];
            readedByte = f.read(buf);
            mem.write(buf, 0, readedByte);
        }
        f.close();
    }
}



