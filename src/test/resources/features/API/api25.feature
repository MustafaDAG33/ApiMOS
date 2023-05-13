@api25
Feature: Dean hesabiyla student olustur
  Scenario: TC01 Student Olusturma
    Given "Ekrem123" ve "Ekrem" ile token al
    Given student olustur
    When beklenen student oldugunu dogrula

  Scenario: TC02 DB'den Student Olustugunu Dogrula
    Given db'den olusan student'i bul
    Then student'i dogrula

  Scenario: TC02 Student Cagirma
    Given user id no ile student hesabini cagir
    Then status kodunu dogrula

  Scenario: TC03 Student Silme
    Given user id no ile student hesabini sil
    Then student hesabinin silindigini dogrula
