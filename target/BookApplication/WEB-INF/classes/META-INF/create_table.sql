CREATE TABLE public.contact (
  id BIGINT not null,
  lastName VARCHAR(50),
  firstName VARCHAR(50),
  patronymic VARCHAR(50),
  dateBirth VARCHAR(50),
  address_id BIGINT,
  mail_id BIGINT,
  phone_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (address_id) REFERENCES address(id),
  FOREIGN KEY (mail_id) REFERENCES mail(id),
  FOREIGN KEY (phone_id) REFERENCES phone(id)
);

CREATE TABLE public.address (
  id BIGINT not null,
  value VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE public.mail (
  id BIGINT not null,
  value VARCHAR(100),
  view VARCHAR(20),
  flag BOOLEAN,
  PRIMARY KEY (id)
);

CREATE TABLE public.phone (
  id BIGINT not null,
  value VARCHAR(100),
  view VARCHAR(20),
  flag BOOLEAN,
  PRIMARY KEY (id)
);