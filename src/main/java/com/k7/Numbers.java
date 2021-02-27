package com.k7;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class Numbers {
    private String filePath;

    public String getSum(int n) {
        Integer sum = 0;
        if (getNumbers().size() < n) n = getNumbers().size();
        for (int i = 0; i < n; i++) {
            sum += getNumbers().get(i);
        }
        return sum.toString();
    }

    private List<Integer> getNumbers() {
        try (SeekableByteChannel channel = Files.newByteChannel(Path.of(filePath), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            String in = "";
            List<Integer> numbersList = new ArrayList<>();
            while (channel.read(buffer) != -1) {
                buffer.flip();
                in += getStringFromBuffer(buffer);
                String[] strParts = in.split(",");
                for (int i = 0; i < strParts.length - 1; i++) {
                    // System.out.println("strParts[" + i + "]: " + strParts[i]);
                    numbersList.add(Integer.valueOf(strParts[i]));
                }
                in = strParts[strParts.length - 1];
                // System.out.println("in: " + in);
                buffer.clear();
            }
            if (in != null)
                numbersList.add(Integer.valueOf(in));
            return numbersList;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private String getStringFromBuffer(ByteBuffer buffer) {
        return new String(buffer.array(), buffer.position(), buffer.limit());
    }
}
