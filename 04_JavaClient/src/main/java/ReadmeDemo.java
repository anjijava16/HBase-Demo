package com.bornski.hadoop.hbasedemo;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;


public class ReadmeDemo {

    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();

        HTable users_table = new HTable(conf, "users");

        for (int i = 1; i <= 10; i++) {
            Put p = new Put(Bytes.toBytes("user" + i));
            p.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("User" + i + "'s name"));
            users_table.put(p);
        }
        Get g = new Get(Bytes.toBytes("user1"));
        Result r = users_table.get(g);
        System.out.println("Name = " + Bytes.toString(r.getValue(Bytes.toBytes("info"), Bytes.toBytes("name"))));
        Scan s = new Scan();
        ResultScanner rs = users_table.getScanner(s);
        for (Result scan_r : rs) {
            System.out.println(Bytes.toString(scan_r.getValue(Bytes.toBytes("info"), Bytes.toBytes("name"))));
        }

        users_table.close();
    }

}
