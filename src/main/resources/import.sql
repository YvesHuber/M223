
INSERT INTO public."USER" (
id, "Email", "Nachname", "Passwort", "Role", "Vorname") VALUES (
'1'::bigint, 'Test@Email.test
'::character varying, 'Nachname'::character varying, '123456'::character varying, 'Admin'::character varying, 'Vorname'::character varying)
 returning id;

 INSERT INTO public."USER" (
id, "Email", "Nachname", "Passwort", "Role", "Vorname") VALUES (
'2'::bigint, 'Test@Email.test
'::character varying, 'Nachname'::character varying, '123456'::character varying, 'Mitglied'::character varying, 'Vorname'::character varying)
 returning id;


INSERT INTO public."BUCHUNG" (
id, "Datum", "Halbtag", "Status", "Visablility", user_id) VALUES (
'1'::bigint, '2022-09-26'::date, false::boolean, 'Accepted'::character varying, true::boolean, '1'::bigint)
 returning id;

 INSERT INTO public."BUCHUNG" (
id, "Datum", "Halbtag", "Status", "Visablility", user_id) VALUES (
'2'::bigint, '2022-09-26'::date, false::boolean, 'Accepted'::character varying, false::boolean, '2'::bigint)
 returning id;