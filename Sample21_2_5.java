package com.sample.MongoJava.connect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

/**
 * DB接続サンプルプログラム.
 * ・接続先1(host1.com:20000).
 * ・接続先2(host2.com:20000).
 * ユーザー情報
 * ・ユーザー名：mongoUser
 * ・パスワード：mongoPassword
 * 接続オプション
 * ・writeConcern{ w:1, j:true }
 */
public class Sample21_2_5 {

	public static void main(String[] args) {

		// ユーザー情報の作成
        MongoCredential credential =
        		MongoCredential.createCredential("mongoUser","testdb","mongoPassword".toCharArray());
        List<MongoCredential> credentialList = new ArrayList<>(Arrays.asList(credential));

        //接続先情報の作成
        ServerAddress primary = new ServerAddress("host1.com", 20000);
        ServerAddress secondary = new ServerAddress("host2.com", 20000);
        List<ServerAddress> serverList = Arrays.asList(primary, secondary);

        //接続オプションの作成
        MongoClientOptions options = MongoClientOptions.builder()
        		.writeConcern(WriteConcern.W1)
        		.writeConcern(WriteConcern.JOURNALED)
        		.build();

        //DB接続
        MongoClient client = new MongoClient(serverList, credentialList, options);

        //DBクローズ
        client.close();
	}
}
