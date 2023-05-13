#@ApiGetStudent
#Feature: Create_Student by Dean
#
#  Scenario: Create Student
#    Given create student
#    Then validate body the student
#
#  Scenario Outline: TC05_Validate_Student
#    Given userId ile request gonder
#    Then body soyle olmali: username="<username>" ssn="<ssn>" name="<name>" surname="<surname>" birthDay="<birthDay>" birthPlace="<birthPlace>" phoneNumber="<phoneNumber>" gender="<gender>" motherName="<motherName>" fatherName="<fatherName>" email="<email>"
#    Then validate body
#
#    Examples:
#    |username|ssn|name|surname|birthDay|birthPlace|phoneNumber|gender|motherName|fatherName|email|
#    |5.Henry|198-22-2547|David|Henry|2011-05-02|Paris|553-628-2547|MALE|Marry|Alex   |paris4@gmail.com|


