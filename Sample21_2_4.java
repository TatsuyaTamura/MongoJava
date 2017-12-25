package com.sample.MongoJava.connect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * DB接続サンプルプログラム.
 * ・接続先1(host1.com:20000).
 * ・接続先2(host2.com:20000).
 * ユーザー情報
 * ・ユーザー名：mongoUser
 * ・パスワード：mongoPassword
 */
public class Sample21_2_4 {

	public static void main(String[] args) {

		// ユーザー情報の作成
        MongoCredential credential =
        		MongoCredential.createCredential("mongoUser","testdb","mongoPassword".toCharArray());
        List<MongoCredential> credentialList = new ArrayList<>(Arrays.asList(credential));

        //接続先情報の作成
        ServerAddress primary = new ServerAddress("host1.com", 20000);
        ServerAddress secondary = new ServerAddress("host2.com", 20000);
        List<ServerAddress> serverList = Arrays.asList(primary, secondary);

        //DB接続
        MongoClient client = new MongoClient(serverList, credentialList);

        //DBクローズ
        client.close();
	}
}
