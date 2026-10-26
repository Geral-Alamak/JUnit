from unittest.mock import Mock
import pytest
from main import Penilaian

@pytest.fixture
def p():
    instance = Penilaian()
    yield instance
    del instance  # Cleanup

def test_diskon_besar(p):
    assert p.hitung_diskon(150000) == 20

def test_diskon_sedang(p):
    assert p.hitung_diskon(75000) == 10

def test_diskon_nol(p):
    assert p.hitung_diskon(20000) == 0

@pytest.mark.parametrize("nilai,expected", [
    (0, "Remedial"),
    (74, "Remedial"),
    (75, "Lulus"),
    (90, "Lulus"),
    (100, "Lulus")
])
def test_bva_klasifikasi_nilai(p, nilai, expected):
    assert p.klasifikasi_nilai(nilai) == expected

def test_bagi_normal(p):
    assert p.bagi(10, 2) == 5

def test_negatif_diskon(p):
    with pytest.raises(ValueError):
        p.hitung_diskon(-1)

def test_negatif_bagi_nol(p):
    with pytest.raises(ZeroDivisionError):
        p.bagi(10, 0)

def test_negatif_nilai(p):
    with pytest.raises(ValueError):
        p.klasifikasi_nilai(101)

def test_mock_usage(p):
    mock_func = Mock(return_value=True)
    res = mock_func(p.hitung_diskon(100000))
    mock_func.assert_called_once_with(20)
    assert res is True
