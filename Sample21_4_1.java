package com.sample.MongoJava.find;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * 全件検索サンプルプログラム.
 */
public class Sample21_4_1 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //find実行(全件検索)
        FindIterable<Document> fit = collection.find();

        //全件表示(iterator)
        MongoCursor<Document> cursor = fit.iterator();
        while(cursor.hasNext()) {
        	Document doc = cursor.next();
        	System.out.println(doc.toJson());
        }

        //DBクローズ
        client.close();
	}
}
