package com.helloword.database.test;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.helloword.database.NewWordManager;
import com.helloword.database.beans.NewWord;

import android.content.Context;
import android.provider.UserDictionary.Words;
import android.test.AndroidTestCase;
import android.util.Log;

public class NewWordManagerTest extends AndroidTestCase {
	NewWordManager manage ;
	static String LOG_TAG = "NewWordManagerTest";
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Context mContext = this.getContext();
		
		manage = new NewWordManager(mContext);
		Log.d(LOG_TAG, "begin unittest");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testAll() {
		boolean result = manage.delAllNewWordFromList();
		assertEquals(result, true);
		
		NewWord word = new NewWord();
//		word.word_id = 1;
//		word.word_content = "hello";
//		word.word_meaning = "aa";
//		word.word_type    = 1;
		result = manage.addNewWordToList(word);
		assertEquals(result, true);
		Log.d(LOG_TAG, "add word to list");
		
		List<NewWord> words = manage.ListNewWordFromList(0, 10);
		Log.d(LOG_TAG, "word list size is " + words.size());
		assertEquals(words.size(), 1);
		
		NewWord word2 = manage.GetNewWordFromListById(1);
		
//		assertEquals(word2.word_content, "hello");
		
		result = manage.delNewWordFromList(1);
		assertEquals(result, true);
		
		result = manage.delAllNewWordFromList();
		assertEquals(result, true);
	}


}
