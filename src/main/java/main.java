public class main {
    public int hitungDiskon(int total) {
        if (total < 0) throw new IllegalArgumentException("Total tidak boleh negatif");
        if (total >= 100000) return 20;
        if (total >= 50000) return 10;
        return 0;
    }

    public String klasifikasiNilai(int nilai) {
        if (nilai < 0 || nilai > 100) throw new IllegalArgumentException("Nilai harus 0-100");
        if (nilai >= 75) return "Lulus";
        return "Remedial";
    }

    public int bagi(int a, int b) {
        if (b == 0) throw new ArithmeticException("Pembagi nol");
        return a / b;
    }
}
