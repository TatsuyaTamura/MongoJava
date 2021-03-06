package com.sample.MongoJava.find;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * 部分一致検索サンプルプログラム.
 */
public class Sample21_4_4 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //取得フィールドの指定
        Document field = new Document();
        field.append("_id", 0);

        //find実行(部分一致検索)
        FindIterable<Document> fit = collection.find(regex("employeeName","田"))
        		.projection(field);

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
