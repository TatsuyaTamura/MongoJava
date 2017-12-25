package com.sample.MongoJava.insert;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * insertManyサンプルプログラム.
 */
public class Sample21_3_1 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //登録データ(JSON形式)
        String json = "{employeeID: 1, employeeName: \"田村\" , age: 30, division: \"営業1課\"}";

        //JSONをDocument型に変換
        Document doc = Document.parse(json);

        //insertOne実行
        collection.insertOne(doc);

        //DBクローズ
        client.close();
	}
}
