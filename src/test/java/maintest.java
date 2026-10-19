import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class maintest {
    private main p;

    @BeforeEach
    void setUp() {
        p = new main();
    }

    @Test
    @DisplayName("Test Diskon Besar")
    void testDiskonBesar() {
        assertEquals(20, p.hitungDiskon(150000));
    }

    @Test
    @DisplayName("Test Diskon Sedang")
    void testDiskonSedang() {
        assertEquals(10, p.hitungDiskon(75000));
    }

    @Test
    @DisplayName("Test Diskon Nol")
    void testDiskonNol() {
        assertEquals(0, p.hitungDiskon(20000));
    }

    @ParameterizedTest
    @DisplayName("Test BVA Klasifikasi Nilai")
    @CsvSource({
        "0, Remedial",
        "74, Remedial",
        "75, Lulus",
        "90, Lulus",
        "100, Lulus"
    })
    void testBvaKlasifikasiNilai(int nilai, String expected) {
        assertEquals(expected, p.klasifikasiNilai(nilai));
    }

    @Test
    @DisplayName("Test Pembagian Normal")
    void testBagiNormal() {
        assertEquals(5, p.bagi(10, 2));
    }

    @Test
    @DisplayName("Test Negatif: Diskon Negatif")
    void testNegatifDiskon() {
        assertThrows(IllegalArgumentException.class, () -> p.hitungDiskon(-1));
    }

    @Test
    @DisplayName("Test Negatif: Bagi dengan Nol")
    void testNegatifBagiNol() {
        assertThrows(ArithmeticException.class, () -> p.bagi(10, 0));
    }

    @Test
    @DisplayName("Test Negatif: Nilai Di Luar Batas")
    void testNegatifNilai() {
        assertThrows(IllegalArgumentException.class, () -> p.klasifikasiNilai(101));
    }
}
