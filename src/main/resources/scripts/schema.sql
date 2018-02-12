CREATE TABLE POLICY(
  transaction_ref    VARCHAR(100) PRIMARY KEY,
  business_data VARCHAR(1000)
);

CREATE TABLE MESSAGES(
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  transaction_ref    VARCHAR(100),
  data_to_send VARCHAR(1000) 
);

ALTER TABLE MESSAGES ADD FOREIGN KEY (transaction_ref) REFERENCES POLICY(transaction_ref);