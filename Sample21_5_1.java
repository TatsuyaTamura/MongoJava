package com.sample.MongoJava.aggregation;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;

/**
 * 各種集計サンプルプログラム.
 */
public class Sample21_5_1 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //$group(avg)
        Bson group =
        	Aggregates.group("$division", Accumulators.avg("sum_age", "$age"));

        List<Bson> listBson = new ArrayList<>();
        listBson.add(group);

        //aggregation実行(sum)
        AggregateIterable<Document> ait =
        		collection.aggregate(listBson);

        //全件表示(iterator)
        MongoCursor<Document> cursor = ait.iterator();
        while(cursor.hasNext()) {
        	Document doc = cursor.next();
        	System.out.println(doc.toJson());
        }

        //DBクローズ
        client.close();
	}
}
