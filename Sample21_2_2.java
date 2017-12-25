package com.sample.MongoJava.connect;

import com.mongodb.MongoClient;

/**
 * DB接続サンプルプログラム.
 * 接続先(host1.com:20000).
 */
public class Sample21_2_2 {
	public static void main(String[] args) {

		//DB接続(host1.com:20000)
		MongoClient client = new MongoClient( "host1.com" , 20000 );

		//DBクローズ
		client.close();
	}
}
