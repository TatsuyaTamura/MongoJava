package com.sample.MongoJava.connect;

import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * DB接続サンプルプログラム.
 * 接続先1(host1.com:20000).
 * 接続先2(host2.com:20000).
 */
public class Sample21_2_3 {

	public static void main(String[] args) {

		// 接続情報の作成
        ServerAddress primary = new ServerAddress("host1.com", 20000);
        ServerAddress secondary = new ServerAddress("host2.com", 20000);
        List<ServerAddress> serverList = Arrays.asList(primary, secondary);

        //DB接続(host1.com:20000, host2.com:20000)
        MongoClient client = new MongoClient(serverList);

        //DBクローズ
        client.close();
	}
}
