package com.sample.MongoJava.connect;

import com.mongodb.MongoClient;

/**
 * DB接続サンプルプログラム.
 * 接続先(localhost:27017).
 */
public class Sample21_2_1 {

	public static void main(String[] args) {

		//DB接続(localhost:27017)
		MongoClient client = new MongoClient();

		//DBクローズ
		client.close();
	}
}
