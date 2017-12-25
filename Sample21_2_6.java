package com.sample.MongoJava.connect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * DAO生成サンプル
 * ・データベース名：testdb
 * ・コレクション名：employee
 */
public class Sample21_2_6 {

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

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //各種CRUD操作

        //DBクローズ
        client.close();
	}
}
