package ru.billing.stocklist;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Reader implements Iterator<String> {

    private ArrayList<String> textLines = new ArrayList<>();

    public Reader(File file, String charsetName) throws IOException {
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader inputStream = new InputStreamReader(fileStream,charsetName);
        BufferedReader br = new BufferedReader(inputStream);
        String line;
        do {
            line = br.readLine();
            textLines.add(line);

        } while(line != null);
        fileStream.close();
        inputStream.close();
        br.close();
    }

    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
        return currentIndex < textLines.size() & textLines.get(currentIndex) != null;
    }

    @Override
    public String next() {
        String line = textLines.get(currentIndex);
        currentIndex++;
        return line;
//        return textLines.get(currentIndex++);
    }
}
