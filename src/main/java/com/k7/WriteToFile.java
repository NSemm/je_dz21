package com.k7;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteToFile {


    synchronized public void write(String s) {
        try (SeekableByteChannel channel = Files.newByteChannel(
                Path.of("out.txt"),
                StandardOpenOption.APPEND)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(new String("s\n")
                    .getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
