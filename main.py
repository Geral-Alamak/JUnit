class Penilaian:
    def hitung_diskon(self, total: int) -> int:
        if total < 0:
            raise ValueError("Total tidak boleh negatif")
        if total >= 100000:
            return 20
        if total >= 50000:
            return 10
        return 0

    def klasifikasi_nilai(self, nilai: int) -> str:
        if not (0 <= nilai <= 100):
            raise ValueError("Nilai harus 0-100")
        if nilai >= 75:
            return "Lulus"
        return "Remedial"

    def bagi(self, a: int, b: int) -> int:
        if b == 0:
            raise ZeroDivisionError("Pembagi nol")
        return a // b
