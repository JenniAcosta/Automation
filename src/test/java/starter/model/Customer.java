package starter.model;

public enum Customer {
    Jennifer("jennifer@gmail.com","Secret_Jennifer");

    final String username;
    final String password;

    Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static Customer withName(String name) {
        return valueOf(name);
    }
}
