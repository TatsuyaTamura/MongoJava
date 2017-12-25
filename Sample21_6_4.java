package com.sample.MongoJava.update;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;

/**
 * BulkUpdateサンプルプログラム.
 */
public class Sample21_6_4 {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //検索条件ドキュメント
        Bson filter1 = eq("employeeID", 1);
        Bson filter2 = eq("employeeID", 2);
        Bson filter3 = eq("employeeID", 3);
        Bson filter4 = eq("employeeID", 4);
        Bson filter5 = eq("employeeID", 5);

        //更新ドキュメント
        Bson update1 = set("age", 30);
        Bson update2 = set("age", 31);
        Bson update3 = set("age", 23);
        Bson update4 = set("age", 37);
        Bson update5 = set("age", 35);

        //Bulk用Listの生成
        List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();

        //Bulk用ListにDocumentを追加
        writes.add(new UpdateOneModel<Document>(filter1, update1));
        writes.add(new UpdateOneModel<Document>(filter2, update2));
        writes.add(new UpdateOneModel<Document>(filter3, update3));
        writes.add(new UpdateOneModel<Document>(filter4, update4));
        writes.add(new UpdateOneModel<Document>(filter5, update5));

        //BulkのOption設定(順次実行)
        BulkWriteOptions op = new BulkWriteOptions();
        op.ordered(true);

        //BulkUpdate実行
        BulkWriteResult bwr = collection.bulkWrite(writes, op);

        //DBクローズ
        client.close();
	}
}
