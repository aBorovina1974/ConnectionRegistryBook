INSERT INTO modification (id, name, description)
VALUES (1, 'promjena vlasništva', null);
INSERT INTO modification (id, name, description)
VALUES (2, 'izmještaj', null);
INSERT INTO modification (id, name, description)
VALUES (3, 'promjena statusa', null);

INSERT INTO connection_category (id, name, description)
VALUES (1, 'stalni prikljuèak', null);
INSERT INTO connection_category (id, name, description)
VALUES (2, 'privremeni prikljuèak', null);
INSERT INTO connection_category (id, name, description)
VALUES (3, 'prikljuèak s ogranièenim korištenjem', null);

INSERT INTO request_purpose (id, name, description)
VALUES (1, 'vodoopskrba', null);
INSERT INTO request_purpose (id, name, description)
VALUES (2, 'odvodnja', null);
INSERT INTO request_purpose (id, name, description)
VALUES (3, 'vodoopskrba i odvodnja', null);

INSERT INTO status (id, name, description)
VALUES (1, 'zahtjev', null);
INSERT INTO status (id, name, description)
VALUES (2, 'aktivan', null);
INSERT INTO status (id, name, description)
VALUES (3, 'iskljuèen', null);

INSERT INTO municipality (id, name, description)
VALUES (1, 'Blato', null);
INSERT INTO municipality (id, name, description)
VALUES (2, 'Vela Luka', null);
INSERT INTO municipality (id, name, description)
VALUES (3, 'Smokvica', null);

INSERT INTO connection_purpose (id, name, description)
VALUES (1, 'stambena graðevina', null);
INSERT INTO connection_purpose (id, name, description)
VALUES (2, 'poslovna graðevina', null);
INSERT INTO connection_purpose (id, name, description)
VALUES (3, 'poljoprivredna graðevina', null);
INSERT INTO connection_purpose (id, name, description)
VALUES (4, 'graðevno zemljište', null);
INSERT INTO connection_purpose (id, name, description)
VALUES (5, 'poljoprivredno zemljište', null);

INSERT INTO unit (id, name, description)
VALUES (1, 'metar', null);

INSERT INTO profile (id, name, description)
VALUES (1, '1/2', null);
INSERT INTO profile (id, name, description)
VALUES (2, '3/4', null);
INSERT INTO profile (id, name, description)
VALUES (3, '6/4', null);

INSERT INTO request_type (id, name, description)
VALUES (1, 'novi prikljuèak', null);
INSERT INTO request_type (id, name, description)
VALUES (2, 'promjena vlasništva', null);
INSERT INTO request_type (id, name, description)
VALUES (3, 'izmještaj', null);

INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (1, 'Ante', 'Borovina', '12221376543', 'ul 17. br. 10 20271 Blato', '020851643', 'aborovina74@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (2, 'Ksenija', 'Borovina', '23331143258', 'ul 22. br. 11 20271 Blato', '020851232', 'ksenija.borovina@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (3, 'Sandy', 'Baèiæ', '88234123123', 'ul 1. br. 10 20271 Blato', '020852122', 'sandyb@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (4, 'Ivo', 'Iviæ', '32132145678', 'Poljièka ulica Split', '021113642', 'iivic@yahoo.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (5, 'Petar', 'Petroviæ', '99886543211', 'Obala bb Vela Luka', '020813666', 'ppetrovic@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (6, 'Marija', 'Mariæ', '77652312312', 'Ulica Franje Tuðmana br.3 Vela Luka', '020813222', 'marija.maric@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (7, 'Marijo', 'Marinoviæ', '13323245656', 'ul 12. br. 10 Blato', '020851888', 'marijo.marinoviæ@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (8, 'Mitar', 'Barèot', '13323283656', 'ul 1. br. 18 Vela Luka', '020812313', 'mbarcot@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (9, 'Edi', 'Oreb', '13323288856', 'ul 38. br. 10 Vela Luka', '020812300', 'edi.oreb@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (10, 'Petar', 'Radovanoviæ', '13323299999', 'ul 15. br. 8 Smokvica', '020814877', 'petar.radovanovic@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (11, 'Ivan', 'Pecotiæ', '55523245787', 'ul 3. br. 11 Smokvica', '0208144444', 'i.radovanovic@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (12, 'Vinko', 'Rubeša', '13535245656', 'ul 18. br. 36 Vela Luka', '020812200', 'v.rubesa@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (13, 'Ivan', 'Gugiæ', '33323249874', 'ul 32. br. 80 Vela Luka', '020812122', 'mivan.gugic@gmail.com' );
INSERT INTO person (id, name, surname_nickname, oib, address, phone, email)
VALUES (14, 'Markica', 'Padovan', '44355545655', 'ul 17. br. 7 Blato', '020851666', 'm.padovan@gmail.com' );

INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (1, '2018-09-08', 1, 1, 3, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (2, '2018-09-09', 2, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (3, '2018-09-11', 3, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (4, '2018-09-15', 4, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (5, '2018-09-16', 5, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (6, '2018-09-19', 6, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (7, '2018-09-20', 7, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (8, '2018-06-20', 8, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (9, '2018-03-23', 9, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (10, '2018-09-25', 10, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (11, '2018-05-21', 11, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (12, '2018-1-28', 12, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (13, '2018-04-30', 13, 1, 1, null);
INSERT INTO connection_request_form (id, submission_date, submitter, request_type, request_purpose, author)
VALUES (14, '2018-08-03', 14, 1, 1, null);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (1, 1, null, 1, null, null, '123/ab', null, 1, '321/bba', 1, 'Blato Mali Uèijak', 'Blato ul 11. br. 1', 1, null, true);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (2, 2, null, 1, null, null, '444/cd', null, 1, '111/bbc', 1, 'Blato Vela Strana', 'Blato ul 22. br. 3', 1, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (3, 3, null, 1, null, null, '323/cc', null, 1, '12345/b', 1, 'Blato Prigradica', 'Prigradica', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (4, 4, null, 1, null, null, '341/oo', null, 1, '12333/bo', 1, 'Blato Doèine', 'Blato ul 20. br. 1', 1, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (5, 5, null, 1, null, null, '112/ic', null, 1, '12001/ic', 2, 'Vela Luka Bobovišæa', 'Vela Luka ul 8. br. 16', 1, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (6, 6, null, 1, null, null, '999/ca', null, 1, '55345/b', 1, 'Blato Krtinja', 'Blato ul 1. br. 8', 1, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (7, 7, null, 1, null, null, '1010/ab', null, 1, '222/bo', 1, 'Blato Prižba', 'Prižba', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (8, 8, null, 1, null, null, '1510/ab', null, 1, '22555/cg', 1, 'Blato Prižba', 'Prižba', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (9, 9, null, 1, null, null, '1010/ab', null, 1, '66551/zz', 3, 'Vinaèac', 'Prižba', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (10, 10, null, 1, null, null, '1010/ax', null, 1, '99999/ks', 3, 'Brna', 'Brna', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (11, 11, null, 1, null, null, '1010/az', null, 1, '889900/gu', 3, 'Smokvica', 'ul 8. br. 1', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (12, 12, null, 1, null, null, '1011/ab', null, 1, '211334/ij', 1, 'Blato Gršæica', 'Gršæica bb', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (13, 13, null, 1, null, null, '1011/bb', null, 1, '552334/sa', 2, 'Garma', 'Garma bb', 5, null, false);

INSERT INTO connection (id, request_form_id, contract_id, connection_category, connection_date, work_order_id, registry_book_no, owner, status, cadastral_parcel_no, cadastral_municipality, settlement_area, address, connection_purpose, documentation, has_drainage)
VALUES (14, 14, null, 1, null, null, '2010/ab', null, 1, '112388/to', 1, 'Blato Krtinja', 'ul 45. br. 14 Blato', 5, null, false);

INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (1, '1/a', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (2, '1/b', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (3, '1/c', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (4, '1/d', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (5, '1/e', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (6, '1/f', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (7, '2/a', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (8, '2/b', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (9, '2/c', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (10, '2/d', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (11, '2/e', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (12, '2/f', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (13, '2/g', null, null);
INSERT INTO work_order (id, work_order_no, working_hours, work_type)
VALUES (14, '2/h', null, null);

INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (1, 1);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (2, 1);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (3, 2);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (3, 3);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (4, 4);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (5, 5);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (6, 6);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (7, 7);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (8, 8);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (9, 9);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (10, 10);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (11, 11);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (12, 12);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (13, 13);
INSERT INTO work_order_connection(work_order_id, connection_id)
VALUES (14, 14);