package com.sample.MongoJava.insert;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * insertOneサンプルプログラム.
 */
public class Sample21_3_2 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //登録データ(JSON形式)
        String json1 = "{employeeID: 2, employeeName: \"山田\" , age: 31, division: \"営業1課\"}";
        String json2 = "{employeeID: 3, employeeName: \"佐藤\" , age: 23, division: \"営業2課\"}";

        //JSONをDocument型に変換
        Document doc1 = Document.parse(json1);
        Document doc2 = Document.parse(json2);

        //DocumentをListに格納
        List<Document> documents = new ArrayList<Document>();
        documents.add(doc1);
        documents.add(doc2);

        //insertMany実行
        collection.insertMany(documents);

        //DBクローズ
        client.close();
	}
}
