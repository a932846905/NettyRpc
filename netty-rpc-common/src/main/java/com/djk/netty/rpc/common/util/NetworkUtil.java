package com.djk.netty.rpc.common.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkUtil {
    public static InetAddress getInetAddress(String Name, int type) {
        try {
            Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
            InetAddress addr;
            if (type == 4) {
                while (nifs.hasMoreElements()) {
                    NetworkInterface nif = nifs.nextElement();
                    Enumeration<InetAddress> addresses = nif.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        addr = addresses.nextElement();
                        if (nif.getName().equals(Name) && addr instanceof Inet4Address) {
                            return addr;
                        }
                    }
                }
            } else if (type == 6) {
                while (nifs.hasMoreElements()) {
                    NetworkInterface nif = nifs.nextElement();
                    Enumeration<InetAddress> addresses = nif.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        addr = addresses.nextElement();
                        if (nif.getName().equals(Name) && addr instanceof Inet6Address) {
                            return addr;
                        }
                    }
                }
            } else {
                System.out.println("类型指定错误,将输出全部网卡接口信息");
                System.out.println();
                while (nifs.hasMoreElements()) {
                    NetworkInterface nif = nifs.nextElement();
                    Enumeration<InetAddress> addresses = nif.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        addr = addresses.nextElement();
                        System.out.println("网卡接口名称：" + nif.getName());
                        System.out.println("网卡接口地址：" + addr.getHostAddress());
                        System.out.println();
                    }
                }
                return null;
            }

        } catch (Exception e) {
            System.out.println("获取Socket失败");
        }
        return null;
    }
}
