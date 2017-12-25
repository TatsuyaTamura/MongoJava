package com.sample.MongoJava.delete;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * deleteManyサンプルプログラム.
 */
public class Sample21_7_2 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //deleteMany実行
        collection.deleteMany(gte("age", 35));

        //DBクローズ
        client.close();
	}
}
