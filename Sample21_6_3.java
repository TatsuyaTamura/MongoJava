package com.sample.MongoJava.update;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * replaceOneサンプルプログラム.
 */
public class Sample21_6_3 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //replaceデータ(JSON形式)
        String json = "{employeeID: 1, firstName: \"田村\" , lastName: \"達也\", age: 30}";

        //JSONをDocument型に変換
        Document doc = Document.parse(json);

        //replaceOne実行
        collection.replaceOne(
            eq("employeeID", 1), //検索条件
            doc); //更新内容

        //DBクローズ
        client.close();
	}
}
