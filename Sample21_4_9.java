package com.sample.MongoJava.find;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

/**
 * ソートサンプルプログラム.
 */
public class Sample21_4_9 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //取得フィールドの指定
        Document field = new Document();
        field.append("_id", 0);

        //find実行(全件検索＋ソート)
        FindIterable<Document> fit = collection.find()
        		.projection(field)
        		.sort(Sorts.ascending("age"));

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
