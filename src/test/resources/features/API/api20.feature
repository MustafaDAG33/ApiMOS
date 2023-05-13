@api20
Feature: Teacher Toplantilari Gorebilmeli Guncelleyebilmeli ve Silebilmeli

  Scenario: TC01 Toplanti Olustur
    Given "AydinOnan" ve "Aydin Onan" ile token al
    Given teacher hesabiyla bir toplanti olustur
    Then beklenen toplantinin oldugunu dogrula

  Scenario: TC02 DB ile Toplantiyi Dogrula
    Given Teacher hesabiyla olusturulan toplantiyi bul
    Then Toplantiyi dogrula

  Scenario: TC03 Tum Toplantilari Cagir
    Given teacher hesabiyla tum toplantilari cagir
    When toplantilarin geldigini dogrula

  Scenario: TC04 Toplantiyi Guncelle
    Given toplanti id no ile toplantiyi editle
    Then toplantinin editlendigini dogrula

  Scenario: TC05 Toplantiyi Sil
    Given user id no ile toplantiyi sil
    Then toplantinin silindigini dogrula

  Scenario: TC06 Toplantinin Silindigini Dogrula
    Given Teacher hesabiyla olusturulan toplantiyi bul
    Then toplantinin db'den silindigini dogrula










