package com.sample.MongoJava.insert;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;

/**
 * BulkInsertサンプルプログラム.
 */
public class Sample21_3_3 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //登録ドキュメント(JSON形式)
        String json1 = "{employeeID: 4, employeeName: \"中山\", age: 37, division: \"営業2課\"}";
        String json2 = "{employeeID: 5, employeeName: \"吉田\", age: 35, division: \"経理課\"}";

        //Document型に変換
        Document doc1 = Document.parse(json1);
        Document doc2 = Document.parse(json2);

        //Bulk用Listの生成
        List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();

        //Bulk用ListにDocumentを追加
        writes.add(new InsertOneModel<Document>(doc1));
        writes.add(new InsertOneModel<Document>(doc2));

        //BulkのOption設定(順次実行)
        BulkWriteOptions op = new BulkWriteOptions();
        op.ordered(true);

        //BulkInsert実行
        BulkWriteResult bwr = collection.bulkWrite(writes, op);

        //DBクローズ
        client.close();
	}
}
