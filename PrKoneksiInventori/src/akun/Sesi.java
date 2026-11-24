
package akun;

public final class Sesi {
    private final String nama;
    private final String username;
    private final String peran;

    public Sesi(String nama, String username, String peran) {
        this.nama = nama;
        this.username = username;
        this.peran = peran;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPeran() {
        return peran;
    }

    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(peran);
    }

    public boolean bolehSimpan() {
        return isAdmin();
    }
}
