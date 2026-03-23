package LMSwithlist;



public class LibraryTest {
	
	Library library;
	void shouldThrowExceptionWhenTitleIsNull() {
		
		assertThrows(IllegalArgumentException.class.()->library)
	}
	
		/*try {
			lib.reserve(null);
		} catch (IllegalArgumentException e) {
			System.out.println("Passed: null title test");
		} catch (Exception e) {
		}
	}*/
	//voidTestSuccessfulReservation()
	{
		Book book=new Book("1","Learn Java",100.1f,"Pariwesh");
		library.books.add(book);
		library.reserve("Learn Java");
		assertEquals(STATUS.BOOKED,book.getStatus());
	}
}//
	
	void shouldThrowExceptionWhenTitleIsBlank() {
		Library lib = new Library();
		
	
	
	

      

        try {
            lib.reserve("");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: blank title test");
        } catch (Exception e) {
        }
    }

    void shouldThrowExceptionWhenTitleHasOnlyWhitespace() {
        Library lib = new Library();

        try {
            lib.reserve("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: whitespace title test");
        } catch (Exception e) {
        }
    }
}



/*
