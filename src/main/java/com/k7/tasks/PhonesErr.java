package com.k7.tasks;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class PhonesErr {
    private String filePath;


    public List<String> getPhoneList() {
        try (SeekableByteChannel channel = Files.newByteChannel(Path.of(filePath), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String in = "";
            List<String> phoneList = new ArrayList<>();
            while (channel.read(buffer) != -1) {
                buffer.flip();
                in += getStringFromBuffer(buffer);
                String[] strParts = in.split("\n");
                for (int i = 0; i < strParts.length - 1; i++) {
                    System.out.println("strParts[" + i + "]: " + strParts[i]);
                    phoneList.add(parse(strParts[i]));
                }
                in = strParts[strParts.length - 1];
                 System.out.println("in: " + in);
                buffer.clear();
            }
            if (parse(in) != null)
                phoneList.add(parse(in));
            return phoneList;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    private String getStringFromBuffer(ByteBuffer buffer) {
        return new String(buffer.array(), buffer.position(), buffer.limit());
    }

    private String parse(String user) {
        Pattern pattern = Pattern.compile("(?:(.+)\\[)(?:(.+):)(?:(.+)\\])");
        Matcher matcher = pattern.matcher(user);
        String parsedPhone;
        if ((!matcher.matches())) {
            System.out.println(user + " - Invalid String!");
            return null;
        } else {
            parsedPhone=matcher.group();
        }
        return parsedPhone;
    }


}
