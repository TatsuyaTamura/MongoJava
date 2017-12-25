package com.sample.MongoJava.delete;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.WriteModel;

/**
 * BulkDeleteサンプルプログラム.
 */
public class Sample21_7_3 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //検索条件ドキュメント
        Bson filter1 = eq("employeeID", 2);
        Bson filter2 = eq("employeeID", 3);

        //Bulk用Listの生成
        List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();

        //Bulk用ListにDocumentを追加
        writes.add(new DeleteOneModel<Document>(filter1));
        writes.add(new DeleteOneModel<Document>(filter2));

        //BulkのOption設定(順次実行)
        BulkWriteOptions op = new BulkWriteOptions();
        op.ordered(true);

        //BulkUpdate実行
        BulkWriteResult bwr = collection.bulkWrite(writes, op);

        //DBクローズ
        client.close();
	}
}
