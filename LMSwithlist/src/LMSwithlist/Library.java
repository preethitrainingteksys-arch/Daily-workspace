package LMSwithlist;

class Library {

    void reserve(String title) throws Exception {

        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }

        Object books;
		for (Book book : ((Object) books).values()) {
            if (book.title.equals(title) && book.getStatus() == STATUS.AVAILABLE) {
                book.setStatus(STATUS.BOOKED);
                System.out.println("Borrowed: " + title);
                return;
            }
        }

        throw new Exception("Book is not available.");
    }
}