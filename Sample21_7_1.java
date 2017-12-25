package com.sample.MongoJava.delete;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * deleteOneサンプルプログラム.
 */
public class Sample21_7_1 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //deleteOne実行
        collection.deleteOne(eq("firstName", "田村"));

        //DBクローズ
        client.close();
	}
}
