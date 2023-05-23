

public class test {
    public static void main(String[] args) {
        int harga_admin = 10000;
        String query = "INSERT INTO pembayaran (id_pendaftaran, harga_admin, total) SELECT id_pendaftaran, " + harga_admin + " AS harga_admin, (SELECT harga_dokter FROM dokter WHERE id_dokter = pendaftaran.id_dokter) + " + harga_admin + " AS total FROM pendaftaran WHERE id_pendaftaran = ?;";
        System.out.println(query);
    }
}
