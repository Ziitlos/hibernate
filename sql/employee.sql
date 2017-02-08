CREATE TABLE EMPLOYEE (
  ID NUMBER(10) NOT NULL,
  first_name VARCHAR2(20),
  last_name VARCHAR2(20),
  salary NUMBER(10),
  PRIMARY KEY (id)
);

CREATE SEQUENCE employee_sequence START WITH 1;

CREATE OR REPLACE TRIGGER employee_bir
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
  BEGIN
    SELECT employee_sequence.nextval
    INTO :new.id
    FROM dual;
  END;

COMMIT;
