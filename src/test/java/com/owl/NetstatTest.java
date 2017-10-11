package com.owl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wanghouping on 2017/10/8.
 * @author wang hou ping
 */
public class NetstatTest {

    private static final String call =
            "tcp 0 0 0.0.0.0:30732 0.0.0.0:* LISTEN 31/python\n" +
            "tcp 0 0 127.0.0.1:30732 0.0.0.0:* LISTEN 12/cupsd\n" +
            "tcp 0 0 127.0.0.1:3128 0.0.0.0:* LISTEN 6278/(squid)\n" +
            "tcp 0 0 127.0.0.1:25 0.0.0.0:* LISTEN 5854/exim4\n" +
            "tcp 0 0 127.0.0.1:25 0.0.0.0:* LISTEN 5854/exim4\n" +
            "udp 0 0 0.0.0.0:32769 0.0.0.0:* 6278/(squid)\n" +
            "udp 0 0 0.0.0.0:3130 0.0.0.0:* 6278/(squid)\n" +
            "udp 0 0 0.0.0.0:68 0.0.0.0:* 4583/dhclient3\n" +
            "udp 0 0 0.0.0.0:6881 0.0.0.0:* 6908/python";

    private static final String callStr =
            "root      5136     1  0 Sep05 ?        00:00:13 java -classpath .:log4j-1.2.14.jarjdbc14.jar RunThread EATER\n" +
            "root      5136     1  0 Sep05 ?        00:00:13 java -classpath .:demo.jar RunThread EATER\n" +
            "root      6416     1  0 Nov14 ?        00:01:35 /usr/java/jdk1.6.0_14";

    private static final Pattern pattern = Pattern.compile("([0-9]+)(?=/.*)");//匹配的模式

    private static final Pattern pattern1 = Pattern.compile("(?<=\\s+)([0-9]+)(?=\\s+)");

    public static void main(String[] args) {
        Matcher matcher = pattern.matcher(call);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
//        Matcher matcher = pattern1.matcher(callStr);
//        while(matcher.find()) {
//            System.out.println(matcher.group() + "\n");
//        }
    }
}
