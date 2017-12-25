package com.sample.MongoJava.update;

import static com.mongodb.client.model.Updates.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * updateManyサンプルプログラム.
 */
public class Sample21_6_2 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //updateMany実行(全件更新)
        collection.updateMany(
            new Document(), //検索条件
            set("age",60)); //更新内容

        //DBクローズ
        client.close();
	}
}
