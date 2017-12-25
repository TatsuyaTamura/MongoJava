package com.sample.MongoJava.aggregation;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;

/**
 * $countサンプルプログラム.
 */
public class Sample21_5_2 {

	public static void main(String[] args) {

        //DB接続
        MongoClient client = new MongoClient("localhost", 27017);

        //DAO生成
        MongoDatabase db = client.getDatabase("testdb");
        MongoCollection<Document> collection = db.getCollection("employee");

        //$match
        Bson match = Aggregates.match(eq("division", "営業1課"));

        //$count
        Bson count =
        	Aggregates.count("employee_count");

        List<Bson> listBson = new ArrayList<>();
        listBson.add(match);
        listBson.add(count);

        //aggregation実行($count)
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
