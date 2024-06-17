CREATE TABLE user_requests (
  token CHARACTER(36) NOT NULL,
  operation_type CHARACTER VARYING(64) NOT NULL,
  user_id CHARACTER(36) NOT NULL,
  user_name CHARACTER VARYING(64),
  email CHARACTER VARYING(40),
  hashed_password CHARACTER(64),
  salt CHARACTER(32),
  reg_date DATE,
  new_email CHARACTER VARYING(40),
  new_hashed_password CHARACTER(64),
  new_salt CHARACTER(32),
  expiry TIMESTAMP NOT NULL,
  CONSTRAINT user_requests_pkey PRIMARY KEY (token)
);
