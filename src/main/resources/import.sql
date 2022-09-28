
-- Benutzer Imports

INSERT INTO public."USER" (
 "Email", "Nachname", "Passwort", "Role", "Vorname") VALUES (
'Test@Admin.test'::character varying, 'Huber'::character varying, '123456'::character varying, 'Admin'::character varying, 'Yves'::character varying)
 returning id;

 INSERT INTO public."USER" (
 "Email", "Nachname", "Passwort", "Role", "Vorname") VALUES (
'Test@Mitglied.test'::character varying, 'Machaz'::character varying, '123456'::character varying, 'Mitglied'::character varying, 'Severin'::character varying)
 returning id;

-- Buchungen Imports

INSERT INTO public."BUCHUNG" (
 "Datum", "Halbtag", "Status", "Visablility", user_id) VALUES (
'2022-09-26'::date, false::boolean, 'Accepted'::character varying, true::boolean, '1'::bigint)
 returning id;

 INSERT INTO public."BUCHUNG" (
"Datum", "Halbtag", "Status", "Visablility", user_id) VALUES (
'2022-09-26'::date, false::boolean, 'Accepted'::character varying, false::boolean, '2'::bigint)
 returning id;