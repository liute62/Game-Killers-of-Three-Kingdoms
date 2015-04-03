package com.system.utils;

import java.io.FileReader;

import org.easymock.Mock;
import org.easymock.internal.MockBuilder;
import org.junit.Test;


public class UtilsTestcase {

	@Test
	public void testInitialCards()
	{
		File mockFile = EasyMock.createMock(File.class);
		FileReader mockIn = EasyMock.createMock(FileReader.class);
		BufferedReader mockBr = EasyMock.createMock(BufferedReader.class);
		
		EasyMock.expect(new FileReader(mockFile)).andReturn(mockIn);
		EasyMock.expect(new BufferedReader(mockIn)).andReturn(mockBr);
		
		
	
	}
	
}
