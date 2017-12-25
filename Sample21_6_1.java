package com.sample.MongoJava.update;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * updateOneサンプルプログラム.
 */
public class Sample21_6_1 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //updateOne実行
        collection.updateOne(
            eq("employeeName", "田村"), //検索条件
            (set("age", 31))); //更新内容

        //DBクローズ
        client.close();
	}
}
