package lab.backend;

class LibrarianUser implements LibraryObject{

    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    LibrarianUser(String id, String name, String email, String address, String phoneNumber) {
        this.id = id; 
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public  String getSearchKey() {
        return id;
    }
    
    
    @Override
    public  String lineRepresentation() {
        return String.join(",", id, name, email, address, phoneNumber);

    }

}