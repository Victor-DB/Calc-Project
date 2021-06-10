package com.tasks.io;

import java.io.*;

public class ByteWorkClass {

    public void readBytesFromArrayOfNums(byte[] arrByte) {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(arrByte);
        int b;
        System.out.print("readBytesFromArrayOfNums result: ");
        while ((b = byteStream.read()) != -1) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public void readBytesFromString(String string) throws IOException {
        byte[] arrByte = string.getBytes();
        int c;
        ByteArrayInputStream byteStream = new ByteArrayInputStream(arrByte);
        System.out.print("readBytesFromString result: ");
        while ((c = byteStream.read()) != -1) {
            System.out.print((char) c + " ");
        } System.out.println();
    }

    public void writeByteArrayFromString(String string) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] arrByte = string.getBytes();
        baos.write(arrByte);
        byte[] bufArr = baos.toByteArray();
        System.out.print("writeByteArrayFromString result: ");
        for (byte b : bufArr) {
            System.out.print((char) b + " ");
        }
        System.out.print(" ");
    }

    public void writeByteArrayToFile(String string) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] arrByte = string.getBytes();
        try {
            baos.write(arrByte);
        } catch (IOException e) { e.printStackTrace(); }

        try {
            FileOutputStream fos = new FileOutputStream("textByte.bin");
            baos.writeTo(fos);
            fos.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        String string = "Это предложение будет сконвертировано в байты";
        byte[] arrByte = new byte[] {1, 2, 3, 4, 5, 6, 7};
        ByteWorkClass bwc = new ByteWorkClass();
        bwc.readBytesFromArrayOfNums(arrByte);
        bwc.readBytesFromString(string);
        bwc.writeByteArrayFromString(string);
        bwc.writeByteArrayToFile(string);
    }
}


