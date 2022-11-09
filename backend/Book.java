package lab.backend;

class Book implements LibraryObject {

    private String bookId;
    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;

    Book(String bookId, String title, String authorName, String publisherName, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        setQuantity(quantity);
    }
    
    @Override
    public String lineRepresentation() {
        return String.join(",", bookId, title, authorName, publisherName, String.valueOf(quantity));
    }
    
    @Override
    public String getSearchKey() {
        return bookId;
    }

    int getQuantity() {
        return quantity;
    }

    final void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
        
        else{
            this.quantity = 0;
        }
    }

}
