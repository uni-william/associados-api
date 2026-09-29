set session_replication_role = 'replica';

DELETE FROM company;
INSERT INTO company (id, document,email, name, phone, associate_tax, day_base, address_city, address_complement, address_neighborhood,
                     address_number, address_state, address_street, address_zip_code, created_at)
VALUES(
       '6e148bd5-47f6-4022-b9da-07cfaa294f7a',
       '38431538000123',
       'apm@gmail.com',
       'Moto Clube Apaixpmados por Motos',
       '92997841254',
       20.00,
       20,
       'Manais',
       'Sala 101',
       'Centro',
       '100',
       'AM',
       'Rua das Flores',
       '69043000',
       TIMESTAMP '2021-01-01 00:00:00'
       );


set session_replication_role = 'origin';