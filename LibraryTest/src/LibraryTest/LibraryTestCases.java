package LibraryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LibraryTestCases {
	

	@Test
	void testaddbook() {
		Library lib=new Library(5);
		int result=lib.addbook(3);
		assertEquals(8, result);
		
	}
	@Test
	void testborrowbook()
	{
		Library lib=new Library(0);
		assertThrows(IllegalArgumentException.class,()->{
			lib.borrowbook();
		});
	}
	@Test
	void testgetAvaialblebooks()
	{
		Library lib=new Library(10);
		assertEquals(10, lib.getAvailablebooks());
	}

}
